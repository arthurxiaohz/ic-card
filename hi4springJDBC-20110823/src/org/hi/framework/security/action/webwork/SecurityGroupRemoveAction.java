/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.SecurityGroup;
/*    */ import org.hi.framework.security.service.SecurityGroupManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class SecurityGroupRemoveAction extends BaseAction
/*    */ {
/*    */   private SecurityGroup securityGroup;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/* 14 */     securityGroupMgr.removeSecurityGroupById(this.securityGroup.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public SecurityGroup getSecurityGroup() {
/* 19 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroup securityGroup) {
/* 23 */     this.securityGroup = securityGroup;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.SecurityGroupRemoveAction
 * JD-Core Version:    0.6.0
 */