/*    */ package org.hi.metadata.hsc.constant;
/*    */ 
/*    */ public class ORMappingType
/*    */ {
/*    */   public static final String ORM_TYPE_HIBERNATE = "hibernate";
/*    */   public static final String ORM_TYPE_IBATIS = "ibatis";
/*    */   public static final String ORM_TYPE_IBATIS3 = "ibatis3";
/*    */ 
/*    */   public static String getOutputFileType(String ormType)
/*    */   {
/* 10 */     if (ormType.equals("hibernate"))
/* 11 */       return ".hbm.xml";
/* 12 */     if (ormType.equals("ibatis"))
/* 13 */       return ".ism.xml";
/* 14 */     if (ormType.equals("ibatis3"))
/* 15 */       return ".ism3.xml";
/* 16 */     return "";
/*    */   }
/*    */ 
/*    */   public static String templateFileName(String ormType) {
/* 20 */     if (ormType.equals("hibernate"))
/* 21 */       return "hbm.hbm";
/* 22 */     if (ormType.equals("ibatis"))
/* 23 */       return "ism.ism";
/* 24 */     if (ormType.equals("ibatis3"))
/* 25 */       return "ism3.ism3";
/* 26 */     return "";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.constant.ORMappingType
 * JD-Core Version:    0.6.0
 */