/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.UserGroup;
/*    */ import org.hi.framework.security.service.UserGroupManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserGroupViewAction extends BaseAction
/*    */ {
/*    */   private UserGroup userGroup;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/* 14 */     this.userGroup = userGroupMgr.getUserGroupById(this.userGroup.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserGroup getUserGroup() {
/* 19 */     return this.userGroup;
/*    */   }
/*    */ 
/*    */   public void setUserGroup(UserGroup userGroup) {
/* 23 */     this.userGroup = userGroup;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserGroupViewAction
 * JD-Core Version:    0.6.0
 */