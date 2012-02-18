package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.SecurityGroupPageInfo;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.security.service.SecurityGroupManager;

public class SecurityGroupListAction extends BaseAction{
	private SecurityGroup securityGroup;
	private SecurityGroupPageInfo pageInfo;
	private List<SecurityGroup> securityGroups;
	
	public String execute() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		pageInfo = pageInfo == null ? new SecurityGroupPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		securityGroups = securityGroupMgr.getSecurityGroupList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}
	
	public List<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	public SecurityGroupPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(SecurityGroupPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
