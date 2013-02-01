/*    */ package org.hi.framework.dao.ibatis3;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections.map.LinkedMap;
/*    */ import org.hi.framework.dao.ibatis.IQuery;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ 
/*    */ public class Query extends LinkedMap
/*    */   implements IQuery
/*    */ {
/* 21 */   StringBuffer querySql = new StringBuffer();
/*    */   Entity entity;
/*    */   Class clazz;
/* 32 */   Map<String, Object> parameterObject = new LinkedHashMap();
/*    */ 
/* 34 */   int step = 0;
/*    */ 
/* 36 */   public void putParameter(String parameterName, Object obj) { this.parameterObject.put(parameterName + this.step, obj);
/* 37 */     this.step += 1; }
/*    */ 
/*    */   public Query append(String sqlSegment)
/*    */   {
/* 41 */     this.querySql.append(sqlSegment);
/* 42 */     return this;
/*    */   }
/*    */ 
/*    */   public Query append(StringBuffer sqlSegment) {
/* 46 */     this.querySql.append(sqlSegment);
/* 47 */     return this;
/*    */   }
/*    */ 
/*    */   public StringBuffer getQuerySql() {
/* 51 */     return this.querySql;
/*    */   }
/*    */ 
/*    */   public Map<String, Object> getParameterObject() {
/* 55 */     return this.parameterObject;
/*    */   }
/*    */ 
/*    */   public void replaceAll(String regex, String replacement) {
/* 59 */     String _sql = this.querySql.toString().replaceAll(regex, replacement);
/* 60 */     this.querySql = new StringBuffer(_sql);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 64 */     return this.querySql.toString();
/*    */   }
/*    */ 
/*    */   public Object get(Object key) {
/* 68 */     return this.parameterObject.get(key);
/*    */   }
/*    */ 
/*    */   public Entity getEntity() {
/* 72 */     return this.entity;
/*    */   }
/*    */ 
/*    */   public void setEntity(Entity entity) {
/* 76 */     this.entity = entity;
/*    */   }
/*    */ 
/*    */   public Class getClazz() {
/* 80 */     return this.clazz;
/*    */   }
/*    */ 
/*    */   public void setClazz(Class clazz) {
/* 84 */     this.clazz = clazz;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.Query
 * JD-Core Version:    0.6.0
 */