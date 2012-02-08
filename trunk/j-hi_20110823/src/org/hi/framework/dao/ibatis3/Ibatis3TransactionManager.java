package org.hi.framework.dao.ibatis3;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import org.springframework.jdbc.datasource.ConnectionHolder;
import java.sql.Connection;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

// Assume that suspending / resuming a tx will be handled by the
// DataSourceTransactionManager and this will not change the SqlSession.
// This is probably an _incorrect_ assumption, but to suspend both the
// SqlSession and the
// Connection, we would need a wrapper object that holds both.
public final class Ibatis3TransactionManager extends DataSourceTransactionManager {
    private static final long serialVersionUID = -8266556305791786416L;

    private SqlSessionFactory sessionFactory;

    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
    protected Object doGetTransaction() {
        return super.doGetTransaction();
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        super.doBegin(transaction, definition);

        SqlSession session = (SqlSession) TransactionSynchronizationManager.getResource(sessionFactory);

        if (session == null) {
            // DataSourceTransactionManager should have created a connection in
            // doBegin()
            Connection connection = ((ConnectionHolder) TransactionSynchronizationManager
                    .getResource(getDataSource())).getConnection();

            session = new SpringSqlSession(sessionFactory.openSession(connection), getDataSource(), connection);

            TransactionSynchronizationManager.bindResource(sessionFactory, session);
        }
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        ((SqlSession) TransactionSynchronizationManager.getResource(sessionFactory)).commit();

        super.doCommit(status);
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status)
            throws TransactionException {
        ((SqlSession) TransactionSynchronizationManager
                .getResource(sessionFactory)).rollback();

        super.doRollback(status);
    }

    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        SqlSession session = (SqlSession) TransactionSynchronizationManager
                .unbindResource(sessionFactory);
        session.close();

        super.doCleanupAfterCompletion(transaction);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        
//        sessionFactory = sessionFactoryBuilder.getSqlSessionFactory();
        
        if (sessionFactory == null) {
            throw new IllegalArgumentException(
                    "Property 'sessionFactory' is required");
        }
    }
}
