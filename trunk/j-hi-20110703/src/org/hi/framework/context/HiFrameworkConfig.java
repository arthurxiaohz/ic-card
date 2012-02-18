package org.hi.framework.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

/**
 * 该类用于加载Hi平台运行时配置信息
 * @author 张昊
 * @since 2007-5-20
 *
 */
public class HiFrameworkConfig {
	protected final  Log logger = LogFactory.getLog(HiFrameworkConfig.class);
	private Resource location;

	/**
	 * 得到hi平台运行时配置信息，对应的是/WEB-INF/config/hiFrameworkConfig.properties文件
	 * @return 返回hiFrameworkConfig.properties文件的Properties对象
	 */
	public Properties getConfig() {
		Properties props = null;
    
		try {
        	props = new Properties();
        	logger.info("loading properties file :" + location.getFilename());
        	InputStream is = location.getInputStream();
			props.load( is );
			is.close();
		} catch (IOException e) {
			logger.error("Unable to load " +  location.getFilename(), e);
			return null;
			
		}
		return props;
	}
	

	public Resource getLocation() {
		return location;
	}

	public void setLocation(Resource location) {
		this.location = location;
	}
}
