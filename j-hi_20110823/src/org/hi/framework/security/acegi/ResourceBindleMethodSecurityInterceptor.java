package org.hi.framework.security.acegi;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.intercept.method.MethodDefinitionSource;
import org.acegisecurity.intercept.method.MethodDefinitionSourceEditor;
import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.spring.JarResource;
import org.hi.framework.util.DataInputStreamUtil;
import org.springframework.core.io.Resource;

/**
 * ����̳���Aecgi�ṩ��<code>MethodSecurityInterceptor</code>��.������һ��������������Ҫ����
 * �Ƕ�ҵ��㷽��������ʵ�ֵ�ǰ�û�ӵ�е�Ȩ���Ƿ�������ø��෽��Ȩ��,�����ǰ�û���Ȩ����û����֮ƥ���
 * Ȩ������Ҫ�׳�<code>AccessDeniedException</code>�쳣
 * <p>�������ҪĿ����ͨ����չ<code>MethodSecurityInterceptor</code>,ʵ��Ȩ�����õ���Դ������
 * ����ͨ��������ض����ȫ�����ļ�,ʵ���ϰ�ȫ�����ļ�ֻ��һ�������properties�ļ�,Ҫ���ڸ������ļ���
 * ������BUSINESS_SECURITY/BUSINESS_SECURITY_END��������ʼ/��ֹ�ı�ʶ��.ͨ����һ��ȡ��ȫ�����ļ�
 * �е�����,��ȡ�ַ���Ȼ�󽻸�<code>MethodDefinitionSourceEditor</code>����б༭,�����γ�<code>
 * MethodDefinitionSource</code>����
 * @author ���
 * @since 2007-2-1
 * @see org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor
 * @see org.acegisecurity.intercept.method.MethodDefinitionSourceEditor
 * <p>Sping����:<p>
 * <DIV>&nbsp; &lt;bean id="contactManagerSecurity" class="org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="authenticationManager"&gt;&lt;ref bean="authenticationManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="accessDecisionManager"&gt;&lt;ref bean="accessDecisionManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="mappingLocations"&gt;&lt;value&gt;classpath*:/**&nbsp;/*-security.properties&lt;/value&gt;&lt;/property&gt;<BR>&nbsp; &lt;property name="runAsManager"&gt;&lt;ref bean="runAsManager"/&gt;&lt;/property&gt;<BR>&nbsp; &lt;/bean&gt;</DIV>
 * <p>��ȫ�����ļ�:<p>
 * BUSINESS_SECURITY<BR>&nbsp;org.hi.base.organization.service.impl.HiOrgManagerImpl.getList=HIORG_LIST<BR>&nbsp;org.hi.base.organization.service.impl.HiOrgManagerImpl.removeObject=HIORG_DEL<BR>&nbsp;org.hi.base.organization.service.impl.HiOrgManagerImpl.removeObjectById=HIORG_DEL&nbsp;<BR>BUSINESS_SECURITY_END
 * 
 */
public class ResourceBindleMethodSecurityInterceptor extends
		MethodSecurityInterceptor {
	
	private static final String FILTER_BUSINESS_ATTRIBUTER_START = "BUSINESS_SECURITY";

	private static final String FILTER_BUSINESS_ATTRIBUTER_START_END = "BUSINESS_SECURITY_END";

	private Resource[] mappingLocations;
	
	public void setMappingLocations(Resource[] mappingLocations)  throws IOException{
		this.mappingLocations = mappingLocations;
		this.setObjectDefinitionSource();
	}
	
	private void setObjectDefinitionSource() throws IOException{
		MethodDefinitionSourceEditor mdsEditor = new MethodDefinitionSourceEditor();
		
		List<Resource> allMappingLocations = new ArrayList<Resource>();
//		InputStream configStream =  this.getClass().getResourceAsStream("securities.properties");
//		Properties properties = FileUtil.getProperties(configStream);
		if(HiConfigHolder.getJarFile() != null){
			List<String> jarUrls = new ArrayList<String>();
			String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
			for (String jarFileName : jars) {
				String hiJarUrl = null;
				try {
					hiJarUrl = URLDecoder.decode(this.getClass().getClassLoader().getResource("../lib/"+jarFileName).getFile(), "utf-8");
					if(hiJarUrl != null)
						jarUrls.add(hiJarUrl);
				} 
				catch (Exception e) {}
			}
			
	//		����jar���е������ļ�
			if(jarUrls.size() > 0){
				for (String hiJarUrl : jarUrls) {
					if(hiJarUrl != null){
						Resource[] jarResources = JarResource.getInstance(new File(hiJarUrl), "*-security.properties");
						for (Resource resource : jarResources) {
							allMappingLocations.add(resource);
						}
					}
				}
			}
		}
		for (int i = 0; i < mappingLocations.length; i++) 
			allMappingLocations.add(mappingLocations[i]);
		
		
		StringBuffer sb = new StringBuffer();
		for (Resource resource : allMappingLocations) {
			sb.append(DataInputStreamUtil.getInputStreameSegment(resource,
					FILTER_BUSINESS_ATTRIBUTER_START,
					FILTER_BUSINESS_ATTRIBUTER_START_END));
		}

		mdsEditor.setAsText(sb.toString());
		this.setObjectDefinitionSource((MethodDefinitionSource) mdsEditor.getValue());
	}
}
