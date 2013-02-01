/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AuthorityViewAction extends BaseAction
/*    */ {
/*    */   private Authority authority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 14 */     this.authority = authorityMgr.getAuthorityById(this.authority.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Authority getAuthority() {
/* 19 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(Authority authority) {
/* 23 */     this.authority = authority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.AuthorityViewAction
 * JD-Core Version:    0.6.0
 */