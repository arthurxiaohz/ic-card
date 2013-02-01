/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class RoleRemoveAction extends BaseAction
/*    */ {
/*    */   private Role role;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 18 */     if ((UserContextHelper.getUser().getUserMgrType() == null) || 
/* 19 */       (UserContextHelper.getUser().getUserMgrType().intValue() == 1402)) {
/* 20 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能删除建角色", "Role"));
/*    */     }
/* 22 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 23 */     this.role = roleMgr.getRoleById(this.role.getId());
/* 24 */     HiUser currentUsre = UserContextHelper.getUser();
/*    */ 
/* 26 */     if ((currentUsre.getUserMgrType().intValue() == 1401) && ((this.role.getCreator() == null) || 
/* 27 */       (!this.role.getCreator().equals(currentUsre)))) {
/* 28 */       throw new BusinessException(I18NUtil.getString("您的用户类型为管理员,只能删除您自己所创建的角色", "Role"));
/*    */     }
/* 30 */     roleMgr.removeRoleUserAuthority(this.role.getId());
/* 31 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Role getRole() {
/* 35 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role) {
/* 39 */     this.role = role;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleRemoveAction
 * JD-Core Version:    0.6.0
 */