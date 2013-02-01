/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.service.RoleManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class RoleAssignSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Role role;
/*    */   private String userIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     if (super.perExecute(this.role) != null) return returnCommand();
/* 21 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 22 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 24 */     if ((this.userIndexs == null) || (this.userIndexs.length() <= 0)) {
/* 25 */       return returnCommand();
/*    */     }
/* 27 */     List users = new ArrayList();
/* 28 */     String[] ids = this.userIndexs.split(",");
/* 29 */     for (int i = 0; i < ids.length; i++)
/*    */     {
/* 31 */       if (ids[i].trim().equals("")) {
/*    */         continue;
/*    */       }
/* 34 */       Integer userid = new Integer(ids[i]);
/* 35 */       HiUser user = userMgr.getHiUserById(userid);
/*    */ 
/* 37 */       if (user.getUserMgrType().intValue() != 1400) {
/* 38 */         users.add(user);
/*    */       }
/*    */     }
/* 41 */     roleMgr.saveUserRole(this.role, users);
/* 42 */     super.postExecute(this.role);
/* 43 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public String getUserIndexs()
/*    */   {
/* 48 */     return this.userIndexs;
/*    */   }
/*    */ 
/*    */   public void setUserIndexs(String userIndexs) {
/* 52 */     this.userIndexs = userIndexs;
/*    */   }
/*    */ 
/*    */   public Role getRole()
/*    */   {
/* 57 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role)
/*    */   {
/* 62 */     this.role = role;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleAssignSaveAction
 * JD-Core Version:    0.6.0
 */