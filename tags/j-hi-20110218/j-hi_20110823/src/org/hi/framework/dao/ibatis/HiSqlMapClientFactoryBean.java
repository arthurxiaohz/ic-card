package org.hi.framework.dao.ibatis;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.spring.ContextLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.web.context.support.ServletContextResource;

public class HiSqlMapClientFactoryBean extends SqlMapClientFactoryBean{
	private IbatisHiDialect dialect;
	private Resource[] mappingLocations ;
	private Resource[] mappingJarLocations;
	private Properties properties;
	private Resource configLocation;
	private boolean sqlShow;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	public IbatisHiDialect getDialect() {
		return dialect;
	}
	public void setDialect(IbatisHiDialect dialect) {
		this.dialect = dialect;
	}
	public Resource[] getMappingLocations() {
		return mappingLocations;
	}
	public void setMappingLocations(Resource[] mappingLocations) {
		this.mappingLocations = mappingLocations;
	}
	
	public Resource[] getMappingJarLocations() {
		return mappingJarLocations;
	}
	public void setMappingJarLocations(Resource[] mappingJarLocations) {
		this.mappingJarLocations = mappingJarLocations;
	}
	
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public boolean isSqlShow() {
		return sqlShow;
	}
	public void setSqlShow(boolean sqlShow) {
		this.sqlShow = sqlShow;
	}
	
	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
		super.setConfigLocation(configLocation);
	}

	public  ServletContext getServletContext(){
		return SpringContextHolder.getServletContext();
	}
	
	
//	覆盖父类该方法，目的是修改mappingJarLocations属性的值
	public void afterPropertiesSet() throws Exception {
//		处理方言
		if(dialect == null){
			String dialectValue = properties.getProperty(IbatisHiDialect.HI_PROPERTY_DIALET_KEY);
			if(dialectValue != null)
				this.dialect = (IbatisHiDialect)BeanUtil.CreateObject(dialectValue);
		}
		
		List<Resource> jarResource = new ArrayList<Resource>();
		
		Set<String> jars = new LinkedHashSet<String>();
		if(HiConfigHolder.getJarFile() != null)
			jars = StringUtils.strToSet((HiConfigHolder.getJarFile().trim()));
		
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
		
		super.afterPropertiesSet();
	}
	
}
