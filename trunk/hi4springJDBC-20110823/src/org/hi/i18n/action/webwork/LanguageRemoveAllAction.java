/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.Language;
/*    */ import org.hi.i18n.service.LanguageManager;
/*    */ 
/*    */ public class LanguageRemoveAllAction extends BaseAction
/*    */ {
/*    */   private Language language;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer languageid = new Integer(ids[i]);
/* 24 */         languageMgr.removeLanguageById(languageid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Language getLanguage() {
/* 33 */     return this.language;
/*    */   }
/*    */ 
/*    */   public void setLanguage(Language language) {
/* 37 */     this.language = language;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageRemoveAllAction
 * JD-Core Version:    0.6.0
 */