/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class Query
/*    */   implements IQuery
/*    */ {
/* 17 */   StringBuffer querySql = new StringBuffer();
/*    */ 
/* 22 */   Map<String, Object> parameterObject = new LinkedHashMap();
/*    */ 
/*    */   public void putParameter(String parameterName, Object obj) {
/* 25 */     this.parameterObject.put(parameterName, obj);
/*    */   }
/*    */ 
/*    */   public Query append(String sqlSegment) {
/* 29 */     this.querySql.append(sqlSegment);
/* 30 */     return this;
/*    */   }
/*    */ 
/*    */   public Query append(StringBuffer sqlSegment) {
/* 34 */     this.querySql.append(sqlSegment);
/* 35 */     return this;
/*    */   }
/*    */ 
/*    */   public StringBuffer getQuerySql() {
/* 39 */     return this.querySql;
/*    */   }
/*    */ 
/*    */   public Map<String, Object> getParameterObject() {
/* 43 */     return this.parameterObject;
/*    */   }
/*    */ 
/*    */   public void replaceAll(String regex, String replacement) {
/* 47 */     String _sql = this.querySql.toString().replaceAll(regex, replacement);
/* 48 */     this.querySql = new StringBuffer(_sql);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 52 */     return this.querySql.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.Query
 * JD-Core Version:    0.6.0
 */