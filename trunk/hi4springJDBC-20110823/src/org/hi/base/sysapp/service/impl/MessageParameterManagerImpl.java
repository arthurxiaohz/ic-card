/*    */ package org.hi.base.sysapp.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.MessageParameter;
/*    */ import org.hi.base.sysapp.service.MessageParameterManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class MessageParameterManagerImpl extends ManagerImpl
/*    */   implements MessageParameterManager
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
/*    */   public void saveMessageParameter(MessageParameter messageParameter)
/*    */   {
/* 34 */     saveObject(messageParameter);
/*    */   }
/*    */ 
/*    */   public void removeMessageParameterById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public MessageParameter getMessageParameterById(Integer id)
/*    */   {
/* 44 */     return (MessageParameter)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<MessageParameter> getMessageParameterList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityMessageParameter(MessageParameter messageParameter) {
/* 52 */     saveObject(messageParameter);
/*    */   }
/*    */   public void removeSecurityMessageParameterById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public MessageParameter getSecurityMessageParameterById(Integer id) {
/* 58 */     return (MessageParameter)getObjectById(id);
/*    */   }
/*    */   public List<MessageParameter> getSecurityMessageParameterList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.service.impl.MessageParameterManagerImpl
 * JD-Core Version:    0.6.0
 */