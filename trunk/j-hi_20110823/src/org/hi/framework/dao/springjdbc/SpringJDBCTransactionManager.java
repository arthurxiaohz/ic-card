package org.hi.framework.dao.springjdbc;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class SpringJDBCTransactionManager extends DataSourceTransactionManager {
	
	SpringJDBCHiSessionFactory sessionFactory;
	
	public SpringJDBCHiSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SpringJDBCHiSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
