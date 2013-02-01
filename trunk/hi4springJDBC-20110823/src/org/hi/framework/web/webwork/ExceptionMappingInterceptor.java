/*    */ package org.hi.framework.web.webwork;
/*    */ 
/*    */ import com.opensymphony.xwork.ActionInvocation;
/*    */ import com.opensymphony.xwork.ActionProxy;
/*    */ import com.opensymphony.xwork.config.entities.ActionConfig;
/*    */ import com.opensymphony.xwork.config.entities.ExceptionMappingConfig;
/*    */ import com.opensymphony.xwork.interceptor.ExceptionHolder;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ExceptionMappingInterceptor extends com.opensymphony.xwork.interceptor.ExceptionMappingInterceptor
/*    */ {
/*    */   public String intercept(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 17 */       result = invocation.invoke();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */       String result;
/* 19 */       if (this.logEnabled) {
/* 20 */         handleLogging(e);
/*    */       }
/* 22 */       BaseAction action = (BaseAction)invocation.getAction();
/* 23 */       action.setStatusCode(300);
/* 24 */       action.setTipsMessage(e.getMessage());
/*    */ 
/* 26 */       List exceptionMappings = invocation.getProxy().getConfig().getExceptionMappings();
/* 27 */       String mappedResult = findResultFromExceptions(exceptionMappings, e);
/* 28 */       if (mappedResult != null) {
/* 29 */         String result = mappedResult;
/* 30 */         publishException(invocation, new ExceptionHolder(e));
/*    */       } else {
/* 32 */         throw e;
/*    */       }
/*    */     }
/*    */     String result;
/* 36 */     return result;
/*    */   }
/*    */ 
/*    */   protected String findResultFromExceptions(List exceptionMappings, Throwable t) {
/* 40 */     String result = null;
/*    */ 
/* 43 */     if (exceptionMappings != null) {
/* 44 */       int deepest = 2147483647;
/* 45 */       for (Iterator iter = exceptionMappings.iterator(); iter.hasNext(); ) {
/* 46 */         ExceptionMappingConfig exceptionMappingConfig = (ExceptionMappingConfig)iter.next();
/* 47 */         int depth = getDepth(exceptionMappingConfig.getExceptionClassName(), t);
/* 48 */         if ((depth >= 0) && (depth < deepest)) {
/* 49 */           deepest = depth;
/* 50 */           result = exceptionMappingConfig.getResult();
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 55 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.webwork.ExceptionMappingInterceptor
 * JD-Core Version:    0.6.0
 */