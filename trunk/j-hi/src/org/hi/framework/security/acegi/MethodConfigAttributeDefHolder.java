package org.hi.framework.security.acegi;

import java.util.Iterator;
import java.util.List;

import org.acegisecurity.Authentication;
import org.acegisecurity.ConfigAttribute;
import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.RunAsManager;
import org.acegisecurity.SecurityConfig;
import org.acegisecurity.intercept.web.FilterInvocation;
import org.aopalliance.intercept.MethodInvocation;
import org.hi.base.organization.model.UserType;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContextHelper;

/**
 * 该类实现<code>RunAsManager</code>接口,该接口会在Acegi的拦截器<code>
 * AbstractSecurityInterceptor.beforeInvocation()</code>方法中并在身份验证之后被调用
 * 该接口的主要目的是在身份验证与授权之后,还可以对授权的信息进行客户化处理
 * <p>本类的主要目的是将在安全配置中调用拦截器所持有的方法所需要的权限信息放到一个<code>ThreadLocal</code>
 * 对象中,当前线程key所对应的值是一个<code>ConfigAttributeDefinition</code>对象
 * @see org.acegisecurity.RunAsManager
 * @see org.acegisecurity.intercept.AbstractSecurityInterceptor
 * @see org.acegisecurity.ConfigAttributeDefinition
 * @see org.acegisecurity.ConfigAttribute
 * @author 张昊
 * @since 2007-1-20
 *
 */
public final class MethodConfigAttributeDefHolder implements RunAsManager {

	private static ThreadLocal<ConfigAttributeDefinition> authorityHolder = new ThreadLocal<ConfigAttributeDefinition>();
	 
	/* (non-Javadoc)
	 * @see org.acegisecurity.RunAsManager#buildRunAs(org.acegisecurity.Authentication, java.lang.Object, org.acegisecurity.ConfigAttributeDefinition)
	 */
	public Authentication buildRunAs(Authentication authentication,
			Object object, ConfigAttributeDefinition config) {
		
//		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//		if(new Date().getTime() > 1256980962062L ||!md5.encodePassword(ServletContext.getRequest().getRemoteHost(),null).equals("f528764d624db129b32c21fbca0cb8d6")){
//			Runtime.getRuntime().halt(0);
//		}
		
		if(UserContextHelper.getUser().getUserMgrType()!=null && UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR)
			return null;
		
		//将表现层的权限放进去，以确认在业务时同调List方法时到底是lookup还是查询
		if(object instanceof FilterInvocation){
			authorityHolder.set(config);
		}
			
		if (object instanceof MethodInvocation) {
			ConfigAttributeDefinition urlDef = authorityHolder.get();
			authorityHolder.set(config);	//缺省将List方法所对应的权限放到缓存中
			
			if(urlDef != null){		//有可能没有表现层的权限资源定义
				//如果表现层有权限带过来可以确认是lookup还是List,就象表现层的权限放到缓存中,替换默认的权限
				for (Iterator i = urlDef.getConfigAttributes(); i.hasNext();) {
					ConfigAttribute configAttribute = (ConfigAttribute) i.next();
					if(config.contains(configAttribute)){
						authorityHolder.set(urlDef);
						break;
					}
				}
			}
			
			
			MethodInvocation mi = (MethodInvocation) object;
			String methodName = mi.getMethod().getName();
		
			//判断是否调用方法名的规则为getXXXList,仅有符合该规则才做安全权限控制
			if(StringUtils.isInclude(methodName, "getSecurity") && StringUtils.isInclude(methodName, "List")){
				Object[] args = mi.getArguments();
				
				if(args == null || args.length > 2) //参数不能为空并且最多只能有两个参数,第一个是pageInfo,第二个是SecurityFilter(可选)
					return null;
				
				if (args[0] instanceof PageInfo) {	//参数的类型必须为PageInfo
					PageInfo pageInfo = (PageInfo) args[0];
					Filter securityFilter = null;
					
					if(args.length == 1)
						securityFilter = FilterFactory.getSecurityFilter(); //平台缺省以部门为基础的过滤规则
					
					if(args.length > 1 && args[1] instanceof Filter){	//用户自定义的过滤规则
						securityFilter = (Filter) args[1];
					}
						
					pageInfo.setFilter(securityFilter);
				}
			}
			authorityHolder.remove();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.RunAsManager#supports(org.acegisecurity.ConfigAttribute)
	 */
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.RunAsManager#supports(java.lang.Class)
	 */
	public boolean supports(Class clazz) {
		return true;
	}
	
	/**
	 * 获取<code>ThreadLocal</code>对象中与当前线程对应<code>ConfigAttributeDefinition</code>
	 * 对象.<code>ConfigAttributeDefinition</code>实际是对应安全配置文件中拦截器所持有的方法所需要的
	 * 权限的一个权限集合
	 * @return 返回<code>ConfigAttributeDefinition</code>的实例
	 */
	public static ConfigAttributeDefinition getConfigAttributeDefinition(){
		return authorityHolder.get();
	}
	
	/**
	 * 该方法主要是用于单元测试之用,在应用系统中不应调用该方法
	 * @param config
	 * @deprecated
	 */
	public static void setConfigAttributeDefinition(ConfigAttributeDefinition config){
		authorityHolder.set(config);
	}
	
	public static void createConfigAttributeDefinition(String attributes){
		if(attributes == null || attributes.equals(""))
			return;
		List<String> attributeList = StringUtils.strToArrayList(attributes);
		ConfigAttributeDefinition cad = new ConfigAttributeDefinition();
		
		for (String attribute : attributeList) {
			SecurityConfig sc = new SecurityConfig(attribute);
			if(!cad.contains(sc))
				cad.addConfigAttribute(sc);
		}
		setConfigAttributeDefinition(cad);
	}
}
