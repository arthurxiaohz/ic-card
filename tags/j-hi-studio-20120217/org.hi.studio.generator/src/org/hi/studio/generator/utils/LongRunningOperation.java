/*    */ package org.hi.studio.generator.utils;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import org.eclipse.core.runtime.IProgressMonitor;
/*    */ import org.eclipse.jface.operation.IRunnableWithProgress;
/*    */ 
/*    */ public class LongRunningOperation
/*    */   implements IRunnableWithProgress
/*    */ {
/*    */   private static final int TOTAL_TIME = 10000;
/*    */   private static final int INCREMENT = 500;
/*    */   private boolean indeterminate;
/*    */ 
/*    */   public LongRunningOperation(boolean indeterminate)
/*    */   {
/* 24 */     this.indeterminate = indeterminate;
/*    */   }
/*    */ 
/*    */   public void run(IProgressMonitor monitor)
/*    */     throws InvocationTargetException, InterruptedException
/*    */   {
/* 38 */     monitor.beginTask("Running long running operation", 
/* 39 */       this.indeterminate ? -1 : 10000);
/* 40 */     for (int total = 0; (total < 10000) && (!monitor.isCanceled()); total += 500) {
/* 41 */       Thread.sleep(500L);
/* 42 */       monitor.worked(500);
/*    */ 
/* 44 */       if (total == 5000) {
/* 45 */         monitor.subTask("Doing second half");
/*    */       }
/*    */     }
/* 48 */     monitor.done();
/* 49 */     if (monitor.isCanceled())
/* 50 */       throw new InterruptedException(
/* 51 */         "The long running operation was cancelled");
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.utils.LongRunningOperation
 * JD-Core Version:    0.6.0
 */