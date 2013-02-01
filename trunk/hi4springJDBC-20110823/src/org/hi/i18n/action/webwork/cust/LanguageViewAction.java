/*    */ package org.hi.i18n.action.webwork.cust;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
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
/* 13 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/* 14 */     this.language = languageMgr.getLanguageById(this.language.getId());
/*    */ 
/* 16 */     languageMgr.addLanguageStr(this.language);
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.cust.LanguageViewAction
 * JD-Core Version:    0.6.0
 */