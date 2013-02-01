/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiLogViewAction extends BaseAction
/*    */ {
/*    */   private HiLog hiLog;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/* 14 */     this.hiLog = hiLogMgr.getHiLogById(this.hiLog.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiLog getHiLog() {
/* 19 */     return this.hiLog;
/*    */   }
/*    */ 
/*    */   public void setHiLog(HiLog hiLog) {
/* 23 */     this.hiLog = hiLog;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.HiLogViewAction
 * JD-Core Version:    0.6.0
 */