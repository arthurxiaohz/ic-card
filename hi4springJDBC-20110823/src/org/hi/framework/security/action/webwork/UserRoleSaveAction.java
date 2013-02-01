/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserRoleSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private UserRole userRole;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.userRole) != null) return returnCommand();
/* 14 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 15 */     userRoleMgr.saveUserRole(this.userRole);
/* 16 */     super.postExecute(this.userRole);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserRole getUserRole() {
/* 21 */     return this.userRole;
/*    */   }
/*    */ 
/*    */   public void setUserRole(UserRole userRole) {
/* 25 */     this.userRole = userRole;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserRoleSaveAction
 * JD-Core Version:    0.6.0
 */