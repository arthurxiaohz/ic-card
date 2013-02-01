/*     */ package org.hi.base.organization.service.impl;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.model.UserGroup;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ import org.hi.framework.security.service.UserAuthorityManager;
/*     */ import org.hi.framework.security.service.UserGroupManager;
/*     */ import org.hi.framework.security.service.UserRoleManager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class HiUserManagerImpl extends ManagerImpl
/*     */   implements HiUserManager
/*     */ {
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  25 */     HiUser user = (HiUser)obj;
/*  26 */     if (user.getCreator() == null)
/*  27 */       user.setCreator(UserContextHelper.getUser());
/*  28 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  33 */     super.postSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  38 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  44 */     HiUser user = (HiUser)obj;
/*  45 */     UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
/*  46 */     UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  47 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*     */ 
/*  49 */     userGroupMgr.removeUserGroupByUser(user.getId());
/*  50 */     userRoleMgr.removeUserRoleByUser(user.getId());
/*  51 */     userAuthMgr.removeUserAuthorityByUser(user.getId());
/*     */ 
/*  53 */     super.postRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   public void saveHiUser(HiUser HiUser)
/*     */   {
/*  58 */     saveObject(HiUser);
/*     */   }
/*     */ 
/*     */   public void removeHiUserById(Integer id)
/*     */   {
/*  63 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public HiUser getHiUserById(Integer id)
/*     */   {
/*  68 */     return (HiUser)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<HiUser> getHiUserList(PageInfo pageInfo) {
/*  72 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void saveSecurityHiUser(HiUser hiUser) {
/*  76 */     saveObject(hiUser);
/*     */   }
/*     */   public void removeSecurityHiUserById(Integer id) {
/*  79 */     removeObjectById(id);
/*     */   }
/*     */   public HiUser getSecurityHiUserById(Integer id) {
/*  82 */     return (HiUser)getObjectById(id);
/*     */   }
/*     */   public List<HiUser> getSecurityHiUserList(PageInfo pageInfo) {
/*  85 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public String getAllOrgHTML() {
/*  89 */     HiOrgManager orgManager = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  90 */     String result = "";
/*  91 */     List orglist = orgManager.getObjects();
/*  92 */     result = result + "<select name=\"leftorg\" id=\"leftorg\" size=\"15\" style=\"width:200px\" multiple ondblclick=\"getalluserbyorgid(this.value)\">";
/*  93 */     for (int i = 0; i < orglist.size(); i++) {
/*  94 */       HiOrg org = (HiOrg)orglist.get(i);
/*  95 */       result = result + "<option value=\"" + org.getId() + "\">" + org.getOrgName() + "</option>";
/*     */     }
/*  97 */     result = result + "</select>";
/*  98 */     System.out.println(result);
/*  99 */     return result;
/*     */   }
/*     */   public String getAllUserByOrgIdHTML(String orgid) {
/* 102 */     List userlist = getAllUserByOrgId(orgid);
/* 103 */     String result = "";
/* 104 */     result = result + "<select name=\"left\" id=\"left\" size=\"15\" style=\"width:200px\" multiple>";
/* 105 */     result = result + "<option value=\"0\">全部</option>";
/* 106 */     for (int i = 0; i < userlist.size(); i++) {
/* 107 */       HiUser user = (HiUser)userlist.get(i);
/* 108 */       result = result + "<option value=\"" + user.getId() + "\">" + user.getFullName() + "</option>";
/*     */     }
/* 110 */     result = result + "</select>";
/* 111 */     System.out.println(result);
/* 112 */     return result;
/*     */   }
/*     */   public List getAllUserByOrgId(String orgid) {
/* 115 */     Filter filter = FilterFactory.getSimpleFilter("org.id", new Integer(orgid));
/* 116 */     return getObjects(filter);
/*     */   }
/*     */   public String getAllUserHTML() {
/* 119 */     List userlist = getObjects();
/* 120 */     String result = "";
/* 121 */     result = result + "<select name=\"left\" id=\"left\" size=\"15\" style=\"width:200px\" multiple>";
/* 122 */     result = result + "<option value=\"0\">全部</option>";
/* 123 */     for (int i = 0; i < userlist.size(); i++) {
/* 124 */       HiUser user = (HiUser)userlist.get(i);
/* 125 */       result = result + "<option value=\"" + user.getId() + "\">" + user.getFullName() + "</option>";
/*     */     }
/* 127 */     result = result + "</select>";
/* 128 */     System.out.println(result);
/* 129 */     return result;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.service.impl.HiUserManagerImpl
 * JD-Core Version:    0.6.0
 */