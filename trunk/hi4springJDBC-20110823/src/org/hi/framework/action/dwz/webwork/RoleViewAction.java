/*     */ package org.hi.framework.action.dwz.webwork;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
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
/*  37 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*  38 */   private Map<Menu, List<Authority>> map = new HashMap();
/*     */ 
/*     */   public String execute() throws Exception {
/*  41 */     if (UserContextHelper.getUser().getUserMgrType() == null) {
/*  42 */       throw new BusinessException(I18NUtil.getString("系统无法识别您的用户类型"));
/*     */     }
/*  44 */     if (UserContextHelper.getUser().getUserMgrType().intValue() == 1402) {
/*  45 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
/*     */     }
/*     */ 
/*  48 */     if ((UserContextHelper.getUser().getUserMgrType().intValue() == 1401) && 
/*  49 */       (this.role.getId().intValue() > 0) && (this.role.getCreator().equals(UserContextHelper.getUser()))) {
/*  50 */       throw new BusinessException(I18NUtil.getString("您的用户是管理员,所以只能编辑您自己创建的角色!", "Role"));
/*     */     }
/*     */ 
/*  54 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/*  55 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/*  56 */     this.role = roleMgr.getRoleById(this.role.getId());
/*     */ 
/*  58 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  59 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.sequence");
/*     */ 
/*  61 */     this.roleAuthorities = getRoleAuthority(authorityMgr.getObjects(null, sorter));
/*     */ 
/*  63 */     this.menus = new LinkedList();
/*  64 */     sorter = SorterFactory.getSimpleSort("menu.sequence");
/*  65 */     List menuLinks = menuLinkMgr.getObjects(null, sorter);
/*  66 */     for (MenuLink menuLink : menuLinks) {
/*  67 */       Menu menu = menuLink.getMenu();
/*  68 */       boolean has = false;
/*  69 */       for (Menu _menu : this.menus) {
/*  70 */         if (menu.getId().equals(_menu.getId())) {
/*  71 */           has = true;
/*  72 */           break;
/*     */         }
/*     */       }
/*  75 */       if (has)
/*     */         continue;
/*  77 */       if (UserContextHelper.getUser().getUserMgrType().intValue() == 1400) {
/*  78 */         this.menus.add(menu);
/*     */       }
/*  80 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/*  81 */         (!UserContextHelper.getUserContext().getUserMenuUrls().contains(menuLink.getLinkUrl())) || 
/*  82 */         (menu.getId().intValue() == 2000)) continue;
/*  83 */       this.menus.add(menu);
/*     */     }
/*     */ 
/*  87 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Role getRole() {
/*  91 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/*  95 */     this.role = role;
/*     */   }
/*     */ 
/*     */   private List<RoleAuthority> getRoleAuthority(List<Authority> authorties)
/*     */   {
/* 100 */     RoleAuthorityManager roleAuMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 101 */     List currnt = new ArrayList();
/* 102 */     if (this.role.getId() != null) {
/* 103 */       Filter filter = FilterFactory.getSimpleFilter("role.id", this.role.getId(), "=");
/* 104 */       currnt = roleAuMgr.getObjects(filter);
/*     */     }
/* 106 */     List result = new ArrayList();
/*     */ 
/* 108 */     for (Authority authority : authorties) {
/* 109 */       boolean hasAuthortie = false;
/* 110 */       for (RoleAuthority roleAuth : currnt) {
/* 111 */         if (roleAuth.getAuthority().getAuthorityName().equals(authority.getAuthorityName())) {
/* 112 */           hasAuthortie = true;
/*     */ 
/* 114 */           if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 115 */             (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 116 */             (UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) == null)))
/*     */             continue;
/* 118 */           result.add(roleAuth);
/* 119 */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 124 */       if (hasAuthortie)
/*     */         continue;
/* 126 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 127 */         (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 128 */         (UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) == null)))
/*     */         continue;
/* 130 */       RoleAuthority roleAuthority = new RoleAuthority();
/* 131 */       roleAuthority.setAuthority(authority);
/* 132 */       result.add(roleAuthority);
/*     */     }
/*     */ 
/* 136 */     return result;
/*     */   }
/*     */ 
/*     */   public List<HiOrg> getOrgs() {
/* 140 */     if (this.orgs == null) {
/* 141 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 142 */       this.orgs = orgMgr.getObjects();
/*     */     }
/* 144 */     return this.orgs;
/*     */   }
/*     */ 
/*     */   public String getShowMode() {
/* 148 */     return this.showMode;
/*     */   }
/*     */ 
/*     */   public List<Menu> getMenus() {
/* 152 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public List<RoleAuthority> getRoleAuthorities() {
/* 156 */     return this.roleAuthorities;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.action.dwz.webwork.RoleViewAction
 * JD-Core Version:    0.6.0
 */