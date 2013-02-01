/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.GroupRolePageInfo;
/*    */ import org.hi.framework.security.model.GroupRole;
/*    */ import org.hi.framework.security.service.GroupRoleManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class GroupRoleListAction extends BaseAction
/*    */ {
/*    */   private GroupRole groupRole;
/*    */   private GroupRolePageInfo pageInfo;
/*    */   private List<GroupRole> groupRoles;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new GroupRolePageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.groupRoles = groupRoleMgr.getGroupRoleList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public GroupRole getGroupRole() {
/* 30 */     return this.groupRole;
/*    */   }
/*    */ 
/*    */   public void setGroupRole(GroupRole groupRole) {
/* 34 */     this.groupRole = groupRole;
/*    */   }
/*    */ 
/*    */   public List<GroupRole> getGroupRoles() {
/* 38 */     return this.groupRoles;
/*    */   }
/*    */ 
/*    */   public void setGroupRoles(List<GroupRole> groupRoles) {
/* 42 */     this.groupRoles = groupRoles;
/*    */   }
/*    */ 
/*    */   public GroupRolePageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(GroupRolePageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.GroupRoleListAction
 * JD-Core Version:    0.6.0
 */