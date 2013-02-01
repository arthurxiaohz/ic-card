/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserAuthorityRemoveAction extends BaseAction
/*    */ {
/*    */   private UserAuthority userAuthority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 14 */     userAuthorityMgr.removeUserAuthorityById(this.userAuthority.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserAuthority getUserAuthority() {
/* 19 */     return this.userAuthority;
/*    */   }
/*    */ 
/*    */   public void setUserAuthority(UserAuthority userAuthority) {
/* 23 */     this.userAuthority = userAuthority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthorityRemoveAction
 * JD-Core Version:    0.6.0
 */