/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.hi.base.sysapp.service.HiLogManager;
/*    */ 
/*    */ public class LogDataBaseProcessor
/*    */   implements LogSaveProcessor
/*    */ {
/*    */   public void saveLog(List<HiLog> logs)
/*    */   {
/* 13 */     SaveLog logThread = new SaveLog(logs);
/* 14 */     logThread.start();
/*    */   }
/*    */   private class SaveLog extends Thread {
/*    */     List<HiLog> logs;
/*    */ 
/* 20 */     SaveLog() { this.logs = new LinkedList();
/* 21 */       for (HiLog hiLog : logs)
/* 22 */         this.logs.add(hiLog);
/*    */     }
/*    */ 
/*    */     public void run()
/*    */     {
/* 27 */       HiLogManager logMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
/* 28 */       for (HiLog log : this.logs)
/* 29 */         logMgr.saveHiLog(log);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogDataBaseProcessor
 * JD-Core Version:    0.6.0
 */