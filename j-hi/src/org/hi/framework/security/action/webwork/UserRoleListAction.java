package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.UserRolePageInfo;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;

public class UserRoleListAction extends BaseAction{
	private UserRole userRole;
	private UserRolePageInfo pageInfo;
	private List<UserRole> userRoles;
	
	public String execute() throws Exception {
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
}
