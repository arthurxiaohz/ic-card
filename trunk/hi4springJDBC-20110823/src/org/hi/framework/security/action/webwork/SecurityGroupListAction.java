/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.SecurityGroupPageInfo;
/*    */ import org.hi.framework.security.model.SecurityGroup;
/*    */ import org.hi.framework.security.service.SecurityGroupManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class SecurityGroupListAction extends BaseAction
/*    */ {
/*    */   private SecurityGroup securityGroup;
/*    */   private SecurityGroupPageInfo pageInfo;
/*    */   private List<SecurityGroup> securityGroups;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new SecurityGroupPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.securityGroups = securityGroupMgr.getSecurityGroupList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public SecurityGroup getSecurityGroup() {
/* 30 */     return this.securityGroup;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroup(SecurityGroup securityGroup) {
/* 34 */     this.securityGroup = securityGroup;
/*    */   }
/*    */ 
/*    */   public List<SecurityGroup> getSecurityGroups() {
/* 38 */     return this.securityGroups;
/*    */   }
/*    */ 
/*    */   public void setSecurityGroups(List<SecurityGroup> securityGroups) {
/* 42 */     this.securityGroups = securityGroups;
/*    */   }
/*    */ 
/*    */   public SecurityGroupPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(SecurityGroupPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.SecurityGroupListAction
 * JD-Core Version:    0.6.0
 */