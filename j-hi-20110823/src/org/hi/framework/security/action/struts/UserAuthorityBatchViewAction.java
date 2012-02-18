package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.web.struts.BaseAction;

public class UserAuthorityBatchViewAction extends BaseAction {
	private List<Authority> authorities;
	private List<HiOrg> orgs;
	private List<Menu> menus;
	private String showMode = HiConfigHolder.getSecurityOrgShowMode();
	public String execute() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.id");
		
		authorities = authorityMgr.getObjects();
		menus = menuMgr.getObjects();
		
		return returnCommand();
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


	public List<Authority> getAuthorities() {
		return authorities;
	}



}
