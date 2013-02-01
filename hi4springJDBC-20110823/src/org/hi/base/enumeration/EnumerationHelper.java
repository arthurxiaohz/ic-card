/*     */ package org.hi.base.enumeration;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.enumeration.model.Enumeration;
/*     */ import org.hi.base.enumeration.model.EnumerationValue;
/*     */ import org.hi.base.enumeration.service.EnumerationManager;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ 
/*     */ public class EnumerationHelper
/*     */ {
/*  24 */   private static EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/*     */ 
/*     */   public static List<EnumerationValue> getEnumerationValue(String enumName)
/*     */   {
/*  33 */     List enums = enumMgr.getEnumerations();
/*     */ 
/*  35 */     for (Enumeration enumeration : enums) {
/*  36 */       if (enumeration.getEnName().equals(enumName)) {
/*  37 */         return enumeration.getEnumerationValues();
/*     */       }
/*     */     }
/*  40 */     return new ArrayList();
/*     */   }
/*     */ 
/*     */   public static Map<Integer, String> getEnumerationValueMap(String enumName, String pattern, String title)
/*     */   {
/*  50 */     List values = getEnumerationValue(enumName);
/*     */ 
/*  52 */     Map result = new LinkedHashMap();
/*     */ 
/*  54 */     for (EnumerationValue enumValue : values) {
/*  55 */       StringBuffer sb = new StringBuffer("");
/*  56 */       if ((pattern == null) && (title == null)) {
/*  57 */         result.put(enumValue.getId(), enumValue.getDescription());
/*     */       }
/*  61 */       else if ((pattern == null) || (pattern.trim().equals(""))) {
/*  62 */         sb.append(BeanUtil.getPropertyValue(enumValue, title).toString());
/*  63 */         result.put(enumValue.getId(), sb.toString());
/*     */       }
/*     */       else
/*     */       {
/*  67 */         List titleUnits = StringUtils.strToArrayList(title, pattern);
/*  68 */         int step = 0;
/*  69 */         for (String titleUnit : titleUnits) {
/*  70 */           if (step > 0) {
/*  71 */             sb.append(pattern);
/*     */           }
/*  73 */           sb.append(BeanUtil.getPropertyValue(enumValue, titleUnit).toString());
/*     */ 
/*  75 */           step++;
/*     */         }
/*     */ 
/*  78 */         result.put(enumValue.getId(), sb.toString());
/*     */       }
/*     */     }
/*     */ 
/*  82 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, String> getEnumerationValueMapForString(String enumName)
/*     */   {
/*  92 */     List values = getEnumerationValue(enumName);
/*     */ 
/*  94 */     Map result = new LinkedHashMap();
/*     */ 
/*  96 */     for (EnumerationValue enumValue : values) {
/*  97 */       result.put(enumValue.getId().toString(), enumValue.getDescription());
/*     */     }
/*     */ 
/* 100 */     return result;
/*     */   }
/*     */ 
/*     */   public static EnumerationValue getEnumerationValue(Integer enumerationValueId)
/*     */   {
/* 109 */     List enums = enumMgr.getEnumerations();
/*     */ 
/* 111 */     for (Enumeration enumeration : enums) {
/* 112 */       List enumerationValues = enumeration.getEnumerationValues();
/* 113 */       for (Iterator iter = enumerationValues.iterator(); iter.hasNext(); ) {
/* 114 */         EnumerationValue value = (EnumerationValue)iter.next();
/*     */ 
/* 116 */         if (value.getId().equals(enumerationValueId)) {
/* 117 */           return value;
/*     */         }
/*     */       }
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   public static String getDescription(Integer enumerationValueId)
/*     */   {
/* 129 */     EnumerationValue enumValue = getEnumerationValue(enumerationValueId);
/* 130 */     if (enumValue == null)
/* 131 */       return null;
/* 132 */     return enumValue.getDescription();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.EnumerationHelper
 * JD-Core Version:    0.6.0
 */