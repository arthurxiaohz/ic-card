/*     */ package org.hi.framework.web.taglib.component;
/*     */ 
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.web.taglib.component.builder.AnchorTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.DateTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.EntityTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.InputTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.LookupTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.PageTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.SelectTagBuilder;
/*     */ import org.hi.framework.web.taglib.component.builder.TextTagBuilder;
/*     */ 
/*     */ public class TagBuilderFactory
/*     */ {
/*     */   public static final String SELECT_BUILDER_KEY = "hi.pageinfo.tagbuilder.select";
/*     */   public static final String DATE_BUILDER_KEY = "hi.pageinfo.tagbuilder.date";
/*     */   public static final String INPUT_BUILDER_KEY = "hi.pageinfo.tagbuilder.input";
/*     */   public static final String ANCHOR_BUILDER_KEY = "hi.pageinfo.tagbuilder.anchor";
/*     */   public static final String TEXT_BUILDER_KEY = "hi.pageinfo.tagbuilder.text";
/*     */   public static final String ENTITY_BUILDER_KEY = "hi.pageinfo.tagbuilder.entity";
/*     */   public static final String PAGE_BUILDER_KEY = "hi.pageinfo.tagbuilder.page";
/*     */   public static final String LOOKUP_BUILDER_KEY = "hi.pageinfo.tagbuilder.lookup";
/*     */ 
/*     */   public static TagBuilder getSelectTagBuilder()
/*     */   {
/*  30 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.select");
/*  31 */     if ((clzz == null) || (clzz.equals(SelectTagBuilder.class)))
/*  32 */       return new SelectTagBuilder();
/*  33 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getDateTagBuilder()
/*     */   {
/*  38 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.date");
/*  39 */     if ((clzz == null) || (clzz.equals(DateTagBuilder.class)))
/*  40 */       return new DateTagBuilder();
/*  41 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getInputTagBuilder() {
/*  45 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.input");
/*  46 */     if ((clzz == null) || (clzz.equals(InputTagBuilder.class)))
/*  47 */       return new InputTagBuilder();
/*  48 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getAnchorTagBuilder() {
/*  52 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.anchor");
/*  53 */     if ((clzz == null) || (clzz.equals(AnchorTagBuilder.class)))
/*  54 */       return new AnchorTagBuilder();
/*  55 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getTextTagBuilder() {
/*  59 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.text");
/*  60 */     if ((clzz == null) || (clzz.equals(TextTagBuilder.class)))
/*  61 */       return new TextTagBuilder();
/*  62 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getEntityTagBuilder() {
/*  66 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.entity");
/*  67 */     if ((clzz == null) || (clzz.equals(EntityTagBuilder.class)))
/*  68 */       return new EntityTagBuilder();
/*  69 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getPageTagBuilder() {
/*  73 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.page");
/*  74 */     if ((clzz == null) || (clzz.equals(PageTagBuilder.class)))
/*  75 */       return new PageTagBuilder();
/*  76 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   public static TagBuilder getLookupTagBuilder() {
/*  80 */     Class clzz = getTagBuilderClass("hi.pageinfo.tagbuilder.lookup");
/*  81 */     if ((clzz == null) || (clzz.equals(LookupTagBuilder.class)))
/*  82 */       return new LookupTagBuilder();
/*  83 */     return getTagBuilder(clzz);
/*     */   }
/*     */ 
/*     */   private static TagBuilder getTagBuilder(Class clzz) {
/*     */     try {
/*  88 */       return (TagBuilder)clzz.newInstance();
/*     */     } catch (InstantiationException e) {
/*  90 */       e.printStackTrace();
/*     */     } catch (IllegalAccessException e) {
/*  92 */       e.printStackTrace();
/*     */     }
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */   private static Class getTagBuilderClass(String builderKey) {
/*  98 */     String className = HiConfigHolder.getTagBuilderClass(builderKey);
/*  99 */     if (className == null)
/* 100 */       return null;
/*     */     try {
/* 102 */       return Class.forName(className);
/*     */     } catch (ClassNotFoundException e) {
/* 104 */       e.printStackTrace();
/*     */     }
/* 106 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.TagBuilderFactory
 * JD-Core Version:    0.6.0
 */