/*     */ package org.hi.base.sysapp.message;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.base.sysapp.model.MessageParameter;
/*     */ import org.hi.base.sysapp.service.MessageManager;
/*     */ 
/*     */ public abstract class AbstractMessageProvider
/*     */   implements MessageProvider
/*     */ {
/*     */   private String messageType;
/*     */   protected boolean remove;
/*     */   protected boolean persistence;
/*     */ 
/*     */   public Message creatMessage(String receivers, String receiverNames, String sender, Date sendDate, String messageText, List<MessageParameter> pars)
/*     */   {
/*  23 */     Message message = new Message();
/*  24 */     message.setReceivers(receivers);
/*  25 */     message.setReceiverNames(receiverNames);
/*  26 */     message.setSender(sender);
/*  27 */     message.setCreateDate(new Timestamp(new Date().getTime()));
/*  28 */     if (sendDate == null)
/*  29 */       message.setSendDate(new Timestamp(new Date().getTime()));
/*     */     else
/*  31 */       message.setSendDate(new Timestamp(sendDate.getTime()));
/*  32 */     message.setMessageText(messageText);
/*  33 */     message.setMessageType(new Integer(getMessageType()));
/*     */ 
/*  35 */     if ((pars != null) && (pars.size() > 0)) {
/*  36 */       for (MessageParameter messageParameter : pars) {
/*  37 */         messageParameter.setMessage(message);
/*     */       }
/*  39 */       message.setMessageParameters(pars);
/*     */     }
/*     */ 
/*  43 */     if (this.persistence) {
/*  44 */       MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  45 */       mesgMgr.saveObject(message);
/*     */     }
/*     */ 
/*  48 */     MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean("org.hi.message.MessageProviderManager");
/*  49 */     if (providerMgr.cache) {
/*  50 */       providerMgr.addMessage(message);
/*     */     }
/*  52 */     return message;
/*     */   }
/*     */ 
/*     */   public Message creatMessage(String receivers, String receiverNames, String sender, Date sendDate, String messageText)
/*     */   {
/*  57 */     return creatMessage(receivers, receiverNames, sender, sendDate, messageText, null);
/*     */   }
/*     */ 
/*     */   public Message creatMessage(String receivers, String sender, String messageText) {
/*  61 */     return creatMessage(receivers, null, sender, null, messageText, null);
/*     */   }
/*     */ 
/*     */   public void sentProcess(Message message) {
/*  65 */     MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean("org.hi.message.MessageProviderManager");
/*  66 */     MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/*  67 */     if (providerMgr.cache) {
/*  68 */       providerMgr.removeMessage(message);
/*     */     }
/*     */ 
/*  72 */     if (this.persistence)
/*  73 */       if (isRemove()) {
/*  74 */         mesgMgr.removeObject(message);
/*     */       }
/*     */       else {
/*  77 */         message.setIsSent(Integer.valueOf(3200));
/*  78 */         mesgMgr.saveObject(message);
/*     */       }
/*     */   }
/*     */ 
/*     */   protected String getParameter(List<MessageParameter> parameters, String key)
/*     */   {
/*  85 */     if ((parameters == null) || (parameters.size() == 0))
/*  86 */       return null;
/*  87 */     for (MessageParameter parameter : parameters) {
/*  88 */       if (parameter.getParameterKey().equals(key))
/*  89 */         return parameter.getParameterValue();
/*     */     }
/*  91 */     return null;
/*     */   }
/*     */   public abstract String[] getAllReceivers();
/*     */ 
/*     */   public boolean isRemove() {
/*  97 */     return this.remove;
/*     */   }
/*     */   public String getMessageType() {
/* 100 */     return this.messageType;
/*     */   }
/*     */ 
/*     */   public void setMessageType(String messageType) {
/* 104 */     this.messageType = messageType;
/*     */   }
/*     */ 
/*     */   public void setRemove(boolean remove) {
/* 108 */     this.remove = remove;
/*     */   }
/*     */ 
/*     */   public boolean isPersistence() {
/* 112 */     return this.persistence;
/*     */   }
/*     */ 
/*     */   public void setPersistence(boolean persistence) {
/* 116 */     this.persistence = persistence;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.AbstractMessageProvider
 * JD-Core Version:    0.6.0
 */