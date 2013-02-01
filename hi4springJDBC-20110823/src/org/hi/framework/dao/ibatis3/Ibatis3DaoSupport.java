/*     */ package org.hi.framework.dao.ibatis3;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import javax.sql.DataSource;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.ibatis.session.SqlSession;
/*     */ import org.apache.ibatis.session.SqlSessionFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.springframework.dao.support.DaoSupport;
/*     */ import org.springframework.jdbc.CannotGetJdbcConnectionException;
/*     */ import org.springframework.transaction.support.TransactionSynchronizationManager;
/*     */ 
/*     */ public class Ibatis3DaoSupport extends DaoSupport
/*     */ {
/*     */   private SqlSessionFactory sessionFactory;
/*     */   private DataSource dataSource;
/*     */ 
/*     */   public SqlSession openSession()
/*     */   {
/*  28 */     SqlSession session = (SqlSession)TransactionSynchronizationManager.getResource(this.sessionFactory);
/*     */ 
/*  31 */     if (session == null) {
/*  32 */       session = createSpringSqlSession();
/*     */     }
/*     */ 
/*  35 */     return session;
/*     */   }
/*     */ 
/*     */   public SqlSessionFactory getSessionFactory() {
/*  39 */     return this.sessionFactory;
/*     */   }
/*     */ 
/*     */   public void setSessionFactory(SqlSessionFactory sessionFactory) {
/*  43 */     this.sessionFactory = sessionFactory;
/*     */   }
/*     */ 
/*     */   public DataSource getDataSource() {
/*  47 */     return this.dataSource;
/*     */   }
/*     */ 
/*     */   public void setDataSource(DataSource dataSource) {
/*  51 */     this.dataSource = dataSource;
/*     */   }
/*     */ 
/*     */   public Object execute(SqlSessionCallback callback)
/*     */     throws SQLException
/*     */   {
/*  57 */     SqlSession session = openSession();
/*     */     try
/*     */     {
/*  60 */       Object localObject2 = callback.doInSqlSession(session);
/*     */       SpringSqlSession springSession;
/*     */       Connection con;
/*     */       return localObject2;
/*     */     }
/*     */     finally
/*     */     {
/*  65 */       SpringSqlSession springSession = (SpringSqlSession)session;
/*     */ 
/*  67 */       if (!springSession.isRunningInTransaction()) {
/*  68 */         Connection con = springSession.getConnection();
/*     */ 
/*  70 */         if ((con != null) && (!con.isClosed())) {
/*     */           try {
/*  72 */             con.close();
/*     */           }
/*     */           catch (Exception localException1)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  80 */     throw localObject1;
/*     */   }
/*     */ 
/*     */   protected void checkDaoConfig() throws IllegalArgumentException
/*     */   {
/*  85 */     SpringSqlSessionFactoryBuilder clientFactory = (SpringSqlSessionFactoryBuilder)SpringContextHolder.getBean("&sessionFactory");
/*  86 */     if (this.sessionFactory == null) {
/*  87 */       if (clientFactory.getSqlSessionFactory() == null)
/*  88 */         throw new IllegalArgumentException(
/*  89 */           "Property 'sessionFactory' is required");
/*  90 */       this.sessionFactory = clientFactory.getSqlSessionFactory();
/*     */     }
/*     */ 
/*  93 */     if (this.dataSource == null) {
/*  94 */       if (clientFactory.getDataSource() == null)
/*  95 */         throw new IllegalArgumentException(
/*  96 */           "Property 'dataSource' is required");
/*  97 */       this.dataSource = clientFactory.getDataSource();
/*     */     }
/*     */   }
/*     */ 
/*     */   private SqlSession createSpringSqlSession()
/*     */   {
/* 103 */     if (this.logger.isDebugEnabled()) {
/* 104 */       this.logger
/* 105 */         .debug("creating SqlSession as SpringSqlSession with DataSource " + 
/* 106 */         this.dataSource);
/*     */     }
/*     */ 
/* 109 */     Connection con = null;
/*     */     try
/*     */     {
/* 112 */       con = this.dataSource.getConnection();
/*     */     }
/*     */     catch (SQLException sqle) {
/* 115 */       throw new CannotGetJdbcConnectionException(
/* 116 */         "Could not get JDBC Connection", sqle);
/*     */     }
/*     */ 
/* 119 */     SpringSqlSession session = new SpringSqlSession(this.sessionFactory.openSession(con), this.dataSource, con);
/* 120 */     session.setRunningInTransaction(false);
/* 121 */     return session;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.Ibatis3DaoSupport
 * JD-Core Version:    0.6.0
 */