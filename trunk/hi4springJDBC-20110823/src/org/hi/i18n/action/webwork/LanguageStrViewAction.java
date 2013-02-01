/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageStr;
/*    */ import org.hi.i18n.service.LanguageStrManager;
/*    */ 
/*    */ public class LanguageStrViewAction extends BaseAction
/*    */ {
/*    */   private LanguageStr languageStr;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/* 14 */     this.languageStr = languageStrMgr.getLanguageStrById(this.languageStr.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageStr getLanguageStr() {
/* 19 */     return this.languageStr;
/*    */   }
/*    */ 
/*    */   public void setLanguageStr(LanguageStr languageStr) {
/* 23 */     this.languageStr = languageStr;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageStrViewAction
 * JD-Core Version:    0.6.0
 */