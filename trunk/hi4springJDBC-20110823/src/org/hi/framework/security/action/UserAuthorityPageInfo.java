/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiOrgPageInfo;
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class UserAuthorityPageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected Integer f_scope;
/*    */   protected String f_scope_op;
/*    */   protected HiUserPageInfo securityUser;
/*    */   protected AuthorityPageInfo authority;
/*    */   protected HiOrgPageInfo org;
/*    */   protected RoleAuthorityPageInfo roleAuthority;
/*    */ 
/*    */   public Integer getF_id()
/*    */   {
/* 25 */     return this.f_id;
/*    */   }
/*    */ 
/*    */   public void setF_id(Integer f_id) {
/* 29 */     this.f_id = f_id;
/*    */   }
/*    */ 
/*    */   public String getF_id_op() {
/* 33 */     return this.f_id_op;
/*    */   }
/*    */ 
/*    */   public void setF_id_op(String f_id_op) {
/* 37 */     this.f_id_op = f_id_op;
/*    */   }
/*    */ 
/*    */   public Integer getF_scope() {
/* 41 */     return this.f_scope;
/*    */   }
/*    */ 
/*    */   public void setF_scope(Integer f_scope) {
/* 45 */     this.f_scope = f_scope;
/*    */   }
/*    */ 
/*    */   public String getF_scope_op() {
/* 49 */     return this.f_scope_op;
/*    */   }
/*    */ 
/*    */   public void setF_scope_op(String f_scope_op) {
/* 53 */     this.f_scope_op = f_scope_op;
/*    */   }
/*    */ 
/*    */   public HiUserPageInfo getSecurityUser() {
/* 57 */     return this.securityUser;
/*    */   }
/*    */ 
/*    */   public void setSecurityUser(HiUserPageInfo securityUser) {
/* 61 */     this.securityUser = securityUser;
/*    */   }
/*    */   public AuthorityPageInfo getAuthority() {
/* 64 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(AuthorityPageInfo authority) {
/* 68 */     this.authority = authority;
/*    */   }
/*    */   public HiOrgPageInfo getOrg() {
/* 71 */     return this.org;
/*    */   }
/*    */ 
/*    */   public void setOrg(HiOrgPageInfo org) {
/* 75 */     this.org = org;
/*    */   }
/*    */   public RoleAuthorityPageInfo getRoleAuthority() {
/* 78 */     return this.roleAuthority;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthority(RoleAuthorityPageInfo roleAuthority) {
/* 82 */     this.roleAuthority = roleAuthority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.UserAuthorityPageInfo
 * JD-Core Version:    0.6.0
 */