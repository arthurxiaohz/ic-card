package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.service.UserGroupManager;
import org.hi.framework.web.SynchronizationData;

public class UserGroupSaveAction extends BaseAction implements SynchronizationData{
	private UserGroup userGroup;
	
	public String execute() throws Exception {
		if(super.perExecute(userGroup)!= null) return returnCommand();
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		userGroupMgr.saveUserGroup(userGroup);
		super.postExecute(userGroup);
		return returnCommand();
	}
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
