/*     */ package org.hi.i18n.service.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ import org.hi.i18n.service.LanguageCodeManager;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ 
/*     */ public class LanguageCodeManagerImpl extends ManagerImpl
/*     */   implements LanguageCodeManager, InitializingBean
/*     */ {
/*  19 */   private Map<Integer, LanguageCode> languageCodeCache = Collections.synchronizedMap(new HashMap());
/*     */ 
/*  21 */   protected void preSaveObject(Object obj) { super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  26 */     super.postSaveObject(obj);
/*  27 */     reLoadLanguageCode();
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  32 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  37 */     super.postRemoveObject(obj);
/*  38 */     reLoadLanguageCode();
/*     */   }
/*     */ 
/*     */   public void saveLanguageCode(LanguageCode languageCode)
/*     */   {
/*  43 */     saveObject(languageCode);
/*     */   }
/*     */ 
/*     */   public void removeLanguageCodeById(Integer id)
/*     */   {
/*  48 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public LanguageCode getLanguageCodeById(Integer id)
/*     */   {
/*  53 */     if (HiConfigHolder.getI18NLanguage() == null) {
/*  54 */       return (LanguageCode)getObjectById(id);
/*     */     }
/*  56 */     return (LanguageCode)this.languageCodeCache.get(id);
/*     */   }
/*     */ 
/*     */   public List<LanguageCode> getLanguageCodeList(PageInfo pageInfo) {
/*  60 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void saveSecurityLanguageCode(LanguageCode languageCode) {
/*  64 */     saveObject(languageCode);
/*     */   }
/*     */ 
/*     */   public void removeSecurityLanguageCodeById(Integer id)
/*     */   {
/*  69 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public LanguageCode getSecurityLanguageCodeById(Integer id)
/*     */   {
/*  74 */     return (LanguageCode)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<LanguageCode> getSecurityLanguageCodeList(PageInfo pageInfo)
/*     */   {
/*  79 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public List<String> getAllLanguageCode() {
/*  83 */     List allLanguageCodes = new ArrayList();
/*  84 */     if (HiConfigHolder.getI18NLanguage() == null) {
/*  85 */       return allLanguageCodes;
/*     */     }
/*  87 */     Collection allLanguageCode = this.languageCodeCache.values();
/*  88 */     for (LanguageCode languageCode : allLanguageCode) {
/*  89 */       if ((languageCode.getLanguageCode() != null) && (!languageCode.equals("")))
/*  90 */         allLanguageCodes.add(languageCode.getLanguageCode());
/*     */     }
/*  92 */     return allLanguageCodes;
/*     */   }
/*     */ 
/*     */   protected void reLoadLanguageCode() {
/*  96 */     if (HiConfigHolder.getPublished()) {
/*  97 */       return;
/*     */     }
/*  99 */     loadLanguageCode();
/*     */   }
/*     */ 
/*     */   protected void loadLanguageCode() {
/* 103 */     if (HiConfigHolder.getI18NLanguage() == null) {
/* 104 */       return;
/*     */     }
/* 106 */     List _languages = getObjects();
/* 107 */     this.languageCodeCache.clear();
/* 108 */     for (LanguageCode _language : _languages)
/*     */     {
/* 110 */       LanguageCode language = new LanguageCode();
/* 111 */       BeanUtil.setBean2Bean(_language, language);
/*     */ 
/* 113 */       this.languageCodeCache.put(language.getId(), language);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet() throws Exception {
/* 117 */     loadLanguageCode();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.service.impl.LanguageCodeManagerImpl
 * JD-Core Version:    0.6.0
 */