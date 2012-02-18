package org.hi.framework.security.acegi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.intercept.web.FilterInvocation;
import org.acegisecurity.intercept.web.FilterInvocationDefinitionSource;
import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
import org.hi.common.util.FileUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.spring.ContextLoader;
import org.hi.framework.spring.JarResource;
import org.hi.framework.util.DataInputStreamUtil;
import org.hi.framework.web.ServletContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ResourceUtils;

/**
 * 该类继承自Aecgi提供的<code>FilterSecurityInterceptor</code>类.后者是一个Servlet过滤器主要功能
 * 客户端请求实现当前用户拥有的权限是否包含调用该类方法权限,如果当前用户的权限中没有与之匹配的
 * 权限则主要抛出<code>AccessDeniedException</code>异常.最终实现控制页面安全的目的
 * <p>本类的主要目的是通过扩展<code>FilterSecurityInterceptor</code>,实现权限配置的资源束管理
 * 可以通过该类加载多个安全配置文件,实际上安全配置文件只是一个特殊的properties文件,要求在该配置文件中
 * 必须有WEB_SECURITY/WEB_SECURITY这两个开始/截止的标识符.通过逐一截取安全配置文件
 * 中的内容,获取字符串然后交给<code>FilterInvocationDefinitionSourceEditor</code>类进行编辑,最终形成<code>
 * FilterInvocationDefinitionSource</code>对象 
 * @author 张昊
 * @since 2007-1-24
 * @see org.acegisecurity.intercept.web.FilterSecurityInterceptor
 * @see org.acegisecurity.intercept.web.FilterInvocationDefinitionSourceEditor
 * @see org.acegisecurity.intercept.web.FilterInvocationDefinitionSource
 * <p>Sping配置:<p>
 * &nbsp;&nbsp; &lt;bean id="filterInvocationInterceptor" class="org.hi.framework.security.acegi.ResourceBindleFilterSecurityInterceptor"&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="authenticationManager"&gt;&lt;ref bean="authenticationManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="accessDecisionManager"&gt;&lt;ref local="accessDecisionManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="mappingLocations"&gt;&lt;value&gt;classpath*:/**&nbsp;/*-security.properties&lt;/value&gt;&lt;/property&gt;<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;property name="runAsManager"&gt;&lt;ref bean="runAsManager"/&gt;&lt;/property&gt;<BR>&nbsp;&nbsp; &lt;/bean&gt;
 * <p>安全配置文件:<p>
 * WEB_SECURITY<BR>&nbsp;/login.jsp*=ANONYMOUS,USER<BR>&nbsp;/**=AUTH_USER<BR>WEB_SECURITY_END
 */
public class ResourceBindleFilterSecurityInterceptor extends FilterSecurityInterceptor {

	private static final String FILTER_WEB_ATTRIBUTER_START = "WEB_SECURITY";

	private static final String FILTER_WEB_ATTRIBUTER_START_END = "WEB_SECURITY_END";

	private Resource[] mappingLocations;

	public void setMappingLocations(Resource[] mappingLocations)  throws IOException{
		this.mappingLocations = mappingLocations;
		this.setObjectDefinitionSource();
	}
	
	protected void setObjectDefinitionSource() throws IOException{
		HiFilterInvocationDefinitionSourceEditor fidsEditor = new HiFilterInvocationDefinitionSourceEditor();
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
					FILTER_WEB_ATTRIBUTER_START,
					FILTER_WEB_ATTRIBUTER_START_END));
		}

		fidsEditor.setAsText(sb.toString());
		this.setObjectDefinitionSource((FilterInvocationDefinitionSource) fidsEditor.getValue());
	}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    	ServletContext.setRequest((HttpServletRequest)request);
    	ServletContext.setResponse((HttpServletResponse)response);
    	super.doFilter(request, response, chain);
    }

}
