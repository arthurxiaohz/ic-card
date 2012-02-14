/*    */ package org.hi.studio.core.log;
/*    */ 
/*    */ public class ExceptionManager
/*    */ {
/*    */   public static void logError(Exception exception, String message)
/*    */   {
/*  9 */     LogMessage.logError(message, exception);
/*    */   }
/*    */ 
/*    */   public static void logError(Exception exception, String message, Object[] objects) {
/* 13 */     LogMessage.logError(message, exception);
/*    */   }
/*    */ 
/*    */   public static void logError(String message) {
/* 17 */     LogMessage.logError(message, null);
/*    */   }
/*    */ 
/*    */   public static void info(String inforString) {
/* 21 */     LogMessage.logError(inforString, null);
/*    */   }
/*    */ 
/*    */   public static void logWarning(Exception exception, String message) {
/* 25 */     LogMessage.logError(message, exception);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.log.ExceptionManager
 * JD-Core Version:    0.6.0
 */