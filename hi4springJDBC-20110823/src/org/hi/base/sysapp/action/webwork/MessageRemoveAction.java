/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageRemoveAction extends BaseAction
/*    */ {
/*    */   private Message message;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 14 */     messageMgr.removeMessageById(this.message.getId());
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

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageRemoveAction
 * JD-Core Version:    0.6.0
 */