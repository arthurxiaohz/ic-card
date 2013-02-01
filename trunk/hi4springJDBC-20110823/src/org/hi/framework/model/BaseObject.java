/*     */ package org.hi.framework.model;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ 
/*     */ public abstract class BaseObject
/*     */   implements Serializable
/*     */ {
/*  24 */   private boolean dirty = false;
/*     */   public static final String POJO_DELETED = "deleted";
/*     */   public static final String VERSION = "version";
/*  50 */   protected Map<String, Object> oldValues = new HashMap();
/*     */ 
/*     */   public abstract String toString();
/*     */ 
/*     */   public abstract boolean equals(Object paramObject);
/*     */ 
/*     */   public abstract int hashCode();
/*     */ 
/*     */   public abstract Serializable getPrimarykey();
/*     */ 
/*     */   public abstract void setVersion(Integer paramInteger);
/*     */ 
/*     */   public abstract Integer getVersion();
/*     */ 
/*     */   public String getDataSymbol()
/*     */   {
/*  47 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isDeletedFlag()
/*     */   {
/*  57 */     return BeanUtil.hasPropertyName(this, "deleted");
/*     */   }
/*     */ 
/*     */   public BaseObject getParentEntity()
/*     */   {
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   public void setParentEntity(BaseObject parent)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean isDirty()
/*     */   {
/*  75 */     return this.dirty;
/*     */   }
/*     */ 
/*     */   public void setDirty(boolean dirty) {
/*  79 */     this.dirty = dirty;
/*     */ 
/*  81 */     if (!this.dirty)
/*  82 */       this.oldValues.clear();
/*     */   }
/*     */ 
/*     */   public Object getOldValue(String propertyName) {
/*  86 */     return this.oldValues.get(propertyName);
/*     */   }
/*     */ 
/*     */   public boolean hasOldValue(String propertyName) {
/*  90 */     return this.oldValues.keySet().contains(propertyName);
/*     */   }
/*     */ 
/*     */   public boolean isCascadeDirty()
/*     */   {
/*  98 */     if (this.dirty)
/*  99 */       return true;
/* 100 */     PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(this);
/* 101 */     for (PropertyDescriptor descriptor : properties) {
/* 102 */       Class clzz = descriptor.getPropertyType();
/*     */ 
/* 105 */       if (!Collection.class.isAssignableFrom(clzz)) {
/*     */         continue;
/*     */       }
/* 108 */       String propertyName = descriptor.getName();
/* 109 */       Object collObj = BeanUtil.getPropertyValue(this, propertyName);
/*     */ 
/* 112 */       if (collObj == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 116 */       Collection coll = (Collection)collObj;
/* 117 */       for (Iterator i = coll.iterator(); i.hasNext(); ) {
/* 118 */         BaseObject element = (BaseObject)i.next();
/* 119 */         if (element.dirty) {
/* 120 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.model.BaseObject
 * JD-Core Version:    0.6.0
 */