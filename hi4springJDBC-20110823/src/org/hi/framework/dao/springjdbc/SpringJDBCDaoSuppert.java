/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import org.springframework.jdbc.core.support.JdbcDaoSupport;
/*    */ 
/*    */ public class SpringJDBCDaoSuppert extends JdbcDaoSupport
/*    */ {
/*    */   protected SpringJDBCHiSessionFactory sessionFactory;
/*    */ 
/*    */   public SpringJDBCHiSessionFactory getSessionFactory()
/*    */   {
/* 10 */     return this.sessionFactory;
/*    */   }
/*    */ 
/*    */   public void setSessionFactory(SpringJDBCHiSessionFactory sessionFactory) {
/* 14 */     setDataSource(sessionFactory.getDataSource());
/* 15 */     this.sessionFactory = sessionFactory;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.SpringJDBCDaoSuppert
 * JD-Core Version:    0.6.0
 */