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
 * ������Acegi�ṩ�Ľӿ�<code>UserDetails</code>��ʵ����,<code>UserDetails</code>�ӿ�
 * ����Ҫ�����ǵ��û�ͨ�������֤�����ڴ洢��ǰ�û��������Ϣ,��������������μ�Acegi�ṩ��javaDoc
 * <p>�����������Ҫ�Ƕ�<code>UserDetails</code>�ӿ���������չ,�γɴ洢��ǰ�û���Ϣ��������
 * ��Ҫ������ǰ�û���POJOʵ��,��ǰ�û���ӵ�е�Ȩ�ޡ���ɫ���û����.����֮��,���໹�ṩ��һЩ�뵱ǰ
 * �û��йصĹ��߷���,�統ǰ�û����ڵĲ��š����ŵ��쵼��
 * 
 * @see org.acegisecurity.userdetails.UserDetails
 * @author ���
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
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor,����Ϊ��");
        }
		this.user = user;
	}
	
	/**
	 * ��ǰ�û��Ļ�����Ϣ,HiUser��POJO
	 * @return ���ص�ǰ�û��Ļ�����Ϣ
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
	 * ��ǰ�û����ڲ��ŵ���Ϣ
	 * @return ���ص�ǰ�û����ڵĲ���
	 */
	public HiOrg getOrg(){
		return this.getUser().getOrg();
	}
	
	/**
	 * �û���ӵ�е�Ȩ��
	 * @return �����û���ӵ�е�Ȩ��
	 */
	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	
	/**
	 * �û���ӵ�еĽ�ɫ 
	 * @return �����û���ӵ�еĽ�ɫ
	 */
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	/**
	 * ��ǰ�û����ڵ��û���
	 * @return ��ǰ�û����ڵ��û���
	 */
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	
	/**
	 * �Ƿ��ǳ�������Ա
	 * @return ���Ϊ��������Ա����true,���򷵻�false
	 */
	public boolean isSupperManager(){
		return user.isSupperManager();
	}
	
	/**
	 * �Ƿ��ǹ���Ա
	 * @return ���Ϊ����Ա����true,���򷵻�false
	 */
	public boolean isManager(){
    	if(user.getUserMgrType() == null)
    		return false;
    	return user.getUserMgrType().equals(UserType.USERTYPE_MANAGER);

	}
	
	/****	���ù��߷������û�ID������������ID������ ****/
	
	/**
	 * ��õ�ǰ�û�������
	 * @return ���ص�ǰ�û�������
	 */
	public String getUserName(){
		return user.getFullName();
	}
	
	/**
	 * ��õ�ǰ�û���IDֵ
	 * @return ���ص�ǰ�û���IDֵ
	 */
	public Integer getUserId(){
		return user.getId();
	}
	
	/**
	 * ��õ�ǰ�û����ڲ��ŵĲ�������
	 * @return ��ǰ�û��Ĳ��ŵĲ�������
	 */
	public String getOrgName(){
		if(user.getOrg() == null)
			return null;

		return user.getOrg().getOrgName();
	}
	
	/**
	 * ��õ�ǰ�û����ڲ��ŵĲ��Ź����ߵ�IDֵ
	 * @return ��ǰ�û��Ĳ����쵼��IDֵ
	 */
	public Integer getOrgId(){
		if(this.user.getOrg() == null)
			return null;
		
		return user.getOrg().getId();
	}
	
	/**
	 * ��õ�ǰ�û����ڲ��ŵĲ��Ź�����
	 * @return ��ǰ�û��Ĳ����쵼
	 */
	public HiUser getLeader(){
		if (this.getOrg() == null)
			return null;
		
		return this.getOrg().getManager();
	}
	
	/**
	 * ��Ϊͬ��Ȩ�޷�Χ��ͬ,�������û�ӵ�е�Ȩ���п��ܻ���ֶ�����ͬȨ�޵ļ�¼,����UserAuthority��
	 * ��һ���û����ж�����ͬ��Ȩ��,Ҳ���Ǹñ���authority�ֶε�ֵ��ͬ.��������������,��ͬ��Ȩ�޵���Χ
	 * ��ͬ�ŵ�һ��<code>List</code>��,����Ȩ����Ϊkey,������ͬȨ�޵���Χ��ͬ��<code>UserAuthority</code>
	 * �ļ���(<code>List</code>)Ϊֵ,��ŵ�Map��,�����ظ�Map
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
	 * ��õ�ǰ�û�ӵ�в˵�Ȩ�޵�URL
	 * <p>ע�⣺URL����Ĳ�����������
	 * @return ��Ȩ���ʲ˵����ӵ�URL����
	 */
	public Set<String> getUserMenuUrls(){
		if(userMenuUrls != null)
			return userMenuUrls;
		
		Set<String> result = new HashSet<String>();
		FilterSecurityInterceptor filterInvocationInterceptor = (FilterSecurityInterceptor)SpringContextHolder.getBean("filterInvocationInterceptor");
		//�������url��Ȩ�޶���
		AbstractFilterInvocationDefinitionSource invocationDefinitionSource = (AbstractFilterInvocationDefinitionSource)filterInvocationInterceptor.getObjectDefinitionSource();
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		List<MenuLink> MenuLinks = menuLinkMgr.getObjects();
		
		//ȫ��Ȩ����˵����ӵ�URL���ձ�,֮����url��һ��set����Ϊ�п���һ��Ȩ�޶�Ӧ���url
		Map<String,Set<String>> configAttributes = new HashMap<String,Set<String>>();
		
		//�����в˵�������ѯ
		for (MenuLink link : MenuLinks) {
			String url = link.getLinkUrl();
			if(url == null)
				continue;
			
			//ȥ��url����Ĳ���
			if(StringUtils.isIncludes(url, "?"))
				url = url.substring(0, url.indexOf("?"));
			
			//ͨ��url����������ļ��е�Ȩ��
			ConfigAttributeDefinition configAttributeDefintion = invocationDefinitionSource.lookupAttributes(url);
			//����ǿ�ֵ������action����Ȩ�޿���
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
		
		//��ǰ�û���ӵ�е�Ȩ������ձ���ƥ��
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
		
		if(expiredDate == null)	//���ʧЧ����Ϊnull,����Ϊ��������
			return true;
		
//		���ʧЧ����С�ڵ�ǰʱ��,����Ϊ��ǰ�û����ʺ�δ����
		if(expiredDate.getTime() < System.currentTimeMillis()) 
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		if(user.getAccountLocked() == null)  //���Ϊnull����Ϊ�񼴲��������ʺ�
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
			return true;						//���Ϊnull,��Ĭ��Ϊ�������
		return user.getAccountEnabled() == YesNo.YESNO_YES;
	}
}
