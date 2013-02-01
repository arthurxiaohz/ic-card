/*     */ package org.hi.framework.security.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.UserGroupPageInfo;
/*     */ import org.hi.framework.security.model.UserGroup;
/*     */ import org.hi.framework.security.service.UserGroupManager;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class UserGroupAction extends BaseAction
/*     */ {
/*     */   private UserGroup userGroup;
/*     */   private UserGroupPageInfo pageInfo;
/*     */   private List<UserGroup> userGroups;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveUserGroup()
/*     */     throws Exception
/*     */   {
/*  25 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  26 */     if (super.perExecute(this.userGroup) != null) return returnCommand();
/*  27 */     userGroupMgr.saveUserGroup(this.userGroup);
/*  28 */     super.postExecute(this.userGroup);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeUserGroup()
/*     */     throws Exception
/*     */   {
/*  37 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  38 */     userGroupMgr.removeUserGroupById(this.userGroup.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllUserGroup()
/*     */     throws Exception
/*     */   {
/*  46 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer userGroupid = new Integer(ids[i]);
/*  55 */         userGroupMgr.removeUserGroupById(userGroupid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewUserGroup()
/*     */     throws Exception
/*     */   {
/*  67 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  68 */     this.userGroup = userGroupMgr.getUserGroupById(this.userGroup.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String userGroupList()
/*     */     throws Exception
/*     */   {
/*  76 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new UserGroupPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.userGroups = userGroupMgr.getUserGroupList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public UserGroup getUserGroup()
/*     */   {
/*  89 */     return this.userGroup;
/*     */   }
/*     */ 
/*     */   public void setUserGroup(UserGroup userGroup) {
/*  93 */     this.userGroup = userGroup;
/*     */   }
/*     */ 
/*     */   public List<UserGroup> getUserGroups() {
/*  97 */     return this.userGroups;
/*     */   }
/*     */ 
/*     */   public void setUserGroups(List<UserGroup> userGroups) {
/* 101 */     this.userGroups = userGroups;
/*     */   }
/*     */ 
/*     */   public UserGroupPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(UserGroupPageInfo pageInfo) {
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
 * Qualified Name:     org.hi.framework.security.action.struts.UserGroupAction
 * JD-Core Version:    0.6.0
 */