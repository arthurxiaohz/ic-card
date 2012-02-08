package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.web.SynchronizationData;

public class UserAuthoritySaveAction extends BaseAction implements SynchronizationData{
	private UserAuthority userAuthority;
	
	public String execute() throws Exception {
		if(super.perExecute(userAuthority)!= null) return returnCommand();
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		userAuthorityMgr.saveUserAuthority(userAuthority);
		super.postExecute(userAuthority);
		return returnCommand();
	}
	
	public UserAuthority getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthority userAuthority) {
		this.userAuthority = userAuthority;
	}

}
