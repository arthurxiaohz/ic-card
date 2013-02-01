/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.framework.service.Manager;
/*    */ import org.hibernate.dialect.Oracle9Dialect;
/*    */ 
/*    */ public class HiOracle9iDialect extends Oracle9Dialect
/*    */   implements HibernateHiDialect
/*    */ {
/* 12 */   private HibernateOracleAgentDialect agent = new HibernateOracleAgentDialect();
/*    */ 
/*    */   public String getMaxRecode(Object hql, Filter filter, Page page) {
/* 15 */     String _hql = (String)hql;
/* 16 */     boolean isWhere = (filter != null) && (filter.getConditions().size() > 0);
/* 17 */     if (isWhere)
/* 18 */       _hql = _hql + "and ";
/*    */     else {
/* 20 */       _hql = _hql + " where ";
/*    */     }
/* 22 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 24 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 25 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/* 27 */     return _hql + " rownum <= " + maxLimit + " ";
/*    */   }
/*    */   public String getDataBaseType() {
/* 30 */     return "ORACLE";
/*    */   }
/*    */   public String getFilterSQL(Filter filter, Manager manager) {
/* 33 */     return this.agent.getFilterSQL(filter, manager);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.HiOracle9iDialect
 * JD-Core Version:    0.6.0
 */