/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.sql.DataSource;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.AbstractMySQLDialect;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.metadata.hsc.HSCHelper;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ 
/*    */ public class HiMySQLDialect extends AbstractMySQLDialect
/*    */   implements SpringJDBCHiDialect
/*    */ {
/*    */   public String getMaxRecode(Object query, Filter filter, Page page)
/*    */   {
/* 24 */     SpringJDBCQuery _query = (SpringJDBCQuery)query;
/* 25 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 27 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 28 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/*    */ 
/* 31 */     if (!maxLimit.equals(String.valueOf(0)))
/* 32 */       _query.append(" limit ").append(maxLimit);
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   public String getDataBaseType()
/*    */   {
/* 40 */     return "SQLSERVER";
/*    */   }
/*    */ 
/*    */   public String getLimitString(String querySelect, Page page) {
/* 44 */     if (page == null) {
/* 45 */       return querySelect;
/*    */     }
/* 47 */     return querySelect.length() + 20 + 
/* 48 */       querySelect + 
/* 49 */       new StringBuilder(" limit ").append(page.getStartRowPosition()).append(", ").append(page.getPageSize()).toString();
/*    */   }
/*    */ 
/*    */   public boolean inResult(int rowNum, Page page)
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */   public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values)
/*    */   {
/* 60 */     String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*    */ 
/* 63 */     Entity parentEntity = null;
/*    */     try {
/* 65 */       Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
/* 66 */       parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
/*    */     }
/*    */     catch (Exception e) {
/* 69 */       e.printStackTrace();
/*    */     }
/* 71 */     if (parentEntity != null) {
/* 72 */       return sql;
/*    */     }
/* 74 */     StringBuffer sb = new StringBuffer();
/*    */ 
/* 76 */     List list = StringUtils.dividToList(sql, "(", ",");
/* 77 */     for (String string : list) {
/* 78 */       if ((StringUtils.isInclude(string, "(")) && (StringUtils.isInclude(string, ","))) {
/* 79 */         sb.append("(");
/*    */       }
/*    */       else {
/* 82 */         sb.append(string);
/*    */       }
/*    */     }
/*    */ 
/* 86 */     if (values != null) {
/* 87 */       values.remove(0);
/*    */     }
/* 89 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public Number getSelectKey(String entityName, DataSource dataSource)
/*    */   {
/* 94 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.HiMySQLDialect
 * JD-Core Version:    0.6.0
 */