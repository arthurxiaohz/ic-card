package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class PrivilegeResourceRemoveAllAction extends BaseAction{
	private PrivilegeResource privilegeResource;
	private String orderIndexs;
	
	public String execute() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer privilegeResourceid = new Integer( ids[i] );
				privilegeResourceMgr.removePrivilegeResourceById(privilegeResourceid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public PrivilegeResource getPrivilegeResource() {
		return privilegeResource;
	}

	public void setPrivilegeResource(PrivilegeResource privilegeResource) {
		this.privilegeResource = privilegeResource;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
