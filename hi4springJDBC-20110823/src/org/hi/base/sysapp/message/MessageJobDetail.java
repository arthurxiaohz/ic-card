/*    */ package org.hi.base.sysapp.message;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.quartz.JobDetail;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ 
/*    */ public class MessageJobDetail extends JobDetail
/*    */ {
/*    */   public void execute()
/*    */   {
/* 20 */     MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean("org.hi.message.MessageProviderManager");
/*    */ 
/* 22 */     Timestamp crrentTime = new Timestamp(new Date().getTime());
/*    */     List messages;
/*    */     List messages;
/* 24 */     if (providerMgr.isCache()) {
/* 25 */       messages = providerMgr.getMessages();
/*    */     }
/*    */     else {
/* 28 */       MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 29 */       Filter filter = FilterFactory.getSimpleFilter("isSent", Integer.valueOf(3201), "=")
/* 30 */         .addCondition("sendDate", crrentTime, "<=", "AND");
/* 31 */       messages = mesgMgr.getObjects(filter);
/*    */     }
/*    */ 
/* 35 */     for (Message message : messages)
/* 36 */       synchronized (messages) {
/* 37 */         if (message.getSendDate().before(crrentTime)) {
/* 38 */           MessageProvider provider = providerMgr.getProvider(message.getMessageType().toString());
/* 39 */           provider.sendMessage(message);
/*    */         }
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.MessageJobDetail
 * JD-Core Version:    0.6.0
 */