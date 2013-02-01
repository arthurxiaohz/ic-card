/*    */ package org.hi.framework.dao.springjdbc;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.sql.DataSource;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.AbstractOracleDialect;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
/*    */ 
/*    */ public class HiOracle9iDialect extends AbstractOracleDialect
/*    */   implements SpringJDBCHiDialect
/*    */ {
/*    */   public String getMaxRecode(Object query, Filter filter, Page page)
/*    */   {
/* 20 */     SpringJDBCQuery _query = (SpringJDBCQuery)query;
/* 21 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 23 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 24 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/* 26 */     if (!maxLimit.equals(String.valueOf(0))) {
/* 27 */       return null;
/*    */     }
/* 29 */     boolean isWhere = ((filter != null) && (filter.getConditions().size() > 0)) || 
/* 30 */       (_query.toString().contains("where"));
/* 31 */     if (isWhere)
/* 32 */       _query.append("and ");
/*    */     else {
/* 34 */       _query.append(" where ");
/*    */     }
/*    */ 
/* 37 */     _query.append(" rownum <= ").append(maxLimit);
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   public String getDataBaseType()
/*    */   {
/* 45 */     return "ORACLE";
/*    */   }
/*    */ 
/*    */   public String getLimitString(String querySelect, Page page) {
/* 49 */     if (page == null) {
/* 50 */       return querySelect;
/*    */     }
/* 52 */     String sql = querySelect.trim();
/* 53 */     boolean isForUpdate = false;
/* 54 */     boolean hasOffset = true;
/* 55 */     if (sql.toLowerCase().endsWith(" for update")) {
/* 56 */       sql = sql.substring(0, sql.length() - 11);
/* 57 */       isForUpdate = true;
/*    */     }
/*    */ 
/* 60 */     StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
/* 61 */     if (hasOffset) {
/* 62 */       pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
/*    */     }
/*    */     else {
/* 65 */       pagingSelect.append("select * from ( ");
/*    */     }
/* 67 */     pagingSelect.append(sql);
/* 68 */     if (hasOffset) {
/* 69 */       pagingSelect.append(" ) row_ where rownum <= " + page.getEndRowPosition() + ") where rownum_ > " + page.getStartRowPosition());
/*    */     }
/*    */     else {
/* 72 */       pagingSelect.append(" ) where rownum <=" + page.getEndRowPosition());
/*    */     }
/*    */ 
/* 75 */     if (isForUpdate) {
/* 76 */       pagingSelect.append(" for update");
/*    */     }
/*    */ 
/* 79 */     return pagingSelect.toString();
/*    */   }
/*    */ 
/*    */   public boolean inResult(int rowNum, Page page)
/*    */   {
/* 85 */     return true;
/*    */   }
/*    */ 
/*    */   public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values) {
/* 89 */     return sql;
/*    */   }
/*    */ 
/*    */   public Number getSelectKey(String entityName, DataSource dataSource) {
/* 93 */     OracleSequenceMaxValueIncrementer incr = new OracleSequenceMaxValueIncrementer(dataSource, "HIBERNATE_SEQUENCE");
/* 94 */     return Integer.valueOf(incr.nextIntValue());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.HiOracle9iDialect
 * JD-Core Version:    0.6.0
 */