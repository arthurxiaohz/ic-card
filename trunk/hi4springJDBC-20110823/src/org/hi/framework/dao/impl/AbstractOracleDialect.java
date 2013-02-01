/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ 
/*    */ public abstract class AbstractOracleDialect extends HiAbstractDialect
/*    */ {
/*    */   protected String getFeildToString(String fieldName, FilterBean filterBean)
/*    */   {
/*  9 */     Object val = filterBean.getValue();
/* 10 */     if ((val instanceof Date))
/* 11 */       return "to_char(" + fieldName + ",'yyyy-mm-dd')";
/* 12 */     if ((val instanceof Timestamp)) {
/* 13 */       return "to_char(" + fieldName + ",'yyyy-mm-dd 24hi:mi:ss')";
/*    */     }
/* 15 */     return fieldName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.impl.AbstractOracleDialect
 * JD-Core Version:    0.6.0
 */