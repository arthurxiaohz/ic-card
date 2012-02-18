package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.service.UserGroupManager;

public class UserGroupRemoveAction extends BaseAction{
	private UserGroup userGroup;
	
	public String execute() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		userGroupMgr.removeUserGroupById(userGroup.getId());
		return returnCommand();
	}
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
