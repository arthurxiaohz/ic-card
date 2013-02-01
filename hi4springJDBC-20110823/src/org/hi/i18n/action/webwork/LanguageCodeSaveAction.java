/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageCode;
/*    */ import org.hi.i18n.service.LanguageCodeManager;
/*    */ 
/*    */ public class LanguageCodeSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private LanguageCode languageCode;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/* 14 */     if (super.perExecute(this.languageCode) != null) return returnCommand();
/* 15 */     languageCodeMgr.saveLanguageCode(this.languageCode);
/* 16 */     super.postExecute(this.languageCode);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageCode getLanguageCode() {
/* 21 */     return this.languageCode;
/*    */   }
/*    */ 
/*    */   public void setLanguageCode(LanguageCode languageCode) {
/* 25 */     this.languageCode = languageCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageCodeSaveAction
 * JD-Core Version:    0.6.0
 */