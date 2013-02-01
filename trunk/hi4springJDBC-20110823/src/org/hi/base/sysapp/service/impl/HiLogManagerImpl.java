/*    */ package org.hi.base.sysapp.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class HiLogManagerImpl extends ManagerImpl
/*    */   implements HiLogManager
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
/*    */   public void saveHiLog(HiLog hiLog)
/*    */   {
/* 33 */     saveObject(hiLog);
/*    */   }
/*    */ 
/*    */   public void removeHiLogById(Integer id)
/*    */   {
/* 38 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public HiLog getHiLogById(Integer id)
/*    */   {
/* 43 */     return (HiLog)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<HiLog> getHiLogList(PageInfo pageInfo) {
/* 47 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityHiLog(HiLog hiLog) {
/* 51 */     saveObject(hiLog);
/*    */   }
/*    */ 
/*    */   public void removeSecurityHiLogById(Integer id)
/*    */   {
/* 56 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public HiLog getSecurityHiLogById(Integer id)
/*    */   {
/* 61 */     return (HiLog)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<HiLog> getSecurityHiLogList(PageInfo pageInfo) {
/* 65 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.service.impl.HiLogManagerImpl
 * JD-Core Version:    0.6.0
 */