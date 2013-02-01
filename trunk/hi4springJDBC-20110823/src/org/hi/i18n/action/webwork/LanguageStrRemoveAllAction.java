/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.LanguageStr;
/*    */ import org.hi.i18n.service.LanguageStrManager;
/*    */ 
/*    */ public class LanguageStrRemoveAllAction extends BaseAction
/*    */ {
/*    */   private LanguageStr languageStr;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer languageStrid = new Integer(ids[i]);
/* 24 */         languageStrMgr.removeLanguageStrById(languageStrid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public LanguageStr getLanguageStr() {
/* 33 */     return this.languageStr;
/*    */   }
/*    */ 
/*    */   public void setLanguageStr(LanguageStr languageStr) {
/* 37 */     this.languageStr = languageStr;
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
 * Qualified Name:     org.hi.i18n.action.webwork.LanguageStrRemoveAllAction
 * JD-Core Version:    0.6.0
 */