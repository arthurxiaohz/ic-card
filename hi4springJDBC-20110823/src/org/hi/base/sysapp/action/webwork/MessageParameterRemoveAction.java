/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.MessageParameter;
/*    */ import org.hi.base.sysapp.service.MessageParameterManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageParameterRemoveAction extends BaseAction
/*    */ {
/*    */   private MessageParameter messageParameter;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/* 14 */     messageParameterMgr.removeMessageParameterById(this.messageParameter.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MessageParameter getMessageParameter() {
/* 19 */     return this.messageParameter;
/*    */   }
/*    */ 
/*    */   public void setMessageParameter(MessageParameter messageParameter) {
/* 23 */     this.messageParameter = messageParameter;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageParameterRemoveAction
 * JD-Core Version:    0.6.0
 */