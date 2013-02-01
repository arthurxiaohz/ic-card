/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageViewAction extends BaseAction
/*    */ {
/*    */   private Message message;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 14 */     this.message = messageMgr.getMessageById(this.message.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Message getMessage() {
/* 19 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(Message message) {
/* 23 */     this.message = message;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageViewAction
 * JD-Core Version:    0.6.0
 */