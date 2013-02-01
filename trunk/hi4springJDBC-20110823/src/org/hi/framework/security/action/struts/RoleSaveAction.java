/*    */ package org.hi.framework.security.action.struts;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.web.BusinessException;
/*    */ import org.hi.framework.web.struts.BaseAction;
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
/* 21 */     if (super.perExecute(null) != null) return returnCommand();
/* 22 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 23 */     Filter filter = FilterFactory.getSimpleFilter("roleName", this.role.getRoleName(), "=");
/* 24 */     List roles = roleMgr.getObjects(filter);
/* 25 */     if (((this.role.getId() == null) && (roles.size() > 0)) || ((this.role.getId() != null) && (roles.size() > 1)))
/* 26 */       throw new BusinessException(I18NUtil.getStringByParameter("角色名重复", "Role", this.role.getRoleName()));
/* 27 */     String[] indexs = (String[])null;
/* 28 */     if (this.roleAuthorityIndex != null) {
/* 29 */       indexs = this.roleAuthorityIndex.split(",");
/*    */     }
/* 31 */     if (roles.size() == 0)
/* 32 */       roles.add(new Role());
/* 33 */     Role _role = (Role)roles.get(0);
/*    */ 
/* 35 */     _role.setDescription(this.role.getDescription());
/* 36 */     _role.setDisplayRef(this.role.getDisplayRef());
/* 37 */     _role.setRoleName(this.role.getRoleName());
/*    */ 
/* 39 */     roleMgr.saveRoleAndAuthority(_role, this.roleAuthorities, indexs);
/* 40 */     super.postExecute(null);
/* 41 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Role getRole() {
/* 45 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role) {
/* 49 */     this.role = role;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> getRoleAuthorities() {
/* 53 */     return this.roleAuthorities;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthorities(List<RoleAuthority> roleAuthorities) {
/* 57 */     this.roleAuthorities = roleAuthorities;
/*    */   }
/*    */ 
/*    */   public String getRoleAuthorityIndex() {
/* 61 */     return this.roleAuthorityIndex;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthorityIndex(String roleAuthorityIndex) {
/* 65 */     this.roleAuthorityIndex = roleAuthorityIndex;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.struts.RoleSaveAction
 * JD-Core Version:    0.6.0
 */