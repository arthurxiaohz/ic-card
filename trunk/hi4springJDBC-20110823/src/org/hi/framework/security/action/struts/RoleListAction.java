/*    */ package org.hi.framework.security.action.struts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.RolePageInfo;
/*    */ import org.hi.framework.security.action.UserRolePageInfo;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class RoleListAction extends BaseAction
/*    */ {
/*    */   private Role role;
/*    */   private UserRolePageInfo pageInfo;
/*    */   private List<Role> roles;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 24 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 25 */     this.pageInfo = (this.pageInfo == null ? new UserRolePageInfo() : this.pageInfo);
/*    */ 
/* 28 */     if ((this.pageInfo.getSecurityUser() == null) || (this.pageInfo.getSecurityUser().getF_fullName() == null) || (this.pageInfo.getSecurityUser().getF_fullName().equals(""))) {
/* 29 */       RolePageInfo rolePageInfo = this.pageInfo.getRole() == null ? new RolePageInfo() : this.pageInfo.getRole();
/* 30 */       rolePageInfo.setCurrentPage(this.pageInfo.getCurrentPage());
/* 31 */       rolePageInfo.setPageSize(this.pageInfo.getPageSize());
/* 32 */       rolePageInfo.setMaxRecords(this.pageInfo.getMaxRecords());
/* 33 */       if ((this.pageInfo.getSorterName() != null) && (!this.pageInfo.getSorterName().trim().equals(""))) {
/* 34 */         String sortName = this.pageInfo.getSorterName();
/* 35 */         rolePageInfo.setSorterName(sortName.substring(sortName.indexOf(".") + 1));
/*    */       }
/* 37 */       rolePageInfo.setSorterDirection(this.pageInfo.getSorterDirection());
/* 38 */       PageInfo sarchPageInfo = PageInfoUtil.populate(rolePageInfo);
/*    */ 
/* 43 */       this.roles = roleMgr.getSecurityRoleList(sarchPageInfo);
/*    */ 
/* 45 */       this.pageInfo.setStartRowPosition(rolePageInfo.getStartRowPosition());
/* 46 */       this.pageInfo.setEndRowPosition(rolePageInfo.getEndRowPosition());
/* 47 */       this.pageInfo.setIsFristPage(rolePageInfo.getIsFristPage());
/* 48 */       this.pageInfo.setIsLastPage(rolePageInfo.getIsLastPage());
/* 49 */       this.pageInfo.setTotalPage(rolePageInfo.getTotalPage());
/* 50 */       this.pageInfo.setTotalRecords(rolePageInfo.getTotalRecords());
/*    */     }
/*    */     else {
/* 53 */       UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 54 */       PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo);
/* 55 */       List userRoles = userRoleMgr.getUserRoleList(sarchPageInfo);
/* 56 */       this.roles = new ArrayList();
/* 57 */       for (UserRole userRole : userRoles) {
/* 58 */         this.roles.add(userRole.getRole());
/*    */       }
/*    */     }
/*    */ 
/* 62 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Role getRole() {
/* 66 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role) {
/* 70 */     this.role = role;
/*    */   }
/*    */ 
/*    */   public List<Role> getRoles() {
/* 74 */     return this.roles;
/*    */   }
/*    */ 
/*    */   public void setRoles(List<Role> roles) {
/* 78 */     this.roles = roles;
/*    */   }
/*    */ 
/*    */   public UserRolePageInfo getPageInfo() {
/* 82 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(UserRolePageInfo pageInfo) {
/* 86 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.RoleListAction
 * JD-Core Version:    0.6.0
 */