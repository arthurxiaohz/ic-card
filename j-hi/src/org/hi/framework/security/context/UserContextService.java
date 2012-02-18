package org.hi.framework.security.context;

import javax.servlet.http.HttpServletRequest;

import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;

/**
 * 该类是Acegi提供的<code>UserDetailsService</code>接口的实现类,该接口的作用是在身份验证
 * 成功之后用于客户化的创建并加载用户信息.并且Acegi约定用户信息的类型必须是<code>UserDetails</code>
 * 接口的子类
 * <p>本类的作用是通过实现<code>UserDetailsService</code>接口,覆盖其<code>loadUserByUsername(String username)</code>
 * 方法创建<code>UserContext</code>实例,并为其加载相关数据.注意对于创建与为其加载数据的过程
 * 是在<code>SecurityManager</code>方法中完成的,因此在Spring配置文件为本类设置时一定要该
 * <code>scurityManager</code>属性
 * @see org.acegisecurity.userdetails.UserDetailsService
 * @see org.acegisecurity.userdetails.UserDetails
 * @see org.hi.framework.security.context.UserContext
 * @see org.hi.framework.security.service.SecurityManager
 * @author 张昊
 * @since 2007-1-21
 * <p>Spring配置例如：<p>
 * &nbsp;&lt;bean id="userContextSerivce" class="org.hi.framework.security.context.UserContextService"&gt;<BR>&nbsp;&lt;property name="securityManager"&gt;&lt;ref local="securityManager"/&gt;&lt;/property&gt;<BR>&nbsp;&lt;/bean&gt; 
 *<p>&nbsp;&lt;bean id="securityManager" parent="txProxyTemplate"&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="target"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;bean class="org.hi.framework.security.service.impl.SecurityManagerImpl"&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="DAO" ref="baseDAO"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userClass" value="org.hi.base.organization.model.HiUser"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userAuthorityClass" value="org.hi.framework.security.model.UserAuthority"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/bean&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&lt;/bean&gt;
 */
public class UserContextService implements UserDetailsService {


	private org.hi.framework.security.service.SecurityManager scurityManager;
	/**
	 * 覆盖接口<code>UserDetailsService</code>的方法,身份验证成功后,通过该方法创建并加载
	 * <code>UserContext</code>实例
	 * @param username 当前用户的登录帐号
	 * @return UserContext对象
	 * @see org.hi.framework.security.context.UserContext
	 * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserContext uesrContext = scurityManager.getUserContext(username);
		
		if(uesrContext == null)
			throw new UsernameNotFoundException("user:" + username + " not found");
		
		return uesrContext;
	}
	
	public void setSecurityManager(org.hi.framework.security.service.SecurityManager securityManager) {
		scurityManager = securityManager;
	}

	
	
	/**
	 * 不通过表现层直接调用业务层方法之前执行本方法.的目的是为当前用户加载权限上下文.
	 * <p>注意：强烈不推荐使用此方法,原因为于不应该在页面端直接调用业务层的数据,这样有可能将
	 * 业务信息暴露给终端用户,在安全性上有很的大隐患.该方法没有可替换的方法,避免调用该方法
	 * 的方式是在页面端调用表现层的action而非直截调用业务层类中的方法.
	 * @param request
	 * @deprecated
	 */
	public void loadSecurityContext(HttpServletRequest request){
		Object contextFromSessionObject = request.getSession(true).getAttribute(HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY);
		
		if(contextFromSessionObject == null)
			return;
		
		if (!(contextFromSessionObject instanceof SecurityContext))
			return;
		
		 SecurityContextHolder.setContext((SecurityContext) contextFromSessionObject);
	}
	
}
