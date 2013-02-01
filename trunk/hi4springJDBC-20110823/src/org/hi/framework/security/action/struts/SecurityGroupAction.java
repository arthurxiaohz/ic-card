/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.SecurityGroupPageInfo;
/*     */ import org.hi.framework.security.model.SecurityGroup;
/*     */ import org.hi.framework.security.service.SecurityGroupManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class SecurityGroupAction extends BaseAction
/*     */ {
/*     */   private SecurityGroup securityGroup;
/*     */   private SecurityGroupPageInfo pageInfo;
/*     */   private List<SecurityGroup> securityGroups;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveSecurityGroup()
/*     */     throws Exception
/*     */   {
/*  25 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*  26 */     if (super.perExecute(this.securityGroup) != null) return returnCommand();
/*  27 */     securityGroupMgr.saveSecurityGroup(this.securityGroup);
/*  28 */     super.postExecute(this.securityGroup);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeSecurityGroup()
/*     */     throws Exception
/*     */   {
/*  37 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*  38 */     securityGroupMgr.removeSecurityGroupById(this.securityGroup.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllSecurityGroup()
/*     */     throws Exception
/*     */   {
/*  46 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer securityGroupid = new Integer(ids[i]);
/*  55 */         securityGroupMgr.removeSecurityGroupById(securityGroupid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewSecurityGroup()
/*     */     throws Exception
/*     */   {
/*  67 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*  68 */     this.securityGroup = securityGroupMgr.getSecurityGroupById(this.securityGroup.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String securityGroupList()
/*     */     throws Exception
/*     */   {
/*  76 */     SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new SecurityGroupPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.securityGroups = securityGroupMgr.getSecurityGroupList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public SecurityGroup getSecurityGroup()
/*     */   {
/*  89 */     return this.securityGroup;
/*     */   }
/*     */ 
/*     */   public void setSecurityGroup(SecurityGroup securityGroup) {
/*  93 */     this.securityGroup = securityGroup;
/*     */   }
/*     */ 
/*     */   public List<SecurityGroup> getSecurityGroups() {
/*  97 */     return this.securityGroups;
/*     */   }
/*     */ 
/*     */   public void setSecurityGroups(List<SecurityGroup> securityGroups) {
/* 101 */     this.securityGroups = securityGroups;
/*     */   }
/*     */ 
/*     */   public SecurityGroupPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(SecurityGroupPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.struts.SecurityGroupAction
 * JD-Core Version:    0.6.0
 */