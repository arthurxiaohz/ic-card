/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.AbstractOracleDialect;
/*    */ import org.hi.framework.paging.Page;
/*    */ 
/*    */ class HibernateOracleAgentDialect extends AbstractOracleDialect
/*    */ {
/*    */   /** @deprecated */
/*    */   public String getDataBaseType()
/*    */   {
/* 13 */     return null;
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public String getMaxRecode(Object query, Filter filter, Page page)
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.HibernateOracleAgentDialect
 * JD-Core Version:    0.6.0
 */