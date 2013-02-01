/*     */ package org.hi.framework.security.service.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.service.UserAuthorityManager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ 
/*     */ public class UserAuthorityManagerImpl extends ManagerImpl
/*     */   implements UserAuthorityManager
/*     */ {
/*     */   protected void preSaveObject(Object obj)
/*     */   {
/*  20 */     super.preSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postSaveObject(Object obj)
/*     */   {
/*  25 */     super.postSaveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void preRemoveObject(Object obj)
/*     */   {
/*  30 */     super.preRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   protected void postRemoveObject(Object obj)
/*     */   {
/*  35 */     super.postRemoveObject(obj);
/*     */   }
/*     */ 
/*     */   public void saveUserAuthority(UserAuthority UserAuthority)
/*     */   {
/*  40 */     saveObject(UserAuthority);
/*     */   }
/*     */ 
/*     */   public void removeUserAuthorityById(Integer id)
/*     */   {
/*  45 */     removeObjectById(id);
/*     */   }
/*     */ 
/*     */   public UserAuthority getUserAuthorityById(Integer id)
/*     */   {
/*  50 */     return (UserAuthority)getObjectById(id);
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthorityList(PageInfo pageInfo) {
/*  54 */     return super.getList(pageInfo);
/*     */   }
/*     */ 
/*     */   public void saveBatchUserAuthority(List<HiUser> users, List<UserAuthority> userAuthorities)
/*     */   {
/*  60 */     if ((users == null) || (users.size() < 0)) {
/*  61 */       return;
/*     */     }
/*  63 */     for (HiUser user : users)
/*     */     {
/*  65 */       for (UserAuthority userAuthority : userAuthorities) {
/*  66 */         if (userAuthority.getAuthority() == null) {
/*     */           continue;
/*     */         }
/*  69 */         UserAuthority persistence = new UserAuthority();
/*  70 */         persistence.setSecurityUser(user);
/*  71 */         persistence.setAuthority(userAuthority.getAuthority());
/*  72 */         persistence.setOrg(userAuthority.getOrg());
/*  73 */         persistence.setScope(userAuthority.getScope());
/*  74 */         userAuthority.setSecurityUser(user);
/*  75 */         saveUserAuthority(persistence);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthority(HiUser user) {
/*  81 */     Filter filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId());
/*  82 */     return getObjects(filter);
/*     */   }
/*     */ 
/*     */   public void saveBatchSingleUserAuthority(String[] indexs, List<UserAuthority> userAuthorities, HiUser user) {
/*  86 */     for (int i = 0; i < indexs.length; i++) {
/*  87 */       UserAuthority userAuthority = (UserAuthority)userAuthorities.get(Integer.parseInt(indexs[i].trim()));
/*  88 */       if (userAuthority.getId() == null) {
/*  89 */         userAuthority.setSecurityUser(user);
/*  90 */         saveUserAuthority(userAuthority);
/*     */       }
/*     */       else {
/*  93 */         UserAuthority persistent = getUserAuthorityById(userAuthority.getId());
/*  94 */         persistent.setAuthority(userAuthority.getAuthority());
/*  95 */         persistent.setOrg(userAuthority.getOrg());
/*  96 */         persistent.setSecurityUser(user);
/*  97 */         persistent.setScope(userAuthority.getScope());
/*  98 */         persistent.setRoleAuthority(userAuthority.getRoleAuthority());
/*  99 */         saveUserAuthority(persistent);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeUserAuthorityByUser(Integer userId) {
/* 105 */     Filter filter = FilterFactory.getSimpleFilter("securityUser.id", userId, "=");
/* 106 */     List userAuthoites = getObjects(filter);
/* 107 */     for (UserAuthority userAuthority : userAuthoites)
/* 108 */       removeObjectById(userAuthority.getId());
/*     */   }
/*     */ 
/*     */   public void removeUserAuthorityByRoleAuthority(RoleAuthority roleAuthority)
/*     */   {
/* 114 */     if ((roleAuthority == null) || (roleAuthority.getId() == null))
/* 115 */       return;
/* 116 */     Filter filter = FilterFactory.getSimpleFilter("roleAuthority.id", roleAuthority.getId(), "=");
/* 117 */     List userAuthoites = getObjects(filter);
/* 118 */     for (UserAuthority userAuthority : userAuthoites)
/* 119 */       removeObjectById(userAuthority.getId());
/*     */   }
/*     */ 
/*     */   public void saveSecurityUserAuthority(UserAuthority userAuthority)
/*     */   {
/* 124 */     saveObject(userAuthority);
/*     */   }
/*     */   public void removeSecurityUserAuthorityById(Integer id) {
/* 127 */     removeObjectById(id);
/*     */   }
/*     */   public UserAuthority getSecurityUserAuthorityById(Integer id) {
/* 130 */     return (UserAuthority)getObjectById(id);
/*     */   }
/*     */   public List<UserAuthority> getSecurityUserAuthorityList(PageInfo pageInfo) {
/* 133 */     return super.getList(pageInfo);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.impl.UserAuthorityManagerImpl
 * JD-Core Version:    0.6.0
 */