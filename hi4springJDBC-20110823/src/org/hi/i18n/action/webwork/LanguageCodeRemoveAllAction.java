/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageCode;
/*    */ import org.hi.i18n.service.LanguageCodeManager;
/*    */ 
/*    */ public class LanguageCodeRemoveAllAction extends BaseAction
/*    */ {
/*    */   private LanguageCode languageCode;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer languageCodeid = new Integer(ids[i]);
/* 24 */         languageCodeMgr.removeLanguageCodeById(languageCodeid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageCode getLanguageCode() {
/* 33 */     return this.languageCode;
/*    */   }
/*    */ 
/*    */   public void setLanguageCode(LanguageCode languageCode) {
/* 37 */     this.languageCode = languageCode;
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageCodeRemoveAllAction
 * JD-Core Version:    0.6.0
 */