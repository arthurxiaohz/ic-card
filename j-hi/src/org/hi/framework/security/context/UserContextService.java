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
 * ������Acegi�ṩ��<code>UserDetailsService</code>�ӿڵ�ʵ����,�ýӿڵ��������������֤
 * �ɹ�֮�����ڿͻ����Ĵ����������û���Ϣ.����AcegiԼ���û���Ϣ�����ͱ�����<code>UserDetails</code>
 * �ӿڵ�����
 * <p>�����������ͨ��ʵ��<code>UserDetailsService</code>�ӿ�,������<code>loadUserByUsername(String username)</code>
 * ��������<code>UserContext</code>ʵ��,��Ϊ������������.ע����ڴ�����Ϊ��������ݵĹ���
 * ����<code>SecurityManager</code>��������ɵ�,�����Spring�����ļ�Ϊ��������ʱһ��Ҫ��
 * <code>scurityManager</code>����
 * @see org.acegisecurity.userdetails.UserDetailsService
 * @see org.acegisecurity.userdetails.UserDetails
 * @see org.hi.framework.security.context.UserContext
 * @see org.hi.framework.security.service.SecurityManager
 * @author ���
 * @since 2007-1-21
 * <p>Spring�������磺<p>
 * &nbsp;&lt;bean id="userContextSerivce" class="org.hi.framework.security.context.UserContextService"&gt;<BR>&nbsp;&lt;property name="securityManager"&gt;&lt;ref local="securityManager"/&gt;&lt;/property&gt;<BR>&nbsp;&lt;/bean&gt; 
 *<p>&nbsp;&lt;bean id="securityManager" parent="txProxyTemplate"&gt;<BR>&nbsp;&nbsp;&nbsp; &lt;property name="target"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;bean class="org.hi.framework.security.service.impl.SecurityManagerImpl"&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="DAO" ref="baseDAO"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userClass" value="org.hi.base.organization.model.HiUser"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="userAuthorityClass" value="org.hi.framework.security.model.UserAuthority"/&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/bean&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;/property&gt;<BR>&nbsp;&lt;/bean&gt;
 */
public class UserContextService implements UserDetailsService {


	private org.hi.framework.security.service.SecurityManager scurityManager;
	/**
	 * ���ǽӿ�<code>UserDetailsService</code>�ķ���,�����֤�ɹ���,ͨ���÷�������������
	 * <code>UserContext</code>ʵ��
	 * @param username ��ǰ�û��ĵ�¼�ʺ�
	 * @return UserContext����
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
	 * ��ͨ�����ֲ�ֱ�ӵ���ҵ��㷽��֮ǰִ�б�����.��Ŀ����Ϊ��ǰ�û�����Ȩ��������.
	 * <p>ע�⣺ǿ�Ҳ��Ƽ�ʹ�ô˷���,ԭ��Ϊ�ڲ�Ӧ����ҳ���ֱ�ӵ���ҵ��������,�����п��ܽ�
	 * ҵ����Ϣ��¶���ն��û�,�ڰ�ȫ�����кܵĴ�����.�÷���û�п��滻�ķ���,������ø÷���
	 * �ķ�ʽ����ҳ��˵��ñ��ֲ��action����ֱ�ص���ҵ������еķ���.
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
