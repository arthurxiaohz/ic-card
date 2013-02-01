/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletContext;
/*    */ import org.apache.ibatis.mapping.ParameterMapping;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.AbstractOracleDialect;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.metadata.hsc.HSCHelper;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ 
/*    */ public class HiOracle9iDialect extends AbstractOracleDialect
/*    */   implements IbatisHiDialect
/*    */ {
/*    */   public String getSelectKey(String entityName)
/*    */   {
/* 22 */     String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*    */ 
/* 25 */     Entity parentEntity = null;
/*    */     try {
/* 27 */       Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
/* 28 */       parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
/*    */     }
/*    */     catch (Exception e) {
/* 31 */       e.printStackTrace();
/*    */     }
/* 33 */     if (parentEntity != null) {
/* 34 */       return null;
/*    */     }
/* 36 */     return " SELECT HIBERNATE_SEQUENCE.NEXTVAL AS ID FROM DUAL ";
/*    */   }
/*    */ 
/*    */   public String getKeyGenerateType()
/*    */   {
/* 43 */     return "pre";
/*    */   }
/*    */ 
/*    */   public String getMaxRecode(Object query, Filter filter, Page page)
/*    */   {
/* 50 */     IQuery _query = (IQuery)query;
/* 51 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 53 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 54 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/* 56 */     if (!maxLimit.equals(String.valueOf(0))) {
/* 57 */       return null;
/*    */     }
/* 59 */     boolean isWhere = ((filter != null) && (filter.getConditions().size() > 0)) || 
/* 60 */       (_query.toString().contains("where"));
/* 61 */     if (isWhere)
/* 62 */       _query.append("and ");
/*    */     else {
/* 64 */       _query.append(" where ");
/*    */     }
/*    */ 
/* 67 */     _query.append(" rownum <= ").append(maxLimit);
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   public String getDataBaseType() {
/* 72 */     return "ORACLE";
/*    */   }
/*    */ 
/*    */   public String processInsertSql(String insertMap, String entityName)
/*    */   {
/* 77 */     return insertMap;
/*    */   }
/*    */ 
/*    */   public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms)
/*    */   {
/* 83 */     return processInsertSql(insertMap, entityName);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.HiOracle9iDialect
 * JD-Core Version:    0.6.0
 */