/*    */ package org.hi.framework.security.action;
/*    */ 
/*    */ import org.hi.base.organization.action.HiUserPageInfo;
/*    */ import org.hi.framework.web.PageInfoView;
/*    */ 
/*    */ public class UserGroupPageInfo extends PageInfoView
/*    */ {
/*    */   protected Integer f_id;
/*    */   protected String f_id_op;
/*    */   protected HiUserPageInfo securityUser;
/*    */   protected SecurityGroupPageInfo securityGroup;
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
/*    */   public HiUserPageInfo getSecurityUser() {
/* 35 */     return this.securityUser;
/*    */   }
/*    */ 
/*    */   public void setSecurityUser(HiUserPageInfo securityUser) {
/* 39 */     this.securityUser = securityUser;
/*    */   }
/*    */   public SecurityGroupPageInfo getSecurityGroup() {
/* 42 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroupPageInfo securityGroup) {
/* 46 */     this.securityGroup = securityGroup;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.UserGroupPageInfo
 * JD-Core Version:    0.6.0
 */