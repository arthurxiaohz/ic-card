/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import com.vladium.utils.IObjectProfileNode;
/*    */ import com.vladium.utils.ObjectProfiler;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ 
/*    */ public class LogSizeCacheProcessor extends AbstractLogCacheProcessor
/*    */ {
/*    */   private int size;
/*    */ 
/*    */   public synchronized void addHiLog(HiLog log)
/*    */   {
/* 12 */     addHiLogToCache(log);
/* 13 */     IObjectProfileNode profile = ObjectProfiler.profile(this.logCache);
/* 14 */     int cacheSize = profile.size();
/* 15 */     if (cacheSize < getSize() * 1024) return;
/* 16 */     LogSaveProcessor saveProcessor = getInterceptor().getSaveProcessor();
/* 17 */     saveProcessor.saveLog(getHiLogs());
/*    */   }
/*    */ 
/*    */   public int getSize() {
/* 21 */     return this.size;
/*    */   }
/*    */ 
/*    */   public void setSize(int size) {
/* 25 */     this.size = size;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogSizeCacheProcessor
 * JD-Core Version:    0.6.0
 */