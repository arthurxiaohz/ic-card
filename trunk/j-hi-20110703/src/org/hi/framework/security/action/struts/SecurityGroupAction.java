package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.SecurityGroupPageInfo;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.security.service.SecurityGroupManager;

public class SecurityGroupAction extends BaseAction{
	private SecurityGroup securityGroup;
	private SecurityGroupPageInfo pageInfo;
	private List<SecurityGroup> securityGroups;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存用户组
	 */
	public String saveSecurityGroup() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		if(super.perExecute(securityGroup)!= null) return returnCommand();
		securityGroupMgr.saveSecurityGroup(securityGroup);
		super.postExecute(securityGroup);
		return returnCommand();
	}
	
	
	/**
	 * 删除用户组
	 */
	public String removeSecurityGroup() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		securityGroupMgr.removeSecurityGroupById(securityGroup.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些用户组
	 */
	public String removeAllSecurityGroup() throws Exception {
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
	
	/**
	 *查看用户组
	 */
	public String viewSecurityGroup() throws Exception {
		SecurityGroupManager securityGroupMgr = (SecurityGroupManager)SpringContextHolder.getBean(SecurityGroup.class);
		securityGroup = securityGroupMgr.getSecurityGroupById(securityGroup.getId());
		return returnCommand();
	}
	
	/**
	 * 用户组列表
	 */
	public String securityGroupList() throws Exception {
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
