/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class GroupRolePageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected SecurityGroupPageInfo securityGroup;
/*    */   protected RolePageInfo role;
/*    */ 
/*    */   public Integer getF_id()
/*    */   {
/* 19 */     return this.f_id;
/*    */   }
/*    */ 
/*    */   public void setF_id(Integer f_id) {
/* 23 */     this.f_id = f_id;
/*    */   }
/*    */ 
/*    */   public String getF_id_op() {
/* 27 */     return this.f_id_op;
/*    */   }
/*    */ 
/*    */   public void setF_id_op(String f_id_op) {
/* 31 */     this.f_id_op = f_id_op;
/*    */   }
/*    */ 
/*    */   public SecurityGroupPageInfo getSecurityGroup() {
/* 35 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroupPageInfo securityGroup) {
/* 39 */     this.securityGroup = securityGroup;
/*    */   }
/*    */   public RolePageInfo getRole() {
/* 42 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(RolePageInfo role) {
/* 46 */     this.role = role;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.GroupRolePageInfo
 * JD-Core Version:    0.6.0
 */