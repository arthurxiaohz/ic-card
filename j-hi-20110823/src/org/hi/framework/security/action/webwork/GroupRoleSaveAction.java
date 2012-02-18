package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.security.service.GroupRoleManager;
import org.hi.framework.web.SynchronizationData;

public class GroupRoleSaveAction extends BaseAction implements SynchronizationData{
	private GroupRole groupRole;
	
	public String execute() throws Exception {
		if(super.perExecute(groupRole)!= null) return returnCommand();
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		groupRoleMgr.saveGroupRole(groupRole);
		super.postExecute(groupRole);
		return returnCommand();
	}
	
	public GroupRole getGroupRole() {
		return groupRole;
	}

	public void setGroupRole(GroupRole groupRole) {
		this.groupRole = groupRole;
	}

}
