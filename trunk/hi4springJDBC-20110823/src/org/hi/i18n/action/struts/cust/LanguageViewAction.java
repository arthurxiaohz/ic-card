/*    */ package org.hi.i18n.action.struts.cust;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ import org.hi.i18n.model.Language;
/*    */ import org.hi.i18n.service.LanguageManager;
/*    */ 
/*    */ public class LanguageViewAction extends BaseAction
/*    */ {
/*    */   private Language language;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 12 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/* 13 */     this.language = languageMgr.getLanguageById(this.language.getId());
/*    */ 
/* 15 */     languageMgr.addLanguageStr(this.language);
/* 16 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Language getLanguage() {
/* 20 */     return this.language;
/*    */   }
/*    */ 
/*    */   public void setLanguage(Language language) {
/* 24 */     this.language = language;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.struts.cust.LanguageViewAction
 * JD-Core Version:    0.6.0
 */