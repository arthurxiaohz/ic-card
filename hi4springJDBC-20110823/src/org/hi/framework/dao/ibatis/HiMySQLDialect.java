/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletContext;
/*    */ import org.apache.ibatis.mapping.ParameterMapping;
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
/*    */   implements IbatisHiDialect
/*    */ {
/*    */   public String getSelectKey(String entityName)
/*    */   {
/* 19 */     return " select @@IDENTITY as value ";
/*    */   }
/*    */   public String getKeyGenerateType() {
/* 22 */     return "post";
/*    */   }
/*    */   public String getMaxRecode(Object query, Filter filter, Page page) {
/* 25 */     IQuery _query = (IQuery)query;
/* 26 */     String maxLimit = HiConfigHolder.getMaxLimit();
/*    */ 
/* 28 */     if (page != null) {
/* 29 */       maxLimit = String.valueOf(page.getMaxRecords());
/*    */     }
/*    */ 
/* 32 */     if (!maxLimit.equals(String.valueOf(0)))
/* 33 */       _query.append(" limit ").append(maxLimit);
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   public String getDataBaseType() {
/* 38 */     return "MSSQL";
/*    */   }
/*    */ 
/*    */   public String processInsertSql(String insertMap, String entityName) {
/* 42 */     return processInsertSqlFor3(insertMap, entityName, null);
/*    */   }
/*    */ 
/*    */   public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms) {
/* 46 */     StringBuffer sb = new StringBuffer();
/* 47 */     String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
/*    */ 
/* 50 */     Entity parentEntity = null;
/*    */     try {
/* 52 */       Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
/* 53 */       parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
/*    */     }
/*    */     catch (Exception e) {
/* 56 */       e.printStackTrace();
/*    */     }
/* 58 */     if (parentEntity != null) {
/* 59 */       return insertMap;
/*    */     }
/* 61 */     List list = StringUtils.dividToList(insertMap, "(", ",");
/* 62 */     for (String string : list) {
/* 63 */       if ((StringUtils.isInclude(string, "(")) && (StringUtils.isInclude(string, ","))) {
/* 64 */         sb.append("(");
/*    */       }
/*    */       else {
/* 67 */         sb.append(string);
/*    */       }
/*    */     }
/* 70 */     if (pms != null) {
/* 71 */       pms.remove(0);
/*    */     }
/* 73 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.HiMySQLDialect
 * JD-Core Version:    0.6.0
 */