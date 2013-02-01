/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ 
/*    */ public class UserAuthorityForm
/*    */ {
/*    */   protected Authority authority;
/*    */   protected HiOrg org;
/*    */   protected Integer scope;
/*    */ 
/*    */   public Authority getAuthority()
/*    */   {
/* 12 */     return this.authority;
/*    */   }
/*    */   public void setAuthority(Authority authority) {
/* 15 */     this.authority = authority;
/*    */   }
/*    */   public HiOrg getOrg() {
/* 18 */     return this.org;
/*    */   }
/*    */   public void setOrg(HiOrg org) {
/* 21 */     this.org = org;
/*    */   }
/*    */   public Integer getScope() {
/* 24 */     return this.scope;
/*    */   }
/*    */   public void setScope(Integer scope) {
/* 27 */     this.scope = scope;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.UserAuthorityForm
 * JD-Core Version:    0.6.0
 */