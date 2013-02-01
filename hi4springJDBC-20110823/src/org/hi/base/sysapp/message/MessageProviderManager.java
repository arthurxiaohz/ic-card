/*    */ package org.hi.base.sysapp.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ 
/*    */ public class MessageProviderManager
/*    */ {
/*    */   public static final String SPRING_BEAN_ID = "org.hi.message.MessageProviderManager";
/*    */   protected Map<String, MessageProvider> providers;
/*    */   protected boolean cache;
/* 21 */   private static List<Message> messages = Collections.synchronizedList(new ArrayList());
/*    */ 
/*    */   public boolean isCache() {
/* 24 */     return this.cache;
/*    */   }
/*    */ 
/*    */   public void setCache(boolean cache)
/*    */   {
/* 29 */     this.cache = cache;
/*    */ 
/* 31 */     MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
/* 32 */     Filter filter = FilterFactory.getSimpleFilter("isSent", Integer.valueOf(3201), "=");
/* 33 */     messages = Collections.synchronizedList(mesgMgr.getObjects(filter));
/*    */   }
/*    */ 
/*    */   public Map<String, MessageProvider> getProviders()
/*    */   {
/* 38 */     return this.providers;
/*    */   }
/*    */ 
/*    */   public void setProviders(Map<String, MessageProvider> providers)
/*    */   {
/* 43 */     this.providers = providers;
/*    */   }
/*    */ 
/*    */   public MessageProvider getProvider(String providerType)
/*    */   {
/* 48 */     return (MessageProvider)this.providers.get(providerType);
/*    */   }
/*    */ 
/*    */   public synchronized void addMessage(Message message) {
/* 52 */     messages.add(message);
/*    */   }
/*    */ 
/*    */   public synchronized void removeMessage(Message message) {
/* 56 */     messages.remove(message);
/*    */   }
/*    */ 
/*    */   public synchronized List<Message> getMessages() {
/* 60 */     return messages;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.MessageProviderManager
 * JD-Core Version:    0.6.0
 */