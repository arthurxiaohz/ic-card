/*     */ package org.hi.framework.security.action.webwork;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.menu.service.MenuManager;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.service.AuthorityManager;
/*     */ import org.hi.framework.security.service.UserAuthorityManager;
/*     */ import org.hi.framework.web.webwork.BaseAction;
/*     */ 
/*     */ public class UserAuthoritySingleBatchViewAction extends BaseAction
/*     */ {
/*     */   private List<UserAuthority> userAuthorities;
/*     */   private List<HiOrg> orgs;
/*     */   private List<Menu> menus;
/*  27 */   private Integer userid = UserContextHelper.getUser().getId();
/*  28 */   private HiUser user = null;
/*  29 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*     */ 
/*     */   public String execute() throws Exception {
/*  32 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  33 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  34 */     HiUserManager uesrMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  35 */     if (this.user != null)
/*  36 */       this.user = uesrMgr.getHiUserById(this.user.getId());
/*     */     else {
/*  38 */       this.user = uesrMgr.getHiUserById(this.userid);
/*     */     }
/*  40 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.id");
/*  41 */     this.userAuthorities = getUserAuthority(authorityMgr.getObjects(null, sorter));
/*  42 */     this.menus = menuMgr.getObjects();
/*     */ 
/*  44 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   private List<UserAuthority> getUserAuthority(List<Authority> authorties) {
/*  48 */     UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
/*  49 */     List curent = userAuthorityMgr.getUserAuthority(this.user);
/*     */ 
/*  51 */     List result = new ArrayList();
/*  52 */     for (Authority authority : authorties) {
/*  53 */       boolean hasAuthortie = false;
/*  54 */       for (UserAuthority userAuthority : curent) {
/*  55 */         if (userAuthority.getAuthority().getAuthorityName().equals(authority.getAuthorityName())) {
/*  56 */           hasAuthortie = true;
/*  57 */           result.add(userAuthority);
/*  58 */           break;
/*     */         }
/*     */       }
/*     */ 
/*  62 */       if (hasAuthortie) {
/*     */         continue;
/*     */       }
/*  65 */       UserAuthority userAuthority = new UserAuthority();
/*  66 */       userAuthority.setAuthority(authority);
/*  67 */       result.add(userAuthority);
/*     */     }
/*     */ 
/*  71 */     return result;
/*     */   }
/*     */ 
/*     */   public List<HiOrg> getOrgs() {
/*  75 */     if (this.orgs == null) {
/*  76 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*  77 */       this.orgs = orgMgr.getObjects();
/*     */     }
/*  79 */     return this.orgs;
/*     */   }
/*     */ 
/*     */   public String getShowMode() {
/*  83 */     return this.showMode;
/*     */   }
/*     */ 
/*     */   public List<Menu> getMenus() {
/*  87 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public HiUser getUser() {
/*  91 */     return this.user;
/*     */   }
/*     */ 
/*     */   public void setUser(HiUser user) {
/*  95 */     this.user = user;
/*     */   }
/*     */ 
/*     */   public List<UserAuthority> getUserAuthorities() {
/*  99 */     return this.userAuthorities;
/*     */   }
/*     */ 
/*     */   public void setUserAuthorities(List<UserAuthority> userAuthorities) {
/* 103 */     this.userAuthorities = userAuthorities;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthoritySingleBatchViewAction
 * JD-Core Version:    0.6.0
 */