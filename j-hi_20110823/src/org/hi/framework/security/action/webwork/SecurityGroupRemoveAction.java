package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.security.service.SecurityGroupManager;

public class SecurityGroupRemoveAction extends BaseAction{
	private SecurityGroup securityGroup;
	
	public String execute() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		securityGroupMgr.removeSecurityGroupById(securityGroup.getId());
		return returnCommand();
	}
	
	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}
}
