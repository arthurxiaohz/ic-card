/*     */ package org.hi.i18n.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.action.LanguagePageInfo;
/*     */ import org.hi.i18n.model.Language;
/*     */ import org.hi.i18n.service.LanguageManager;
/*     */ 
/*     */ public class LanguageAction extends BaseAction
/*     */ {
/*     */   private Language language;
/*     */   private LanguagePageInfo pageInfo;
/*     */   private List<Language> languages;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveLanguage()
/*     */     throws Exception
/*     */   {
/*  25 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  26 */     if (super.perExecute(this.language) != null) return returnCommand();
/*  27 */     languageMgr.saveLanguage(this.language);
/*  28 */     super.postExecute(this.language);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeLanguage()
/*     */     throws Exception
/*     */   {
/*  37 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  38 */     languageMgr.removeLanguageById(this.language.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllLanguage()
/*     */     throws Exception
/*     */   {
/*  46 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer languageid = new Integer(ids[i]);
/*  55 */         languageMgr.removeLanguageById(languageid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewLanguage()
/*     */     throws Exception
/*     */   {
/*  67 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  68 */     this.language = languageMgr.getLanguageById(this.language.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String languageList()
/*     */     throws Exception
/*     */   {
/*  76 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new LanguagePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.languages = languageMgr.getLanguageList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Language getLanguage()
/*     */   {
/*  89 */     return this.language;
/*     */   }
/*     */ 
/*     */   public void setLanguage(Language language) {
/*  93 */     this.language = language;
/*     */   }
/*     */ 
/*     */   public List<Language> getLanguages() {
/*  97 */     return this.languages;
/*     */   }
/*     */ 
/*     */   public void setLanguages(List<Language> languages) {
/* 101 */     this.languages = languages;
/*     */   }
/*     */ 
/*     */   public LanguagePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(LanguagePageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.struts.LanguageAction
 * JD-Core Version:    0.6.0
 */