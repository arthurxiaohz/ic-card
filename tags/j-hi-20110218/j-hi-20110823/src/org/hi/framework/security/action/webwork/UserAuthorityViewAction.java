package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;

public class UserAuthorityViewAction extends BaseAction{
	private UserAuthority userAuthority;
	
	public String execute() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		userAuthority = userAuthorityMgr.getUserAuthorityById(userAuthority.getId());
		return returnCommand();
	}
	
	public UserAuthority getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthority userAuthority) {
		this.userAuthority = userAuthority;
	}
}
