package org.hi.framework.security.context;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.acegisecurity.ConfigAttribute;
import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.intercept.web.AbstractFilterInvocationDefinitionSource;
import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;

/**
 * 该类是Acegi提供的接口<code>UserDetails</code>的实现类,<code>UserDetails</code>接口
 * 的主要作用是当用户通过身份验证后用于存储当前用户的相关信息,具体存放在内容请参见Acegi提供的javaDoc
 * <p>本类的作用主要是对<code>UserDetails</code>接口声明的扩展,形成存储当前用户信息的上下文
 * 主要包括当前用户的POJO实例,当前用户所拥有的权限、角色、用户组等.除此之外,该类还提供了一些与当前
 * 用户有关的工具方法,如当前用户所在的部门、部门的领导等
 * 
 * @see org.acegisecurity.userdetails.UserDetails
 * @author 张昊
 * @since 2007-1-21
 *
 */
public class UserContext  implements UserDetails{
	protected final Log log = LogFactory.getLog(getClass());
	private static final long serialVersionUID = -9145437693158151566L;
	private HiUser user;
	private List<UserAuthority> userAuthorities;
	private List<UserRole> userRoles;
	private List<UserGroup> userGroups;
	private Map<String, List<UserAuthority>> authorityNameList;
	private Set<String> userMenuUrls = null;
	
	public UserContext(HiUser user)throws IllegalArgumentException{
		String username = user.getUserName();
		if (((username == null) || "".equals(username)) || (user.getPassword() == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor,密码为空");
        }
		this.user = user;
	}
	
	/**
	 * 当前用户的基本信息,HiUser的POJO
	 * @return 返回当前用户的基本信息
	 */
	public HiUser getUser(){
		HiUser _user = (HiUser)BeanUtil.CreateObject(user.getClass().getName());
		BeanUtil.setBean2Bean(user, _user);
		return _user;
	}
	
	public void setUser(HiUser user){
		this.user = user;
	}
	
	/**
	 * 当前用户所在部门的信息
	 * @return 返回当前用户所在的部门
	 */
	public HiOrg getOrg(){
		return this.getUser().getOrg();
	}
	
	/**
	 * 用户所拥有的权限
	 * @return 返回用户所拥有的权限
	 */
	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	
	/**
	 * 用户所拥有的角色 
	 * @return 返回用户所拥有的角色
	 */
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	/**
	 * 当前用户所在的用户组
	 * @return 当前用户所在的用户组
	 */
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	
	/**
	 * 是否是超级管理员
	 * @return 如果为超级管理员返回true,否则返回false
	 */
	public boolean isSupperManager(){
		return user.isSupperManager();
	}
	
	/**
	 * 是否是管理员
	 * @return 如果为管理员返回true,否则返回false
	 */
	public boolean isManager(){
    	if(user.getUserMgrType() == null)
    		return false;
    	return user.getUserMgrType().equals(UserType.USERTYPE_MANAGER);

	}
	
	/****	常用工具方法如用户ID、姓名，部门ID、名称 ****/
	
	/**
	 * 获得当前用户的名称
	 * @return 返回当前用户的名称
	 */
	public String getUserName(){
		return user.getFullName();
	}
	
	/**
	 * 获得当前用户的ID值
	 * @return 返回当前用户的ID值
	 */
	public Integer getUserId(){
		return user.getId();
	}
	
	/**
	 * 获得当前用户所在部门的部门名称
	 * @return 当前用户的部门的部门名称
	 */
	public String getOrgName(){
		if(user.getOrg() == null)
			return null;

		return user.getOrg().getOrgName();
	}
	
	/**
	 * 获得当前用户所在部门的部门管理者的ID值
	 * @return 当前用户的部门领导的ID值
	 */
	public Integer getOrgId(){
		if(this.user.getOrg() == null)
			return null;
		
		return user.getOrg().getId();
	}
	
	/**
	 * 获得当前用户所在部门的部门管理者
	 * @return 当前用户的部门领导
	 */
	public HiUser getLeader(){
		if (this.getOrg() == null)
			return null;
		
		return this.getOrg().getManager();
	}
	
	/**
	 * 因为同名权限范围不同,所以在用户拥有的权限中可能会出现多条相同权限的记录,即在UserAuthority表
	 * 中一个用户会有多条相同的权限,也就是该表中authority字段的值相同.本方法的作用是,将同名权限但范围
	 * 不同放到一个<code>List</code>中,再以权限名为key,在以相同权限但范围不同的<code>UserAuthority</code>
	 * 的集合(<code>List</code>)为值,存放到Map中,并返回该Map
	 * @return
	 */
	public Map<String, List<UserAuthority>> getAuthorityNameList(){
		if(userAuthorities.size() == 0)
			return null;
		if(this.authorityNameList != null)
			return this.authorityNameList;
		
		Map<String, List<UserAuthority>> authorityNameList = new HashMap<String, List<UserAuthority>>();
		String previousAuthorityName = "";
		List<UserAuthority> nameUserAuthorities = new ArrayList<UserAuthority>();
		for (int i = 0; i<this.userAuthorities.size(); i++) {
			UserAuthority userAuthority = (UserAuthority)userAuthorities.get(i) ;
			String authorityName = userAuthority.getAuthority().getAuthorityName();
			if(authorityName.equalsIgnoreCase(previousAuthorityName)){
				nameUserAuthorities.add(userAuthority);
			}
			else{
				previousAuthorityName = authorityName;
				if(i > 0)
					nameUserAuthorities = new ArrayList<UserAuthority>();
				
				authorityNameList.put(authorityName, nameUserAuthorities);
				nameUserAuthorities.add(userAuthority);
			}
		}
		this.authorityNameList = authorityNameList;
		return this.authorityNameList;
	}
	
	/**
	 * 获得当前用户拥有菜单权限的URL
	 * <p>注意：URL后面的参数将被忽略
	 * @return 有权访问菜单链接的URL集合
	 */
	public Set<String> getUserMenuUrls(){
		if(userMenuUrls != null)
			return userMenuUrls;
		
		Set<String> result = new HashSet<String>();
		FilterSecurityInterceptor filterInvocationInterceptor = (FilterSecurityInterceptor)SpringContextHolder.getBean("filterInvocationInterceptor");
		//获得所有url的权限定义
		AbstractFilterInvocationDefinitionSource invocationDefinitionSource = (AbstractFilterInvocationDefinitionSource)filterInvocationInterceptor.getObjectDefinitionSource();
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		List<MenuLink> MenuLinks = menuLinkMgr.getObjects();
		
		//全部权限与菜单链接的URL对照表,之所以url是一个set是因为有可能一个权限对应多个url
		Map<String,Set<String>> configAttributes = new HashMap<String,Set<String>>();
		
		//对所有菜单链接轮询
		for (MenuLink link : MenuLinks) {
			String url = link.getLinkUrl();
			if(url == null)
				continue;
			
			//去除url后面的参数
			if(StringUtils.isIncludes(url, "?"))
				url = url.substring(0, url.indexOf("?"));
			
			//通过url获得在配置文件中的权限
			ConfigAttributeDefinition configAttributeDefintion = invocationDefinitionSource.lookupAttributes(url);
			//如果是空值表明该action不授权限控制
			if(configAttributeDefintion == null){
				result.add(url);
				continue;
			}
			
			Iterator iterator = configAttributeDefintion.getConfigAttributes();
			while(iterator.hasNext()){
				ConfigAttribute configAttribute = (ConfigAttribute)iterator.next();
				if(configAttributes.get(configAttribute.getAttribute()) == null){
					Set<String> urls = new HashSet<String>();
					urls.add(url);
					configAttributes.put(configAttribute.getAttribute(),urls);
				}
				else{
					configAttributes.get(configAttribute.getAttribute()).add(url);
				}
			}
		}
		
		//当前用户所拥有的权限与对照表相匹配
		for (UserAuthority userAuthority : userAuthorities) {
			if(userAuthority.getAuthority() == null || userAuthority.getAuthority().getAuthorityName() == null)
				continue;
			String authorityName = userAuthority.getAuthority().getAuthorityName();
			if(configAttributes.get(authorityName) != null){
				Set<String> urls = configAttributes.get(authorityName);
				for (String url : urls) {
					result.add(url);
				}
			}
		}
		userMenuUrls = result;
		return userMenuUrls;
	}
	
	//---------------------------------------------------------------------
	// Implementation of UserDetails interface
	//---------------------------------------------------------------------
	
	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
	 */
	public GrantedAuthority[] getAuthorities() {
		GrantedAuthority[] authorities = new GrantedAuthority[userAuthorities.size()];
		for (int i = 0; i<userAuthorities.size(); i++) {
			Authority authority = userAuthorities.get(i).getAuthority();
			
			if(authority == null){
				log.error("user:" + user.getFullName() +" in authorities is null");
			}
			authorities[i] = authority;
		}
		return authorities;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getPassword()
	 */
	public String getPassword() {
		return this.user.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return this.user.getUserName();
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isAccountNonExpired()
	 */
	public boolean isAccountNonExpired() {
		Date expiredDate = user.getExpiredDate();
		
		if(expiredDate == null)	//如果失效日期为null,则认为永不过期
			return true;
		
//		如果失效日期小于当前时间,则认为当前用户的帐号未过期
		if(expiredDate.getTime() < System.currentTimeMillis()) 
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		if(user.getAccountLocked() == null)  //如果为null，则为否即不锁定该帐号
			return true;
		
		return user.getAccountLocked() == YesNo.YESNO_NO;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isEnabled()
	 */
	public boolean isEnabled() {
		if(user.getAccountEnabled() == null)
			return true;						//如果为null,则默认为允许可用
		return user.getAccountEnabled() == YesNo.YESNO_YES;
	}
}
