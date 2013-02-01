/*    */ package org.hi.framework.spring;
/*    */ 
/*    */ public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener
/*    */ {
/*    */   protected ContextLoader createContextLoader()
/*    */   {
/* 14 */     return new ContextLoader();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.spring.ContextLoaderListener
 * JD-Core Version:    0.6.0
 */