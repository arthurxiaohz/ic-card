/*     */ package org.hi.framework.security.action.webwork;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.base.menu.service.MenuLinkManager;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.Role;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.service.AuthorityManager;
/*     */ import org.hi.framework.security.service.RoleAuthorityManager;
/*     */ import org.hi.framework.security.service.RoleManager;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.webwork.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class RoleViewAction extends BaseAction
/*     */ {
/*     */   private Role role;
/*     */   private List<RoleAuthority> roleAuthorities;
/*     */   private List<HiOrg> orgs;
/*     */   private List<Menu> menus;
/*  35 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*     */ 
/*     */   public String execute() throws Exception
/*     */   {
/*  39 */     if (UserContextHelper.getUser().getUserMgrType() == null) {
/*  40 */       throw new BusinessException(I18NUtil.getString("系统无法识别您的用户类型"));
/*     */     }
/*  42 */     if (UserContextHelper.getUser().getUserMgrType().intValue() == 1402) {
/*  43 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
/*     */     }
/*     */ 
/*  46 */     if ((UserContextHelper.getUser().getUserMgrType().intValue() == 1401) && 
/*  47 */       (this.role.getId().intValue() > 0) && (this.role.getCreator().equals(UserContextHelper.getUser()))) {
/*  48 */       throw new BusinessException(I18NUtil.getString("您的用户是管理员,所以只能编辑您自己创建的角色!", "Role"));
/*     */     }
/*     */ 
/*  52 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  53 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/*  54 */     this.role = roleMgr.getRoleById(this.role.getId());
/*     */ 
/*  56 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  57 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.sequence");
/*     */ 
/*  59 */     this.roleAuthorities = getRoleAuthority(authorityMgr.getObjects(null, sorter));
/*     */ 
/*  61 */     this.menus = new LinkedList();
/*  62 */     sorter = SorterFactory.getSimpleSort("menu.sequence");
/*  63 */     List menuLinks = menuLinkMgr.getObjects(null, sorter);
/*  64 */     for (MenuLink menuLink : menuLinks) {
/*  65 */       Menu menu = menuLink.getMenu();
/*  66 */       boolean has = false;
/*  67 */       for (Menu _menu : this.menus) {
/*  68 */         if (menu.getId().equals(_menu.getId())) {
/*  69 */           has = true;
/*  70 */           break;
/*     */         }
/*     */       }
/*  73 */       if (has)
/*     */         continue;
/*  75 */       if (UserContextHelper.getUser().getUserMgrType().intValue() == 1400) {
/*  76 */         this.menus.add(menu);
/*     */       }
/*  78 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/*  79 */         (!UserContextHelper.getUserContext().getUserMenuUrls().contains(menuLink.getLinkUrl())) || 
/*  80 */         (menu.getId().intValue() == 2000)) continue;
/*  81 */       this.menus.add(menu);
/*     */     }
/*     */ 
/*  85 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Role getRole() {
/*  89 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/*  93 */     this.role = role;
/*     */   }
/*     */ 
/*     */   private List<RoleAuthority> getRoleAuthority(List<Authority> authorties)
/*     */   {
/*  98 */     RoleAuthorityManager roleAuMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/*  99 */     List currnt = new ArrayList();
/* 100 */     if (this.role.getId() != null) {
/* 101 */       Filter filter = FilterFactory.getSimpleFilter("role.id", this.role.getId(), "=");
/* 102 */       currnt = roleAuMgr.getObjects(filter);
/*     */     }
/* 104 */     List result = new ArrayList();
/*     */ 
/* 106 */     for (Authority authority : authorties) {
/* 107 */       boolean hasAuthortie = false;
/* 108 */       for (RoleAuthority roleAuth : currnt) {
/* 109 */         if (roleAuth.getAuthority().getAuthorityName().equals(authority.getAuthorityName())) {
/* 110 */           hasAuthortie = true;
/*     */ 
/* 112 */           if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 113 */             (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 114 */             (UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) == null)))
/*     */             continue;
/* 116 */           result.add(roleAuth);
/* 117 */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 122 */       if (hasAuthortie)
/*     */         continue;
/* 124 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 125 */         (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 126 */         (UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) == null)))
/*     */         continue;
/* 128 */       RoleAuthority roleAuthority = new RoleAuthority();
/* 129 */       roleAuthority.setAuthority(authority);
/* 130 */       result.add(roleAuthority);
/*     */     }
/*     */ 
/* 134 */     return result;
/*     */   }
/*     */ 
/*     */   public List<HiOrg> getOrgs() {
/* 138 */     if (this.orgs == null) {
/* 139 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 140 */       this.orgs = orgMgr.getObjects();
/*     */     }
/* 142 */     return this.orgs;
/*     */   }
/*     */ 
/*     */   public String getShowMode() {
/* 146 */     return this.showMode;
/*     */   }
/*     */ 
/*     */   public List<Menu> getMenus() {
/* 150 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public List<RoleAuthority> getRoleAuthorities() {
/* 154 */     return this.roleAuthorities;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleViewAction
 * JD-Core Version:    0.6.0
 */