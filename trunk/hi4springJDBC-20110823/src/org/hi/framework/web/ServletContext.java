/*    */ package org.hi.framework.web;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.hi.SpringContextHolder;
/*    */ 
/*    */ public class ServletContext
/*    */ {
/* 11 */   private static ThreadLocal<HttpServletRequest> requestContext = new ThreadLocal();
/* 12 */   private static ThreadLocal<HttpServletResponse> responseContext = new ThreadLocal();
/*    */ 
/*    */   public static HttpServletRequest getRequest() {
/* 15 */     return (HttpServletRequest)requestContext.get();
/*    */   }
/*    */ 
/*    */   public static void setRequest(HttpServletRequest request) {
/* 19 */     requestContext.set(request);
/*    */   }
/*    */ 
/*    */   public static HttpServletResponse getResponse() {
/* 23 */     return (HttpServletResponse)responseContext.get();
/*    */   }
/*    */ 
/*    */   public static void setResponse(HttpServletResponse response) {
/* 27 */     responseContext.set(response);
/*    */   }
/*    */ 
/*    */   public static javax.servlet.ServletContext getServletContext() {
/* 31 */     return SpringContextHolder.getServletContext();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.ServletContext
 * JD-Core Version:    0.6.0
 */