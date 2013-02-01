/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.RoleAuthorityManager;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class RoleAssignViewAction extends BaseAction
/*    */ {
/*    */   private Role role;
/*    */   private List<RoleAuthority> roleAuthorities;
/*    */   private List<UserRole> userRoles;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 26 */     if ((UserContextHelper.getUser().getUserMgrType() == null) || 
/* 27 */       (UserContextHelper.getUser().getUserMgrType().intValue() == 1402)) {
/* 28 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能分派角色", "Role"));
/*    */     }
/* 30 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 31 */     RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 32 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*    */ 
/* 34 */     this.role = roleMgr.getRoleById(this.role.getId());
/*    */ 
/* 36 */     if ((UserContextHelper.getUser().getUserMgrType().intValue() == 1401) && ((this.role.getCreator() == null) || 
/* 37 */       (!this.role.getCreator().equals(UserContextHelper.getUser())))) {
/* 38 */       throw new BusinessException(I18NUtil.getString("您的用户类型是管理员,必须是您自己创建的角色才可以为该角色分派用户角色", "Role"));
/*    */     }
/*    */ 
/* 41 */     Filter filter = FilterFactory.getSimpleFilter("role.id", this.role.getId(), "=");
/* 42 */     this.roleAuthorities = roleAuthMgr.getObjects(filter);
/*    */ 
/* 44 */     this.userRoles = userRoleMgr.getObjects(filter);
/*    */ 
/* 46 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Role getRole() {
/* 50 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role) {
/* 54 */     this.role = role;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> getRoleAuthorities() {
/* 58 */     return this.roleAuthorities;
/*    */   }
/*    */ 
/*    */   public List<UserRole> getUserRoles() {
/* 62 */     return this.userRoles;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleAssignViewAction
 * JD-Core Version:    0.6.0
 */