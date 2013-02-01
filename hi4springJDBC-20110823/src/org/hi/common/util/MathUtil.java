/*    */ package org.hi.common.util;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class MathUtil
/*    */ {
/*    */   public static Double add(Double d1, Float f1)
/*    */   {
/* 19 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 20 */     BigDecimal b2 = new BigDecimal(Float.toString(f1.floatValue()));
/* 21 */     return Double.valueOf(b1.add(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double sub(Double d1, Float f1) {
/* 25 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 26 */     BigDecimal b2 = new BigDecimal(Float.toString(f1.floatValue()));
/* 27 */     return Double.valueOf(b1.subtract(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double add(Double d1, Double d2) {
/* 31 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 32 */     BigDecimal b2 = new BigDecimal(Double.toString(d2.doubleValue()));
/* 33 */     return Double.valueOf(b1.add(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double sub(Double d1, Double d2) {
/* 37 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 38 */     BigDecimal b2 = new BigDecimal(Double.toString(d2.doubleValue()));
/* 39 */     return Double.valueOf(b1.subtract(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double multiply(Double d1, Float f2) {
/* 43 */     return multiply(d1, new Double(f2.floatValue()));
/*    */   }
/*    */ 
/*    */   public static Double multiply(Double d1, Double d2) {
/* 47 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 48 */     BigDecimal b2 = new BigDecimal(Double.toString(d2.doubleValue()));
/* 49 */     return Double.valueOf(b1.multiply(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double divide(Double d1, Float f2) {
/* 53 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 54 */     BigDecimal b2 = new BigDecimal(Float.toString(f2.floatValue()));
/* 55 */     return Double.valueOf(b1.divide(b2).doubleValue());
/*    */   }
/*    */ 
/*    */   public static Double divide(Double d1, Double d2) {
/* 59 */     BigDecimal b1 = new BigDecimal(Double.toString(d1.doubleValue()));
/* 60 */     BigDecimal b2 = new BigDecimal(Double.toString(d2.doubleValue()));
/* 61 */     return Double.valueOf(b1.divide(b2, 10, 4).doubleValue());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.MathUtil
 * JD-Core Version:    0.6.0
 */