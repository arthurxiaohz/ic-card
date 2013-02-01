/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import org.acegisecurity.ConfigAttributeDefinition;
/*    */ import org.acegisecurity.intercept.web.FilterInvocation;
/*    */ import org.acegisecurity.intercept.web.RegExpBasedFilterInvocationDefinitionMap;
/*    */ 
/*    */ public class HiRegExpBasedFilterInvocationDefinitionMap extends RegExpBasedFilterInvocationDefinitionMap
/*    */ {
/*    */   public ConfigAttributeDefinition getAttributes(Object object)
/*    */     throws IllegalArgumentException
/*    */   {
/* 11 */     if ((object == null) || (!supports(object.getClass()))) {
/* 12 */       throw new IllegalArgumentException("Object must be a FilterInvocation");
/*    */     }
/*    */ 
/* 15 */     String url = ((FilterInvocation)object).getRequestUrl();
/* 16 */     if (url.indexOf("?") != -1)
/* 17 */       url = url.substring(0, url.indexOf("?"));
/* 18 */     return lookupAttributes(url);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.HiRegExpBasedFilterInvocationDefinitionMap
 * JD-Core Version:    0.6.0
 */