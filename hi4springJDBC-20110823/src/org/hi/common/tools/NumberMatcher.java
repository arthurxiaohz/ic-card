/*    */ package org.hi.common.tools;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class NumberMatcher
/*    */   implements Matcher
/*    */ {
/*    */   public boolean isPattern(String pattern)
/*    */   {
/* 28 */     return (pattern.indexOf('*') != -1) || (pattern.indexOf('?') != -1) || (pattern.indexOf('-') != -1);
/*    */   }
/*    */ 
/*    */   public boolean match(String pattern, Object value)
/*    */   {
/* 39 */     if (!(value instanceof Number)) {
/* 40 */       return false;
/*    */     }
/* 42 */     String str = ((Number)value).toString();
/*    */ 
/* 44 */     if ((pattern == null) || (pattern.trim().equals("")) || (str == null) || (str.trim().equals(""))) {
/* 45 */       return false;
/*    */     }
/* 47 */     if (!Pattern.matches("[\\d|\\.]*", str)) {
/* 48 */       return false;
/*    */     }
/* 50 */     pattern = pattern.replaceAll("[.]", "\\\\.");
/* 51 */     StringBuffer sb = new StringBuffer("");
/* 52 */     for (int i = 0; i < pattern.length(); i++) {
/* 53 */       char subChar = pattern.charAt(i);
/* 54 */       switch (subChar) {
/*    */       case '*':
/* 56 */         sb.append("\\d*");
/* 57 */         break;
/*    */       case '?':
/* 59 */         sb.append("\\d{1}");
/* 60 */         break;
/*    */       default:
/* 62 */         sb.append(subChar);
/*    */       }
/*    */     }
/*    */ 
/* 66 */     String[] patterns = sb.toString().split("-");
/* 67 */     if (patterns.length <= 1) {
/* 68 */       pattern = patterns[0];
/*    */     } else {
/* 70 */       sb = new StringBuffer("");
/* 71 */       for (int i = 0; i < patterns.length; i++) {
/* 72 */         String element = patterns[i];
/* 73 */         if (i != 0)
/* 74 */           sb.append(element.charAt(0) + "]{1}" + element.substring(1));
/* 75 */         if (i != patterns.length - 1) {
/* 76 */           sb.append(element.substring(0, element.length() - 1) + "[" + element.charAt(element.length() - 1) + "-");
/*    */         }
/*    */       }
/*    */     }
/* 80 */     pattern = sb.toString();
/*    */ 
/* 82 */     return Pattern.matches(pattern, str);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 87 */     NumberMatcher matcher = new NumberMatcher();
/* 88 */     System.out.println(matcher.match("34-5.5*", new Double(34.534500000000001D)));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.tools.NumberMatcher
 * JD-Core Version:    0.6.0
 */