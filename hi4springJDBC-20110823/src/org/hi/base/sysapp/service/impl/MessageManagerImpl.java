/*    */ package org.hi.base.sysapp.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.Message;
/*    */ import org.hi.base.sysapp.service.MessageManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class MessageManagerImpl extends ManagerImpl
/*    */   implements MessageManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 14 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 19 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 24 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 29 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveMessage(Message message)
/*    */   {
/* 34 */     saveObject(message);
/*    */   }
/*    */ 
/*    */   public void removeMessageById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public Message getMessageById(Integer id)
/*    */   {
/* 44 */     return (Message)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<Message> getMessageList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityMessage(Message message) {
/* 52 */     saveObject(message);
/*    */   }
/*    */   public void removeSecurityMessageById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public Message getSecurityMessageById(Integer id) {
/* 58 */     return (Message)getObjectById(id);
/*    */   }
/*    */   public List<Message> getSecurityMessageList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.service.impl.MessageManagerImpl
 * JD-Core Version:    0.6.0
 */