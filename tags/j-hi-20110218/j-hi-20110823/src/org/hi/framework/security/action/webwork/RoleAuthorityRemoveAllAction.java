package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.RoleAuthorityManager;

public class RoleAuthorityRemoveAllAction extends BaseAction{
	private RoleAuthority roleAuthority;
	private String orderIndexs;
	
	public String execute() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer roleAuthorityid = new Integer( ids[i] );
				roleAuthorityMgr.removeRoleAuthorityById(roleAuthorityid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public RoleAuthority getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthority roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
