/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiLogSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private HiLog hiLog;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/* 14 */     if (super.perExecute(this.hiLog) != null) return returnCommand();
/* 15 */     hiLogMgr.saveHiLog(this.hiLog);
/* 16 */     super.postExecute(this.hiLog);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiLog getHiLog() {
/* 21 */     return this.hiLog;
/*    */   }
/*    */ 
/*    */   public void setHiLog(HiLog hiLog) {
/* 25 */     this.hiLog = hiLog;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.HiLogSaveAction
 * JD-Core Version:    0.6.0
 */