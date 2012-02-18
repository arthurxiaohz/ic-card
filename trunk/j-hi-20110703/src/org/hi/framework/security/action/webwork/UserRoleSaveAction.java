package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;
import org.hi.framework.web.SynchronizationData;

public class UserRoleSaveAction extends BaseAction implements SynchronizationData{
	private UserRole userRole;
	
	public String execute() throws Exception {
		if(super.perExecute(userRole)!= null) return returnCommand();
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		userRoleMgr.saveUserRole(userRole);
		super.postExecute(userRole);
		return returnCommand();
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
