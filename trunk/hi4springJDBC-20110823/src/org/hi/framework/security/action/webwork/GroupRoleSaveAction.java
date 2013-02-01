/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.GroupRole;
/*    */ import org.hi.framework.security.service.GroupRoleManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class GroupRoleSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private GroupRole groupRole;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.groupRole) != null) return returnCommand();
/* 14 */     GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
/* 15 */     groupRoleMgr.saveGroupRole(this.groupRole);
/* 16 */     super.postExecute(this.groupRole);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public GroupRole getGroupRole() {
/* 21 */     return this.groupRole;
/*    */   }
/*    */ 
/*    */   public void setGroupRole(GroupRole groupRole) {
/* 25 */     this.groupRole = groupRole;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.GroupRoleSaveAction
 * JD-Core Version:    0.6.0
 */