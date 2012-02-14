/*    */ package org.hi.studio.core.log;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.eclipse.core.internal.runtime.InternalPlatform;
/*    */ import org.eclipse.core.runtime.IStatus;
/*    */ import org.eclipse.core.runtime.Status;
/*    */ 
/*    */ public class LogMessage
/*    */ {
/*    */   public static void logError(String messge, Exception e)
/*    */   {
/* 11 */     IStatus status = new Status(4, "org.eclipse.core.runtime", 4, messge, e);
/* 12 */     InternalPlatform.getDefault().log(status);
/*    */ 
/* 14 */     System.out.println("messge" + messge);
/* 15 */     if (e != null)
/* 16 */       e.printStackTrace();
/*    */   }
/*    */ 
/*    */   public static void logInfo(String messge) {
/* 20 */     IStatus status = new Status(1, "org.eclipse.core.runtime", messge);
/* 21 */     InternalPlatform.getDefault().log(status);
/* 22 */     System.out.println("logInfo:  " + messge);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.log.LogMessage
 * JD-Core Version:    0.6.0
 */