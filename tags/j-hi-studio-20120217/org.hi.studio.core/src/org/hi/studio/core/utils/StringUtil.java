/*     */ package org.hi.studio.core.utils;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.core.runtime.IStatus;
/*     */ import org.eclipse.jdt.internal.corext.util.JavaConventionsUtil;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ 
/*     */ public class StringUtil
/*     */ {
/*     */   public static String lowerFirstChar(String str)
/*     */   {
/*  32 */     if ((str == null) || (str.equals(""))) {
/*  33 */       return str;
/*     */     }
/*  35 */     String firstChar = str.substring(0, 1);
/*  36 */     return firstChar.toLowerCase() + str.substring(1);
/*     */   }
/*     */ 
/*     */   public static String upperFirstChar(String str)
/*     */   {
/*  44 */     if ((str == null) || (str.equals(""))) {
/*  45 */       return str;
/*     */     }
/*  47 */     String firstChar = str.substring(0, 1);
/*  48 */     return firstChar.toUpperCase() + str.substring(1);
/*     */   }
/*     */ 
/*     */   public static boolean getBoolean(String value)
/*     */   {
/*  54 */     return Boolean.valueOf(value).booleanValue();
/*     */   }
/*     */ 
/*     */   public static int getInt(String value) {
/*  58 */     return Integer.valueOf(value).intValue();
/*     */   }
/*     */ 
/*     */   public static String add(String s, String add) {
/*  62 */     return add(s, add, ",");
/*     */   }
/*     */ 
/*     */   public static String add(String s, String add, String delimiter) {
/*  66 */     return add(s, add, delimiter, false);
/*     */   }
/*     */ 
/*     */   public static String add(String s, String add, String delimiter, boolean allowDuplicates)
/*     */   {
/*  71 */     if ((add == null) || (delimiter == null))
/*  72 */       return null;
/*  73 */     if (s == null)
/*  74 */       s = "";
/*  75 */     if ((allowDuplicates) || (!contains(s, add, delimiter)))
/*  76 */       if (s.endsWith(delimiter))
/*  77 */         s = s + add + delimiter;
/*     */       else
/*  79 */         s = s + delimiter + add + delimiter;
/*  80 */     return s;
/*     */   }
/*     */ 
/*     */   public static boolean contains(String s, String text) {
/*  84 */     return contains(s, text, ",");
/*     */   }
/*     */ 
/*     */   public static boolean contains(String s, String text, String delimiter) {
/*  88 */     if ((s == null) || (text == null) || (delimiter == null))
/*  89 */       return false;
/*  90 */     if (!s.endsWith(delimiter))
/*  91 */       s = s + delimiter;
/*  92 */     int pos = s.indexOf(delimiter + text + delimiter);
/*  93 */     if (pos == -1) {
/*  94 */       return s.startsWith(text + delimiter);
/*     */     }
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   public static int count(String s, String text) {
/* 100 */     if ((s == null) || (text == null))
/* 101 */       return 0;
/* 102 */     int count = 0;
/* 103 */     for (int pos = s.indexOf(text); pos != -1; ) {
/* 104 */       pos = s.indexOf(text, pos + text.length());
/* 105 */       count++;
/*     */     }
/*     */ 
/* 108 */     return count;
/*     */   }
/*     */ 
/*     */   public static boolean endsWith(String s, char end) {
/* 112 */     return startsWith(s, new Character(end).toString());
/*     */   }
/*     */ 
/*     */   public static boolean endsWith(String s, String end) {
/* 116 */     if ((s == null) || (end == null))
/* 117 */       return false;
/* 118 */     if (end.length() > s.length())
/* 119 */       return false;
/* 120 */     String temp = s.substring(s.length() - end.length(), s.length());
/* 121 */     return temp.equalsIgnoreCase(end);
/*     */   }
/*     */ 
/*     */   public static String extractChars(String s) {
/* 125 */     if (s == null)
/* 126 */       return "";
/* 127 */     char[] c = s.toCharArray();
/* 128 */     StringBuffer sb = new StringBuffer();
/* 129 */     for (int i = 0; i < c.length; i++) {
/* 130 */       sb.append(c[i]);
/*     */     }
/* 132 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String extractDigits(String s) {
/* 136 */     if (s == null)
/* 137 */       return "";
/* 138 */     char[] c = s.toCharArray();
/* 139 */     StringBuffer sb = new StringBuffer();
/* 140 */     for (int i = 0; i < c.length; i++) {
/* 141 */       sb.append(c[i]);
/*     */     }
/* 143 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String merge(String[] array) {
/* 147 */     return merge(array, ",");
/*     */   }
/*     */ 
/*     */   public static String merge(String[] array, String delimiter) {
/* 151 */     if (array == null)
/* 152 */       return null;
/* 153 */     StringBuffer sb = new StringBuffer();
/* 154 */     for (int i = 0; i < array.length; i++) {
/* 155 */       sb.append(array[i].trim());
/* 156 */       if (i + 1 != array.length) {
/* 157 */         sb.append(delimiter);
/*     */       }
/*     */     }
/* 160 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String read(ClassLoader classLoader, String name) throws IOException
/*     */   {
/* 165 */     return read(classLoader.getResourceAsStream(name));
/*     */   }
/*     */ 
/*     */   public static String read(InputStream is) throws IOException {
/* 169 */     BufferedReader br = new BufferedReader(new InputStreamReader(is));
/* 170 */     StringBuffer sb = new StringBuffer();
/* 171 */     for (String line = null; (line = br.readLine()) != null; ) {
/* 172 */       sb.append(line).append('\n');
/*     */     }
/* 174 */     br.close();
/* 175 */     return sb.toString().trim();
/*     */   }
/*     */ 
/*     */   public static String remove(String s, String remove) {
/* 179 */     return remove(s, remove, ",");
/*     */   }
/*     */ 
/*     */   public static String remove(String s, String remove, String delimiter) {
/* 183 */     if ((s == null) || (remove == null) || (delimiter == null))
/* 184 */       return null;
/* 185 */     if (!s.endsWith(delimiter)) {
/* 186 */       s = s + delimiter;
/*     */     }
/* 188 */     while (contains(s, remove, delimiter))
/*     */     {
/* 190 */       int pos = s.indexOf(delimiter + remove + delimiter);
/* 191 */       if (pos == -1) {
/* 192 */         if (s.startsWith(remove + delimiter)) {
/* 193 */           s = s.substring(remove.length() + delimiter.length(), s
/* 194 */             .length());
/*     */ 
/* 193 */           continue;
/*     */         }
/*     */       }
/* 196 */       s = s.substring(0, pos) + 
/* 197 */         s.substring(pos + remove.length() + 
/* 198 */         delimiter.length(), s.length());
/*     */     }
/*     */ 
/* 201 */     return s;
/*     */   }
/*     */ 
/*     */   public static String replace(String s, char oldSub, char newSub) {
/* 205 */     newSub = getNewChar(oldSub, newSub);
/*     */ 
/* 207 */     return replace(s, oldSub, new Character(newSub).toString());
/*     */   }
/*     */ 
/*     */   public static String replace(String s, char oldSub, String newSub) {
/* 211 */     if ((s == null) || (newSub == null))
/* 212 */       return null;
/* 213 */     char[] c = s.toCharArray();
/* 214 */     StringBuffer sb = new StringBuffer();
/* 215 */     for (int i = 0; i < c.length; i++) {
/* 216 */       if (c[i] == oldSub)
/* 217 */         sb.append(newSub);
/*     */       else
/* 219 */         sb.append(c[i]);
/*     */     }
/* 221 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String replace(String s, String oldSub, String newSub) {
/* 225 */     newSub = getNewString(oldSub, newSub);
/*     */ 
/* 227 */     if ((s == null) || (oldSub == null) || (newSub == null))
/* 228 */       return null;
/* 229 */     int y = s.indexOf(oldSub);
/* 230 */     if (y >= 0) {
/* 231 */       StringBuffer sb = new StringBuffer();
/* 232 */       int length = oldSub.length();
/*     */ 
/* 234 */       for (int x = 0; x <= y; y = s.indexOf(oldSub, x)) {
/* 235 */         sb.append(s.substring(x, y));
/* 236 */         sb.append(newSub);
/* 237 */         x = y + length;
/*     */       }
/*     */ 
/* 240 */       sb.append(s.substring(x));
/* 241 */       return sb.toString();
/*     */     }
/* 243 */     return s;
/*     */   }
/*     */ 
/*     */   public static String replace(String s, String[] oldSubs, String[] newSubs)
/*     */   {
/* 248 */     if ((s == null) || (oldSubs == null) || (newSubs == null))
/* 249 */       return null;
/* 250 */     if (oldSubs.length != newSubs.length)
/* 251 */       return s;
/* 252 */     for (int i = 0; i < oldSubs.length; i++) {
/* 253 */       s = replace(s, oldSubs[i], newSubs[i]);
/*     */     }
/* 255 */     return s;
/*     */   }
/*     */ 
/*     */   private static String getNewString(String oldString, String newString)
/*     */   {
/* 267 */     String returnString = newString;
/* 268 */     if ((oldString.equals("/")) && (newString.equals("\\"))) {
/* 269 */       return File.separator;
/*     */     }
/*     */ 
/* 272 */     return returnString;
/*     */   }
/*     */ 
/*     */   private static char getNewChar(char oldChar, char newChar)
/*     */   {
/* 280 */     char returnChar = newChar;
/* 281 */     if ((oldChar == '/') && (newChar == '\\')) {
/* 282 */       return File.separatorChar;
/*     */     }
/*     */ 
/* 285 */     return returnChar;
/*     */   }
/*     */ 
/*     */   public static String reverse(String s) {
/* 289 */     if (s == null)
/* 290 */       return null;
/* 291 */     char[] c = s.toCharArray();
/* 292 */     char[] reverse = new char[c.length];
/* 293 */     for (int i = 0; i < c.length; i++) {
/* 294 */       reverse[i] = c[(c.length - i - 1)];
/*     */     }
/* 296 */     return new String(reverse);
/*     */   }
/*     */ 
/*     */   public static String shorten(String s) {
/* 300 */     return shorten(s, 20);
/*     */   }
/*     */ 
/*     */   public static String shorten(String s, int length) {
/* 304 */     return shorten(s, length, "..");
/*     */   }
/*     */ 
/*     */   public static String shorten(String s, String suffix) {
/* 308 */     return shorten(s, 20, suffix);
/*     */   }
/*     */ 
/*     */   public static String shorten(String s, int length, String suffix) {
/* 312 */     if ((s == null) || (suffix == null))
/* 313 */       return null;
/* 314 */     if (s.length() > length)
/* 315 */       s = s.substring(0, length) + suffix;
/* 316 */     return s;
/*     */   }
/*     */ 
/*     */   public static String[] split(String s) {
/* 320 */     return split(s, ",");
/*     */   }
/*     */ 
/*     */   public static String[] split(String s, String delimiter) {
/* 324 */     if ((s == null) || (delimiter == null))
/* 325 */       return new String[0];
/* 326 */     s = s.trim();
/* 327 */     if (!s.endsWith(delimiter))
/* 328 */       s = s + delimiter;
/* 329 */     if (s.equals(delimiter))
/* 330 */       return new String[0];
/* 331 */     List nodeValues = new ArrayList();
/* 332 */     if ((delimiter.equals("\n")) || (delimiter.equals("\r"))) {
/*     */       try {
/* 334 */         BufferedReader br = new BufferedReader(new StringReader(s));
/* 335 */         for (String line = null; (line = br.readLine()) != null; ) {
/* 336 */           nodeValues.add(line);
/*     */         }
/* 338 */         br.close();
/*     */       } catch (IOException ioe) {
/* 340 */         ExceptionManager.logError(ioe, "");
/*     */       }
/*     */     } else {
/* 343 */       int offset = 0;
/* 344 */       for (int pos = s.indexOf(delimiter, offset); pos != -1; pos = s
/* 345 */         .indexOf(delimiter, offset))
/*     */       {
/* 346 */         nodeValues.add(s.substring(offset, pos));
/* 347 */         offset = pos + delimiter.length();
/*     */       }
/*     */     }
/*     */ 
/* 351 */     return (String[])nodeValues.toArray(new String[0]);
/*     */   }
/*     */ 
/*     */   public static boolean[] split(String s, String delimiter, boolean x) {
/* 355 */     String[] array = split(s, delimiter);
/* 356 */     boolean[] newArray = new boolean[array.length];
/* 357 */     for (int i = 0; i < array.length; i++) {
/* 358 */       boolean value = x;
/*     */       try {
/* 360 */         value = Boolean.valueOf(array[i]).booleanValue();
/*     */       } catch (Exception localException) {
/*     */       }
/* 363 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 366 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static double[] split(String s, String delimiter, double x) {
/* 370 */     String[] array = split(s, delimiter);
/* 371 */     double[] newArray = new double[array.length];
/* 372 */     for (int i = 0; i < array.length; i++) {
/* 373 */       double value = x;
/*     */       try {
/* 375 */         value = Double.parseDouble(array[i]);
/*     */       } catch (Exception localException) {
/*     */       }
/* 378 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 381 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static float[] split(String s, String delimiter, float x) {
/* 385 */     String[] array = split(s, delimiter);
/* 386 */     float[] newArray = new float[array.length];
/* 387 */     for (int i = 0; i < array.length; i++) {
/* 388 */       float value = x;
/*     */       try {
/* 390 */         value = Float.parseFloat(array[i]);
/*     */       } catch (Exception localException) {
/*     */       }
/* 393 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 396 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static int[] split(String s, String delimiter, int x) {
/* 400 */     String[] array = split(s, delimiter);
/* 401 */     int[] newArray = new int[array.length];
/* 402 */     for (int i = 0; i < array.length; i++) {
/* 403 */       int value = x;
/*     */       try {
/* 405 */         value = Integer.parseInt(array[i]);
/*     */       } catch (Exception localException) {
/*     */       }
/* 408 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 411 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static long[] split(String s, String delimiter, long x) {
/* 415 */     String[] array = split(s, delimiter);
/* 416 */     long[] newArray = new long[array.length];
/* 417 */     for (int i = 0; i < array.length; i++) {
/* 418 */       long value = x;
/*     */       try {
/* 420 */         value = Long.parseLong(array[i]);
/*     */       } catch (Exception localException) {
/*     */       }
/* 423 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 426 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static short[] split(String s, String delimiter, short x) {
/* 430 */     String[] array = split(s, delimiter);
/* 431 */     short[] newArray = new short[array.length];
/* 432 */     for (int i = 0; i < array.length; i++) {
/* 433 */       short value = x;
/*     */       try {
/* 435 */         value = Short.parseShort(array[i]);
/*     */       } catch (Exception localException) {
/*     */       }
/* 438 */       newArray[i] = value;
/*     */     }
/*     */ 
/* 441 */     return newArray;
/*     */   }
/*     */ 
/*     */   public static final String stackTrace(Throwable t) {
/* 445 */     String s = null;
/*     */     try {
/* 447 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 448 */       t.printStackTrace(new PrintWriter(baos, true));
/* 449 */       s = baos.toString();
/*     */     } catch (Exception e) {
/* 451 */       ExceptionManager.logError(e, "");
/*     */     }
/* 453 */     return s;
/*     */   }
/*     */ 
/*     */   public static boolean startsWith(String s, char begin) {
/* 457 */     return startsWith(s, new Character(begin).toString());
/*     */   }
/*     */ 
/*     */   public static boolean startsWith(String s, String start) {
/* 461 */     if ((s == null) || (start == null))
/* 462 */       return false;
/* 463 */     if (start.length() > s.length())
/* 464 */       return false;
/* 465 */     String temp = s.substring(0, start.length());
/* 466 */     return temp.equalsIgnoreCase(start);
/*     */   }
/*     */ 
/*     */   public static String trimLeading(String s) {
/* 470 */     for (int i = 0; i < s.length(); i++) {
/* 471 */       if (!Character.isWhitespace(s.charAt(i)))
/* 472 */         return s.substring(i, s.length());
/*     */     }
/* 474 */     return "";
/*     */   }
/*     */ 
/*     */   public static String trimTrailing(String s) {
/* 478 */     for (int i = s.length() - 1; i >= 0; i--) {
/* 479 */       if (!Character.isWhitespace(s.charAt(i)))
/* 480 */         return s.substring(0, i + 1);
/*     */     }
/* 482 */     return "";
/*     */   }
/*     */ 
/*     */   public static String wrap(String text) {
/* 486 */     return wrap(text, 80, "\n");
/*     */   }
/*     */ 
/*     */   public static String wrap(String text, int width, String lineSeparator) {
/* 490 */     if (text == null)
/* 491 */       return null;
/* 492 */     StringBuffer sb = new StringBuffer();
/*     */     try {
/* 494 */       BufferedReader br = new BufferedReader(new StringReader(text));
/* 495 */       for (String s = ""; (s = br.readLine()) != null; )
/* 496 */         if (s.length() == 0) {
/* 497 */           sb.append(lineSeparator);
/*     */         } else {
/* 499 */           String[] tokens = s.split(" ");
/* 500 */           boolean firstWord = true;
/* 501 */           int curLineLength = 0;
/* 502 */           int i = 0;
/* 503 */           while (i < tokens.length) {
/* 504 */             if (!firstWord) {
/* 505 */               sb.append(" ");
/* 506 */               curLineLength++;
/*     */             }
/* 508 */             if (firstWord)
/* 509 */               sb.append(lineSeparator);
/* 510 */             sb.append(tokens[i]);
/* 511 */             curLineLength += tokens[i].length();
/* 512 */             if (curLineLength >= width) {
/* 513 */               firstWord = true;
/* 514 */               curLineLength = 0;
/*     */             } else {
/* 516 */               firstWord = false;
/*     */             }
/* 518 */             i++;
/*     */           }
/*     */         }
/*     */     }
/*     */     catch (IOException ioe) {
/* 523 */       ExceptionManager.logError(ioe, "");
/*     */     }
/* 525 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getRandomStr() {
/* 529 */     int num = (int)Math.floor(Math.random() * 1000000.0D);
/* 530 */     return num;
/*     */   }
/*     */ 
/*     */   public static String replaceInvalidateChar(String invalidateString) {
/* 534 */     if (invalidateString != null) {
/* 535 */       invalidateString = replace(invalidateString, "\"", "'");
/*     */     }
/*     */ 
/* 538 */     return invalidateString;
/*     */   }
/*     */ 
/*     */   public static String getStringInScope(String content, String startStr, String endStr) {
/* 542 */     int startPos = content.indexOf(startStr);
/* 543 */     int endPos = content.indexOf(endStr);
/* 544 */     if (startPos < 0)
/* 545 */       return "";
/* 546 */     if (endPos < 0) {
/* 547 */       return "";
/*     */     }
/* 549 */     if (startPos > endPos)
/* 550 */       return "";
/* 551 */     return content.substring(startPos, endPos + endStr.length());
/*     */   }
/*     */ 
/*     */   public static boolean isValidatedName(String testString)
/*     */   {
/* 560 */     char[] ch = testString.toCharArray();
/*     */ 
/* 562 */     for (int i = 0; i < ch.length; i++)
/*     */     {
/* 564 */       char c = ch[i];
/*     */ 
/* 566 */       if (!isChinese(c))
/*     */         continue;
/* 568 */       System.out.println(isChinese(c));
/*     */ 
/* 570 */       return true;
/*     */     }
/*     */ 
/* 577 */     return JavaConventionsUtil.validateFieldName(testString, null).getSeverity() == 
/* 576 */       4;
/*     */   }
/*     */ 
/*     */   private static boolean isChinese(char c)
/*     */   {
/* 585 */     Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
/*     */ 
/* 599 */     return (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || 
/* 589 */       (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || 
/* 591 */       (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || 
/* 593 */       (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) || 
/* 595 */       (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || 
/* 597 */       (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
/*     */   }
/*     */ 
/*     */   public static boolean isErrorPackage(String testString)
/*     */   {
/* 609 */     return JavaConventionsUtil.validatePackageName(testString, null)
/* 608 */       .getSeverity() == 4;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.utils.StringUtil
 * JD-Core Version:    0.6.0
 */