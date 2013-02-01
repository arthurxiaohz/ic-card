/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.UserRolePageInfo;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserRoleListAction extends BaseAction
/*    */ {
/*    */   private UserRole userRole;
/*    */   private UserRolePageInfo pageInfo;
/*    */   private List<UserRole> userRoles;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new UserRolePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.userRoles = userRoleMgr.getUserRoleList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserRole getUserRole() {
/* 30 */     return this.userRole;
/*    */   }
/*    */ 
/*    */   public void setUserRole(UserRole userRole) {
/* 34 */     this.userRole = userRole;
/*    */   }
/*    */ 
/*    */   public List<UserRole> getUserRoles() {
/* 38 */     return this.userRoles;
/*    */   }
/*    */ 
/*    */   public void setUserRoles(List<UserRole> userRoles) {
/* 42 */     this.userRoles = userRoles;
/*    */   }
/*    */ 
/*    */   public UserRolePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(UserRolePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserRoleListAction
 * JD-Core Version:    0.6.0
 */