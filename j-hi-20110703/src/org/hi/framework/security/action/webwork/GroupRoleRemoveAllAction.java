package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.GroupRole;
import org.hi.framework.security.service.GroupRoleManager;

public class GroupRoleRemoveAllAction extends BaseAction{
	private GroupRole groupRole;
	private String orderIndexs;
	
	public String execute() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer groupRoleid = new Integer( ids[i] );
				groupRoleMgr.removeGroupRoleById(groupRoleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public GroupRole getGroupRole() {
		return groupRole;
	}

	public void setGroupRole(GroupRole groupRole) {
		this.groupRole = groupRole;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
