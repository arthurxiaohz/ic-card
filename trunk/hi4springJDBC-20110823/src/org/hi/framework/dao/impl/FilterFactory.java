/*     */ package org.hi.framework.dao.impl;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.SecurityFilter;
/*     */ 
/*     */ public class FilterFactory
/*     */ {
/*     */   public static Filter getSimpleFilter(String name, Object val)
/*     */   {
/*  30 */     SimpleFilter filter = new SimpleFilter();
/*  31 */     filter.addCondition(name, val);
/*  32 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getSimpleFilter(String name, Object val, String op)
/*     */   {
/*  43 */     SimpleFilter filter = new SimpleFilter();
/*  44 */     filter.addCondition(name, val, op);
/*  45 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getSimpleFilter(String name, Object val, String op, String relation)
/*     */   {
/*  57 */     SimpleFilter filter = new SimpleFilter();
/*  58 */     filter.addCondition(name, val, op, relation);
/*  59 */     return filter;
/*     */   }
/*     */ 
/*     */   public static InFilter getInFilter(String name, Collection val)
/*     */   {
/*  69 */     InFilter filter = new InFilter();
/*  70 */     filter.addCondition(name, val, "IN");
/*  71 */     return filter;
/*     */   }
/*     */ 
/*     */   public static InFilter getInFilter(String name, Collection val, String relation)
/*     */   {
/*  87 */     InFilter filter = new InFilter();
/*  88 */     filter.addCondition(name, val, "IN", relation);
/*  89 */     return filter;
/*     */   }
/*     */ 
/*     */   public static NotInFilter getNotInFilter(String name, Collection val)
/*     */   {
/*  99 */     NotInFilter filter = new NotInFilter();
/* 100 */     filter.addCondition(name, val, "IN");
/* 101 */     return filter;
/*     */   }
/*     */ 
/*     */   public static NotInFilter getNotInFilter(String name, Collection val, String relation)
/*     */   {
/* 117 */     NotInFilter filter = new NotInFilter();
/* 118 */     filter.addCondition(name, val, "IN", relation);
/* 119 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getNotLikeFilter(String name, String val)
/*     */   {
/* 129 */     NotLikeFilter filter = new NotLikeFilter();
/* 130 */     filter.addCondition(name, val, "LIKE");
/* 131 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getNotLikeFilter(String name, String val, String relation) {
/* 135 */     NotLikeFilter filter = new NotLikeFilter();
/* 136 */     filter.addCondition(name, val, "LIKE", relation);
/* 137 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getNotLikeFilter(String name, String val, String relation, int controler) {
/* 141 */     NotLikeFilter filter = new NotLikeFilter();
/* 142 */     filter.addCondition(name, val, "LIKE", relation, controler);
/* 143 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getLikeFilter(String name, String val) {
/* 147 */     LikeFilter filter = new LikeFilter();
/* 148 */     filter.addCondition(name, val, "LIKE");
/* 149 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getLikeFilter(String name, String val, String relation) {
/* 153 */     LikeFilter filter = new LikeFilter();
/* 154 */     filter.addCondition(name, val, "LIKE", relation);
/* 155 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getLikeFilter(String name, String val, String relation, int controler) {
/* 159 */     LikeFilter filter = new LikeFilter();
/* 160 */     filter.addCondition(name, val, "LIKE", relation, controler);
/* 161 */     return filter;
/*     */   }
/*     */ 
/*     */   public static Filter getSecurityFilter()
/*     */   {
/* 169 */     String className = HiConfigHolder.getSecurityFilterCalss();
/* 170 */     SecurityFilter filter = null;
/*     */     try {
/* 172 */       filter = (SecurityFilter)Class.forName(className).newInstance();
/*     */     } catch (InstantiationException e) {
/* 174 */       e.printStackTrace();
/*     */     } catch (IllegalAccessException e) {
/* 176 */       e.printStackTrace();
/*     */     } catch (ClassNotFoundException e) {
/* 178 */       e.printStackTrace();
/*     */     }
/* 180 */     return filter.getSeurityFilter();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.FilterFactory
 * JD-Core Version:    0.6.0
 */