package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.security.service.SecurityGroupManager;

public class SecurityGroupRemoveAllAction extends BaseAction{
	private SecurityGroup securityGroup;
	private String orderIndexs;
	
	public String execute() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer securityGroupid = new Integer( ids[i] );
				securityGroupMgr.removeSecurityGroupById(securityGroupid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
