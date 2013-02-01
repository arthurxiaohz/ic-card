/*    */ package org.hi.framework.dao.ibatis3;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import org.apache.ibatis.session.SqlSession;
/*    */ import org.apache.ibatis.session.SqlSessionFactory;
/*    */ import org.springframework.jdbc.datasource.ConnectionHolder;
/*    */ import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/*    */ import org.springframework.transaction.TransactionDefinition;
/*    */ import org.springframework.transaction.TransactionException;
/*    */ import org.springframework.transaction.support.DefaultTransactionStatus;
/*    */ import org.springframework.transaction.support.TransactionSynchronizationManager;
/*    */ 
/*    */ public final class Ibatis3TransactionManager extends DataSourceTransactionManager
/*    */ {
/*    */   private static final long serialVersionUID = -8266556305791786416L;
/*    */   private SqlSessionFactory sessionFactory;
/*    */ 
/*    */   public void setSessionFactory(SqlSessionFactory sessionFactory)
/*    */   {
/* 27 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */ 
/*    */   protected Object doGetTransaction()
/*    */   {
/* 32 */     return super.doGetTransaction();
/*    */   }
/*    */ 
/*    */   protected void doBegin(Object transaction, TransactionDefinition definition)
/*    */   {
/* 37 */     super.doBegin(transaction, definition);
/*    */ 
/* 39 */     SqlSession session = (SqlSession)TransactionSynchronizationManager.getResource(this.sessionFactory);
/*    */ 
/* 41 */     if (session == null)
/*    */     {
/* 44 */       Connection connection = ((ConnectionHolder)
/* 45 */         TransactionSynchronizationManager.getResource(getDataSource())).getConnection();
/*    */ 
/* 47 */       session = new SpringSqlSession(this.sessionFactory.openSession(connection), getDataSource(), connection);
/*    */ 
/* 49 */       TransactionSynchronizationManager.bindResource(this.sessionFactory, session);
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void doCommit(DefaultTransactionStatus status)
/*    */   {
/* 55 */     ((SqlSession)TransactionSynchronizationManager.getResource(this.sessionFactory)).commit();
/*    */ 
/* 57 */     super.doCommit(status);
/*    */   }
/*    */ 
/*    */   protected void doRollback(DefaultTransactionStatus status)
/*    */     throws TransactionException
/*    */   {
/* 63 */     ((SqlSession)
/* 64 */       TransactionSynchronizationManager.getResource(this.sessionFactory)).rollback();
/*    */ 
/* 66 */     super.doRollback(status);
/*    */   }
/*    */ 
/*    */   protected void doCleanupAfterCompletion(Object transaction)
/*    */   {
/* 71 */     SqlSession session = (SqlSession)
/* 72 */       TransactionSynchronizationManager.unbindResource(this.sessionFactory);
/* 73 */     session.close();
/*    */ 
/* 75 */     super.doCleanupAfterCompletion(transaction);
/*    */   }
/*    */ 
/*    */   public void afterPropertiesSet()
/*    */   {
/* 80 */     super.afterPropertiesSet();
/*    */ 
/* 84 */     if (this.sessionFactory == null)
/* 85 */       throw new IllegalArgumentException(
/* 86 */         "Property 'sessionFactory' is required");
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.Ibatis3TransactionManager
 * JD-Core Version:    0.6.0
 */