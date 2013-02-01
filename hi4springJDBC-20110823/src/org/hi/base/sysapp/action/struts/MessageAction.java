/*     */ package org.hi.base.sysapp.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.action.MessagePageInfo;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.base.sysapp.service.MessageManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class MessageAction extends BaseAction
/*     */ {
/*     */   private Message message;
/*     */   private MessagePageInfo pageInfo;
/*     */   private List<Message> messages;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveMessage()
/*     */     throws Exception
/*     */   {
/*  25 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  26 */     if (super.perExecute(this.message) != null) return returnCommand();
/*  27 */     messageMgr.saveMessage(this.message);
/*  28 */     super.postExecute(this.message);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeMessage()
/*     */     throws Exception
/*     */   {
/*  37 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  38 */     messageMgr.removeMessageById(this.message.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllMessage()
/*     */     throws Exception
/*     */   {
/*  46 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer messageid = new Integer(ids[i]);
/*  55 */         messageMgr.removeMessageById(messageid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewMessage()
/*     */     throws Exception
/*     */   {
/*  67 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  68 */     this.message = messageMgr.getMessageById(this.message.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String messageList()
/*     */     throws Exception
/*     */   {
/*  76 */     MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new MessagePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.messages = messageMgr.getSecurityMessageList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Message getMessage()
/*     */   {
/*  89 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(Message message) {
/*  93 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public List<Message> getMessages() {
/*  97 */     return this.messages;
/*     */   }
/*     */ 
/*     */   public void setMessages(List<Message> messages) {
/* 101 */     this.messages = messages;
/*     */   }
/*     */ 
/*     */   public MessagePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(MessagePageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.struts.MessageAction
 * JD-Core Version:    0.6.0
 */