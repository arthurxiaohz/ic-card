/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.acegisecurity.AccessDeniedException;
/*    */ import org.acegisecurity.Authentication;
/*    */ import org.acegisecurity.ConfigAttributeDefinition;
/*    */ import org.acegisecurity.vote.AbstractAccessDecisionManager;
/*    */ import org.acegisecurity.vote.AccessDecisionVoter;
/*    */ import org.aopalliance.intercept.MethodInvocation;
/*    */ 
/*    */ public class AffirmativeBased extends AbstractAccessDecisionManager
/*    */ {
/* 34 */   private boolean managerSecurity = false;
/*    */ 
/*    */   public void setManagerSecurity(boolean managerSecurity)
/*    */   {
/* 40 */     this.managerSecurity = managerSecurity;
/*    */   }
/*    */ 
/*    */   public void decide(Authentication authentication, Object object, ConfigAttributeDefinition config)
/*    */     throws AccessDeniedException
/*    */   {
/* 58 */     if (((object instanceof MethodInvocation)) && (!this.managerSecurity)) {
/* 59 */       return;
/*    */     }
/* 61 */     Iterator iter = getDecisionVoters().iterator();
/* 62 */     int deny = 0;
/*    */ 
/* 64 */     while (iter.hasNext()) {
/* 65 */       AccessDecisionVoter voter = (AccessDecisionVoter)iter.next();
/* 66 */       int result = voter.vote(authentication, object, config);
/*    */ 
/* 68 */       switch (result) {
/*    */       case 1:
/* 70 */         return;
/*    */       case -1:
/* 73 */         deny++;
/*    */       case 0:
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 82 */     if (deny > 0) {
/* 83 */       throw new AccessDeniedException("您没有操作此功能的权限!");
/*    */     }
/*    */ 
/* 87 */     checkAllowIfAllAbstainDecisions();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.AffirmativeBased
 * JD-Core Version:    0.6.0
 */