/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ 
/*    */ public class LogLengthCacheProcessor extends AbstractLogCacheProcessor
/*    */ {
/*    */   private int length;
/*    */ 
/*    */   public synchronized void addHiLog(HiLog log)
/*    */   {
/* 12 */     addHiLogToCache(log);
/*    */ 
/* 14 */     if (this.logCache.size() < this.length) return;
/* 15 */     LogSaveProcessor saveProcessor = getInterceptor().getSaveProcessor();
/* 16 */     saveProcessor.saveLog(getHiLogs());
/*    */   }
/*    */ 
/*    */   public int getLength()
/*    */   {
/* 21 */     return this.length;
/*    */   }
/*    */ 
/*    */   public void setLength(int length) {
/* 25 */     this.length = length;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogLengthCacheProcessor
 * JD-Core Version:    0.6.0
 */