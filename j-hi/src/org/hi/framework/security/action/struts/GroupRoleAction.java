package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.GroupRolePageInfo;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.security.service.GroupRoleManager;

public class GroupRoleAction extends BaseAction{
	private GroupRole groupRole;
	private GroupRolePageInfo pageInfo;
	private List<GroupRole> groupRoles;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存组与角色
	 */
	public String saveGroupRole() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		if(super.perExecute(groupRole)!= null) return returnCommand();
		groupRoleMgr.saveGroupRole(groupRole);
		super.postExecute(groupRole);
		return returnCommand();
	}
	
	
	/**
	 * 删除组与角色
	 */
	public String removeGroupRole() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		groupRoleMgr.removeGroupRoleById(groupRole.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些组与角色
	 */
	public String removeAllGroupRole() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer groupRoleid = new Integer( ids[i] );
				groupRoleMgr.removeGroupRoleById(groupRoleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看组与角色
	 */
	public String viewGroupRole() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		groupRole = groupRoleMgr.getGroupRoleById(groupRole.getId());
		return returnCommand();
	}
	
	/**
	 * 组与角色列表
	 */
	public String groupRoleList() throws Exception {
		GroupRoleManager groupRoleMgr = (GroupRoleManager)SpringContextHolder.getBean(GroupRole.class);
		pageInfo = pageInfo == null ? new GroupRolePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		groupRoles = groupRoleMgr.getGroupRoleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public GroupRole getGroupRole() {
		return groupRole;
	}

	public void setGroupRole(GroupRole groupRole) {
		this.groupRole = groupRole;
	}
	
	public List<GroupRole> getGroupRoles() {
		return groupRoles;
	}

	public void setGroupRoles(List<GroupRole> groupRoles) {
		this.groupRoles = groupRoles;
	}

	public GroupRolePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(GroupRolePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
