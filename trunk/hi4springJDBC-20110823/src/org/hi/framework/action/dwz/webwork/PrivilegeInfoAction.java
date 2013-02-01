/*    */ package org.hi.framework.action.dwz.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.common.util.JSONObject;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class PrivilegeInfoAction extends BaseAction
/*    */ {
/* 27 */   private HiUser user = null;
/*    */   private JSONObject json;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 32 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 33 */     HiUserManager uesrMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 34 */     if (this.user == null)
/* 35 */       return "json";
/* 36 */     this.user = uesrMgr.getHiUserById(this.user.getId());
/*    */ 
/* 39 */     List userPrivilege = userAuthorityMgr.getUserAuthority(this.user);
/*    */ 
/* 42 */     this.json = new JSONObject("userPrivileges", userPrivilege, "id,authority.id,scope,org.id,org.orgName");
/* 43 */     this.json.addJSONObject("user", this.user, "id,org.id,creator.id");
/*    */ 
/* 45 */     return "json";
/*    */   }
/*    */ 
/*    */   public JSONObject getJson() {
/* 49 */     return this.json;
/*    */   }
/*    */ 
/*    */   public void setJson(JSONObject json) {
/* 53 */     this.json = json;
/*    */   }
/*    */ 
/*    */   private boolean hasRole(List<UserRole> userRoles, HiUser user) {
/* 57 */     if (userRoles == null)
/* 58 */       return false;
/* 59 */     for (UserRole userRole : userRoles) {
/* 60 */       if ((userRole.getSecurityUser() != null) && 
/* 61 */         (userRole.getSecurityUser().getId().equals(user.getId()))) {
/* 62 */         return true;
/*    */       }
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */ 
/*    */   public HiUser getUser() {
/* 69 */     return this.user;
/*    */   }
/*    */ 
/*    */   public void setUser(HiUser user) {
/* 73 */     this.user = user;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.webwork.PrivilegeInfoAction
 * JD-Core Version:    0.6.0
 */