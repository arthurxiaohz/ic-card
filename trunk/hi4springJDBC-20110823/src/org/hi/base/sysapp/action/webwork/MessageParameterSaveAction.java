/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.MessageParameter;
/*    */ import org.hi.base.sysapp.service.MessageParameterManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageParameterSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private MessageParameter messageParameter;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.messageParameter) != null) return returnCommand();
/* 14 */     MessageParameterManager messageParameterMgr = (MessageParameterManager)SpringContextHolder.getBean(MessageParameter.class);
/* 15 */     messageParameterMgr.saveMessageParameter(this.messageParameter);
/* 16 */     super.postExecute(this.messageParameter);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MessageParameter getMessageParameter() {
/* 21 */     return this.messageParameter;
/*    */   }
/*    */ 
/*    */   public void setMessageParameter(MessageParameter messageParameter) {
/* 25 */     this.messageParameter = messageParameter;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageParameterSaveAction
 * JD-Core Version:    0.6.0
 */