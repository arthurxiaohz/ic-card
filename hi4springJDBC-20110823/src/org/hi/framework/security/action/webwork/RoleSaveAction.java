/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class RoleSaveAction extends BaseAction
/*    */ {
/*    */   private Role role;
/*    */   private List<RoleAuthority> roleAuthorities;
/*    */   private String roleAuthorityIndex;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 22 */     if (super.perExecute(null) != null) return returnCommand();
/* 23 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 24 */     Filter filter = FilterFactory.getSimpleFilter("roleName", this.role.getRoleName(), "=");
/* 25 */     List roles = roleMgr.getObjects(filter);
/* 26 */     if (((this.role.getId() == null) && (roles.size() > 0)) || ((this.role.getId() != null) && (roles.size() > 1)))
/* 27 */       throw new BusinessException(I18NUtil.getStringByParameter("角色名重复", "Role", this.role.getRoleName()));
/* 28 */     String[] indexs = (String[])null;
/* 29 */     if (this.roleAuthorityIndex != null) {
/* 30 */       indexs = this.roleAuthorityIndex.split(",");
/*    */     }
/* 32 */     if (roles.size() == 0)
/* 33 */       roles.add(new Role());
/* 34 */     Role _role = (Role)roles.get(0);
/*    */ 
/* 36 */     _role.setDescription(this.role.getDescription());
/* 37 */     _role.setDisplayRef(this.role.getDisplayRef());
/* 38 */     _role.setRoleName(this.role.getRoleName());
/*    */ 
/* 40 */     roleMgr.saveRoleAndAuthority(_role, this.roleAuthorities, indexs);
/* 41 */     super.postExecute(null);
/* 42 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Role getRole() {
/* 46 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role) {
/* 50 */     this.role = role;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> getRoleAuthorities() {
/* 54 */     return this.roleAuthorities;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthorities(List<RoleAuthority> roleAuthorities) {
/* 58 */     this.roleAuthorities = roleAuthorities;
/*    */   }
/*    */ 
/*    */   public String getRoleAuthorityIndex() {
/* 62 */     return this.roleAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthorityIndex(String roleAuthorityIndex) {
/* 66 */     this.roleAuthorityIndex = roleAuthorityIndex;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleSaveAction
 * JD-Core Version:    0.6.0
 */