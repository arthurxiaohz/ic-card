/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.LikeFilter;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.framework.paging.impl.PageImpl;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class BizNumberUtil
/*     */ {
/*     */   public static String genNumber(String propertyName, Class clazz)
/*     */   {
/*  38 */     return genNumber(propertyName, clazz, null, null);
/*     */   }
/*     */ 
/*     */   public static String genNumber(String propertyName, Class clazz, String prefix)
/*     */   {
/*  51 */     return genNumber(propertyName, clazz, prefix, null);
/*     */   }
/*     */ 
/*     */   public static String genNumber(String propertyName, Class clazz, String prefix, String postfix)
/*     */   {
/*  65 */     int count = getCountNumber(propertyName, clazz, prefix);
/*     */ 
/*  67 */     count++; String lastNumber = String.valueOf(count);
/*     */ 
/*  69 */     if (prefix != null) {
/*  70 */       lastNumber = prefix + lastNumber;
/*     */     }
/*  72 */     if (postfix != null) {
/*  73 */       lastNumber = lastNumber + postfix;
/*     */     }
/*  75 */     return lastNumber;
/*     */   }
/*     */ 
/*     */   private static int getCountNumber(String propertyName, Class clazz, String prefix) {
/*  79 */     Filter filter = null;
/*  80 */     if (prefix != null) {
/*  81 */       filter = FilterFactory.getSimpleFilter(propertyName, prefix);
/*     */     }
/*  83 */     ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/*     */ 
/*  85 */     int result = bMgr.getObjectCount(clazz, filter);
/*  86 */     return result;
/*     */   }
/*     */ 
/*     */   public static String genNumber(int digit, String propertyName, Class clazz)
/*     */   {
/* 101 */     return genNumber(digit, propertyName, clazz, null, null);
/*     */   }
/*     */ 
/*     */   public static String genNumber(int digit, String propertyName, Class clazz, String prefix)
/*     */   {
/* 117 */     return genNumber(digit, propertyName, clazz, prefix, null);
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz)
/*     */   {
/* 132 */     return genDateNumber(digit, propertyName, clazz, new Date());
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern)
/*     */   {
/* 148 */     return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, null);
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern, String separator)
/*     */   {
/* 165 */     return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, separator);
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz, Date date)
/*     */   {
/* 178 */     return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", null, null, null);
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz, Date date, String prefix)
/*     */   {
/* 192 */     return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", prefix, null, null);
/*     */   }
/*     */ 
/*     */   public static String genDateNumber(int digit, String propertyName, Class clazz, Date date, String datePattern, String prefix, String postfix, String separator)
/*     */   {
/* 209 */     if (date == null)
/* 210 */       return "";
/* 211 */     if (datePattern == null) {
/* 212 */       return "";
/*     */     }
/* 214 */     if (prefix == null)
/* 215 */       prefix = "";
/* 216 */     DateFormat formater = new SimpleDateFormat(datePattern);
/* 217 */     prefix = prefix + formater.format(date);
/*     */ 
/* 219 */     if (separator != null) {
/* 220 */       prefix = prefix + separator;
/*     */     }
/* 222 */     return genNumber(digit, propertyName, clazz, prefix, postfix);
/*     */   }
/*     */ 
/*     */   public static String genNumber(int digit, String propertyName, Class clazz, String prefix, String postfix)
/*     */   {
/* 238 */     if (digit == 0) {
/* 239 */       return "";
/*     */     }
/* 241 */     String lastNumber = getLastNumber(propertyName, clazz, prefix);
/* 242 */     int returnInt = 1;
/*     */ 
/* 244 */     if (!lastNumber.equals("")) {
/* 245 */       if (prefix != null) {
/* 246 */         lastNumber = lastNumber.substring(prefix.length());
/*     */       }
/* 248 */       if (postfix != null) {
/* 249 */         lastNumber = lastNumber.substring(0, lastNumber.lastIndexOf(postfix));
/*     */       }
/*     */     }
/* 252 */     if (!lastNumber.trim().equals("")) {
/* 253 */       Integer lastInt = new Integer(lastNumber);
/* 254 */       returnInt = lastInt.intValue() + 1;
/*     */     }
/*     */ 
/* 258 */     StringBuffer patternDigitSb = new StringBuffer("");
/* 259 */     for (int i = 0; i < digit; i++) {
/* 260 */       patternDigitSb.append("0");
/*     */     }
/* 262 */     DecimalFormat formater = new DecimalFormat(patternDigitSb.toString());
/* 263 */     String returnNumber = formater.format(returnInt);
/*     */ 
/* 265 */     if (prefix != null)
/* 266 */       returnNumber = prefix + returnNumber;
/* 267 */     if (postfix != null) {
/* 268 */       returnNumber = returnNumber + postfix;
/*     */     }
/* 270 */     return returnNumber;
/*     */   }
/*     */ 
/*     */   private static String getLastNumber(String propertyName, Class clazz, String prefix)
/*     */   {
/* 278 */     Sorter sorter = SorterFactory.getSimpleSort(propertyName, "DESC");
/* 279 */     Filter filter = null;
/* 280 */     if (prefix != null)
/* 281 */       filter = FilterFactory.getLikeFilter(propertyName, prefix, "AND", LikeFilter.LIKE_CONTROLER_RIGHT);
/* 282 */     Page page = new PageImpl();
/* 283 */     page.setPageSize(2);
/*     */ 
/* 285 */     ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
/*     */ 
/* 287 */     List result = bMgr.getObjects(clazz, filter, sorter, page);
/* 288 */     if (result.size() == 0) {
/* 289 */       return "";
/*     */     }
/* 291 */     return (String)BeanUtil.getPropertyValue(result.get(0), propertyName);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.util.BizNumberUtil
 * JD-Core Version:    0.6.0
 */