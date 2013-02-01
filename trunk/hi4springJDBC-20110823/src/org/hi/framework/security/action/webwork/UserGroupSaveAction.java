/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserGroup;
/*    */ import org.hi.framework.security.service.UserGroupManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserGroupSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private UserGroup userGroup;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.userGroup) != null) return returnCommand();
/* 14 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/* 15 */     userGroupMgr.saveUserGroup(this.userGroup);
/* 16 */     super.postExecute(this.userGroup);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserGroup getUserGroup() {
/* 21 */     return this.userGroup;
/*    */   }
/*    */ 
/*    */   public void setUserGroup(UserGroup userGroup) {
/* 25 */     this.userGroup = userGroup;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserGroupSaveAction
 * JD-Core Version:    0.6.0
 */