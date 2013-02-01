/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserAuthoritySaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private UserAuthority userAuthority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.userAuthority) != null) return returnCommand();
/* 14 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 15 */     userAuthorityMgr.saveUserAuthority(this.userAuthority);
/* 16 */     super.postExecute(this.userAuthority);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserAuthority getUserAuthority() {
/* 21 */     return this.userAuthority;
/*    */   }
/*    */ 
/*    */   public void setUserAuthority(UserAuthority userAuthority) {
/* 25 */     this.userAuthority = userAuthority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthoritySaveAction
 * JD-Core Version:    0.6.0
 */