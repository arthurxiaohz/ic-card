/*     */ package org.hi.base.enumeration.service.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.hi.base.enumeration.model.Enumeration;
/*     */ import org.hi.base.enumeration.service.EnumerationManager;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class EnumerationManagerImpl extends ManagerImpl
/*     */   implements EnumerationManager
/*     */ {
/*  17 */   protected List<Enumeration> enumerations = Collections.synchronizedList(new ArrayList());
/*     */ 
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  23 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  30 */     loadEnumeration();
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  37 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  44 */     loadEnumeration();
/*     */   }
/*     */ 
/*     */   public void saveEnumeration(Enumeration Enumeration)
/*     */   {
/*  51 */     saveObject(Enumeration);
/*     */   }
/*     */ 
/*     */   public void removeEnumerationById(Integer id)
/*     */   {
/*  58 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public Enumeration getEnumerationById(Integer id)
/*     */   {
/*  65 */     return (Enumeration)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<Enumeration> getEnumerationList(PageInfo pageInfo)
/*     */   {
/*  71 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   protected void loadEnumeration()
/*     */   {
/*  77 */     List _enumerations = new ArrayList();
/*     */ 
/*  79 */     _enumerations = getObjects();
/*  80 */     synchronized (this.enumerations) {
/*  81 */       this.enumerations.clear();
/*  82 */       for (Enumeration _enumeration : _enumerations) {
/*  83 */         Enumeration enumeration = new Enumeration();
/*  84 */         BeanUtil.setBean2Bean(_enumeration, enumeration);
/*  85 */         this.enumerations.add(enumeration);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<Enumeration> getEnumerations() {
/*  91 */     if ((this.enumerations.size() == 0) || (!HiConfigHolder.getPublished())) {
/*  92 */       loadEnumeration();
/*     */     }
/*  94 */     return this.enumerations;
/*     */   }
/*     */ 
/*     */   public void reloadEnumeration() {
/*  98 */     loadEnumeration();
/*     */   }
/*     */ 
/*     */   public void saveSecurityEnumeration(Enumeration enumeration)
/*     */   {
/* 105 */     saveObject(enumeration);
/*     */   }
/*     */   public void removeSecurityEnumerationById(Integer id) {
/* 108 */     removeObjectById(id);
/*     */   }
/*     */   public Enumeration getSecurityEnumerationById(Integer id) {
/* 111 */     return (Enumeration)getObjectById(id);
/*     */   }
/*     */   public List<Enumeration> getSecurityEnumerationList(PageInfo pageInfo) {
/* 114 */     return super.getList(pageInfo);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.service.impl.EnumerationManagerImpl
 * JD-Core Version:    0.6.0
 */