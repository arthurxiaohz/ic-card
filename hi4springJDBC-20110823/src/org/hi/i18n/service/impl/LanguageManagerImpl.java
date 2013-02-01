/*     */ package org.hi.i18n.service.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.i18n.model.Language;
/*     */ import org.hi.i18n.model.LanguageCode;
/*     */ import org.hi.i18n.model.LanguageStr;
/*     */ import org.hi.i18n.service.LanguageCodeManager;
/*     */ import org.hi.i18n.service.LanguageManager;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ 
/*     */ public class LanguageManagerImpl extends ManagerImpl
/*     */   implements LanguageManager, InitializingBean
/*     */ {
/*  23 */   private Map<String, Language> languageCache = Collections.synchronizedMap(new HashMap());
/*     */ 
/*     */   protected void loadLanuage() {
/*  26 */     if (HiConfigHolder.getI18NLanguage() == null) {
/*  27 */       return;
/*     */     }
/*  29 */     List _languages = getObjects();
/*  30 */     this.languageCache.clear();
/*  31 */     for (Language _language : _languages)
/*     */     {
/*  33 */       Language language = new Language();
/*  34 */       BeanUtil.setBean2Bean(_language, language);
/*     */ 
/*  36 */       String keyName = language.getEntity() + ".";
/*  37 */       keyName = keyName + language.getKeyStr();
/*     */ 
/*  39 */       this.languageCache.put(keyName, language);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void reloadLanuage() {
/*  44 */     if (HiConfigHolder.getPublished())
/*  45 */       return;
/*  46 */     loadLanuage();
/*     */   }
/*     */   protected void preSaveObject(Object obj) {
/*  49 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  54 */     super.postSaveObject(obj);
/*  55 */     reloadLanuage();
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  60 */     if ((((Language)obj).getIsSystem() != null) && (((Language)obj).getIsSystem().intValue() == 1)) {
/*  61 */       throw new RuntimeException("The system  language info can not  be remove!");
/*     */     }
/*     */ 
/*  64 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  69 */     super.postRemoveObject(obj);
/*  70 */     reloadLanuage();
/*     */   }
/*     */ 
/*     */   public void saveLanguage(Language language)
/*     */   {
/*  75 */     saveObject(language);
/*     */   }
/*     */ 
/*     */   public void removeLanguageById(Integer id)
/*     */   {
/*  80 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public Language getLanguageById(Integer id)
/*     */   {
/*  85 */     return (Language)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<Language> getLanguageList(PageInfo pageInfo) {
/*  89 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void saveSecurityLanguage(Language language) {
/*  93 */     saveObject(language);
/*     */   }
/*     */ 
/*     */   public void removeSecurityLanguageById(Integer id)
/*     */   {
/*  98 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public Language getSecurityLanguageById(Integer id)
/*     */   {
/* 103 */     return (Language)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<Language> getSecurityLanguageList(PageInfo pageInfo) {
/* 107 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void addLanguageStr(Language language)
/*     */   {
/* 114 */     if (language == null)
/* 115 */       return;
/* 116 */     LanguageCodeManager codeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/* 117 */     List allCodes = codeMgr.getObjects();
/* 118 */     if (allCodes == null)
/* 119 */       return;
/* 120 */     for (LanguageCode languageCode : allCodes)
/*     */     {
/* 122 */       if (getLanguageStrByCode(language, languageCode.getLanguageCode()) != null)
/*     */         continue;
/* 124 */       addLanguageStr(language, languageCode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addLanguageStr(Language language, LanguageCode languageCode)
/*     */   {
/* 138 */     List allStr = language.getLanguageStrs();
/* 139 */     if (allStr == null)
/*     */     {
/* 141 */       allStr = new ArrayList();
/* 142 */       language.setLanguageStrs(allStr);
/*     */     }
/* 144 */     LanguageStr str = new LanguageStr();
/* 145 */     str.setLanguageCode(languageCode.getLanguageCode());
/* 146 */     allStr.add(str);
/*     */   }
/*     */ 
/*     */   private String getLanguageStrByCode(Language language, String languageCode)
/*     */   {
/* 156 */     List allStr = language.getLanguageStrs();
/* 157 */     if ((allStr == null) || (allStr.size() == 0))
/* 158 */       return null;
/* 159 */     for (LanguageStr languageStr : allStr)
/*     */     {
/* 161 */       if ((languageStr.getLanguageCode() == null) || 
/* 162 */         (!languageStr.getLanguageCode().equals(languageCode)))
/*     */         continue;
/* 164 */       if (languageStr.getValue() == null) {
/* 165 */         return "";
/*     */       }
/* 167 */       return languageStr.getValue();
/*     */     }
/*     */ 
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */   public String getLanguageStr(String key, String languageCode)
/*     */   {
/* 179 */     return getLanguageStr(key, null, languageCode);
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet() throws Exception
/*     */   {
/* 184 */     loadLanuage();
/*     */   }
/*     */ 
/*     */   public String getLanguageStr(String key, String entity, String languageCode)
/*     */   {
/* 190 */     String keyName = "";
/*     */ 
/* 192 */     if ((entity == null) || (entity.equals("")))
/* 193 */       keyName = key;
/*     */     else {
/* 195 */       keyName = entity + "." + key;
/*     */     }
/* 197 */     Language language = (Language)this.languageCache.get(keyName);
/*     */ 
/* 199 */     if (language == null) {
/* 200 */       return key;
/*     */     }
/* 202 */     String langStr = getLanguageStrByCode(language, languageCode);
/*     */ 
/* 204 */     if ((langStr == null) || (langStr.equals(""))) {
/* 205 */       return key;
/*     */     }
/* 207 */     return langStr;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.service.impl.LanguageManagerImpl
 * JD-Core Version:    0.6.0
 */