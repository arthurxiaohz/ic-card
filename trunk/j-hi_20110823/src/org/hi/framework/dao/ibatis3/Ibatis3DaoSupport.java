package org.hi.framework.dao.ibatis3;

import java.sql.SQLException;

import org.springframework.dao.support.DaoSupport;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.hi.SpringContextHolder;

import javax.sql.DataSource;

public class Ibatis3DaoSupport extends DaoSupport {
    private SqlSessionFactory sessionFactory;
    private DataSource dataSource;

    // notice there is no closeSession() - assume that the TransactionManager
    // will handle that. If not running in a Transaction, subclasses will need
    // to call execute.
   
    public SqlSession openSession() {
        // if in an existing transaction, this will return the associated
        // SqlSession
        // see Ibatis3TransactionManager
        // is there a better way to figure out if there is an existing tx?
        SqlSession session = (SqlSession) TransactionSynchronizationManager.getResource(sessionFactory);

        // otherwise, create a new SqlSession
        if (session == null) {
            session = createSpringSqlSession();
        }

        return session;
    }

    public SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//     note that the callback will need to get the mapper too as part of the
//     session
    public Object execute(SqlSessionCallback callback) throws SQLException {
        SqlSession session = openSession();

        try {
            return callback.doInSqlSession(session);
        }
        finally {
//            session.close();

            SpringSqlSession springSession = (SpringSqlSession) session;

            if (!springSession.isRunningInTransaction()) {
                java.sql.Connection con = springSession.getConnection();

                if (con != null&&!con.isClosed()) {
                        try {
							con.close();
						} catch (Exception e) {
						}
                  
                }
             
            }
            
        }
    }

    @Override
    protected void checkDaoConfig() throws IllegalArgumentException {
  	  SpringSqlSessionFactoryBuilder clientFactory = (SpringSqlSessionFactoryBuilder)SpringContextHolder.getBean("&sessionFactory");
        if (sessionFactory == null) {
        	if(clientFactory.getSqlSessionFactory()==null)
              throw new IllegalArgumentException(
                    "Property 'sessionFactory' is required");
        	sessionFactory=clientFactory.getSqlSessionFactory();
        }

        if (dataSource == null) {
        	if(clientFactory.getDataSource()==null)
              throw new IllegalArgumentException(
                    "Property 'dataSource' is required");
        	dataSource=clientFactory.getDataSource();
        	
        }
    }

    private SqlSession createSpringSqlSession() {
        if (logger.isDebugEnabled()) {
            logger
                    .debug("creating SqlSession as SpringSqlSession with DataSource "
                            + dataSource);
        }

        java.sql.Connection con = null;

        try {
            con = dataSource.getConnection();
        }
        catch (java.sql.SQLException sqle) {
            throw new org.springframework.jdbc.CannotGetJdbcConnectionException(
                    "Could not get JDBC Connection", sqle);
        }

        SpringSqlSession session = new SpringSqlSession(sessionFactory.openSession(con), dataSource, con);
        session.setRunningInTransaction(false);
        return session;
    }
}
