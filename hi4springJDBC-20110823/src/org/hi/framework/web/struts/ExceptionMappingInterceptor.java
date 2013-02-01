/*    */ package org.hi.framework.web.struts;
/*    */ 
/*    */ import com.opensymphony.xwork2.ActionInvocation;
/*    */ import com.opensymphony.xwork2.ActionProxy;
/*    */ import com.opensymphony.xwork2.config.entities.ActionConfig;
/*    */ import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
/*    */ import com.opensymphony.xwork2.interceptor.ExceptionHolder;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ExceptionMappingInterceptor extends com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor
/*    */ {
/*    */   public String intercept(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 18 */       result = invocation.invoke();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */       String result;
/* 20 */       if (this.logEnabled) {
/* 21 */         handleLogging(e);
/*    */       }
/* 23 */       BaseAction action = (BaseAction)invocation.getAction();
/* 24 */       action.setStatusCode(300);
/* 25 */       action.setTipsMessage(e.getMessage());
/*    */ 
/* 27 */       List exceptionMappings = invocation.getProxy().getConfig().getExceptionMappings();
/* 28 */       String mappedResult = findResultFromExceptions(exceptionMappings, e);
/* 29 */       if (mappedResult != null) {
/* 30 */         String result = mappedResult;
/* 31 */         publishException(invocation, new ExceptionHolder(e));
/*    */       } else {
/* 33 */         throw e;
/*    */       }
/*    */     }
/*    */     String result;
/* 37 */     return result;
/*    */   }
/*    */ 
/*    */   protected String findResultFromExceptions(List exceptionMappings, Throwable t) {
/* 41 */     String result = null;
/*    */ 
/* 44 */     if (exceptionMappings != null) {
/* 45 */       int deepest = 2147483647;
/* 46 */       for (Iterator iter = exceptionMappings.iterator(); iter.hasNext(); ) {
/* 47 */         ExceptionMappingConfig exceptionMappingConfig = (ExceptionMappingConfig)iter.next();
/* 48 */         int depth = getDepth(exceptionMappingConfig.getExceptionClassName(), t);
/* 49 */         if ((depth >= 0) && (depth < deepest)) {
/* 50 */           deepest = depth;
/* 51 */           result = exceptionMappingConfig.getResult();
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 56 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.struts.ExceptionMappingInterceptor
 * JD-Core Version:    0.6.0
 */