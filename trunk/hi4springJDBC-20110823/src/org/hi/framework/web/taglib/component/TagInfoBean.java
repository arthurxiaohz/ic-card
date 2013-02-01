/*     */ package org.hi.framework.web.taglib.component;
/*     */ 
/*     */ import java.util.Map;
/*     */ 
/*     */ public class TagInfoBean
/*     */ {
/*     */   private Map parameters;
/*     */   private String name;
/*     */   private String dateFormat;
/*     */   private String url;
/*     */   private String defaultValue;
/*     */   private boolean isLabel;
/*     */   private String type;
/*     */   private boolean multiple;
/*     */   private String onEvent;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  33 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  37 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getDefaultValue() {
/*  41 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String defaultValue) {
/*  45 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/*  49 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/*  53 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public boolean isLabel()
/*     */   {
/*  58 */     return this.isLabel;
/*     */   }
/*     */ 
/*     */   public void setLabel(boolean isLabel) {
/*  62 */     this.isLabel = isLabel;
/*     */   }
/*     */ 
/*     */   public Map getParameters() {
/*  66 */     return this.parameters;
/*     */   }
/*     */ 
/*     */   public void setParameters(Map parameters) {
/*  70 */     this.parameters = parameters;
/*     */   }
/*     */ 
/*     */   public boolean isMultiple() {
/*  74 */     return this.multiple;
/*     */   }
/*     */ 
/*     */   public void setMultiple(boolean multiple) {
/*  78 */     this.multiple = multiple;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  82 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  86 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getOnEvent() {
/*  90 */     return this.onEvent;
/*     */   }
/*     */ 
/*     */   public void setOnEvent(String onEvent) {
/*  94 */     this.onEvent = onEvent;
/*     */   }
/*     */ 
/*     */   public String getDateFormat() {
/*  98 */     return this.dateFormat;
/*     */   }
/*     */ 
/*     */   public void setDateFormat(String dateFormat) {
/* 102 */     this.dateFormat = dateFormat;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.TagInfoBean
 * JD-Core Version:    0.6.0
 */