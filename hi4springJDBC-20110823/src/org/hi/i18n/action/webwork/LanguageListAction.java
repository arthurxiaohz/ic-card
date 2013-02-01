/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.action.LanguagePageInfo;
/*    */ import org.hi.i18n.model.Language;
/*    */ import org.hi.i18n.service.LanguageManager;
/*    */ 
/*    */ public class LanguageListAction extends BaseAction
/*    */ {
/*    */   private Language language;
/*    */   private LanguagePageInfo pageInfo;
/*    */   private List<Language> languages;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new LanguagePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.languages = languageMgr.getLanguageList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Language getLanguage() {
/* 30 */     return this.language;
/*    */   }
/*    */ 
/*    */   public void setLanguage(Language language) {
/* 34 */     this.language = language;
/*    */   }
/*    */ 
/*    */   public List<Language> getLanguages() {
/* 38 */     return this.languages;
/*    */   }
/*    */ 
/*    */   public void setLanguages(List<Language> languages) {
/* 42 */     this.languages = languages;
/*    */   }
/*    */ 
/*    */   public LanguagePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(LanguagePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageListAction
 * JD-Core Version:    0.6.0
 */