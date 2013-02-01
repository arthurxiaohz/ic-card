/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.action.UserGroupPageInfo;
/*    */ import org.hi.framework.security.model.UserGroup;
/*    */ import org.hi.framework.security.service.UserGroupManager;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserGroupListAction extends BaseAction
/*    */ {
/*    */   private UserGroup userGroup;
/*    */   private UserGroupPageInfo pageInfo;
/*    */   private List<UserGroup> userGroups;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new UserGroupPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.userGroups = userGroupMgr.getUserGroupList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public UserGroup getUserGroup() {
/* 30 */     return this.userGroup;
/*    */   }
/*    */ 
/*    */   public void setUserGroup(UserGroup userGroup) {
/* 34 */     this.userGroup = userGroup;
/*    */   }
/*    */ 
/*    */   public List<UserGroup> getUserGroups() {
/* 38 */     return this.userGroups;
/*    */   }
/*    */ 
/*    */   public void setUserGroups(List<UserGroup> userGroups) {
/* 42 */     this.userGroups = userGroups;
/*    */   }
/*    */ 
/*    */   public UserGroupPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(UserGroupPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserGroupListAction
 * JD-Core Version:    0.6.0
 */