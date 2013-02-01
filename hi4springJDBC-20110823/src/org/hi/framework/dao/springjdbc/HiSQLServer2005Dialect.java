/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import org.hi.framework.paging.Page;
/*    */ 
/*    */ public class HiSQLServer2005Dialect extends HiSQLServerDialect
/*    */   implements SpringJDBCHiDialect
/*    */ {
/*    */   private static final String SELECT = "select";
/*    */   private static final String FROM = "from";
/*    */   private static final String DISTINCT = "distinct";
/*    */ 
/*    */   public String getLimitString(String querySelect, Page page)
/*    */   {
/* 15 */     StringBuilder sb = new StringBuilder(querySelect.trim().toLowerCase());
/*    */ 
/* 17 */     int orderByIndex = sb.indexOf("order by");
/* 18 */     CharSequence orderby = orderByIndex > 0 ? sb.subSequence(orderByIndex, sb.length()) : 
/* 19 */       "ORDER BY CURRENT_TIMESTAMP";
/*    */ 
/* 22 */     if (orderByIndex > 0) {
/* 23 */       sb.delete(orderByIndex, orderByIndex + orderby.length());
/*    */     }
/*    */ 
/* 27 */     replaceDistinctWithGroupBy(sb);
/*    */ 
/* 29 */     insertRowNumberFunction(sb, orderby);
/*    */ 
/* 32 */     sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");
/* 33 */     sb.append("WHERE __hi_row_nr__ BETWEEN " + (page.getStartRowPosition() + 1) + " AND " + page.getEndRowPosition() + " ");
/*    */ 
/* 35 */     return sb.toString();
/*    */   }
/*    */   protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
/* 38 */     int distinctIndex = sql.indexOf("distinct");
/* 39 */     if (distinctIndex > 0) {
/* 40 */       sql.delete(distinctIndex, distinctIndex + "distinct".length() + 1);
/* 41 */       sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
/*    */     }
/*    */   }
/*    */ 
/*    */   protected static void insertRowNumberFunction(StringBuilder sql, CharSequence orderby)
/*    */   {
/* 47 */     int selectEndIndex = sql.indexOf("select") + "select".length();
/*    */ 
/* 50 */     sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby + ") as __hi_row_nr__,");
/*    */   }
/*    */   protected static CharSequence getSelectFieldsWithoutAliases(StringBuilder sql) {
/* 53 */     String select = sql.substring(sql.indexOf("select") + "select".length(), sql.indexOf("from"));
/*    */ 
/* 56 */     return stripAliases(select);
/*    */   }
/*    */ 
/*    */   protected static String stripAliases(String str) {
/* 60 */     return str.replaceAll("\\sas[^,]+(,?)", "$1");
/*    */   }
/*    */ 
/*    */   public boolean inResult(int rowNum, Page page) {
/* 64 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.HiSQLServer2005Dialect
 * JD-Core Version:    0.6.0
 */