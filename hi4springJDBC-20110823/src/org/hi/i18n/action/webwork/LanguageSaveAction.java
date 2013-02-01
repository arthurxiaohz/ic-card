/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.Language;
/*    */ import org.hi.i18n.service.LanguageManager;
/*    */ 
/*    */ public class LanguageSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Language language;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/* 14 */     if (super.perExecute(this.language) != null) return returnCommand();
/* 15 */     languageMgr.saveLanguage(this.language);
/* 16 */     super.postExecute(this.language);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Language getLanguage() {
/* 21 */     return this.language;
/*    */   }
/*    */ 
/*    */   public void setLanguage(Language language) {
/* 25 */     this.language = language;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageSaveAction
 * JD-Core Version:    0.6.0
 */