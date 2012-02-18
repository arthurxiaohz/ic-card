package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;

public class UserRoleViewAction extends BaseAction{
	private UserRole userRole;
	
	public String execute() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		userRole = userRoleMgr.getUserRoleById(userRole.getId());
		return returnCommand();
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
