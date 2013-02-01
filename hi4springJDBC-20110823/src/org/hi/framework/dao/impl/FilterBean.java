/*     */ package org.hi.framework.dao.impl;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class FilterBean
/*     */   implements Serializable
/*     */ {
/*     */   private String fieldName;
/*     */   private Object value;
/*     */   private String operater;
/*     */   private String relations;
/*     */   private boolean not;
/*     */   private int likeControler;
/*     */ 
/*     */   public String getFieldName()
/*     */   {
/*  52 */     return this.fieldName;
/*     */   }
/*     */ 
/*     */   public void setFieldName(String fieldName)
/*     */   {
/*  60 */     this.fieldName = fieldName;
/*     */   }
/*     */ 
/*     */   public String getOperater()
/*     */   {
/*  68 */     return this.operater;
/*     */   }
/*     */ 
/*     */   public void setOperater(String operater)
/*     */   {
/*  76 */     this.operater = operater;
/*     */   }
/*     */ 
/*     */   public String getRelations()
/*     */   {
/*  84 */     return this.relations;
/*     */   }
/*     */ 
/*     */   public void setRelations(String relations)
/*     */   {
/*  92 */     this.relations = relations;
/*     */   }
/*     */ 
/*     */   public Object getValue()
/*     */   {
/* 100 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(Object value)
/*     */   {
/* 108 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public boolean isNot() {
/* 112 */     return this.not;
/*     */   }
/*     */ 
/*     */   public void setNot(boolean not) {
/* 116 */     this.not = not;
/*     */   }
/*     */ 
/*     */   public int getLikeControler() {
/* 120 */     return this.likeControler;
/*     */   }
/*     */ 
/*     */   public void setLikeControler(int likeControler) {
/* 124 */     this.likeControler = likeControler;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 129 */     if (this == other) return true;
/* 130 */     if (other == null) return false;
/* 131 */     if (!(other instanceof FilterBean)) return false;
/* 132 */     FilterBean castOther = (FilterBean)other;
/* 133 */     if (this.value != castOther.value) return false;
/* 134 */     if (this.fieldName != castOther.fieldName) return false;
/*     */ 
/* 139 */     return (this.not == castOther.not) && (this.likeControler == castOther.likeControler) && 
/* 137 */       (this.operater == castOther.operater) && (this.relations == castOther.relations) && 
/* 138 */       ((this.fieldName == castOther.fieldName) || (this.fieldName.equals(castOther.fieldName))) && (
/* 139 */       (this.value == castOther.value) || (this.value.equals(castOther.value)));
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.FilterBean
 * JD-Core Version:    0.6.0
 */