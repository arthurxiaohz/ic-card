package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;
import org.hi.framework.web.SynchronizationData;

public class PrivilegeResourceSaveAction extends BaseAction implements SynchronizationData{
	private PrivilegeResource privilegeResource;
	
	public String execute() throws Exception {
		if(super.perExecute(privilegeResource)!= null) return returnCommand();
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		privilegeResourceMgr.savePrivilegeResource(privilegeResource);
		super.postExecute(privilegeResource);
		return returnCommand();
	}
	
	public PrivilegeResource getPrivilegeResource() {
		return privilegeResource;
	}

	public void setPrivilegeResource(PrivilegeResource privilegeResource) {
		this.privilegeResource = privilegeResource;
	}

}
