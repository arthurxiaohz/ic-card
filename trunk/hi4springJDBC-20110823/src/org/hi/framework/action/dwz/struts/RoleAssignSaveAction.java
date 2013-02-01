/*    */ package org.hi.framework.action.dwz.struts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.base.organization.service.HiUserManager;
/*    */ import org.hi.framework.security.dwz.service.RoleManager;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class RoleAssignSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Role role;
/*    */   private String userIndexs;
/*    */   private int orgID;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 21 */     if (super.perExecute(this.role) != null) return returnCommand();
/* 22 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(RoleManager.class);
/* 23 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*    */ 
/* 25 */     if ((this.userIndexs == null) || (this.userIndexs.length() <= 0)) {
/* 26 */       return returnCommand();
/*    */     }
/* 28 */     List users = new ArrayList();
/* 29 */     String[] ids = this.userIndexs.split(",");
/* 30 */     for (int i = 0; i < ids.length; i++)
/*    */     {
/* 32 */       if (ids[i].trim().equals("")) {
/*    */         continue;
/*    */       }
/* 35 */       Integer userid = new Integer(ids[i]);
/* 36 */       HiUser user = userMgr.getHiUserById(userid);
/*    */ 
/* 38 */       if (user.getUserMgrType().intValue() != 1400) {
/* 39 */         users.add(user);
/*    */       }
/*    */     }
/* 42 */     roleMgr.saveUserRole(this.role, this.orgID, users);
/* 43 */     super.postExecute(this.role);
/* 44 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public String getUserIndexs()
/*    */   {
/* 49 */     return this.userIndexs;
/*    */   }
/*    */ 
/*    */   public void setUserIndexs(String userIndexs) {
/* 53 */     this.userIndexs = userIndexs;
/*    */   }
/*    */ 
/*    */   public Role getRole()
/*    */   {
/* 58 */     return this.role;
/*    */   }
/*    */ 
/*    */   public void setRole(Role role)
/*    */   {
/* 63 */     this.role = role;
/*    */   }
/*    */ 
/*    */   public int getOrgID()
/*    */   {
/* 68 */     return this.orgID;
/*    */   }
/*    */ 
/*    */   public void setOrgID(int orgID)
/*    */   {
/* 73 */     this.orgID = orgID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.struts.RoleAssignSaveAction
 * JD-Core Version:    0.6.0
 */