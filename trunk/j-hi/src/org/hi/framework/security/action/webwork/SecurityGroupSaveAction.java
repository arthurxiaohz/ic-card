package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.security.service.SecurityGroupManager;
import org.hi.framework.web.SynchronizationData;

public class SecurityGroupSaveAction extends BaseAction implements SynchronizationData{
	private SecurityGroup securityGroup;
	
	public String execute() throws Exception {
		if(super.perExecute(securityGroup)!= null) return returnCommand();
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		securityGroupMgr.saveSecurityGroup(securityGroup);
		super.postExecute(securityGroup);
		return returnCommand();
	}
	
	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}

}
