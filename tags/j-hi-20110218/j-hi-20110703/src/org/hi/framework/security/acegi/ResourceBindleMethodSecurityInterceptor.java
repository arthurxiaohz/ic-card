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
 * 该类继承自Aecgi提供的<code>MethodSecurityInterceptor</code>类.后者是一个方法拦截器主要功能
 * 是对业务层方法的拦截实现当前用户拥有的权限是否包含调用该类方法权限,如果当前用户的权限中没有与之匹配的
 * 权限则主要抛出<code>AccessDeniedException</code>异常
 * <p>本类的主要目的是通过扩展<code>MethodSecurityInterceptor</code>,实现权限配置的资源束管理
 * 可以通过该类加载多个安全配置文件,实际上安全配置文件只是一个特殊的properties文件,要求在该配置文件中
 * 必须有BUSINESS_SECURITY/BUSINESS_SECURITY_END这两个开始/截止的标识符.通过逐一截取安全配置文件
 * 中的内容,获取字符串然后交给<code>MethodDefinitionSourceEditor</code>类进行编辑,最终形成<code>
 * MethodDefinitionSource</code>对象
 * @author 张昊
 * @since 2007-2-1
 * @see org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor
 * @see org.acegisecurity.intercept.method.MethodDefinitionSourceEditor
 * <p>Sping配置:<p>
 * <DIV>&nbsp; &lt;bean id="contactManagerSecurity" class="org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="authenticationManager"&gt;&lt;ref bean="authenticationManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="accessDecisionManager"&gt;&lt;ref bean="accessDecisionManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="mappingLocations"&gt;&lt;value&gt;classpath*:/**&nbsp;/*-security.properties&lt;/value&gt;&lt;/property&gt;<BR>&nbsp; &lt;property name="runAsManager"&gt;&lt;ref bean="runAsManager"/&gt;&lt;/property&gt;<BR>&nbsp; &lt;/bean&gt;</DIV>
 * <p>安全配置文件:<p>
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
			
	//		加载jar包中的配置文件
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
