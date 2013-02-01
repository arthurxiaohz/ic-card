/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletContext;
/*    */ import org.apache.ibatis.mapping.ParameterMapping;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.AbstractSQLServerDialect;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.metadata.hsc.HSCHelper;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ 
/*    */ public class HiSQLServerDialect extends AbstractSQLServerDialect
/*    */   implements IbatisHiDialect
/*    */ {
/*    */   public String getSelectKey(String entityName)
/*    */   {
/* 22 */     return " select @@IDENTITY as id ";
/*    */   }
/*    */ 
/*    */   public String getKeyGenerateType() {
/* 26 */     return "post";
/*    */   }
/*    */ 
/*    */   public String getMaxRecode(Object query, Filter filter, Page page) {
/* 30 */     IQuery _query = (IQuery)query;
/* 31 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 33 */     if ((page != null) && (page.getMaxRecords() > 0)) {
/* 34 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/* 36 */     String top = " top " + maxLimit + " ";
/*    */ 
/* 38 */     if (!maxLimit.equals(String.valueOf(0)))
/* 39 */       _query.replaceAll("select", "select" + top);
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   public String getDataBaseType() {
/* 44 */     return "SQLSERVER";
/*    */   }
/*    */ 
/*    */   public String processInsertSql(String insertMap, String entityName) {
/* 48 */     return processInsertSqlFor3(insertMap, entityName, null);
/*    */   }
/*    */ 
/*    */   public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms) {
/* 52 */     StringBuffer sb = new StringBuffer();
/* 53 */     String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*    */ 
/* 56 */     Entity parentEntity = null;
/*    */     try {
/* 58 */       Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
/* 59 */       parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
/*    */     }
/*    */     catch (Exception e) {
/* 62 */       e.printStackTrace();
/*    */     }
/* 64 */     if (parentEntity != null) {
/* 65 */       return insertMap;
/*    */     }
/*    */ 
/* 68 */     List list = StringUtils.dividToList(insertMap, "(", ",");
/* 69 */     for (String string : list) {
/* 70 */       if ((StringUtils.isInclude(string, "(")) && (StringUtils.isInclude(string, ","))) {
/* 71 */         sb.append("(");
/*    */       }
/*    */       else {
/* 74 */         sb.append(string);
/*    */       }
/*    */     }
/*    */ 
/* 78 */     if (pms != null) {
/* 79 */       pms.remove(0);
/*    */     }
/* 81 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.HiSQLServerDialect
 * JD-Core Version:    0.6.0
 */