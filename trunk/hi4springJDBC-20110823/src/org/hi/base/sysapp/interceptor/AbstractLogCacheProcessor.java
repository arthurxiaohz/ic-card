/*    */ package org.hi.base.sysapp.interceptor;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.HiLog;
/*    */ 
/*    */ public abstract class AbstractLogCacheProcessor
/*    */   implements LogCacheProcessor
/*    */ {
/*    */   MethodLogInterceptor interceptor;
/* 11 */   protected List<HiLog> logCache = Collections.synchronizedList(new LinkedList());
/*    */ 
/*    */   public final synchronized List<HiLog> getHiLogs() {
/* 14 */     List result = new LinkedList();
/* 15 */     synchronized (this.logCache) {
/* 16 */       for (HiLog hiLog : this.logCache) {
/* 17 */         result.add(hiLog);
/*    */       }
/* 19 */       this.logCache.clear();
/*    */     }
/*    */ 
/* 22 */     return result;
/*    */   }
/*    */ 
/*    */   public final synchronized void addHiLogToCache(HiLog log) {
/* 26 */     this.logCache.add(log);
/*    */   }
/*    */ 
/*    */   public MethodLogInterceptor getInterceptor() {
/* 30 */     return this.interceptor;
/*    */   }
/*    */ 
/*    */   public void setInterceptor(MethodLogInterceptor interceptor) {
/* 34 */     this.interceptor = interceptor;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.AbstractLogCacheProcessor
 * JD-Core Version:    0.6.0
 */