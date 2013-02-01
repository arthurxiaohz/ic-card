/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageStr;
/*    */ import org.hi.i18n.service.LanguageStrManager;
/*    */ 
/*    */ public class LanguageStrSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private LanguageStr languageStr;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/* 14 */     if (super.perExecute(this.languageStr) != null) return returnCommand();
/* 15 */     languageStrMgr.saveLanguageStr(this.languageStr);
/* 16 */     super.postExecute(this.languageStr);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageStr getLanguageStr() {
/* 21 */     return this.languageStr;
/*    */   }
/*    */ 
/*    */   public void setLanguageStr(LanguageStr languageStr) {
/* 25 */     this.languageStr = languageStr;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageStrSaveAction
 * JD-Core Version:    0.6.0
 */