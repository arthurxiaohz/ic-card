package org.hi.framework.security.action.webwork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.security.service.RoleAuthorityManager;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class RoleViewAction extends BaseAction{
	private Role role;
	private List<RoleAuthority> roleAuthorities;
	private List<HiOrg> orgs;
	private List<Menu> menus;
	private String showMode = HiConfigHolder.getSecurityOrgShowMode();
	
	public String execute() throws Exception {
		
		if(UserContextHelper.getUser().getUserMgrType() == null)
			throw new BusinessException(I18NUtil.getString("ϵͳ�޷�ʶ�������û�����"));
		
		if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MENUAL){
			throw new BusinessException(I18NUtil.getString("����һ���û�,�����޸��봴����ɫ", "Role"));
		}
		
		if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER && 
				role.getId() > 0 && role.getCreator().equals(UserContextHelper.getUser())){
			throw new BusinessException(I18NUtil.getString("�����û��ǹ���Ա,����ֻ�ܱ༭���Լ������Ľ�ɫ!", "Role"));
		}
		
		
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		role = roleMgr.getRoleById(role.getId());
		
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.sequence");
		
		roleAuthorities = getRoleAuthority(authorityMgr.getObjects(null, sorter));
		
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
						menu.getId() != 2000) //����Ӱ�ȫ�˵�
					menus.add(menu);
			}
		}
		
		return returnCommand();
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@SuppressWarnings("unchecked")
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
	
	public List<HiOrg> getOrgs() {
		if(orgs == null){
			HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
			orgs = orgMgr.getObjects();
		}
		return orgs;
	}
	
	public String getShowMode() {
		return showMode;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}

	public List<RoleAuthority> getRoleAuthorities() {
		return roleAuthorities;
	}
}
