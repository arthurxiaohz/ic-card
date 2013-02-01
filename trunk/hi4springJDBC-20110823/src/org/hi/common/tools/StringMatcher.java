/*    */ package org.hi.common.tools;
/*    */ 
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class StringMatcher
/*    */   implements Matcher
/*    */ {
/*    */   public boolean isPattern(String pattern)
/*    */   {
/* 25 */     return (pattern.indexOf('*') != -1) || (pattern.indexOf('?') != -1);
/*    */   }
/*    */ 
/*    */   public boolean match(String pattern, Object value)
/*    */   {
/* 35 */     if (!(value instanceof String)) {
/* 36 */       return false;
/*    */     }
/* 38 */     String str = (String)value;
/*    */ 
/* 40 */     if ((pattern == null) || (pattern.trim().equals("")) || (str == null) || (str.trim().equals(""))) {
/* 41 */       return false;
/*    */     }
/* 43 */     pattern = pattern.replaceAll("[.]", "\\\\.");
/* 44 */     StringBuffer sb = new StringBuffer("");
/* 45 */     for (int i = 0; i < pattern.length(); i++) {
/* 46 */       char subChar = pattern.charAt(i);
/* 47 */       switch (subChar) {
/*    */       case '*':
/* 49 */         sb.append(".*");
/* 50 */         break;
/*    */       case '?':
/* 52 */         sb.append(".{1}");
/* 53 */         break;
/*    */       default:
/* 55 */         sb.append(subChar);
/*    */       }
/*    */     }
/*    */ 
/* 59 */     pattern = sb.toString();
/* 60 */     return Pattern.matches(pattern, str);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.tools.StringMatcher
 * JD-Core Version:    0.6.0
 */