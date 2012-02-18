package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.GroupRole;
import org.hi.framework.security.service.GroupRoleManager;

public class GroupRoleRemoveAction extends BaseAction{
	private GroupRole groupRole;
	
	public String execute() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		groupRoleMgr.removeGroupRoleById(groupRole.getId());
		return returnCommand();
	}
	
	public GroupRole getGroupRole() {
		return groupRole;
	}

	public void setGroupRole(GroupRole groupRole) {
		this.groupRole = groupRole;
	}
}
