/*     */ package org.hi.framework.security.service.impl;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.Role;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ import org.hi.framework.security.service.AuthorityManager;
/*     */ import org.hi.framework.security.service.RoleAuthorityManager;
/*     */ import org.hi.framework.security.service.RoleManager;
/*     */ import org.hi.framework.security.service.UserAuthorityManager;
/*     */ import org.hi.framework.security.service.UserRoleManager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class RoleManagerImpl extends ManagerImpl
/*     */   implements RoleManager
/*     */ {
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  30 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  35 */     super.postSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  40 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  45 */     super.postRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   public void saveRole(Role Role)
/*     */   {
/*  50 */     saveObject(Role);
/*     */   }
/*     */ 
/*     */   public void removeRoleById(Integer id)
/*     */   {
/*  55 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public Role getRoleById(Integer id)
/*     */   {
/*  60 */     return (Role)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleList(PageInfo pageInfo) {
/*  64 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void saveRoleAndAuthority(Role role, List<RoleAuthority> roleAuthories, String[] indexs)
/*     */   {
/*  73 */     saveRole(role);
/*  74 */     RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  75 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  76 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/*     */ 
/*  78 */     Set users = new HashSet();
/*  79 */     if (role.getId() != null) {
/*  80 */       Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), "=");
/*  81 */       List delRoleAuths = roleAuthMgr.getObjects(filter);
/*  82 */       for (RoleAuthority roleAuthority : delRoleAuths) {
/*  83 */         Filter uAFilter = FilterFactory.getSimpleFilter("roleAuthority.id", roleAuthority.getId(), "=");
/*  84 */         List userAuthrities = userAuthorityMgr.getObjects(uAFilter);
/*     */ 
/*  86 */         for (UserAuthority userAuthority : userAuthrities) {
/*  87 */           if (userAuthority.getSecurityUser() != null)
/*  88 */             users.add(userAuthority.getSecurityUser());
/*  89 */           userAuthorityMgr.removeObject(userAuthority);
/*     */         }
/*  91 */         roleAuthMgr.removeRoleAuthorityById(roleAuthority.getId());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  96 */     if (indexs == null) {
/*  97 */       return;
/*     */     }
/*  99 */     Filter userRoleFilter = FilterFactory.getSimpleFilter("role.id", role.getId());
/* 100 */     List userRoles = userRoleMgr.getObjects(userRoleFilter);
/* 101 */     for (UserRole userRole : userRoles) {
/* 102 */       if (!users.contains(userRole.getSecurityUser())) {
/* 103 */         users.add(userRole.getSecurityUser());
/*     */       }
/*     */     }
/* 106 */     AuthorityManager AuthorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 107 */     HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 108 */     for (int i = 0; i < indexs.length; i++) {
/* 109 */       RoleAuthority roleAuthority = (RoleAuthority)roleAuthories.get(Integer.parseInt(indexs[i].trim()));
/* 110 */       Authority authority = (Authority)AuthorityMgr.getObjectById(roleAuthority.getAuthority().getId());
/* 111 */       HiOrg org = (roleAuthority.getOrg() == null) || (roleAuthority.getOrg().getId() == null) ? null : (HiOrg)orgMgr.getObjectById(roleAuthority.getOrg().getId());
/* 112 */       RoleAuthority persistent = new RoleAuthority();
/* 113 */       persistent.setAuthority(authority);
/* 114 */       persistent.setScope(roleAuthority.getScope());
/* 115 */       persistent.setOrg(org);
/* 116 */       persistent.setRole(role);
/* 117 */       roleAuthMgr.saveRoleAuthority(persistent);
/*     */ 
/* 120 */       for (HiUser user : users) {
/* 121 */         UserAuthority userAuthority = new UserAuthority();
/* 122 */         userAuthority.setSecurityUser(user);
/* 123 */         userAuthority.setAuthority(authority);
/* 124 */         userAuthority.setOrg(org);
/* 125 */         userAuthority.setScope(roleAuthority.getScope());
/* 126 */         userAuthority.setRoleAuthority(persistent);
/* 127 */         userAuthorityMgr.saveUserAuthority(userAuthority);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void saveUserRole(Role role, List<HiUser> users)
/*     */   {
/* 137 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 138 */     RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 139 */     UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*     */ 
/* 141 */     Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), "=");
/* 142 */     List roleAuths = roleAuthMgr.getObjects(filter);
/*     */ 
/* 144 */     List userRoles = userRoleMgr.getObjects(filter);
/* 145 */     Set userIds = new HashSet();
/*     */ 
/* 147 */     for (UserRole userRole : userRoles) {
/* 148 */       userIds.add(userRole.getSecurityUser().getId());
/*     */     }
/*     */ 
/* 152 */     for (HiUser user : users) {
/* 153 */       if (userIds.contains(user.getId())) {
/*     */         continue;
/*     */       }
/* 156 */       UserRole userRole = new UserRole();
/* 157 */       userRole.setRole(role);
/* 158 */       userRole.setSecurityUser(user);
/* 159 */       userRoleMgr.saveUserRole(userRole);
/*     */ 
/* 161 */       for (RoleAuthority roleAuthority : roleAuths) {
/* 162 */         UserAuthority userAuthority = new UserAuthority();
/*     */ 
/* 164 */         userAuthority.setAuthority(roleAuthority.getAuthority());
/* 165 */         userAuthority.setOrg(roleAuthority.getOrg());
/* 166 */         userAuthority.setRoleAuthority(roleAuthority);
/* 167 */         userAuthority.setScope(roleAuthority.getScope());
/* 168 */         userAuthority.setSecurityUser(user);
/*     */ 
/* 170 */         userAuthMgr.saveUserAuthority(userAuthority);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeRoleUserAuthority(Integer roleId)
/*     */   {
/* 182 */     UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
/* 183 */     RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 184 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*     */ 
/* 186 */     Role role = getRoleById(roleId);
/*     */ 
/* 189 */     Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), "=");
/*     */ 
/* 191 */     List userRoles = userRoleMgr.getObjects(filter);
/* 192 */     for (UserRole userRole : userRoles) {
/* 193 */       userRoleMgr.removeUserRoleAndAuthorityById(userRole.getId());
/*     */     }
/*     */ 
/* 197 */     List roleAuths = roleAuthMgr.getObjects(filter);
/* 198 */     for (RoleAuthority roleAuthority : roleAuths) {
/* 199 */       userAuthorityMgr.removeUserAuthorityByRoleAuthority(roleAuthority);
/* 200 */       roleAuthMgr.removeRoleAuthorityById(roleAuthority.getId());
/*     */     }
/*     */ 
/* 204 */     removeRoleById(roleId);
/*     */   }
/*     */ 
/*     */   public void saveSecurityRole(Role role)
/*     */   {
/* 209 */     saveObject(role);
/*     */   }
/*     */   public void removeSecurityRoleById(Integer id) {
/* 212 */     removeObjectById(id);
/*     */   }
/*     */   public Role getSecurityRoleById(Integer id) {
/* 215 */     return (Role)getObjectById(id);
/*     */   }
/*     */   public List<Role> getSecurityRoleList(PageInfo pageInfo) {
/* 218 */     return super.getList(pageInfo);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.impl.RoleManagerImpl
 * JD-Core Version:    0.6.0
 */