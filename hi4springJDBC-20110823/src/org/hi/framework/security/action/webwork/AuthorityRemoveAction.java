/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AuthorityRemoveAction extends BaseAction
/*    */ {
/*    */   private Authority authority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 14 */     authorityMgr.removeAuthorityById(this.authority.getId());
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.AuthorityRemoveAction
 * JD-Core Version:    0.6.0
 */