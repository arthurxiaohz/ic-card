/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/*    */ 
/*    */ public class SpringJDBCTransactionManager extends DataSourceTransactionManager
/*    */ {
/*    */   SpringJDBCHiSessionFactory sessionFactory;
/*    */ 
/*    */   public SpringJDBCHiSessionFactory getSessionFactory()
/*    */   {
/* 10 */     return this.sessionFactory;
/*    */   }
/*    */ 
/*    */   public void setSessionFactory(SpringJDBCHiSessionFactory sessionFactory) {
/* 14 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.SpringJDBCTransactionManager
 * JD-Core Version:    0.6.0
 */