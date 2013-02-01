/*    */ package org.hi.framework.web.webwork;
/*    */ 
/*    */ import java.util.Map;
/*    */ import ognl.DefaultTypeConverter;
/*    */ import org.hi.framework.model.BaseObject;
/*    */ 
/*    */ public class HiWebWorkConverter extends DefaultTypeConverter
/*    */ {
/*    */   public Object convertValue(Map context, Object o, Class toClass)
/*    */   {
/* 12 */     if (BaseObject.class.isAssignableFrom(toClass))
/* 13 */       return converToBaseObject(context, (BaseObject)o, toClass);
/* 14 */     if (toClass.equals(String.class))
/* 15 */       return convertToString(context, o);
/* 16 */     if ((o instanceof String[]))
/* 17 */       return convertFromString(context, (String[])o, toClass);
/* 18 */     if ((o instanceof String)) {
/* 19 */       return convertFromString(context, new String[] { (String)o }, toClass);
/*    */     }
/* 21 */     return performFallbackConversion(context, o, toClass);
/*    */   }
/*    */ 
/*    */   protected Object performFallbackConversion(Map context, Object o, Class toClass)
/*    */   {
/* 26 */     return super.convertValue(context, o, toClass);
/*    */   }
/*    */ 
/*    */   public Object converToBaseObject(Map context, BaseObject o, Class toClass) {
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   public Object convertFromString(Map context, String[] values, Class toClass) {
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   public String convertToString(Map context, Object o) {
/* 38 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.webwork.HiWebWorkConverter
 * JD-Core Version:    0.6.0
 */