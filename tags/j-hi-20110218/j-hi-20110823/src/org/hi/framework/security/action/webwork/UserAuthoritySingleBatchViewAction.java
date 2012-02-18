package org.hi.framework.security.action.webwork;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.web.webwork.BaseAction;

public class UserAuthoritySingleBatchViewAction extends BaseAction {
	private List<UserAuthority> userAuthorities;
	private List<HiOrg> orgs;
	private List<Menu> menus;
	private Integer userid = UserContextHelper.getUser().getId();
	private HiUser user = null;
	private String showMode = HiConfigHolder.getSecurityOrgShowMode();
	
	public String execute() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		HiUserManager uesrMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		if(user != null)
			user = uesrMgr.getHiUserById(user.getId());
		else
			user = uesrMgr.getHiUserById(userid);
		
		Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.id");
		userAuthorities = getUserAuthority(authorityMgr.getObjects());
		menus = menuMgr.getObjects();
		
		return returnCommand();
	}

	private List<UserAuthority> getUserAuthority(List<Authority> authorties){
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		List<UserAuthority> curent= userAuthorityMgr.getUserAuthority(user);
		
		List<UserAuthority> result = new ArrayList<UserAuthority>();
		for (Authority authority : authorties) {
			boolean hasAuthortie = false;
			for (UserAuthority userAuthority : curent) {
				if(userAuthority.getAuthority().getAuthorityName().equals(authority.getAuthorityName())){
					hasAuthortie = true;
					result.add(userAuthority);
					break;
				}
			}
				
			if(hasAuthortie)
				continue;
			
			UserAuthority userAuthority = new UserAuthority();
			userAuthority.setAuthority(authority);
			result.add(userAuthority);
			
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

	public HiUser getUser() {
		return user;
	}

	public void setUser(HiUser user) {
		this.user = user;
	}

	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}





}
