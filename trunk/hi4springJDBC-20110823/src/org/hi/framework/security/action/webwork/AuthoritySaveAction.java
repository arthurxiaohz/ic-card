/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class AuthoritySaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Authority authority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.authority) != null) return returnCommand();
/* 14 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 15 */     authorityMgr.saveAuthority(this.authority);
/* 16 */     super.postExecute(this.authority);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Authority getAuthority() {
/* 21 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(Authority authority) {
/* 25 */     this.authority = authority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.AuthoritySaveAction
 * JD-Core Version:    0.6.0
 */