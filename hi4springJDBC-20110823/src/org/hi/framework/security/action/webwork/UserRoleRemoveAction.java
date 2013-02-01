/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserRoleRemoveAction extends BaseAction
/*    */ {
/*    */   private UserRole userRole;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 14 */     userRoleMgr.removeUserRoleAndAuthorityById(this.userRole.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserRole getUserRole() {
/* 19 */     return this.userRole;
/*    */   }
/*    */ 
/*    */   public void setUserRole(UserRole userRole) {
/* 23 */     this.userRole = userRole;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserRoleRemoveAction
 * JD-Core Version:    0.6.0
 */