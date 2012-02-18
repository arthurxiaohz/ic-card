package org.hi.framework.dao.hibernate;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class LocalSessionFactoryBean extends
		org.springframework.orm.hibernate3.LocalSessionFactoryBean {
	protected Resource[] mappingJarLocations;
	

	public void setMappingJarLocations(Resource[] mappingJarLocations) {
		this.mappingJarLocations = mappingJarLocations;
	}
	
	public void afterPropertiesSet() throws Exception {
		
		Set<String> jars = new LinkedHashSet<String>();
		
		if(HiConfigHolder.getJarFile() != null)
			jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
		
		
		List<Resource> jarResource = new ArrayList<Resource>();
		
//		加载在appContext-orm配置文件中的jar
		if(this.mappingJarLocations != null){
			for (Resource resource : mappingJarLocations) {
				
				if(jars.contains(resource.getFilename()))
					continue;
				
				jarResource.add(resource);
			}
		}
		
		
//		加载hiFrameworkConfig.properties文件中的jar

		for (String jarFileName : jars) {
			URL hiJarUrl = null;
			try {
				File classFile = new File(this.getClass().getClassLoader().getResource("").toURI());
				hiJarUrl = new URL(classFile.getParentFile().toURI().toString() + "/lib/"+jarFileName);
				if(hiJarUrl != null){
					jarResource.add(new UrlResource(hiJarUrl));
				}
			} 
			catch (Exception e) {
				logger.error("error:load jar file  == " + jarFileName);
			}
		}
		
		this.mappingJarLocations = jarResource.toArray(new Resource[jarResource.size()]);
		super.setMappingJarLocations(this.mappingJarLocations);
		super.afterPropertiesSet();
	}
}
