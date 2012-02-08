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
 * ����ʵ��<code>RunAsManager</code>�ӿ�,�ýӿڻ���Acegi��������<code>
 * AbstractSecurityInterceptor.beforeInvocation()</code>�����в��������֤֮�󱻵���
 * �ýӿڵ���ҪĿ�����������֤����Ȩ֮��,�����Զ���Ȩ����Ϣ���пͻ�������
 * <p>�������ҪĿ���ǽ��ڰ�ȫ�����е��������������еķ�������Ҫ��Ȩ����Ϣ�ŵ�һ��<code>ThreadLocal</code>
 * ������,��ǰ�߳�key����Ӧ��ֵ��һ��<code>ConfigAttributeDefinition</code>����
 * @see org.acegisecurity.RunAsManager
 * @see org.acegisecurity.intercept.AbstractSecurityInterceptor
 * @see org.acegisecurity.ConfigAttributeDefinition
 * @see org.acegisecurity.ConfigAttribute
 * @author ���
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
		
		//�����ֲ��Ȩ�޷Ž�ȥ����ȷ����ҵ��ʱͬ��List����ʱ������lookup���ǲ�ѯ
		if(object instanceof FilterInvocation){
			authorityHolder.set(config);
		}
			
		if (object instanceof MethodInvocation) {
			ConfigAttributeDefinition urlDef = authorityHolder.get();
			authorityHolder.set(config);	//ȱʡ��List��������Ӧ��Ȩ�޷ŵ�������
			
			if(urlDef != null){		//�п���û�б��ֲ��Ȩ����Դ����
				//������ֲ���Ȩ�޴���������ȷ����lookup����List,������ֲ��Ȩ�޷ŵ�������,�滻Ĭ�ϵ�Ȩ��
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
		
			//�ж��Ƿ���÷������Ĺ���ΪgetXXXList,���з��ϸù��������ȫȨ�޿���
			if(StringUtils.isInclude(methodName, "getSecurity") && StringUtils.isInclude(methodName, "List")){
				Object[] args = mi.getArguments();
				
				if(args == null || args.length > 2) //��������Ϊ�ղ������ֻ������������,��һ����pageInfo,�ڶ�����SecurityFilter(��ѡ)
					return null;
				
				if (args[0] instanceof PageInfo) {	//���������ͱ���ΪPageInfo
					PageInfo pageInfo = (PageInfo) args[0];
					Filter securityFilter = null;
					
					if(args.length == 1)
						securityFilter = FilterFactory.getSecurityFilter(); //ƽ̨ȱʡ�Բ���Ϊ�����Ĺ��˹���
					
					if(args.length > 1 && args[1] instanceof Filter){	//�û��Զ���Ĺ��˹���
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
	 * ��ȡ<code>ThreadLocal</code>�������뵱ǰ�̶߳�Ӧ<code>ConfigAttributeDefinition</code>
	 * ����.<code>ConfigAttributeDefinition</code>ʵ���Ƕ�Ӧ��ȫ�����ļ��������������еķ�������Ҫ��
	 * Ȩ�޵�һ��Ȩ�޼���
	 * @return ����<code>ConfigAttributeDefinition</code>��ʵ��
	 */
	public static ConfigAttributeDefinition getConfigAttributeDefinition(){
		return authorityHolder.get();
	}
	
	/**
	 * �÷�����Ҫ�����ڵ�Ԫ����֮��,��Ӧ��ϵͳ�в�Ӧ���ø÷���
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
