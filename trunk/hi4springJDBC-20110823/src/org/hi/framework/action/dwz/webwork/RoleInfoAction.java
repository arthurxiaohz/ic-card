/*     */ package org.hi.framework.action.dwz.webwork;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.common.util.JSONObject;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ import org.hi.framework.security.service.UserRoleManager;
/*     */ import org.hi.framework.web.webwork.BaseAction;
/*     */ 
/*     */ public class RoleInfoAction extends BaseAction
/*     */ {
/*     */   private int roleID;
/*     */   private int orgID;
/*  23 */   private String otherUserStr = "";
/*     */ 
/*  25 */   private String hasRoleUserString = "";
/*     */   private JSONObject json;
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  31 */     List otherUsers = new ArrayList();
/*  32 */     List hasRoleUsers = new ArrayList();
/*  33 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*  34 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*     */ 
/*  37 */     Filter roleFilter = FilterFactory.getSimpleFilter("role.id", Integer.valueOf(this.roleID), "=");
/*  38 */     roleFilter.addCondition("securityUser.org.id", Integer.valueOf(this.orgID), "=");
/*     */ 
/*  40 */     List userRoles = userRoleMgr.getObjects(roleFilter);
/*     */ 
/*  43 */     Filter userFilter = FilterFactory.getSimpleFilter("org.id", Integer.valueOf(this.orgID), "=")
/*  44 */       .addCondition("userMgrType", Integer.valueOf(1400), "<>");
/*  45 */     List allOrgUsers = userMgr.getObjects(userFilter);
/*     */ 
/*  47 */     if (allOrgUsers != null) {
/*  48 */       for (HiUser user : allOrgUsers) {
/*  49 */         if (hasRole(userRoles, user))
/*  50 */           hasRoleUsers.add(user);
/*     */         else
/*  52 */           otherUsers.add(user);
/*     */       }
/*     */     }
/*  55 */     this.json = new JSONObject("orgID", Integer.valueOf(this.orgID));
/*  56 */     this.json.addJSONObject("otherUsers", otherUsers, "id,fullName");
/*  57 */     this.json.addJSONObject("hasRoleUsers", hasRoleUsers, "id,fullName");
/*     */ 
/*  59 */     return "json";
/*     */   }
/*     */ 
/*     */   public JSONObject getJson() {
/*  63 */     return this.json;
/*     */   }
/*     */ 
/*     */   public void setJson(JSONObject json) {
/*  67 */     this.json = json;
/*     */   }
/*     */ 
/*     */   private boolean hasRole(List<UserRole> userRoles, HiUser user) {
/*  71 */     if (userRoles == null)
/*  72 */       return false;
/*  73 */     for (UserRole userRole : userRoles) {
/*  74 */       if ((userRole.getSecurityUser() != null) && 
/*  75 */         (userRole.getSecurityUser().getId().equals(user.getId()))) {
/*  76 */         return true;
/*     */       }
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   public String getOtherUserStr() {
/*  83 */     return this.otherUserStr;
/*     */   }
/*     */ 
/*     */   public void setOtherUserStr(String otherUserStr) {
/*  87 */     this.otherUserStr = otherUserStr;
/*     */   }
/*     */ 
/*     */   public String getHasRoleUserString() {
/*  91 */     return this.hasRoleUserString;
/*     */   }
/*     */ 
/*     */   public void setHasRoleUserString(String hasRoleUserString) {
/*  95 */     this.hasRoleUserString = hasRoleUserString;
/*     */   }
/*     */ 
/*     */   public int getRoleID() {
/*  99 */     return this.roleID;
/*     */   }
/*     */ 
/*     */   public void setRoleID(int roleID) {
/* 103 */     this.roleID = roleID;
/*     */   }
/*     */ 
/*     */   public int getOrgID() {
/* 107 */     return this.orgID;
/*     */   }
/*     */ 
/*     */   public void setOrgID(int orgID) {
/* 111 */     this.orgID = orgID;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.webwork.RoleInfoAction
 * JD-Core Version:    0.6.0
 */