/*    */ package org.hi.framework.web.struts;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.NumberFormat;
/*    */ import java.util.Map;
/*    */ import org.apache.struts2.util.StrutsTypeConverter;
/*    */ 
/*    */ public class DoubleConvert extends StrutsTypeConverter
/*    */ {
/*    */   public Object convertFromString(Map context, String[] values, Class toClass)
/*    */   {
/* 16 */     if (Double.class.equals(toClass)) {
/* 17 */       String doubleStr = values[0];
/* 18 */       if ((doubleStr == null) || (doubleStr.equals("")))
/* 19 */         return null;
/* 20 */       Double doubleValue = Double.valueOf(Double.parseDouble(doubleStr));
/* 21 */       return doubleValue;
/*    */     }
/* 23 */     return Integer.valueOf(0);
/*    */   }
/*    */ 
/*    */   public String convertToString(Map context, Object obj) {
/* 27 */     NumberFormat formatter = new DecimalFormat("0.0");
/* 28 */     String value = formatter.format(Double.valueOf(obj.toString()));
/* 29 */     return value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.struts.DoubleConvert
 * JD-Core Version:    0.6.0
 */