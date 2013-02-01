/*    */ package org.hi.i18n.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.hi.i18n.model.Timezone;
/*    */ import org.hi.i18n.service.TimezoneManager;
/*    */ 
/*    */ public class TimezoneManagerImpl extends ManagerImpl
/*    */   implements TimezoneManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 13 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 18 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 23 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 28 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveTimezone(Timezone timezone)
/*    */   {
/* 33 */     saveObject(timezone);
/*    */   }
/*    */ 
/*    */   public void removeTimezoneById(Integer id)
/*    */   {
/* 38 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public Timezone getTimezoneById(Integer id)
/*    */   {
/* 43 */     return (Timezone)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<Timezone> getTimezoneList(PageInfo pageInfo) {
/* 47 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityTimezone(Timezone timezone) {
/* 51 */     saveObject(timezone);
/*    */   }
/*    */ 
/*    */   public void removeSecurityTimezoneById(Integer id)
/*    */   {
/* 56 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public Timezone getSecurityTimezoneById(Integer id)
/*    */   {
/* 61 */     return (Timezone)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<Timezone> getSecurityTimezoneList(PageInfo pageInfo) {
/* 65 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.service.impl.TimezoneManagerImpl
 * JD-Core Version:    0.6.0
 */