/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ import org.springframework.beans.factory.InitializingBean;
/*    */ 
/*    */ public class LogTimerCacheProcessor extends AbstractLogCacheProcessor
/*    */   implements InitializingBean
/*    */ {
/*    */   private int period;
/* 13 */   Timer timer = new Timer();
/*    */ 
/* 15 */   public void addHiLog(HiLog log) { addHiLogToCache(log); }
/*    */ 
/*    */   public void afterPropertiesSet()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.period == 0)
/* 21 */       this.period = 10;
/* 22 */     this.timer.scheduleAtFixedRate(new SaveTimerTask(), 20000L, this.period * 1000 * 60);
/*    */   }
/*    */ 
/*    */   public int getPeriod() {
/* 26 */     return this.period;
/*    */   }
/*    */ 
/*    */   public void setPeriod(int period) {
/* 30 */     this.period = period;
/*    */   }
/*    */   class SaveTimerTask extends TimerTask {
/*    */     SaveTimerTask() {
/*    */     }
/*    */     public void run() {
/* 36 */       if (LogTimerCacheProcessor.this.getHiLogs().size() == 0) return;
/* 37 */       LogSaveProcessor saveProcessor = LogTimerCacheProcessor.this.getInterceptor().getSaveProcessor();
/* 38 */       saveProcessor.saveLog(LogTimerCacheProcessor.this.getHiLogs());
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogTimerCacheProcessor
 * JD-Core Version:    0.6.0
 */