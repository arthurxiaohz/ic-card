/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import org.acegisecurity.Authentication;
/*    */ import org.acegisecurity.ConfigAttribute;
/*    */ import org.acegisecurity.ConfigAttributeDefinition;
/*    */ import org.acegisecurity.vote.AccessDecisionVoter;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.framework.security.context.UserContext;
/*    */ 
/*    */ public class SupperManagerVoter
/*    */   implements AccessDecisionVoter
/*    */ {
/*    */   public boolean supports(ConfigAttribute attribute)
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean supports(Class clazz)
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   public int vote(Authentication authentication, Object object, ConfigAttributeDefinition config)
/*    */   {
/* 40 */     UserContext userContext = null;
/*    */     try {
/* 42 */       userContext = (UserContext)authentication.getDetails();
/*    */     }
/*    */     catch (ClassCastException e) {
/* 45 */       return 0;
/*    */     }
/* 47 */     HiUser user = userContext.getUser();
/* 48 */     if (user.isSupperManager()) {
/* 49 */       return 1;
/*    */     }
/* 51 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.SupperManagerVoter
 * JD-Core Version:    0.6.0
 */