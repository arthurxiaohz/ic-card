package org.hi.framework.security.action.struts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.security.action.RolePageInfo;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.security.service.RoleAuthorityManager;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class RoleAction extends BaseAction{
	private Role role;
	private RolePageInfo pageInfo;
	private List<Role> roles;
	private String orderIndexs;
	private List<RoleAuthority> roleAuthorities;
	private String roleAuthorityIndex;
	private List<Menu> menus;
	private List<HiOrg> orgs;
	private String showMode = HiConfigHolder.getSecurityOrgShowMode();
	
	/**
	 * 新增/修改保存角色
	 * @deprecated 该方法已废弃
	 * @see rg.hi.framework.security.action.struts.RoleSaveAction
	 */
	public String saveRole() throws Exception {
		if(super.perExecute(null)!= null) return returnCommand();
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		Filter filter = FilterFactory.getSimpleFilter("roleName", role.getRoleName(), Filter.OPERATOR_EQ);
		List<Role> roles = roleMgr.getObjects(filter);
		
		if((role.getId() == null && roles.size() > 0) || (role.getId() != null && roles.size() > 1) )
			throw new BusinessException(I18NUtil.getStringByParameter("角色名重复", "Role", role.getRoleName()));
		String[] indexs = null;
		if(roleAuthorityIndex != null)
			indexs= roleAuthorityIndex.split(",");
		
		if(roles.size() == 0)
			roles.add(new Role());
		
		Role _role = this.role;
		
		_role.setDescription(role.getDescription());
		_role.setDisplayRef(role.getDisplayRef());
		_role.setRoleName(role.getRoleName());
		_role.setVersion(role.getVersion());
		roleMgr.saveRoleAndAuthority(role, roleAuthorities, indexs);
		
		super.postExecute(null);
		return returnCommand();
	}
	
	
	/**
	 * 删除角色
	 */
	public String removeRole() throws Exception {
		if(UserContextHelper.getUser().getUserMgrType() == null || 
				UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MENUAL){
			throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
		}
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		role = roleMgr.getRoleById(role.getId());
		HiUser currentUsre = UserContextHelper.getUser();
		
		if(currentUsre.getUserMgrType() == UserType.USERTYPE_MANAGER && (role.getCreator() == null 
			|| !role.getCreator().equals(currentUsre)))
			throw new BusinessException(I18NUtil.getString("您的用户类型为管理员,只能删除您自己所创建的角色", "Role"));
		
		roleMgr.removeRoleUserAuthority(role.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些角色
	 */
	public String removeAllRole() throws Exception {
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer roleid = new Integer( ids[i] );
				roleMgr.removeRoleById(roleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看角色
	 */
	public String viewRole() throws Exception {
		if(UserContextHelper.getUser().getUserMgrType() == null)
			throw new BusinessException(I18NUtil.getString("系统无法识别您的用户类型"));
		
		if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MENUAL){
			throw new BusinessException(I18NUtil.getString("您是一般用户,不能修改与创建角色", "Role"));
		}
		
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		role = roleMgr.getRoleById(role.getId());
		
		if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER && 
				(role.getCreator() == null || !role.getCreator().equals(UserContextHelper.getUser()))){
			throw new BusinessException(I18NUtil.getString("您的用户是管理员,所以只能编辑您自己创建的角色!", "Role"));
		}
		
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.sequence");
		
		roleAuthorities = getRoleAuthority(authorityMgr.getObjects());
		
		menus = new LinkedList<Menu>();
		sorter = SorterFactory.getSimpleSort("menu.sequence");
		List<MenuLink> menuLinks = menuLinkMgr.getObjects(null, sorter);
		for (MenuLink menuLink : menuLinks) {
			Menu menu = menuLink.getMenu();
			boolean has = false;
			for (Menu _menu : menus) {
				if(menu.getId().equals(_menu.getId())){
					has = true;
					break;
				}
			}
			if(!has){
				
				if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR)
					menus.add(menu);
				
				if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER && 
						UserContextHelper.getUserContext().getUserMenuUrls().contains(menuLink.getLinkUrl()) &&
						menu.getId() != 2000) //不添加安全菜单
					menus.add(menu);
			}
		}
		
		return returnCommand();
	}
	
	/**
	 * 角色列表
	 */
	public String roleList() throws Exception {
		return returnCommand();	
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public RolePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(RolePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
	private List<RoleAuthority> getRoleAuthority(List<Authority> authorties){
		RoleAuthorityManager roleAuMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		List<RoleAuthority> currnt =  new ArrayList<RoleAuthority>();
		if(role.getId() != null){
		Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
		currnt = roleAuMgr.getObjects(filter);
		}
		List<RoleAuthority> result = new ArrayList<RoleAuthority>();
		
		for (Authority authority : authorties) {
			boolean hasAuthortie = false;
			for (RoleAuthority roleAuth : currnt) {
				if(roleAuth.getAuthority().getAuthorityName().equals(authority.getAuthorityName())){
					hasAuthortie = true;
					
					if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR ||
							(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER &&
									UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) !=null)
							){
						result.add(roleAuth);
						break;
					}
				}
			}
			
			if(hasAuthortie)
				continue;
			if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR||
					(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER &&
							UserContextHelper.getUserContext().getAuthorityNameList().get(authority.getAuthorityName()) !=null)
					){
				RoleAuthority roleAuthority = new RoleAuthority();
				roleAuthority.setAuthority(authority);
				result.add(roleAuthority);
			}
		}
		
		return result;
	}


	public List<RoleAuthority> getRoleAuthorities() {
		return roleAuthorities;
	}


	public void setRoleAuthorities(List<RoleAuthority> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}


	public String getRoleAuthorityIndex() {
		return roleAuthorityIndex;
	}


	public void setRoleAuthorityIndex(String roleAuthorityIndex) {
		this.roleAuthorityIndex = roleAuthorityIndex;
	}


	public List<Menu> getMenus() {
		return menus;
	}


	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}


	public String getShowMode() {
		return showMode;
	}


	public void setShowMode(String showMode) {
		this.showMode = showMode;
	}
	
	public List<HiOrg> getOrgs() {
		if(orgs == null){
			HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
			orgs = orgMgr.getObjects();
		}
		return orgs;
	}
	
}
