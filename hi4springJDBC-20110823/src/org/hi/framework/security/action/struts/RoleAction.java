/*     */ package org.hi.framework.security.action.struts;
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
/*     */ import org.hi.base.organization.action.HiOrgPageInfo;
/*     */ import org.hi.base.organization.model.HiOrg;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiOrgManager;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.Sorter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.hi.framework.dao.impl.SorterFactory;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.security.action.RolePageInfo;
/*     */ import org.hi.framework.security.context.UserContext;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.security.model.Authority;
/*     */ import org.hi.framework.security.model.Role;
/*     */ import org.hi.framework.security.model.RoleAuthority;
/*     */ import org.hi.framework.security.model.UserAuthority;
/*     */ import org.hi.framework.security.service.AuthorityManager;
/*     */ import org.hi.framework.security.service.RoleAuthorityManager;
/*     */ import org.hi.framework.security.service.RoleManager;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class RoleAction extends BaseAction
/*     */ {
/*     */   private Role role;
/*     */   private RolePageInfo pageInfo;
/*     */   private List<Role> roles;
/*     */   private String orderIndexs;
/*     */   private List<RoleAuthority> roleAuthorities;
/*     */   private String roleAuthorityIndex;
/*     */   private List<Menu> menus;
/*     */   private List<HiOrg> orgs;
/*  45 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*     */ 
/*     */   /** @deprecated */
/*     */   public String saveRole()
/*     */     throws Exception
/*     */   {
/*  53 */     if (super.perExecute(null) != null) return returnCommand();
/*  54 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/*  55 */     Filter filter = FilterFactory.getSimpleFilter("roleName", this.role.getRoleName(), "=");
/*  56 */     List roles = roleMgr.getObjects(filter);
/*     */ 
/*  58 */     if (((this.role.getId() == null) && (roles.size() > 0)) || ((this.role.getId() != null) && (roles.size() > 1)))
/*  59 */       throw new BusinessException(I18NUtil.getStringByParameter("角色名重复", "Role", this.role.getRoleName()));
/*  60 */     String[] indexs = (String[])null;
/*  61 */     if (this.roleAuthorityIndex != null) {
/*  62 */       indexs = this.roleAuthorityIndex.split(",");
/*     */     }
/*  64 */     if (roles.size() == 0) {
/*  65 */       roles.add(new Role());
/*     */     }
/*  67 */     Role _role = this.role;
/*     */ 
/*  69 */     _role.setDescription(this.role.getDescription());
/*  70 */     _role.setDisplayRef(this.role.getDisplayRef());
/*  71 */     _role.setRoleName(this.role.getRoleName());
/*  72 */     _role.setVersion(this.role.getVersion());
/*  73 */     roleMgr.saveRoleAndAuthority(this.role, this.roleAuthorities, indexs);
/*     */ 
/*  75 */     super.postExecute(null);
/*  76 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeRole()
/*     */     throws Exception
/*     */   {
/*  84 */     if ((UserContextHelper.getUser().getUserMgrType() == null) || 
/*  85 */       (UserContextHelper.getUser().getUserMgrType().intValue() == 1402)) {
/*  86 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
/*     */     }
/*  88 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/*  89 */     this.role = roleMgr.getRoleById(this.role.getId());
/*  90 */     HiUser currentUsre = UserContextHelper.getUser();
/*     */ 
/*  92 */     if ((currentUsre.getUserMgrType().intValue() == 1401) && ((this.role.getCreator() == null) || 
/*  93 */       (!this.role.getCreator().equals(currentUsre)))) {
/*  94 */       throw new BusinessException(I18NUtil.getString("您的用户类型为管理员,只能删除您自己所创建的角色", "Role"));
/*     */     }
/*  96 */     roleMgr.removeRoleUserAuthority(this.role.getId());
/*  97 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllRole()
/*     */     throws Exception
/*     */   {
/* 104 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 105 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/* 107 */       String[] ids = this.orderIndexs.split(",");
/* 108 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/* 110 */         if (ids[i].length() <= 0)
/*     */           continue;
/* 112 */         Integer roleid = new Integer(ids[i]);
/* 113 */         roleMgr.removeRoleById(roleid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 118 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewRole()
/*     */     throws Exception
/*     */   {
/* 125 */     if (UserContextHelper.getUser().getUserMgrType() == null) {
/* 126 */       throw new BusinessException(I18NUtil.getString("系统无法识别您的用户类型"));
/*     */     }
/* 128 */     if (UserContextHelper.getUser().getUserMgrType().intValue() == 1402) {
/* 129 */       throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
/*     */     }
/*     */ 
/* 134 */     if ((UserContextHelper.getUser().getUserMgrType().intValue() == 1401) && 
/* 135 */       (this.role.getId().intValue() > 0) && (!this.role.getCreator().equals(UserContextHelper.getUser()))) {
/* 136 */       throw new BusinessException(I18NUtil.getString("您的用户是管理员,所以只能编辑您自己创建的角色!", "Role"));
/*     */     }
/*     */ 
/* 140 */     AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 141 */     RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
/* 142 */     this.role = roleMgr.getRoleById(this.role.getId());
/*     */ 
/* 144 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 145 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.sequence");
/*     */ 
/* 147 */     this.roleAuthorities = getRoleAuthority(authorityMgr.getObjects(null, sorter));
/*     */ 
/* 149 */     this.menus = new LinkedList();
/* 150 */     sorter = SorterFactory.getSimpleSort("menu.sequence");
/* 151 */     List menuLinks = menuLinkMgr.getObjects(null, sorter);
/* 152 */     for (MenuLink menuLink : menuLinks) {
/* 153 */       Menu menu = menuLink.getMenu();
/* 154 */       boolean has = false;
/* 155 */       for (Menu _menu : this.menus) {
/* 156 */         if (menu.getId().equals(_menu.getId())) {
/* 157 */           has = true;
/* 158 */           break;
/*     */         }
/*     */       }
/* 161 */       if (has)
/*     */         continue;
/* 163 */       if (UserContextHelper.getUser().getUserMgrType().intValue() == 1400) {
/* 164 */         this.menus.add(menu);
/*     */       }
/* 166 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 167 */         (!UserContextHelper.getUserContext().getUserMenuUrls().contains(menuLink.getLinkUrl())) || 
/* 168 */         (menu.getId().intValue() == 2000)) continue;
/* 169 */       this.menus.add(menu);
/*     */     }
/*     */ 
/* 173 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String roleList()
/*     */     throws Exception
/*     */   {
/* 180 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Role getRole()
/*     */   {
/* 187 */     return this.role;
/*     */   }
/*     */ 
/*     */   public void setRole(Role role) {
/* 191 */     this.role = role;
/*     */   }
/*     */ 
/*     */   public List<Role> getRoles() {
/* 195 */     return this.roles;
/*     */   }
/*     */ 
/*     */   public void setRoles(List<Role> roles) {
/* 199 */     this.roles = roles;
/*     */   }
/*     */ 
/*     */   public RolePageInfo getPageInfo() {
/* 203 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(RolePageInfo pageInfo) {
/* 207 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 211 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 215 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ 
/*     */   private List<RoleAuthority> getRoleAuthority(List<Authority> authorties) {
/* 219 */     RoleAuthorityManager roleAuMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 220 */     List currnt = new ArrayList();
/* 221 */     if (this.role.getId() != null) {
/* 222 */       Filter filter = FilterFactory.getSimpleFilter("role.id", this.role.getId(), "=");
/* 223 */       currnt = roleAuMgr.getObjects(filter);
/*     */     }
/* 225 */     List result = new ArrayList();
/*     */ 
/* 227 */     for (Authority authority : authorties) {
/* 228 */       boolean hasAuthortie = false;
/* 229 */       for (RoleAuthority roleAuth : currnt) {
/* 230 */         if (roleAuth.getAuthority().getAuthorityName().equals(authority.getAuthorityName())) {
/* 231 */           hasAuthortie = true;
/*     */ 
/* 233 */           if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 234 */             (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 235 */             (UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) == null)))
/*     */             continue;
/* 237 */           result.add(roleAuth);
/* 238 */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 243 */       if (hasAuthortie)
/*     */         continue;
/* 245 */       List list = (List)UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName());
/* 246 */       if ((UserContextHelper.getUser().getUserMgrType().intValue() != 1400) && (
/* 247 */         (UserContextHelper.getUser().getUserMgrType().intValue() != 1401) || 
/* 248 */         (list == null)))
/*     */         continue;
/* 250 */       RoleAuthority roleAuthority = new RoleAuthority();
/* 251 */       roleAuthority.setAuthority(authority);
/* 252 */       roleAuthority.setScope(((UserAuthority)list.get(0)).getScope());
/* 253 */       result.add(roleAuthority);
/*     */     }
/*     */ 
/* 257 */     return result;
/*     */   }
/*     */ 
/*     */   public List<RoleAuthority> getRoleAuthorities()
/*     */   {
/* 262 */     return this.roleAuthorities;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthorities(List<RoleAuthority> roleAuthorities)
/*     */   {
/* 267 */     this.roleAuthorities = roleAuthorities;
/*     */   }
/*     */ 
/*     */   public String getRoleAuthorityIndex()
/*     */   {
/* 272 */     return this.roleAuthorityIndex;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthorityIndex(String roleAuthorityIndex)
/*     */   {
/* 277 */     this.roleAuthorityIndex = roleAuthorityIndex;
/*     */   }
/*     */ 
/*     */   public List<Menu> getMenus()
/*     */   {
/* 282 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public void setMenus(List<Menu> menus)
/*     */   {
/* 287 */     this.menus = menus;
/*     */   }
/*     */ 
/*     */   public String getShowMode()
/*     */   {
/* 292 */     return this.showMode;
/*     */   }
/*     */ 
/*     */   public void setShowMode(String showMode)
/*     */   {
/* 297 */     this.showMode = showMode;
/*     */   }
/*     */ 
/*     */   public List<HiOrg> getOrgs() {
/* 301 */     if (this.orgs == null) {
/* 302 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/*     */ 
/* 306 */       HiOrgPageInfo pageInfo = new HiOrgPageInfo();
/* 307 */       pageInfo.setPageSize(2147483647);
/*     */ 
/* 309 */       PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, null);
/* 310 */       this.orgs = orgMgr.getSecurityHiOrgList(sarchPageInfo);
/*     */     }
/* 312 */     return this.orgs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.RoleAction
 * JD-Core Version:    0.6.0
 */