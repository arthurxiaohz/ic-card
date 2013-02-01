/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.impl.FilterFactory;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.Role;
/*    */ import org.hi.framework.security.model.UserAuthority;
/*    */ import org.hi.framework.security.model.UserRole;
/*    */ import org.hi.framework.security.service.UserAuthorityManager;
/*    */ import org.hi.framework.security.service.UserRoleManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class UserRoleManagerImpl extends ManagerImpl
/*    */   implements UserRoleManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 19 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 24 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 29 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 34 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveUserRole(UserRole UserRole)
/*    */   {
/* 39 */     saveObject(UserRole);
/*    */   }
/*    */ 
/*    */   public void removeUserRoleById(Integer id)
/*    */   {
/* 44 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public UserRole getUserRoleById(Integer id)
/*    */   {
/* 49 */     return (UserRole)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<UserRole> getUserRoleList(PageInfo pageInfo) {
/* 53 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void removeUserRoleAndAuthorityById(Integer userRoleId)
/*    */   {
/* 58 */     UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/* 59 */     UserRole userRole = getUserRoleById(userRoleId);
/*    */ 
/* 61 */     Filter filter = FilterFactory.getSimpleFilter("roleAuthority.role.id", userRole.getRole().getId(), "=")
/* 62 */       .addCondition("securityUser.id", userRole.getSecurityUser().getId(), "=");
/*    */ 
/* 64 */     List userAuthorities = userAuthMgr.getObjects(filter);
/* 65 */     for (UserAuthority userAuthority : userAuthorities) {
/* 66 */       userAuthMgr.removeUserAuthorityById(userAuthority.getId());
/*    */     }
/*    */ 
/* 69 */     removeUserRoleById(userRole.getId());
/*    */   }
/*    */ 
/*    */   public void removeUserRoleByUser(Integer userId)
/*    */   {
/* 74 */     Filter filter = FilterFactory.getSimpleFilter("securityUser.id", userId, "=");
/* 75 */     List userRoles = getObjects(filter);
/* 76 */     for (UserRole userRole : userRoles)
/* 77 */       removeUserRoleAndAuthorityById(userRole.getId());
/*    */   }
/*    */ 
/*    */   public void saveSecurityUserRole(UserRole userRole)
/*    */   {
/* 83 */     saveObject(userRole);
/*    */   }
/*    */   public void removeSecurityUserRoleById(Integer id) {
/* 86 */     removeObjectById(id);
/*    */   }
/*    */   public UserRole getSecurityUserRoleById(Integer id) {
/* 89 */     return (UserRole)getObjectById(id);
/*    */   }
/*    */   public List<UserRole> getSecurityUserRoleList(PageInfo pageInfo) {
/* 92 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.impl.UserRoleManagerImpl
 * JD-Core Version:    0.6.0
 */