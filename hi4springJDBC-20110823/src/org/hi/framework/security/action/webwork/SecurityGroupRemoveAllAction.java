/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.SecurityGroup;
/*    */ import org.hi.framework.security.service.SecurityGroupManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class SecurityGroupRemoveAllAction extends BaseAction
/*    */ {
/*    */   private SecurityGroup securityGroup;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer securityGroupid = new Integer(ids[i]);
/* 24 */         securityGroupMgr.removeSecurityGroupById(securityGroupid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public SecurityGroup getSecurityGroup() {
/* 33 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroup securityGroup) {
/* 37 */     this.securityGroup = securityGroup;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.SecurityGroupRemoveAllAction
 * JD-Core Version:    0.6.0
 */