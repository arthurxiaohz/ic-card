/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import org.acegisecurity.ConfigAttributeDefinition;
/*    */ import org.acegisecurity.event.authorization.PublicInvocationEvent;
/*    */ import org.acegisecurity.intercept.ObjectDefinitionSource;
/*    */ import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
/*    */ import org.acegisecurity.intercept.web.FilterInvocation;
/*    */ import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
/*    */ import org.aopalliance.intercept.MethodInvocation;
/*    */ import org.springframework.context.ApplicationEvent;
/*    */ import org.springframework.context.ApplicationListener;
/*    */ 
/*    */ public class NotAttributeListener
/*    */   implements ApplicationListener
/*    */ {
/*    */   private FilterSecurityInterceptor filterSecurityInterceptor;
/*    */   private MethodSecurityInterceptor methodSecurityInterceptor;
/*    */ 
/*    */   public FilterSecurityInterceptor getFilterSecurityInterceptor()
/*    */   {
/* 17 */     return this.filterSecurityInterceptor;
/*    */   }
/*    */ 
/*    */   public void setFilterSecurityInterceptor(FilterSecurityInterceptor filterSecurityInterceptor)
/*    */   {
/* 23 */     this.filterSecurityInterceptor = filterSecurityInterceptor;
/*    */   }
/*    */ 
/*    */   public MethodSecurityInterceptor getMethodSecurityInterceptor()
/*    */   {
/* 29 */     return this.methodSecurityInterceptor;
/*    */   }
/*    */ 
/*    */   public void setMethodSecurityInterceptor(MethodSecurityInterceptor methodSecurityInterceptor)
/*    */   {
/* 36 */     this.methodSecurityInterceptor = methodSecurityInterceptor;
/*    */   }
/*    */ 
/*    */   public void onApplicationEvent(ApplicationEvent event)
/*    */   {
/* 41 */     if (!(event instanceof PublicInvocationEvent)) {
/* 42 */       return;
/*    */     }
/* 44 */     Object object = event.getSource();
/* 45 */     if (object == null) {
/* 46 */       return;
/*    */     }
/* 48 */     ConfigAttributeDefinition attr = null;
/* 49 */     if ((object instanceof FilterInvocation))
/* 50 */       attr = this.filterSecurityInterceptor.obtainObjectDefinitionSource().getAttributes(object);
/* 51 */     if ((object instanceof MethodInvocation)) {
/* 52 */       attr = this.methodSecurityInterceptor.obtainObjectDefinitionSource().getAttributes(object);
/*    */     }
/* 54 */     if (attr == null)
/* 55 */       MethodConfigAttributeDefHolder.setConfigAttributeDefinition(null);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.NotAttributeListener
 * JD-Core Version:    0.6.0
 */