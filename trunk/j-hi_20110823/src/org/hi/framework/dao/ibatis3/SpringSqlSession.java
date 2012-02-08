package org.hi.framework.dao.ibatis3;

import org.springframework.beans.factory.InitializingBean;

import org.apache.ibatis.session.SqlSession;

import org.springframework.jdbc.support.JdbcAccessor;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import java.util.List;

import org.apache.ibatis.exceptions.IbatisException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.result.ResultHandler;
import org.apache.ibatis.mapping.Configuration;

/**
 * Extension of SqlSession that handles exception translation from Ibatis 3 to
 * Spring's exception framework.
 */
@SuppressWarnings("unchecked")
public final class SpringSqlSession extends JdbcAccessor implements SqlSession, InitializingBean {
    private SqlSession delegate;

    // Spring will be managing the connection, but carry a handle to the
    // connection so that it can be retrieved later and closed
    // this will probably be obviated when/if DefaultSqlSession allows access to
    // the connection -- see http://issues.apache.org/jira/browse/IBATIS-634
    private Connection connection;

    private boolean runningInTransaction = true;

    SpringSqlSession() {}

    SpringSqlSession(SqlSession delegate, DataSource dataSource,
            Connection connection) {
        this.delegate = delegate;
        setDataSource(dataSource);
        this.connection = connection;
        afterPropertiesSet();
    }

    public void setDelegate(SqlSession delegate) {
        this.delegate = delegate;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isRunningInTransaction() {
        return runningInTransaction;
    }

    public void setRunningInTransaction(boolean runningInTransaction) {
        this.runningInTransaction = runningInTransaction;
    }

    public void afterPropertiesSet() {
        if (delegate == null) {
            throw new IllegalArgumentException(
                    "Property 'delegate' is required");
        }

        if (connection == null) {
            throw new IllegalArgumentException(
                    "Property 'connection' is required");
        }

        super.afterPropertiesSet();
    }

    public Object selectOne(String statement) {
        return selectOne(statement, null);
    }

    public Object selectOne(final String statement, final Object parameter) {
        try {
            return delegate.selectOne(statement, parameter);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "selectOne", statement);
        }
    }

    public List selectList(String statement) {
        return selectList(statement, null);
    }

    public List selectList(String statement, Object parameter) {
        return selectList(statement, parameter, Executor.NO_ROW_OFFSET,
                Executor.NO_ROW_LIMIT);
    }

    public List selectList(final String statement, final Object parameter,
            final int offset, final int limit) {
        try {
            return delegate.selectList(statement, parameter, offset, limit);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "selectList", statement);
        }
    }

    public void select(String statement, Object parameter, ResultHandler handler) {
        select(statement, parameter, Executor.NO_ROW_OFFSET,
                Executor.NO_ROW_LIMIT, handler);
    }

    public void select(final String statement, final Object parameter,
            final int offset, final int limit, final ResultHandler handler) {
        try {
            delegate.select(statement, parameter, offset, limit, handler);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "select", statement);
        }
    }

    public int insert(String statement) {
        return insert(statement, null);
    }

    public int insert(String statement, Object parameter) {
        try {
            return delegate.insert(statement, parameter);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "insert", statement);
        }

    }

    public int update(String statement) {
        return update(statement, null);
    }

    public int update(final String statement, final Object parameter) {
        try {
            return delegate.update(statement, parameter);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "update", statement);
        }
    }

    public int delete(String statement) {
        return update(statement, null);
    }

    public int delete(String statement, Object parameter) {
        try {
            return delegate.delete(statement, parameter);
        }
        catch (IbatisException ie) {
            throw translateIbatisException(ie, "delete", statement);
        }
    }

    public void commit() {
        if (delegate != null) {
            delegate.commit();
        }
    }

    public void commit(boolean force) {
        if (delegate != null) {
            delegate.commit(force);
        }
    }

    public void rollback() {
        if (delegate != null) {
            delegate.rollback();
        }
    }

    public void rollback(boolean force) {
        if (delegate != null) {
            delegate.rollback(force);
        }
    }

    public void close() {
        if (delegate != null) {
            delegate.close();
        }
    }

    public Configuration getConfiguration() {
        return delegate == null ? null : delegate.getConfiguration();
    }

    public <T> T getMapper(Class<T> type) {
        return delegate == null ? null : delegate.getMapper(type);
    }

    // do we want / need to translate the IbatisException hierarchy into Spring's?
    private RuntimeException translateIbatisException(IbatisException ie,
            String methodName, String statement) {
        if (ie.getCause() instanceof SQLException) {
            return getExceptionTranslator().translate(methodName, statement,
                    (SQLException) ie.getCause());
        }
        else {
            return ie;
        }
    }
}
