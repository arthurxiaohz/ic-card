/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.framework.service.Manager;
/*    */ import org.hibernate.dialect.SQLServerDialect;
/*    */ 
/*    */ public class HiSQLServerDialect extends SQLServerDialect
/*    */   implements HibernateHiDialect
/*    */ {
/* 11 */   private HibernateSQLServerAgentDialect agent = new HibernateSQLServerAgentDialect();
/*    */ 
/* 13 */   public String getMaxRecode(Object hql, Filter filter, Page page) { String _hql = (String)hql;
/* 14 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 16 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 17 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/* 19 */     String top = " top " + maxLimit + " ";
/*    */ 
/* 21 */     _hql.replaceAll("select", "select" + top);
/* 22 */     return _hql; }
/*    */ 
/*    */   public String getDataBaseType() {
/* 25 */     return "SQLSERVER";
/*    */   }
/*    */   public String getFilterSQL(Filter filter, Manager manager) {
/* 28 */     return this.agent.getFilterSQL(filter, manager);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.HiSQLServerDialect
 * JD-Core Version:    0.6.0
 */