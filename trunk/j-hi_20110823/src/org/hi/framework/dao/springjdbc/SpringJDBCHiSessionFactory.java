package org.hi.framework.dao.springjdbc;

import java.util.Properties;

import javax.sql.DataSource;

import org.hi.common.util.BeanUtil;
import org.springframework.beans.factory.InitializingBean;


public class SpringJDBCHiSessionFactory implements InitializingBean{
	private boolean sqlShow;
	private SpringJDBCHiDialect dialect;
	private DataSource dataSource;
	private Properties properties;
	
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
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public SpringJDBCHiDialect getDialect() {
		return dialect;
	}

	public void afterPropertiesSet() throws Exception {
//		¥¶¿Ì∑Ω—‘
		if(dialect == null){
			String dialectValue = properties.getProperty(SpringJDBCHiDialect.HI_PROPERTY_DIALET_KEY);
			if(dialectValue != null)
				this.dialect = (SpringJDBCHiDialect)BeanUtil.CreateObject(dialectValue);
		}
		
	}
	
	
}
