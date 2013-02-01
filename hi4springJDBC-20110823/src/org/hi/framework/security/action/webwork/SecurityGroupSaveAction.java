/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.SecurityGroup;
/*    */ import org.hi.framework.security.service.SecurityGroupManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class SecurityGroupSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private SecurityGroup securityGroup;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.securityGroup) != null) return returnCommand();
/* 14 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/* 15 */     securityGroupMgr.saveSecurityGroup(this.securityGroup);
/* 16 */     super.postExecute(this.securityGroup);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public SecurityGroup getSecurityGroup() {
/* 21 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroup securityGroup) {
/* 25 */     this.securityGroup = securityGroup;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.SecurityGroupSaveAction
 * JD-Core Version:    0.6.0
 */