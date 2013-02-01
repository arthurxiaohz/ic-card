/*    */ package org.hi.framework.web.taglib.component.builder;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class BuilderTools
/*    */ {
/*    */   public static String getParameters(Map parameters)
/*    */   {
/*  8 */     if (parameters == null) {
/*  9 */       return "";
/*    */     }
/* 11 */     StringBuffer result = new StringBuffer("");
/* 12 */     Iterator it = parameters.keySet().iterator();
/* 13 */     while (it.hasNext()) {
/* 14 */       Object key = it.next();
/* 15 */       String value = (String)parameters.get(key);
/* 16 */       result.append(" " + key + "=\"" + value + "\" ");
/*    */     }
/*    */ 
/* 19 */     return result.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.BuilderTools
 * JD-Core Version:    0.6.0
 */