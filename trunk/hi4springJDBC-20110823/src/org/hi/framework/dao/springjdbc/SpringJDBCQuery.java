/*     */ package org.hi.framework.dao.springjdbc;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class SpringJDBCQuery
/*     */ {
/*  25 */   StringBuffer querySql = new StringBuffer();
/*     */ 
/*  30 */   Map<String, Object> parameterObject = new LinkedHashMap();
/*     */ 
/*     */   private void setParameterSingle(String parameterName, Object value) {
/*  33 */     if ((value instanceof Boolean))
/*  34 */       this.parameterObject.put(parameterName, Boolean.valueOf(((Boolean)value).booleanValue()));
/*  35 */     else if ((value instanceof Byte))
/*  36 */       this.parameterObject.put(parameterName, Byte.valueOf(((Byte)value).byteValue()));
/*  37 */     else if ((value instanceof Character))
/*  38 */       this.parameterObject.put(parameterName, Character.valueOf(((Character)value).charValue()));
/*  39 */     else if ((value instanceof Double))
/*  40 */       this.parameterObject.put(parameterName, Double.valueOf(((Double)value).doubleValue()));
/*  41 */     else if ((value instanceof Float))
/*  42 */       this.parameterObject.put(parameterName, Float.valueOf(((Float)value).floatValue()));
/*  43 */     else if ((value instanceof Integer))
/*  44 */       this.parameterObject.put(parameterName, Integer.valueOf(((Integer)value).intValue()));
/*  45 */     else if ((value instanceof Long))
/*  46 */       this.parameterObject.put(parameterName, Long.valueOf(((Long)value).longValue()));
/*  47 */     else if ((value instanceof Short))
/*  48 */       this.parameterObject.put(parameterName, Short.valueOf(((Short)value).shortValue()));
/*  49 */     else if ((value instanceof String))
/*  50 */       this.parameterObject.put(parameterName, (String)value);
/*  51 */     else if ((value instanceof byte[]))
/*  52 */       this.parameterObject.put(parameterName, (byte[])value);
/*  53 */     else if ((value instanceof BigDecimal))
/*  54 */       this.parameterObject.put(parameterName, (BigDecimal)value);
/*  55 */     else if ((value instanceof BigInteger))
/*  56 */       this.parameterObject.put(parameterName, (BigInteger)value);
/*  57 */     else if ((value instanceof java.sql.Date))
/*  58 */       this.parameterObject.put(parameterName, (java.sql.Date)value);
/*  59 */     else if ((value instanceof Time))
/*  60 */       this.parameterObject.put(parameterName, (Time)value);
/*  61 */     else if ((value instanceof Timestamp))
/*  62 */       this.parameterObject.put(parameterName, (Timestamp)value);
/*  63 */     else if ((value instanceof java.util.Date))
/*  64 */       this.parameterObject.put(parameterName, (java.util.Date)value);
/*  65 */     else if ((value instanceof Locale))
/*  66 */       this.parameterObject.put(parameterName, (Locale)value);
/*     */     else
/*  68 */       this.parameterObject.put(parameterName, value);
/*     */   }
/*     */ 
/*     */   public void putParameter(String parameterName, Object value)
/*     */   {
/*  74 */     if ((value instanceof Collection)) {
/*  75 */       Collection values = (Collection)value;
/*  76 */       int j = 0;
/*  77 */       for (Iterator i = values.iterator(); i.hasNext(); ) {
/*  78 */         Object val = i.next();
/*  79 */         setParameterSingle(parameterName + j, val);
/*  80 */         j++;
/*     */       }
/*     */     }
/*     */     else {
/*  84 */       setParameterSingle(parameterName, value);
/*     */     }
/*     */   }
/*     */ 
/*     */   public SpringJDBCQuery append(String sqlSegment) {
/*  89 */     this.querySql.append(sqlSegment);
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */   public SpringJDBCQuery append(StringBuffer sqlSegment) {
/*  94 */     this.querySql.append(sqlSegment);
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */   public String getQuerySql() {
/*  99 */     return this.querySql.toString();
/*     */   }
/*     */ 
/*     */   public Object[] getParameterObjects() {
/* 103 */     Collection values = this.parameterObject.values();
/* 104 */     return values.toArray(new Object[values.size()]);
/*     */   }
/*     */ 
/*     */   public void replaceAll(String regex, String replacement) {
/* 108 */     String _sql = this.querySql.toString().replaceAll(regex, replacement);
/* 109 */     this.querySql = new StringBuffer(_sql);
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 113 */     return this.querySql.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.SpringJDBCQuery
 * JD-Core Version:    0.6.0
 */