/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiOrgPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class RoleAuthorityPageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected Integer f_scope;
/*    */   protected String f_scope_op;
/*    */   protected RolePageInfo role;
/*    */   protected AuthorityPageInfo authority;
/*    */   protected HiOrgPageInfo org;
/*    */ 
/*    */   public Integer getF_id()
/*    */   {
/* 23 */     return this.f_id;
/*    */   }
/*    */ 
/*    */   public void setF_id(Integer f_id) {
/* 27 */     this.f_id = f_id;
/*    */   }
/*    */ 
/*    */   public String getF_id_op() {
/* 31 */     return this.f_id_op;
/*    */   }
/*    */ 
/*    */   public void setF_id_op(String f_id_op) {
/* 35 */     this.f_id_op = f_id_op;
/*    */   }
/*    */ 
/*    */   public Integer getF_scope() {
/* 39 */     return this.f_scope;
/*    */   }
/*    */ 
/*    */   public void setF_scope(Integer f_scope) {
/* 43 */     this.f_scope = f_scope;
/*    */   }
/*    */ 
/*    */   public String getF_scope_op() {
/* 47 */     return this.f_scope_op;
/*    */   }
/*    */ 
/*    */   public void setF_scope_op(String f_scope_op) {
/* 51 */     this.f_scope_op = f_scope_op;
/*    */   }
/*    */ 
/*    */   public RolePageInfo getRole() {
/* 55 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(RolePageInfo role) {
/* 59 */     this.role = role;
/*    */   }
/*    */   public AuthorityPageInfo getAuthority() {
/* 62 */     return this.authority;
/*    */   }
/*    */ 
/*    */   public void setAuthority(AuthorityPageInfo authority) {
/* 66 */     this.authority = authority;
/*    */   }
/*    */   public HiOrgPageInfo getOrg() {
/* 69 */     return this.org;
/*    */   }
/*    */ 
/*    */   public void setOrg(HiOrgPageInfo org) {
/* 73 */     this.org = org;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.RoleAuthorityPageInfo
 * JD-Core Version:    0.6.0
 */