/*     */ package org.hi.framework.dao.ibatis3;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import javax.sql.DataSource;
/*     */ import org.apache.ibatis.exceptions.IbatisException;
/*     */ import org.apache.ibatis.executor.result.ResultHandler;
/*     */ import org.apache.ibatis.mapping.Configuration;
/*     */ import org.apache.ibatis.session.SqlSession;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.jdbc.support.JdbcAccessor;
/*     */ import org.springframework.jdbc.support.SQLExceptionTranslator;
/*     */ 
/*     */ public final class SpringSqlSession extends JdbcAccessor
/*     */   implements SqlSession, InitializingBean
/*     */ {
/*     */   private SqlSession delegate;
/*     */   private Connection connection;
/*  34 */   private boolean runningInTransaction = true;
/*     */ 
/*     */   SpringSqlSession() {
/*     */   }
/*     */ 
/*     */   SpringSqlSession(SqlSession delegate, DataSource dataSource, Connection connection) {
/*  40 */     this.delegate = delegate;
/*  41 */     setDataSource(dataSource);
/*  42 */     this.connection = connection;
/*  43 */     afterPropertiesSet();
/*     */   }
/*     */ 
/*     */   public void setDelegate(SqlSession delegate) {
/*  47 */     this.delegate = delegate;
/*     */   }
/*     */ 
/*     */   public Connection getConnection() {
/*  51 */     return this.connection;
/*     */   }
/*     */ 
/*     */   public void setConnection(Connection connection) {
/*  55 */     this.connection = connection;
/*     */   }
/*     */ 
/*     */   public boolean isRunningInTransaction() {
/*  59 */     return this.runningInTransaction;
/*     */   }
/*     */ 
/*     */   public void setRunningInTransaction(boolean runningInTransaction) {
/*  63 */     this.runningInTransaction = runningInTransaction;
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet() {
/*  67 */     if (this.delegate == null) {
/*  68 */       throw new IllegalArgumentException(
/*  69 */         "Property 'delegate' is required");
/*     */     }
/*     */ 
/*  72 */     if (this.connection == null) {
/*  73 */       throw new IllegalArgumentException(
/*  74 */         "Property 'connection' is required");
/*     */     }
/*     */ 
/*  77 */     super.afterPropertiesSet();
/*     */   }
/*     */ 
/*     */   public Object selectOne(String statement) {
/*  81 */     return selectOne(statement, null);
/*     */   }
/*     */ 
/*     */   public Object selectOne(String statement, Object parameter) {
/*     */     try {
/*  86 */       return this.delegate.selectOne(statement, parameter);
/*     */     } catch (IbatisException ie) {
/*     */     }
/*  89 */     throw translateIbatisException(ie, "selectOne", statement);
/*     */   }
/*     */ 
/*     */   public List selectList(String statement)
/*     */   {
/*  94 */     return selectList(statement, null);
/*     */   }
/*     */ 
/*     */   public List selectList(String statement, Object parameter) {
/*  98 */     return selectList(statement, parameter, 0, 
/*  99 */       2147483647);
/*     */   }
/*     */ 
/*     */   public List selectList(String statement, Object parameter, int offset, int limit)
/*     */   {
/*     */     try {
/* 105 */       return this.delegate.selectList(statement, parameter, offset, limit);
/*     */     } catch (IbatisException ie) {
/*     */     }
/* 108 */     throw translateIbatisException(ie, "selectList", statement);
/*     */   }
/*     */ 
/*     */   public void select(String statement, Object parameter, ResultHandler handler)
/*     */   {
/* 113 */     select(statement, parameter, 0, 
/* 114 */       2147483647, handler);
/*     */   }
/*     */ 
/*     */   public void select(String statement, Object parameter, int offset, int limit, ResultHandler handler)
/*     */   {
/*     */     try {
/* 120 */       this.delegate.select(statement, parameter, offset, limit, handler);
/*     */     }
/*     */     catch (IbatisException ie) {
/* 123 */       throw translateIbatisException(ie, "select", statement);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int insert(String statement) {
/* 128 */     return insert(statement, null);
/*     */   }
/*     */ 
/*     */   public int insert(String statement, Object parameter) {
/*     */     try {
/* 133 */       return this.delegate.insert(statement, parameter);
/*     */     } catch (IbatisException ie) {
/*     */     }
/* 136 */     throw translateIbatisException(ie, "insert", statement);
/*     */   }
/*     */ 
/*     */   public int update(String statement)
/*     */   {
/* 142 */     return update(statement, null);
/*     */   }
/*     */ 
/*     */   public int update(String statement, Object parameter) {
/*     */     try {
/* 147 */       return this.delegate.update(statement, parameter);
/*     */     } catch (IbatisException ie) {
/*     */     }
/* 150 */     throw translateIbatisException(ie, "update", statement);
/*     */   }
/*     */ 
/*     */   public int delete(String statement)
/*     */   {
/* 155 */     return update(statement, null);
/*     */   }
/*     */ 
/*     */   public int delete(String statement, Object parameter) {
/*     */     try {
/* 160 */       return this.delegate.delete(statement, parameter);
/*     */     } catch (IbatisException ie) {
/*     */     }
/* 163 */     throw translateIbatisException(ie, "delete", statement);
/*     */   }
/*     */ 
/*     */   public void commit()
/*     */   {
/* 168 */     if (this.delegate != null)
/* 169 */       this.delegate.commit();
/*     */   }
/*     */ 
/*     */   public void commit(boolean force)
/*     */   {
/* 174 */     if (this.delegate != null)
/* 175 */       this.delegate.commit(force);
/*     */   }
/*     */ 
/*     */   public void rollback()
/*     */   {
/* 180 */     if (this.delegate != null)
/* 181 */       this.delegate.rollback();
/*     */   }
/*     */ 
/*     */   public void rollback(boolean force)
/*     */   {
/* 186 */     if (this.delegate != null)
/* 187 */       this.delegate.rollback(force);
/*     */   }
/*     */ 
/*     */   public void close()
/*     */   {
/* 192 */     if (this.delegate != null)
/* 193 */       this.delegate.close();
/*     */   }
/*     */ 
/*     */   public Configuration getConfiguration()
/*     */   {
/* 198 */     return this.delegate == null ? null : this.delegate.getConfiguration();
/*     */   }
/*     */ 
/*     */   public <T> T getMapper(Class<T> type) {
/* 202 */     return this.delegate == null ? null : this.delegate.getMapper(type);
/*     */   }
/*     */ 
/*     */   private RuntimeException translateIbatisException(IbatisException ie, String methodName, String statement)
/*     */   {
/* 208 */     if ((ie.getCause() instanceof SQLException)) {
/* 209 */       return getExceptionTranslator().translate(methodName, statement, 
/* 210 */         (SQLException)ie.getCause());
/*     */     }
/*     */ 
/* 213 */     return ie;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.SpringSqlSession
 * JD-Core Version:    0.6.0
 */