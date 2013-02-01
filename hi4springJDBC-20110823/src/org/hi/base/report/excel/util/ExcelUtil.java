/*    */ package org.hi.base.report.excel.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ExcelUtil
/*    */ {
/* 11 */   private static Map<Character, Integer> alphabetic = null;
/*    */ 
/* 16 */   public static final Integer MAX_COLUMN = Integer.valueOf(255);
/*    */ 
/* 20 */   public static final Integer MAX_ROW = Integer.valueOf(65535);
/*    */   public static final int EXCEL_HEX = 26;
/*    */ 
/*    */   static
/*    */   {
/* 24 */     if (alphabetic == null) {
/* 25 */       alphabetic = new LinkedHashMap();
/* 26 */       for (int i = 65; i < 91; i++)
/* 27 */         alphabetic.put(Character.valueOf((char)i), Integer.valueOf(i - 64));
/*    */     }
/*    */   }
/*    */ 
/*    */   public static Integer getInteger(String colName)
/*    */   {
/* 34 */     if ((colName == null) || (colName.trim().equals("")))
/* 35 */       return null;
/* 36 */     int result = 0;
/* 37 */     for (int i = 0; i < colName.length(); i++) {
/* 38 */       Integer val = (Integer)alphabetic.get(Character.valueOf(colName.charAt(i)));
/*    */ 
/* 40 */       if (val == null) {
/* 41 */         return null;
/*    */       }
/* 43 */       result += Hex(colName.length() - i - 1, val.intValue());
/*    */     }
/*    */ 
/* 46 */     return Integer.valueOf(result);
/*    */   }
/*    */ 
/*    */   private static int Hex(int digit, int number) {
/* 50 */     return (int)(number * Math.pow(26.0D, digit));
/*    */   }
/*    */ 
/*    */   public static boolean isChristcross(String str) {
/* 54 */     if ((str == null) || (str.trim().equals(""))) {
/* 55 */       return false;
/*    */     }
/* 57 */     for (int i = 0; i < str.length(); i++) {
/* 58 */       if (alphabetic.get(Character.valueOf(str.charAt(i))) == null)
/* 59 */         return false;
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */   public static boolean isNumber(String str)
/*    */   {
/* 68 */     if ((str == null) || (str.trim().equals("")))
/* 69 */       return false;
/*    */     try {
/* 71 */       Integer.parseInt(str);
/*    */     } catch (NumberFormatException e) {
/* 73 */       return false;
/*    */     }
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 83 */     System.out.println(isNumber("12"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.util.ExcelUtil
 * JD-Core Version:    0.6.0
 */