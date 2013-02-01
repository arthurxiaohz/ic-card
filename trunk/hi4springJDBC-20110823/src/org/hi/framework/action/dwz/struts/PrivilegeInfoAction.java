/*    */ package org.hi.framework.action.dwz.struts;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.common.util.JSONObject;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class PrivilegeInfoAction extends BaseAction
/*    */ {
/* 17 */   private HiUser user = null;
/*    */   private JSONObject json;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 22 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 23 */     HiUserManager uesrMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 24 */     if (this.user == null)
/* 25 */       return "json";
/* 26 */     this.user = uesrMgr.getHiUserById(this.user.getId());
/*    */ 
/* 29 */     List userPrivilege = userAuthorityMgr.getUserAuthority(this.user);
/*    */ 
/* 32 */     this.json = new JSONObject("userPrivileges", userPrivilege, "id,authority.id,scope,org.id,org.orgName");
/* 33 */     this.json.addJSONObject("user", this.user, "id,org.id,creator.id");
/*    */ 
/* 35 */     return "json";
/*    */   }
/*    */ 
/*    */   public JSONObject getJson() {
/* 39 */     return this.json;
/*    */   }
/*    */ 
/*    */   public void setJson(JSONObject json) {
/* 43 */     this.json = json;
/*    */   }
/*    */ 
/*    */   private boolean hasRole(List<UserRole> userRoles, HiUser user) {
/* 47 */     if (userRoles == null)
/* 48 */       return false;
/* 49 */     for (UserRole userRole : userRoles) {
/* 50 */       if ((userRole.getSecurityUser() != null) && 
/* 51 */         (userRole.getSecurityUser().getId().equals(user.getId()))) {
/* 52 */         return true;
/*    */       }
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */ 
/*    */   public HiUser getUser() {
/* 59 */     return this.user;
/*    */   }
/*    */ 
/*    */   public void setUser(HiUser user) {
/* 63 */     this.user = user;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.struts.PrivilegeInfoAction
 * JD-Core Version:    0.6.0
 */