/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageCode;
/*    */ import org.hi.i18n.service.LanguageCodeManager;
/*    */ 
/*    */ public class LanguageCodeViewAction extends BaseAction
/*    */ {
/*    */   private LanguageCode languageCode;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/* 14 */     this.languageCode = languageCodeMgr.getLanguageCodeById(this.languageCode.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageCode getLanguageCode() {
/* 19 */     return this.languageCode;
/*    */   }
/*    */ 
/*    */   public void setLanguageCode(LanguageCode languageCode) {
/* 23 */     this.languageCode = languageCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageCodeViewAction
 * JD-Core Version:    0.6.0
 */