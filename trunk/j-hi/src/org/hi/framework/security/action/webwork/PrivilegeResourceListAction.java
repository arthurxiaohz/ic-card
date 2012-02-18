package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.PrivilegeResourcePageInfo;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class PrivilegeResourceListAction extends BaseAction{
	private PrivilegeResource privilegeResource;
	private PrivilegeResourcePageInfo pageInfo;
	private List<PrivilegeResource> privilegeResources;
	
	public String execute() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		pageInfo = pageInfo == null ? new PrivilegeResourcePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		privilegeResources = privilegeResourceMgr.getPrivilegeResourceList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public PrivilegeResource getPrivilegeResource() {
		return privilegeResource;
	}

	public void setPrivilegeResource(PrivilegeResource privilegeResource) {
		this.privilegeResource = privilegeResource;
	}
	
	public List<PrivilegeResource> getPrivilegeResources() {
		return privilegeResources;
	}

	public void setPrivilegeResources(List<PrivilegeResource> privilegeResources) {
		this.privilegeResources = privilegeResources;
	}

	public PrivilegeResourcePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PrivilegeResourcePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
