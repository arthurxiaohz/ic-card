/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.lang.StringEscapeUtils;
/*     */ 
/*     */ public class StringUtils
/*     */ {
/*     */   public static final int BEFORE = 1;
/*     */   public static final int AFTER = 2;
/*     */   public static final String DEFAULT_PATH_SEPARATOR = ",";
/*     */ 
/*     */   public static ArrayList strToArrayList(String str)
/*     */   {
/*  38 */     return strToArrayListManager(str, ",");
/*     */   }
/*     */ 
/*     */   public static ArrayList<String> strToArrayList(String str, String separator)
/*     */   {
/*  48 */     return strToArrayListManager(str, separator);
/*     */   }
/*     */ 
/*     */   private static ArrayList<String> strToArrayListManager(String str, String separator)
/*     */   {
/*  53 */     StringTokenizer strTokens = new StringTokenizer(str, separator);
/*  54 */     ArrayList list = new ArrayList();
/*     */ 
/*  56 */     while (strTokens.hasMoreTokens()) {
/*  57 */       list.add(strTokens.nextToken().trim());
/*     */     }
/*     */ 
/*  60 */     return list;
/*     */   }
/*     */ 
/*     */   public static String[] strToStrArray(String str)
/*     */   {
/*  69 */     return strToStrArrayManager(str, ",");
/*     */   }
/*     */ 
/*     */   public static String[] strToStrArray(String str, String separator)
/*     */   {
/*  79 */     return strToStrArrayManager(str, separator);
/*     */   }
/*     */ 
/*     */   private static String[] strToStrArrayManager(String str, String separator)
/*     */   {
/*  86 */     StringTokenizer strTokens = new StringTokenizer(str, separator);
/*  87 */     String[] strArray = new String[strTokens.countTokens()];
/*  88 */     int i = 0;
/*     */ 
/*  90 */     while (strTokens.hasMoreTokens()) {
/*  91 */       strArray[i] = strTokens.nextToken().trim();
/*  92 */       i++;
/*     */     }
/*     */ 
/*  95 */     return strArray;
/*     */   }
/*     */ 
/*     */   public static Set<String> strToSet(String str) {
/*  99 */     return strToSet(str, ",");
/*     */   }
/*     */ 
/*     */   public static Set<String> strToSet(String str, String separator) {
/* 103 */     String[] values = strToStrArray(str, separator);
/* 104 */     Set result = new LinkedHashSet();
/* 105 */     for (int i = 0; i < values.length; i++) {
/* 106 */       result.add(values[i]);
/*     */     }
/* 108 */     return result;
/*     */   }
/*     */ 
/*     */   public static String ArrayToStr(Object[] array)
/*     */   {
/* 117 */     if ((array == null) || (array.length < 0)) return null;
/* 118 */     String str = "";
/* 119 */     int _step = 0;
/* 120 */     for (int i = 0; i < array.length; i++) {
/* 121 */       if (_step > 0)
/* 122 */         str = str + ",";
/* 123 */       str = str + (String)array[i];
/* 124 */       _step++;
/*     */     }
/* 126 */     return str;
/*     */   }
/*     */ 
/*     */   public static String CollectionToStr(Collection<String> coll) {
/* 130 */     StringBuffer sb = new StringBuffer();
/* 131 */     int i = 0;
/* 132 */     for (String string : coll) {
/* 133 */       if (i > 0)
/* 134 */         sb.append(",");
/* 135 */       i++;
/* 136 */       sb.append(string);
/*     */     }
/* 138 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String encodingTransfer(String inputString, String inencoding, String outencoding)
/*     */   {
/* 150 */     if ((inputString == null) || (inputString.length() == 0)) return inputString;
/*     */     try
/*     */     {
/* 153 */       return new String(inputString.getBytes(outencoding), inencoding);
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 157 */     return inputString;
/*     */   }
/*     */ 
/*     */   public static String delString(String inputString, String delStrs)
/*     */   {
/* 171 */     if ((inputString == null) || (inputString.length() == 0)) return inputString;
/*     */ 
/* 173 */     String[] strs = strToStrArray(delStrs);
/* 174 */     for (int i = 0; i < strs.length; i++) {
/* 175 */       if (strs[i].equals("")) {
/* 176 */         inputString = inputString.replaceAll(" ", "");
/*     */       }
/* 179 */       else if (strs[i].compareTo("a") >= 0)
/* 180 */         inputString = replace(inputString, strs[i], "");
/*     */       else {
/* 182 */         inputString = inputString.replaceAll("\\" + strs[i], "");
/*     */       }
/*     */     }
/* 185 */     if (subCount(delStrs, ",") > strs.length) {
/* 186 */       inputString = inputString.replaceAll("\\,", "");
/*     */     }
/* 188 */     return inputString;
/*     */   }
/*     */ 
/*     */   public static String trimLeft(String value)
/*     */   {
/* 197 */     String result = value;
/* 198 */     if (result == null) return result;
/* 199 */     char[] ch = result.toCharArray();
/* 200 */     int index = -1;
/* 201 */     for (int i = 0; i < ch.length; i++) {
/* 202 */       if (!Character.isWhitespace(ch[i])) break;
/* 203 */       index = i;
/*     */     }
/*     */ 
/* 209 */     if (index != -1) {
/* 210 */       result = result.substring(index + 1);
/*     */     }
/* 212 */     return result;
/*     */   }
/*     */ 
/*     */   public static String trimRight(String value)
/*     */   {
/* 221 */     String result = value;
/* 222 */     if (result == null) return result;
/* 223 */     char[] ch = result.toCharArray();
/* 224 */     int endIndex = -1;
/* 225 */     for (int i = ch.length - 1; i > -1; i--) {
/* 226 */       if (!Character.isWhitespace(ch[i])) break;
/* 227 */       endIndex = i;
/*     */     }
/*     */ 
/* 233 */     if (endIndex != -1) {
/* 234 */       result = result.substring(0, endIndex);
/*     */     }
/* 236 */     return result;
/*     */   }
/*     */ 
/*     */   public static boolean isInclude(String parentStr, String subStr)
/*     */   {
/* 247 */     return parentStr.indexOf(subStr) >= 0;
/*     */   }
/*     */ 
/*     */   public static boolean isIncludes(String parentStr, String subStrs)
/*     */   {
/* 258 */     String[] subStrArray = strToStrArray(subStrs);
/* 259 */     for (int j = 0; j < subStrArray.length; j++) {
/* 260 */       String subStr = subStrArray[j];
/* 261 */       if (isInclude(parentStr, subStr)) {
/* 262 */         return true;
/*     */       }
/*     */     }
/*     */ 
/* 266 */     return false;
/*     */   }
/*     */ 
/*     */   public static int subCount(String parentStr, String subStr)
/*     */   {
/* 276 */     int count = 0;
/*     */ 
/* 278 */     for (int i = 0; i < parentStr.length() - subStr.length(); i++) {
/* 279 */       String tempString = parentStr.substring(i, i + subStr.length());
/* 280 */       if (subStr.equals(tempString)) {
/* 281 */         count++;
/*     */       }
/*     */     }
/*     */ 
/* 285 */     return count;
/*     */   }
/*     */ 
/*     */   public static String subString(String parentStr, String startStr, String endStr)
/*     */   {
/* 296 */     return parentStr.substring(parentStr.indexOf(startStr) + startStr.length(), parentStr.indexOf(endStr));
/*     */   }
/*     */ 
/*     */   public static List<String> subStringList(String parentStr, String startStr, String endStr)
/*     */   {
/* 306 */     List result = new ArrayList();
/* 307 */     List elements = dividToList(parentStr, startStr, endStr);
/* 308 */     for (String element : elements) {
/* 309 */       if ((!isIncludes(element, startStr)) || (!isIncludes(element, endStr)))
/*     */         continue;
/* 311 */       result.add(subString(element, startStr, endStr));
/*     */     }
/* 313 */     return result;
/*     */   }
/*     */ 
/*     */   public static String getUnicodeStr(String inStr)
/*     */   {
/* 336 */     char[] myBuffer = inStr.toCharArray();
/* 337 */     StringBuffer sb = new StringBuffer();
/*     */ 
/* 339 */     for (int i = 0; i < inStr.length(); i++) {
/* 340 */       byte b = (byte)myBuffer[i];
/* 341 */       short s = (short)myBuffer[i];
/* 342 */       String hexB = Integer.toHexString(b);
/* 343 */       String hexS = Integer.toHexString(s);
/*     */ 
/* 364 */       sb.append(" \\u");
/* 365 */       sb.append(fillStr(hexS, "0", 4, 2));
/*     */     }
/*     */ 
/* 371 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static boolean isJavaIdentifier(String s)
/*     */   {
/* 382 */     if ((s.length() == 0) || (Character.isJavaIdentifierStart(s.charAt(0))))
/* 383 */       return false;
/* 384 */     for (int i = 0; i < s.length(); i++)
/* 385 */       if (!Character.isJavaIdentifierPart(s.charAt(i)))
/* 386 */         return false;
/* 387 */     return true;
/*     */   }
/*     */ 
/*     */   public static String replaceAll(String str, char oldchar, char newchar)
/*     */   {
/* 402 */     char[] chars = str.toCharArray();
/* 403 */     for (int i = 0; i < chars.length; i++) {
/* 404 */       if (chars[i] == oldchar)
/* 405 */         chars[i] = newchar;
/*     */     }
/* 407 */     return new String(chars);
/*     */   }
/*     */ 
/*     */   public static String fillStr(String inStr, String fill, int length, int direction)
/*     */   {
/* 420 */     if ((inStr == null) || (inStr.length() > length) || (inStr.length() == 0)) return inStr;
/*     */ 
/* 422 */     StringBuffer tempStr = new StringBuffer("");
/* 423 */     for (int i = 0; i < length - inStr.length(); i++) {
/* 424 */       tempStr.append(fill);
/*     */     }
/*     */ 
/* 427 */     if (direction == 2) {
/* 428 */       return new String(tempStr.toString() + inStr);
/*     */     }
/* 430 */     return new String(inStr + tempStr.toString());
/*     */   }
/*     */ 
/*     */   public static String replace(String str, String pattern, String replace)
/*     */   {
/* 441 */     int s = 0;
/* 442 */     int e = 0;
/* 443 */     StringBuffer result = new StringBuffer();
/* 444 */     while ((e = str.indexOf(pattern, s)) >= 0) {
/* 445 */       result.append(str.substring(s, e));
/* 446 */       result.append(replace);
/* 447 */       s = e + pattern.length();
/*     */     }
/* 449 */     result.append(str.substring(s));
/*     */ 
/* 451 */     return result.toString();
/*     */   }
/*     */ 
/*     */   public static List<String> dividToList(String str, String start, String end)
/*     */   {
/* 462 */     if ((str == null) || (str.length() == 0)) {
/* 463 */       return null;
/*     */     }
/* 465 */     int s = 0;
/* 466 */     int e = 0;
/* 467 */     List result = new ArrayList();
/* 468 */     if ((isInclude(str, start)) && (isInclude(str, end))) {
/* 469 */       while ((e = str.indexOf(start, s)) >= 0) {
/* 470 */         result.add(str.substring(s, e));
/* 471 */         s = str.indexOf(end, e) + end.length();
/* 472 */         result.add(str.substring(e, s));
/*     */       }
/* 474 */       if (s < str.length()) {
/* 475 */         result.add(str.substring(s));
/*     */       }
/* 477 */       if (s == 0)
/* 478 */         result.add(str);
/*     */     } else {
/* 480 */       result.add(str);
/*     */     }
/* 482 */     return result;
/*     */   }
/*     */ 
/*     */   public static String upperFrist(String string)
/*     */   {
/* 492 */     if (string == null)
/* 493 */       return null;
/* 494 */     String upper = string.toUpperCase();
/* 495 */     return upper.substring(0, 1) + string.substring(1);
/*     */   }
/*     */ 
/*     */   public static String lowerFrist(String string)
/*     */   {
/* 504 */     if (string == null)
/* 505 */       return null;
/* 506 */     String lower = string.toLowerCase();
/* 507 */     return lower.substring(0, 1) + string.substring(1);
/*     */   }
/*     */ 
/*     */   public static String URLEncode(String string, String encode) {
/*     */     try {
/* 512 */       return URLEncoder.encode(string, encode);
/*     */     } catch (UnsupportedEncodingException e) {
/* 514 */       e.printStackTrace();
/* 515 */     }return null;
/*     */   }
/*     */ 
/*     */   public static String DateToStr(Date date, String format)
/*     */   {
/* 630 */     SimpleDateFormat formatter = new SimpleDateFormat(format);
/* 631 */     return formatter.format(date);
/*     */   }
/*     */ 
/*     */   public static String escapeHtml(String string)
/*     */   {
/* 640 */     if ((string == null) || (string.length() == 0)) {
/* 641 */       return "";
/*     */     }
/*     */ 
/* 645 */     char c = '\000';
/*     */ 
/* 647 */     int len = string.length();
/* 648 */     StringBuffer sb = new StringBuffer(len + 4);
/*     */ 
/* 651 */     for (int i = 0; i < len; i++) {
/* 652 */       char b = c;
/* 653 */       c = string.charAt(i);
/* 654 */       switch (c) {
/*     */       case '"':
/*     */       case '\\':
/* 657 */         sb.append('\\');
/* 658 */         sb.append(c);
/* 659 */         break;
/*     */       case '/':
/* 661 */         if (b == '<') {
/* 662 */           sb.append('\\');
/*     */         }
/* 664 */         sb.append(c);
/* 665 */         break;
/*     */       case '\b':
/* 667 */         sb.append("\\b");
/* 668 */         break;
/*     */       case '\t':
/* 670 */         sb.append("\\t");
/* 671 */         break;
/*     */       case '\n':
/* 673 */         sb.append("\\n");
/* 674 */         break;
/*     */       case '\f':
/* 676 */         sb.append("\\f");
/* 677 */         break;
/*     */       case '\r':
/* 679 */         sb.append("\\r");
/* 680 */         break;
/*     */       default:
/* 682 */         if ((c < ' ') || ((c >= '') && (c < ' ')) || (
/* 683 */           (c >= ' ') && (c < '℀'))) {
/* 684 */           String t = "000" + Integer.toHexString(c);
/* 685 */           sb.append("\\u" + t.substring(t.length() - 4));
/*     */         } else {
/* 687 */           sb.append(c);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 692 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 697 */     String test = "\b";
/* 698 */     StringEscapeUtils.escapeHtml("\n");
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.util.StringUtils
 * JD-Core Version:    0.6.0
 */