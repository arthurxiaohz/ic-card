/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.action.MessagePageInfo;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MessageListAction extends BaseAction
/*    */ {
/*    */   private Message message;
/*    */   private MessagePageInfo pageInfo;
/*    */   private List<Message> messages;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new MessagePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.messages = messageMgr.getSecurityMessageList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Message getMessage() {
/* 30 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(Message message) {
/* 34 */     this.message = message;
/*    */   }
/*    */ 
/*    */   public List<Message> getMessages() {
/* 38 */     return this.messages;
/*    */   }
/*    */ 
/*    */   public void setMessages(List<Message> messages) {
/* 42 */     this.messages = messages;
/*    */   }
/*    */ 
/*    */   public MessagePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(MessagePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.MessageListAction
 * JD-Core Version:    0.6.0
 */