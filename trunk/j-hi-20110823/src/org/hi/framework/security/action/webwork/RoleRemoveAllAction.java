package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.Role;
import org.hi.framework.security.service.RoleManager;

public class RoleRemoveAllAction extends BaseAction{
	private Role role;
	private String orderIndexs;
	
	public String execute() throws Exception {
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer roleid = new Integer( ids[i] );
				roleMgr.removeRoleUserAuthority(roleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
