/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.framework.service.Manager;
/*    */ import org.hibernate.dialect.MySQLDialect;
/*    */ 
/*    */ public class HiMySQLDialect extends MySQLDialect
/*    */   implements HibernateHiDialect
/*    */ {
/* 12 */   private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal();
/*    */ 
/* 14 */   private final HibernateMySQLAgentDialect agent = new HibernateMySQLAgentDialect();
/*    */ 
/* 16 */   public String getMaxRecode(Object hql, Filter filter, Page page) { pageThreadLocal.set(page);
/* 17 */     return hql;
/*    */   }
/*    */ 
/*    */   public String transformSelectString(String select)
/*    */   {
/* 22 */     if (!select.matches("select\\s+.*\\s*count[(][\\*\\w\\.]+[)].+")) {
/* 23 */       return select;
/*    */     }
/* 25 */     select = select.trim();
/*    */ 
/* 27 */     if (select.matches(".+limit\\s[\\d?]{1,}$")) {
/* 28 */       return select;
/*    */     }
/*    */ 
/* 31 */     Page page = (Page)pageThreadLocal.get();
/* 32 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 34 */     if ((page != null) && (page.getMaxRecords() > 0))
/* 35 */       maxLimit = String.valueOf(page.getMaxRecords());
/* 36 */     return select + " limit " + maxLimit;
/*    */   }
/*    */   public String getDataBaseType() {
/* 39 */     return "MSSQL";
/*    */   }
/*    */ 
/*    */   public String getFilterSQL(Filter filter, Manager manager) {
/* 43 */     return this.agent.getFilterSQL(filter, manager);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.HiMySQLDialect
 * JD-Core Version:    0.6.0
 */