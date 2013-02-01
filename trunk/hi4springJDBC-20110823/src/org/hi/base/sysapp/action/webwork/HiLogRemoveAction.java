/*    */ package org.hi.base.sysapp.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiLogRemoveAction extends BaseAction
/*    */ {
/*    */   private HiLog hiLog;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/* 14 */     hiLogMgr.removeHiLogById(this.hiLog.getId());
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.action.webwork.HiLogRemoveAction
 * JD-Core Version:    0.6.0
 */