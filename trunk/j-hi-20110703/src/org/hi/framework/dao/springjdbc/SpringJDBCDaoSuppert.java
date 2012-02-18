package org.hi.framework.dao.springjdbc;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SpringJDBCDaoSuppert extends JdbcDaoSupport {
	protected SpringJDBCHiSessionFactory sessionFactory;
	
	public SpringJDBCHiSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SpringJDBCHiSessionFactory sessionFactory) {
		setDataSource(sessionFactory.getDataSource());
		this.sessionFactory = sessionFactory;
	}

}
