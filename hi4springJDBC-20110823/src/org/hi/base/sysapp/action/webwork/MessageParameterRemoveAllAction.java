/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.MessageParameter;
/*    */ import org.hi.base.sysapp.service.MessageParameterManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageParameterRemoveAllAction extends BaseAction
/*    */ {
/*    */   private MessageParameter messageParameter;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer messageParameterid = new Integer(ids[i]);
/* 24 */         messageParameterMgr.removeMessageParameterById(messageParameterid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MessageParameter getMessageParameter() {
/* 33 */     return this.messageParameter;
/*    */   }
/*    */ 
/*    */   public void setMessageParameter(MessageParameter messageParameter) {
/* 37 */     this.messageParameter = messageParameter;
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
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageParameterRemoveAllAction
 * JD-Core Version:    0.6.0
 */