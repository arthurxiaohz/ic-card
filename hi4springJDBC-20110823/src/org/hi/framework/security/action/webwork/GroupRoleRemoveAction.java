/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.GroupRole;
/*    */ import org.hi.framework.security.service.GroupRoleManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class GroupRoleRemoveAction extends BaseAction
/*    */ {
/*    */   private GroupRole groupRole;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/* 14 */     groupRoleMgr.removeGroupRoleById(this.groupRole.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public GroupRole getGroupRole() {
/* 19 */     return this.groupRole;
/*    */   }
/*    */ 
/*    */   public void setGroupRole(GroupRole groupRole) {
/* 23 */     this.groupRole = groupRole;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.GroupRoleRemoveAction
 * JD-Core Version:    0.6.0
 */