/*    */ package org.hi.framework.security.dwz.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.security.dwz.service.RoleManager;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ 
/*    */ public class RoleManagerImpl extends org.hi.framework.security.service.impl.RoleManagerImpl
/*    */   implements RoleManager
/*    */ {
/*    */   public void saveUserRole(Role role, int orgID, List<HiUser> users)
/*    */   {
/* 17 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 18 */     Filter roleFilter = FilterFactory.getSimpleFilter("role.id", role.getId(), "=");
/* 19 */     roleFilter.addCondition("securityUser.org.id", Integer.valueOf(orgID), "=");
/*    */ 
/* 21 */     List userRoles = userRoleMgr.getObjects(roleFilter);
/*    */ 
/* 23 */     if ((userRoles != null) && (userRoles.size() > 0))
/*    */     {
/* 25 */       for (UserRole userRole : userRoles)
/*    */       {
/* 27 */         if (userRole.getSecurityUser() == null) {
/*    */           continue;
/*    */         }
/* 30 */         if (!existIn(users, userRole.getSecurityUser().getId()))
/*    */         {
/* 32 */           userRoleMgr.removeObject(userRole);
/*    */         }
/*    */         else {
/* 35 */           removeFormList(users, userRole.getSecurityUser().getId());
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 40 */     saveUserRole(role, users);
/*    */   }
/*    */ 
/*    */   private void removeFormList(List<HiUser> users, Integer userID)
/*    */   {
/* 45 */     if (users == null)
/* 46 */       return;
/* 47 */     for (int i = users.size() - 1; i >= 0; i--)
/*    */     {
/* 49 */       if (!((HiUser)users.get(i)).getId().equals(userID))
/*    */         continue;
/* 51 */       users.remove(i);
/* 52 */       return;
/*    */     }
/*    */   }
/*    */ 
/*    */   private boolean existIn(List<HiUser> users, Integer userID)
/*    */   {
/* 58 */     if ((users == null) || (users.size() == 0))
/* 59 */       return false;
/* 60 */     for (HiUser user : users)
/*    */     {
/* 62 */       if (user.getId().equals(userID))
/* 63 */         return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.dwz.service.impl.RoleManagerImpl
 * JD-Core Version:    0.6.0
 */