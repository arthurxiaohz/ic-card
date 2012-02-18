package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class PrivilegeResourceViewAction extends BaseAction{
	private PrivilegeResource privilegeResource;
	
	public String execute() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		privilegeResource = privilegeResourceMgr.getPrivilegeResourceById(privilegeResource.getId());
		return returnCommand();
	}
	
	public PrivilegeResource getPrivilegeResource() {
		return privilegeResource;
	}

	public void setPrivilegeResource(PrivilegeResource privilegeResource) {
		this.privilegeResource = privilegeResource;
	}
}
