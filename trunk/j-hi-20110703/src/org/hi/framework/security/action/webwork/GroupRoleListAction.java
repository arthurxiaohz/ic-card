package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.GroupRolePageInfo;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.security.service.GroupRoleManager;

public class GroupRoleListAction extends BaseAction{
	private GroupRole groupRole;
	private GroupRolePageInfo pageInfo;
	private List<GroupRole> groupRoles;
	
	public String execute() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		pageInfo = pageInfo == null ? new GroupRolePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		groupRoles = groupRoleMgr.getGroupRoleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public GroupRole getGroupRole() {
		return groupRole;
	}

	public void setGroupRole(GroupRole groupRole) {
		this.groupRole = groupRole;
	}
	
	public List<GroupRole> getGroupRoles() {
		return groupRoles;
	}

	public void setGroupRoles(List<GroupRole> groupRoles) {
		this.groupRoles = groupRoles;
	}

	public GroupRolePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(GroupRolePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
