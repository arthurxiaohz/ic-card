/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.GroupRolePageInfo;
/*     */ import org.hi.framework.security.model.GroupRole;
/*     */ import org.hi.framework.security.service.GroupRoleManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class GroupRoleAction extends BaseAction
/*     */ {
/*     */   private GroupRole groupRole;
/*     */   private GroupRolePageInfo pageInfo;
/*     */   private List<GroupRole> groupRoles;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveGroupRole()
/*     */     throws Exception
/*     */   {
/*  25 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/*  26 */     if (super.perExecute(this.groupRole) != null) return returnCommand();
/*  27 */     groupRoleMgr.saveGroupRole(this.groupRole);
/*  28 */     super.postExecute(this.groupRole);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeGroupRole()
/*     */     throws Exception
/*     */   {
/*  37 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/*  38 */     groupRoleMgr.removeGroupRoleById(this.groupRole.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllGroupRole()
/*     */     throws Exception
/*     */   {
/*  46 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer groupRoleid = new Integer(ids[i]);
/*  55 */         groupRoleMgr.removeGroupRoleById(groupRoleid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewGroupRole()
/*     */     throws Exception
/*     */   {
/*  67 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/*  68 */     this.groupRole = groupRoleMgr.getGroupRoleById(this.groupRole.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String groupRoleList()
/*     */     throws Exception
/*     */   {
/*  76 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new GroupRolePageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.groupRoles = groupRoleMgr.getGroupRoleList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public GroupRole getGroupRole()
/*     */   {
/*  89 */     return this.groupRole;
/*     */   }
/*     */ 
/*     */   public void setGroupRole(GroupRole groupRole) {
/*  93 */     this.groupRole = groupRole;
/*     */   }
/*     */ 
/*     */   public List<GroupRole> getGroupRoles() {
/*  97 */     return this.groupRoles;
/*     */   }
/*     */ 
/*     */   public void setGroupRoles(List<GroupRole> groupRoles) {
/* 101 */     this.groupRoles = groupRoles;
/*     */   }
/*     */ 
/*     */   public GroupRolePageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(GroupRolePageInfo pageInfo) {
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

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.GroupRoleAction
 * JD-Core Version:    0.6.0
 */