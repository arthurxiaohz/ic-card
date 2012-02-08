package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.UserRolePageInfo;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;

public class UserRoleAction extends BaseAction{
	private UserRole userRole;
	private UserRolePageInfo pageInfo;
	private List<UserRole> userRoles;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存用户角色
	 */
	public String saveUserRole() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		if(super.perExecute(userRole)!= null) return returnCommand();
		userRoleMgr.saveUserRole(userRole);
		super.postExecute(userRole);
		return returnCommand();
	}
	
	
	/**
	 * 删除用户角色
	 */
	public String removeUserRole() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		userRoleMgr.removeUserRoleById(userRole.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些用户角色
	 */
	public String removeAllUserRole() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer userRoleid = new Integer( ids[i] );
				userRoleMgr.removeUserRoleById(userRoleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看用户角色
	 */
	public String viewUserRole() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		userRole = userRoleMgr.getUserRoleById(userRole.getId());
		return returnCommand();
	}
	
	/**
	 * 用户角色列表
	 */
	public String userRoleList() throws Exception {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		pageInfo = pageInfo == null ? new UserRolePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		userRoles = userRoleMgr.getUserRoleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRolePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(UserRolePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
