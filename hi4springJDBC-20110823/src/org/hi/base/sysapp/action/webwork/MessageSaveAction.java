/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Message message;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.message) != null) return returnCommand();
/* 14 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 15 */     messageMgr.saveMessage(this.message);
/* 16 */     super.postExecute(this.message);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Message getMessage() {
/* 21 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(Message message) {
/* 25 */     this.message = message;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageSaveAction
 * JD-Core Version:    0.6.0
 */