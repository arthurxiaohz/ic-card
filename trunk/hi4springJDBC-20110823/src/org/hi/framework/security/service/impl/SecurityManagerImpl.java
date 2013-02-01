/*     */ package org.hi.framework.security.service.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.model.UserGroup;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ import org.hi.framework.security.service.SecurityManager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.springframework.dao.DataAccessException;
/*     */ import org.springframework.dao.DataIntegrityViolationException;
/*     */ 
/*     */ public class SecurityManagerImpl extends ManagerImpl
/*     */   implements SecurityManager
/*     */ {
/*  32 */   private Class userClass = HiUser.class;
/*  33 */   private Class userAuthorityClass = UserAuthority.class;
/*  34 */   private Class userRoleClass = UserRole.class;
/*  35 */   private Class userGroupClass = UserGroup.class;
/*     */ 
/*     */   public HiUser getUser(String username)
/*     */   {
/*  41 */     Filter filter = FilterFactory.getSimpleFilter("userName", username, "=");
/*  42 */     HiUser user = (HiUser)getUniqueObject(this.userClass, filter);
/*  43 */     return user;
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthorities(HiUser user)
/*     */     throws DataAccessException
/*     */   {
/*  51 */     Filter filter = null;
/*  52 */     List userAuthorities = null;
/*  53 */     if ((user.getUserMgrType() == null) || (user.getUserMgrType().intValue() != 1400)) {
/*  54 */       filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), "=");
/*  55 */       userAuthorities = getObjects(this.userAuthorityClass, filter);
/*     */     } else {
/*  57 */       userAuthorities = new ArrayList();
/*  58 */       List authorities = getObjects(Authority.class);
/*  59 */       for (Authority authority : authorities) {
/*  60 */         UserAuthority userAuthority = new UserAuthority();
/*  61 */         userAuthority.setAuthority(authority);
/*  62 */         userAuthority.setSecurityUser(user);
/*  63 */         userAuthorities.add(userAuthority);
/*     */       }
/*     */     }
/*     */ 
/*  67 */     if (userAuthorities == null) {
/*  68 */       throw new DataIntegrityViolationException("user:" + user.getFullName() + " havn't userAuthorities");
/*     */     }
/*     */ 
/*  71 */     Collections.sort(userAuthorities, new Comparator()
/*     */     {
/*     */       public int compare(Object o1, Object o2) {
/*  74 */         UserAuthority userAththority1 = (UserAuthority)o1;
/*  75 */         UserAuthority userAththority2 = (UserAuthority)o2;
/*  76 */         String authorityName1 = userAththority1.getAuthority().getAuthorityName();
/*  77 */         String authorityName2 = userAththority2.getAuthority().getAuthorityName();
/*  78 */         int strCompar = authorityName1.compareTo(authorityName2);
/*  79 */         if (strCompar < 0)
/*  80 */           return -1;
/*  81 */         if (strCompar > 0)
/*  82 */           return 1;
/*  83 */         return 0;
/*     */       }
/*     */     });
/*  88 */     return userAuthorities;
/*     */   }
/*     */ 
/*     */   public List<UserRole> getUserRoles(HiUser user)
/*     */   {
/*  96 */     Filter filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), "=");
/*  97 */     return getObjects(this.userRoleClass, filter);
/*     */   }
/*     */ 
/*     */   public List<UserGroup> getUserGroups(HiUser user)
/*     */   {
/* 105 */     Filter filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId(), "=");
/* 106 */     return getObjects(this.userGroupClass, filter);
/*     */   }
/*     */ 
/*     */   public UserContext getUserContext(String username)
/*     */     throws DataAccessException
/*     */   {
/* 113 */     HiUser user = getUser(username);
/*     */ 
/* 115 */     if (user == null) {
/* 116 */       return null;
/*     */     }
/* 118 */     UserContext userContext = new UserContext(user);
/* 119 */     userContext.setUserAuthorities(getUserAuthorities(user));
/* 120 */     if ((user.getUserMgrType() != null) && (user.getUserMgrType().intValue() == 1400)) {
/* 121 */       return userContext;
/*     */     }
/* 123 */     userContext.setUserRoles(getUserRoles(user));
/* 124 */     userContext.setUserGroups(getUserGroups(user));
/* 125 */     return userContext;
/*     */   }
/*     */ 
/*     */   public void setUserClass(Class userClass) {
/* 129 */     this.userClass = userClass;
/*     */   }
/*     */ 
/*     */   public void setUserAuthorityClass(Class userAuthorityClass) {
/* 133 */     this.userAuthorityClass = userAuthorityClass;
/*     */   }
/*     */ 
/*     */   public void setUserRoleClass(Class userRoleClass) {
/* 137 */     this.userRoleClass = userRoleClass;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.impl.SecurityManagerImpl
 * JD-Core Version:    0.6.0
 */