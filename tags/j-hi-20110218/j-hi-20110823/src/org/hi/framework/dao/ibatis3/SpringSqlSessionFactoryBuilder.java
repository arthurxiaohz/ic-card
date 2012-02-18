package org.hi.framework.dao.ibatis3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.ibatis.IbatisHiDialect;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.context.support.ServletContextResource;

// Override SqlSessionFactoryBuilder only to create the necessary
// BeanSqlSessionFactory
public final class SpringSqlSessionFactoryBuilder implements FactoryBean, InitializingBean {
    private SqlSessionFactory sqlSessionFactory;
    private Properties properties;
    private DataSource dataSource;
    private IbatisHiDialect dialect;
	private Resource[] mappingLocations ;
	private Resource[] mappingJarLocations;
	private Resource configLocation;
	private boolean sqlShow;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	public IbatisHiDialect getDialet() {
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
	public boolean isSqlShow() {
		return sqlShow;
	}
	public void setSqlShow(boolean sqlShow) {
		this.sqlShow = sqlShow;
	}
	
	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	
	}

	public  ServletContext getServletContext(){
		return SpringContextHolder.getServletContext();
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SqlSessionFactory getObject() throws Exception {
        return sqlSessionFactory;
    }

    public Class<? extends SqlSessionFactory> getObjectType() {
        return sqlSessionFactory == null ? SqlSessionFactory.class
                : sqlSessionFactory.getClass();
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws java.io.IOException {
    	
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
    	
		
		
    	
        if (configLocation == null) {
            throw new IllegalArgumentException(
                    "Property 'configLocation' is required");
        }
        if (dataSource == null) {
            throw new IllegalArgumentException(
                    "Property 'dataSource' is required");
        }
        
        InputStream  xx =configLocation.getInputStream();
        InputStreamReader x = new InputStreamReader(xx);
        BufferedReader dis = new BufferedReader(x);
       

        XMLConfigBuilder parser = new XMLConfigBuilder(dis, null, properties);
        Configuration config = parser.parse();

        // override any environment from the configuration file
        // this will cause DefaultSqlSessionFactory to use a
        // ManagedTransactionFactory and a null DataSource
        // note this also means any SqlSessions opened from the factory must be
        // passed a Connection
        config.setEnvironment(null);

        sqlSessionFactory = new DefaultSqlSessionFactory(config,dataSource);
    }
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
}
