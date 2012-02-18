package org.hi.framework.security.action.webwork;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.RolePageInfo;
import org.hi.framework.security.action.UserRolePageInfo;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.security.service.UserRoleManager;

public class RoleListAction extends BaseAction{
	private Role role;
	private UserRolePageInfo pageInfo;
	private List<Role> roles;
	
	public String execute() throws Exception {
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		pageInfo = pageInfo == null ? new UserRolePageInfo() : pageInfo;
		
		PageInfo sarchPageInfo;
		if(pageInfo.getSecurityUser() == null || pageInfo.getSecurityUser().getF_fullName() == null || pageInfo.getSecurityUser().getF_fullName().equals("")){
			RolePageInfo rolePageInfo = pageInfo.getRole() == null ? new RolePageInfo() : pageInfo.getRole();
			rolePageInfo.setCurrentPage(pageInfo.getCurrentPage());
			rolePageInfo.setPageSize(pageInfo.getPageSize());
			rolePageInfo.setMaxRecords(pageInfo.getMaxRecords());
			if(pageInfo.getSorterName() != null && !pageInfo.getSorterName().trim().equals("")){
				String sortName = pageInfo.getSorterName();
				rolePageInfo.setSorterName(sortName.substring(sortName.indexOf(".") + 1));
			}
			rolePageInfo.setSorterDirection(pageInfo.getSorterDirection());
			sarchPageInfo = PageInfoUtil.populate(rolePageInfo);
			
			roles = roleMgr.getRoleList(sarchPageInfo);
			
			pageInfo.setStartRowPosition(rolePageInfo.getStartRowPosition());
			pageInfo.setEndRowPosition(rolePageInfo.getEndRowPosition());
			pageInfo.setIsFristPage(rolePageInfo.getIsFristPage());
			pageInfo.setIsLastPage(rolePageInfo.getIsLastPage());
			pageInfo.setTotalPage(rolePageInfo.getTotalPage());
			pageInfo.setTotalRecords(rolePageInfo.getTotalRecords());
		}
		else{
			UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
			sarchPageInfo = PageInfoUtil.populate(pageInfo);
			List<UserRole> userRoles = userRoleMgr.getUserRoleList(sarchPageInfo);
			roles = new ArrayList<Role>();
			for (UserRole userRole : userRoles) {
				roles.add(userRole.getRole());
			}
		}
		
		return returnCommand();	
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public UserRolePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(UserRolePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
