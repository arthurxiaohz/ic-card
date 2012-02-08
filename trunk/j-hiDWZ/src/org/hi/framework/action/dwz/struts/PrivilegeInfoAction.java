package org.hi.framework.action.dwz.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.common.util.JSONObject;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.web.struts.BaseAction;


public class PrivilegeInfoAction extends BaseAction {

	private HiUser user = null;

	private JSONObject json;

	public String execute() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		HiUserManager uesrMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		if (user == null )
			return "json";
			user = uesrMgr.getHiUserById(user.getId());
		
		
		List<UserAuthority> userPrivilege= userAuthorityMgr.getUserAuthority(user);
		
		 
		json = new JSONObject("userPrivileges", userPrivilege,"id,authority.id,scope,org.id,org.orgName");
		json.addJSONObject("user", user,"id,org.id,creator.id");

		return "json";
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	private boolean hasRole(List<UserRole> userRoles, HiUser user) {
		if (userRoles == null)
			return false;
		for (UserRole userRole : userRoles) {
			if (userRole.getSecurityUser() != null
					&& userRole.getSecurityUser().getId().equals(user.getId()))
				return true;
		}

		return false;
	}

	public HiUser getUser() {
		return user;
	}

	public void setUser(HiUser user) {
		this.user = user;
	}

	 
}
