/*     */ package org.hi.framework.dao.springjdbc;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.sql.DataSource;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.AbstractSQLServerDialect;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.metadata.hsc.HSCHelper;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ 
/*     */ public class HiSQLServerDialect extends AbstractSQLServerDialect
/*     */   implements SpringJDBCHiDialect
/*     */ {
/*     */   public String getMaxRecode(Object query, Filter filter, Page page)
/*     */   {
/*  23 */     SpringJDBCQuery _query = (SpringJDBCQuery)query;
/*  24 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*     */ 
/*  26 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/*  27 */       maxLimit = String.valueOf(page.getMaxRecords());
/*     */     }
/*  29 */     String top = " top " + maxLimit + " ";
/*     */ 
/*  31 */     if (!maxLimit.equals(String.valueOf(0)))
/*  32 */       _query.replaceAll("select", "select" + top);
/*  33 */     return null;
/*     */   }
/*     */ 
/*     */   public String getDataBaseType()
/*     */   {
/*  40 */     return "SQLSERVER";
/*     */   }
/*     */ 
/*     */   public String getLimitString(String querySelect, Page page) {
/*  44 */     if (page == null) {
/*  45 */       return querySelect;
/*     */     }
/*  47 */     int limit = page.getEndRowPosition();
/*     */ 
/*  49 */     return new StringBuffer(querySelect.length() + 8)
/*  50 */       .append(querySelect)
/*  51 */       .insert(getAfterSelectInsertPoint(querySelect), " top " + limit)
/*  52 */       .toString();
/*     */   }
/*     */ 
/*     */   static int getAfterSelectInsertPoint(String sql) {
/*  56 */     int selectIndex = sql.toLowerCase().indexOf("select");
/*  57 */     int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
/*  58 */     return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
/*     */   }
/*     */ 
/*     */   public boolean inResult(int rowNum, Page page) {
/*  62 */     if (page == null)
/*  63 */       return true;
/*  64 */     return rowNum >= page.getStartRowPosition();
/*     */   }
/*     */ 
/*     */   public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values)
/*     */   {
/*  69 */     String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*     */ 
/*  72 */     Entity parentEntity = null;
/*     */     try {
/*  74 */       Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
/*  75 */       parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
/*     */     }
/*     */     catch (Exception e) {
/*  78 */       e.printStackTrace();
/*     */     }
/*  80 */     if (parentEntity != null) {
/*  81 */       return sql;
/*     */     }
/*  83 */     StringBuffer sb = new StringBuffer();
/*     */ 
/*  85 */     List list = StringUtils.dividToList(sql, "(", ",");
/*  86 */     for (String string : list) {
/*  87 */       if ((StringUtils.isInclude(string, "(")) && (StringUtils.isInclude(string, ","))) {
/*  88 */         sb.append("(");
/*     */       }
/*     */       else {
/*  91 */         sb.append(string);
/*     */       }
/*     */     }
/*     */ 
/*  95 */     if (values != null) {
/*  96 */       values.remove(0);
/*     */     }
/*  98 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Number getSelectKey(String entityName, DataSource dataSource)
/*     */   {
/* 103 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.HiSQLServerDialect
 * JD-Core Version:    0.6.0
 */