package org.hi.framework.security.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.security.service.SecurityManager;
import org.hi.framework.service.impl.ManagerImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * 该类是一个后端服务类,用以得到给定用户的相关信息
 * @author 张昊
 * @since 2007-1-27
 * Spring配置:<p>
 * <DIV>&nbsp;&lt;bean id="securityManager" parent="txProxyTemplate"&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="target"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;bean class="org.hi.framework.security.service.impl.SecurityManagerImpl"&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="DAO" ref="baseDAO"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userClass" value="org.hi.base.organization.model.HiUser"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userAuthorityClass" value="org.hi.framework.security.model.UserAuthority"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/bean&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&lt;/bean&gt;</DIV>
 *<P>&nbsp;&lt;bean id="baseDAO" class="org.springframework.aop.framework.ProxyFactoryBean"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="proxyInterfaces" value="org.hi.framework.dao.DAO" /&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;property name="interceptorNames"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;list&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;value&gt;baseDAOHibernate&lt;/value&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/list&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&lt;/bean&gt;</P>
 *
 */
public class SecurityManagerImpl extends ManagerImpl implements SecurityManager {
	private Class userClass = HiUser.class;
	private Class userAuthorityClass = UserAuthority.class;
	private Class userRoleClass = UserRole.class;
	private Class userGroupClass = UserGroup.class;
	
	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.SecurityManager#getUser(java.lang.String)
	 */
	public HiUser getUser(String username) {
		Filter filter = FilterFactory.getSimpleFilter("userName", username, Filter.OPERATOR_EQ);
		HiUser user = (HiUser)this.getUniqueObject(userClass, filter);
		return user;
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.SecurityManager#getUserAuthorities(org.hi.base.organization.model.HiUser)
	 */
	public List<UserAuthority> getUserAuthorities(HiUser user) throws DataAccessException{
		
		Filter filter = null;
		List<UserAuthority> userAuthorities = null;
		if(user.getUserMgrType() == null || user.getUserMgrType()!= UserType.USERTYPE_ADMINISTRATOR){
			filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), Filter.OPERATOR_EQ);
			userAuthorities = this.getObjects(userAuthorityClass, filter);
		}else{
			userAuthorities = new ArrayList<UserAuthority>();
			AuthorityManager aMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
			List<Authority> authorities = aMgr.getObjects();
			for (Authority authority : authorities) {
				UserAuthority userAuthority = new UserAuthority();
				userAuthority.setAuthority(authority);
				userAuthority.setSecurityUser(user);
				userAuthorities.add(userAuthority);
			}
		}
		
		if(userAuthorities == null)
			throw new DataIntegrityViolationException("user:" + user.getFullName() + " havn't userAuthorities");
		
		/* 对当前用户所拥有的权限,按权限的名字对UserAuthority集合排序 */
		Collections.sort(userAuthorities, new Comparator<Object>(){

			public int compare(Object o1, Object o2) {
				UserAuthority userAththority1 = (UserAuthority)o1;
				UserAuthority userAththority2 = (UserAuthority)o2;
				String authorityName1 = userAththority1.getAuthority().getAuthorityName();
				String authorityName2 = userAththority2.getAuthority().getAuthorityName();
				int strCompar = authorityName1.compareTo(authorityName2);
				if(strCompar < 0)
					return -1;
				if(strCompar > 0)
					return 1;
				return 0;
			}
			
		});
		
		return userAuthorities;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.SecurityManager#getUserRoles(org.hi.base.organization.model.HiUser)
	 */
	@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoles(HiUser user){
		Filter filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), Filter.OPERATOR_EQ);
		return this.getObjects(userRoleClass, filter);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.SecurityManager#getUserGroups(org.hi.base.organization.model.HiUser)
	 */
	@SuppressWarnings("unchecked")
	public List<UserGroup> getUserGroups(HiUser user){
		Filter filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), Filter.OPERATOR_EQ);
		return this.getObjects(userGroupClass, filter);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.SecurityManager#getUserContext(java.lang.String)
	 */
	public UserContext getUserContext(String username) throws DataAccessException{
		HiUser user = this.getUser(username);
		
		if(user == null)
			return null;
		
		UserContext userContext = new UserContext(user);
		userContext.setUserAuthorities(this.getUserAuthorities(user));
		if(user.getUserMgrType() != null && user.getUserMgrType()== UserType.USERTYPE_ADMINISTRATOR)
			return userContext;
		
		userContext.setUserRoles(this.getUserRoles(user));
		userContext.setUserGroups(this.getUserGroups(user));
		return userContext;
	}

	public void setUserClass(Class userClass) {
		this.userClass = userClass;
	}

	public void setUserAuthorityClass(Class userAuthorityClass) {
		this.userAuthorityClass = userAuthorityClass;
	}

	public void setUserRoleClass(Class userRoleClass) {
		this.userRoleClass = userRoleClass;
	}

}
