package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.PrivilegeResourcePageInfo;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class PrivilegeResourceAction extends BaseAction{
	private PrivilegeResource privilegeResource;
	private PrivilegeResourcePageInfo pageInfo;
	private List<PrivilegeResource> privilegeResources;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı���Ȩ����Դ
	 */
	public String savePrivilegeResource() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		if(super.perExecute(privilegeResource)!= null) return returnCommand();
		privilegeResourceMgr.savePrivilegeResource(privilegeResource);
		super.postExecute(privilegeResource);
		return returnCommand();
	}
	
	
	/**
	 * ɾ��Ȩ����Դ
	 */
	public String removePrivilegeResource() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		privilegeResourceMgr.removePrivilegeResourceById(privilegeResource.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩȨ����Դ
	 */
	public String removeAllPrivilegeResource() throws Exception {
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
	
	/**
	 *�鿴Ȩ����Դ
	 */
	public String viewPrivilegeResource() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		privilegeResource = privilegeResourceMgr.getPrivilegeResourceById(privilegeResource.getId());
		return returnCommand();
	}
	
	/**
	 * Ȩ����Դ�б�
	 */
	public String privilegeResourceList() throws Exception {
		PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
		pageInfo = pageInfo == null ? new PrivilegeResourcePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
