package org.hi.framework.spring;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.HiConfigHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;


/**
 * 本类继承了spring的ContextLoader类并重载了createWebApplicationContext这个方法。
 * 主要是为了覆盖原始jar文件中有可能与classes中重名的配置文件,从而使classes中的配置文件优先于jar中的配置文件
 *
 */
public class ContextLoader extends
		org.springframework.web.context.ContextLoader {

	protected final Log logger = LogFactory.getLog(this.getClass());
	/* (non-Javadoc)
	 * @see org.springframework.web.context.ContextLoader#createWebApplicationContext(javax.servlet.ServletContext, org.springframework.context.ApplicationContext)
	 */
	protected WebApplicationContext createWebApplicationContext(
			ServletContext servletContext, ApplicationContext parent) throws BeansException {
		
		List<String> jarUrls = new ArrayList<String>();
		
//		因为有可能在平台开发时不加载jar包中的文件
		if(HiConfigHolder.getJarFile() != null){
			String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
			for (String jarFileName : jars) {
				String hiJarUrl = null;
				try {
					File classFile = new File(this.getClass().getClassLoader().getResource("").toURI());
					hiJarUrl = (new URL(classFile.getParentFile().toURI().toString() + "/lib/"+jarFileName)).getFile();
					if(hiJarUrl != null)
						jarUrls.add( URLDecoder.decode(hiJarUrl,"utf-8"));
				} 
				catch (Exception e) {
					logger.error("error:load jar file  == " + jarFileName);
				}
			}
		}
		

		
		Class contextClass = determineContextClass(servletContext);
		if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
			throw new ApplicationContextException("Custom context class [" + contextClass.getName() +
					"] is not of type ConfigurableWebApplicationContext");
		}
		
		List<String> allResources = new ArrayList<String>();
		ConfigurableWebApplicationContext wac =
				(ConfigurableWebApplicationContext) BeanUtils.instantiateClass(contextClass);
		wac.setParent(parent);
		wac.setServletContext(servletContext);
		String configLocation = servletContext.getInitParameter(CONFIG_LOCATION_PARAM);
		
		if (configLocation != null) {
			String[] resources = StringUtils.tokenizeToStringArray(configLocation,ConfigurableWebApplicationContext.CONFIG_LOCATION_DELIMITERS);
		
//			第一次加载的目的是为jar文件中的配置所须的依赖提供支持
			for (int i = 0; i < resources.length; i++) {
				if(resources[i] == null || resources[i].equals(""))
					continue;
				if(resources[i].toUpperCase().indexOf("WEB-INF") >= 0)
					allResources.add(resources[i]);
			}
			
//			加载jar包中的配置文件
			if(jarUrls.size() > 0){
				for (String hiJarUrl : jarUrls) {
					if(hiJarUrl != null){
							
						Resource[] jarResources = JarResource.getInstance(new File(hiJarUrl), "*appContext-*.xml");
						for (Resource resource : jarResources) {
							try {
								allResources.add(resource.getURL().toString());
							} catch (IOException e) {}
						}
							
					}
				}
			}
			
//			第二次加载的目标的覆盖jar文件中有可能与classes中重名的配置文件,从而使classes中的配置文件优先于jar中的配置文件
			for (int i = 0; i < resources.length; i++) {
				if(resources[i] == null || resources[i].equals(""))
					continue;
				if(resources[i].toUpperCase().indexOf("WEB-INF") < 0)
					allResources.add(resources[i]);
			}
			
			wac.setConfigLocations(allResources.toArray(new String[allResources.size()]));
		}
		
		wac.refresh();
		return wac;
	}

}
