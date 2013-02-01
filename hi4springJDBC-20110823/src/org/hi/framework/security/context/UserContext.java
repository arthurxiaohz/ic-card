/*     */ package org.hi.framework.security.context;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.acegisecurity.BadCredentialsException;
/*     */ import org.acegisecurity.ConfigAttribute;
/*     */ import org.acegisecurity.ConfigAttributeDefinition;
/*     */ import org.acegisecurity.GrantedAuthority;
/*     */ import org.acegisecurity.intercept.web.AbstractFilterInvocationDefinitionSource;
/*     */ import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
/*     */ import org.acegisecurity.userdetails.UserDetails;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.base.menu.service.MenuLinkManager;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.model.UserGroup;
/*     */ import org.hi.framework.security.model.UserRole;
/*     */ 
/*     */ public class UserContext
/*     */   implements UserDetails
/*     */ {
/*  50 */   protected final Log log = LogFactory.getLog(getClass());
/*     */   private static final long serialVersionUID = -9145437693158151566L;
/*     */   private HiUser user;
/*     */   private List<UserAuthority> userAuthorities;
/*     */   private List<UserRole> userRoles;
/*     */   private List<UserGroup> userGroups;
/*     */   private Map<String, List<UserAuthority>> authorityNameList;
/*  57 */   private Set<String> userMenuUrls = null;
/*     */ 
/*     */   public UserContext(HiUser user) {
/*  60 */     String username = user.getUserName();
/*  61 */     if ((username == null) || ("".equals(username)) || (user.getPassword() == null) || (user.getPassword().equals(""))) {
/*  62 */       throw new BadCredentialsException("Cannot pass null or empty values to constructor,密码为空");
/*     */     }
/*  64 */     this.user = user;
/*     */   }
/*     */ 
/*     */   public HiUser getUser()
/*     */   {
/*  72 */     HiUser _user = (HiUser)BeanUtil.CreateObject(this.user.getClass().getName());
/*  73 */     BeanUtil.setBean2Bean(this.user, _user);
/*  74 */     return _user;
/*     */   }
/*     */ 
/*     */   public void setUser(HiUser user) {
/*  78 */     this.user = user;
/*     */   }
/*     */ 
/*     */   public HiOrg getOrg()
/*     */   {
/*  86 */     return getUser().getOrg();
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthorities()
/*     */   {
/*  94 */     return this.userAuthorities;
/*     */   }
/*     */ 
/*     */   public void setUserAuthorities(List<UserAuthority> userAuthorities) {
/*  98 */     this.userAuthorities = userAuthorities;
/*     */   }
/*     */ 
/*     */   public List<UserRole> getUserRoles()
/*     */   {
/* 106 */     return this.userRoles;
/*     */   }
/*     */ 
/*     */   public void setUserRoles(List<UserRole> userRoles) {
/* 110 */     this.userRoles = userRoles;
/*     */   }
/*     */ 
/*     */   public List<UserGroup> getUserGroups()
/*     */   {
/* 118 */     return this.userGroups;
/*     */   }
/*     */ 
/*     */   public void setUserGroups(List<UserGroup> userGroups) {
/* 122 */     this.userGroups = userGroups;
/*     */   }
/*     */ 
/*     */   public boolean isSupperManager()
/*     */   {
/* 130 */     return this.user.isSupperManager();
/*     */   }
/*     */ 
/*     */   public boolean isManager()
/*     */   {
/* 138 */     if (this.user.getUserMgrType() == null)
/* 139 */       return false;
/* 140 */     return this.user.getUserMgrType().equals(Integer.valueOf(1401));
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/* 151 */     return this.user.getFullName();
/*     */   }
/*     */ 
/*     */   public Integer getUserId()
/*     */   {
/* 159 */     return this.user.getId();
/*     */   }
/*     */ 
/*     */   public String getOrgName()
/*     */   {
/* 167 */     if (this.user.getOrg() == null) {
/* 168 */       return null;
/*     */     }
/* 170 */     return this.user.getOrg().getOrgName();
/*     */   }
/*     */ 
/*     */   public Integer getOrgId()
/*     */   {
/* 178 */     if (this.user.getOrg() == null) {
/* 179 */       return null;
/*     */     }
/* 181 */     return this.user.getOrg().getId();
/*     */   }
/*     */ 
/*     */   public HiUser getLeader()
/*     */   {
/* 189 */     if (getOrg() == null) {
/* 190 */       return null;
/*     */     }
/* 192 */     return getOrg().getManager();
/*     */   }
/*     */ 
/*     */   public Map<String, List<UserAuthority>> getAuthorityNameList()
/*     */   {
/* 203 */     if (this.userAuthorities.size() == 0)
/* 204 */       return null;
/* 205 */     if (this.authorityNameList != null) {
/* 206 */       return this.authorityNameList;
/*     */     }
/* 208 */     Map authorityNameList = new HashMap();
/* 209 */     String previousAuthorityName = "";
/* 210 */     List nameUserAuthorities = new ArrayList();
/* 211 */     for (int i = 0; i < this.userAuthorities.size(); i++) {
/* 212 */       UserAuthority userAuthority = (UserAuthority)this.userAuthorities.get(i);
/* 213 */       String authorityName = userAuthority.getAuthority().getAuthorityName();
/* 214 */       if (authorityName.equalsIgnoreCase(previousAuthorityName)) {
/* 215 */         nameUserAuthorities.add(userAuthority);
/*     */       }
/*     */       else {
/* 218 */         previousAuthorityName = authorityName;
/* 219 */         if (i > 0) {
/* 220 */           nameUserAuthorities = new ArrayList();
/*     */         }
/* 222 */         authorityNameList.put(authorityName, nameUserAuthorities);
/* 223 */         nameUserAuthorities.add(userAuthority);
/*     */       }
/*     */     }
/* 226 */     this.authorityNameList = authorityNameList;
/* 227 */     return this.authorityNameList;
/*     */   }
/*     */ 
/*     */   public Set<String> getUserMenuUrls()
/*     */   {
/* 236 */     if (this.userMenuUrls != null) {
/* 237 */       return this.userMenuUrls;
/*     */     }
/* 239 */     Set result = new HashSet();
/* 240 */     FilterSecurityInterceptor filterInvocationInterceptor = (FilterSecurityInterceptor)SpringContextHolder.getBean("filterInvocationInterceptor");
/*     */ 
/* 242 */     AbstractFilterInvocationDefinitionSource invocationDefinitionSource = (AbstractFilterInvocationDefinitionSource)filterInvocationInterceptor.getObjectDefinitionSource();
/* 243 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 244 */     List MenuLinks = menuLinkMgr.getObjects();
/*     */ 
/* 247 */     Map configAttributes = new HashMap();
/*     */     ConfigAttribute configAttribute;
/* 250 */     for (MenuLink link : MenuLinks) {
/* 251 */       String url = link.getLinkUrl();
/* 252 */       if (url == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 256 */       if (StringUtils.isIncludes(url, "?")) {
/* 257 */         url = url.substring(0, url.indexOf("?"));
/*     */       }
/*     */ 
/* 260 */       ConfigAttributeDefinition configAttributeDefintion = invocationDefinitionSource.lookupAttributes(url);
/*     */ 
/* 262 */       if (configAttributeDefintion == null) {
/* 263 */         result.add(url);
/*     */       }
/*     */       else
/*     */       {
/* 267 */         Iterator iterator = configAttributeDefintion.getConfigAttributes();
/* 268 */         while (iterator.hasNext()) {
/* 269 */           configAttribute = (ConfigAttribute)iterator.next();
/* 270 */           if (configAttributes.get(configAttribute.getAttribute()) == null) {
/* 271 */             Set urls = new HashSet();
/* 272 */             urls.add(url);
/* 273 */             configAttributes.put(configAttribute.getAttribute(), urls);
/*     */           }
/*     */           else {
/* 276 */             ((Set)configAttributes.get(configAttribute.getAttribute())).add(url);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 282 */     for (UserAuthority userAuthority : this.userAuthorities) {
/* 283 */       if ((userAuthority.getAuthority() == null) || (userAuthority.getAuthority().getAuthorityName() == null))
/*     */         continue;
/* 285 */       String authorityName = userAuthority.getAuthority().getAuthorityName();
/* 286 */       if (configAttributes.get(authorityName) != null) {
/* 287 */         Set urls = (Set)configAttributes.get(authorityName);
/* 288 */         for (String url : urls) {
/* 289 */           result.add(url);
/*     */         }
/*     */       }
/*     */     }
/* 293 */     this.userMenuUrls = result;
/* 294 */     return this.userMenuUrls;
/*     */   }
/*     */ 
/*     */   public GrantedAuthority[] getAuthorities()
/*     */   {
/* 305 */     GrantedAuthority[] authorities = new GrantedAuthority[this.userAuthorities.size()];
/* 306 */     for (int i = 0; i < this.userAuthorities.size(); i++) {
/* 307 */       Authority authority = ((UserAuthority)this.userAuthorities.get(i)).getAuthority();
/*     */ 
/* 309 */       if (authority == null) {
/* 310 */         this.log.error("user:" + this.user.getFullName() + " in authorities is null");
/*     */       }
/* 312 */       authorities[i] = authority;
/*     */     }
/* 314 */     return authorities;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 321 */     return this.user.getPassword();
/*     */   }
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 328 */     return this.user.getUserName();
/*     */   }
/*     */ 
/*     */   public boolean isAccountNonExpired()
/*     */   {
/* 335 */     Date expiredDate = this.user.getExpiredDate();
/*     */ 
/* 337 */     if (expiredDate == null) {
/* 338 */       return true;
/*     */     }
/*     */ 
/* 342 */     return expiredDate.getTime() >= System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public boolean isAccountNonLocked()
/*     */   {
/* 351 */     if (this.user.getAccountLocked() == null) {
/* 352 */       return true;
/*     */     }
/* 354 */     return this.user.getAccountLocked().intValue() == 3201;
/*     */   }
/*     */ 
/*     */   public boolean isCredentialsNonExpired()
/*     */   {
/* 361 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isEnabled()
/*     */   {
/* 368 */     if (this.user.getAccountEnabled() == null)
/* 369 */       return true;
/* 370 */     return this.user.getAccountEnabled().intValue() == 3200;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.context.UserContext
 * JD-Core Version:    0.6.0
 */