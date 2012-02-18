package org.hi.framework.action.dwz.webwork;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiUserManager;
import org.hi.common.util.JSONObject;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;
import org.hi.framework.web.webwork.BaseAction;

public class RoleInfoAction extends BaseAction {

	private int roleID;
	private int orgID;

	// 当前部门下有这个角色的用户
	private String otherUserStr = "";
	// 当前部门下没有这个角色的用户
	private String hasRoleUserString = "";

	private JSONObject json;

	public String execute() throws Exception {

		List<HiUser> otherUsers = new ArrayList<HiUser>();
		List<HiUser> hasRoleUsers = new ArrayList<HiUser>();
		UserRoleManager userRoleMgr = (UserRoleManager) SpringContextHolder.getBean(UserRole.class);
		HiUserManager userMgr = (HiUserManager) SpringContextHolder.getBean(HiUser.class);

		// 得到当前部门下所有有这个角色的用户
		Filter roleFilter = FilterFactory.getSimpleFilter("role.id", roleID,Filter.OPERATOR_EQ);
		roleFilter.addCondition("securityUser.org.id", orgID,Filter.OPERATOR_EQ);

		List<UserRole> userRoles = userRoleMgr.getObjects(roleFilter);

		// 得到当前部门所有用户
		Filter userFilter = FilterFactory.getSimpleFilter("org.id", orgID,Filter.OPERATOR_EQ)
			.addCondition("userMgrType", UserType.USERTYPE_ADMINISTRATOR, Filter.OPERATOR_NOT_EQ); //不显示超级管理员
		List<HiUser> allOrgUsers = userMgr.getObjects(userFilter);

		if (allOrgUsers != null)
			for (HiUser user : allOrgUsers) {
				if (hasRole(userRoles, user))
					hasRoleUsers.add(user);
				else
					otherUsers.add(user);

			}
		json = new JSONObject("orgID", orgID);
		json.addJSONObject("otherUsers", otherUsers, "id,fullName");
		json.addJSONObject("hasRoleUsers", hasRoleUsers, "id,fullName");

		return "json";
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	private boolean hasRole(List<UserRole> userRoles, HiUser user) {
		if (userRoles == null)
			return false;
		for (UserRole userRole : userRoles) {
			if (userRole.getSecurityUser() != null
					&& userRole.getSecurityUser().getId().equals(user.getId()))
				return true;
		}

		return false;
	}

	public String getOtherUserStr() {
		return otherUserStr;
	}

	public void setOtherUserStr(String otherUserStr) {
		this.otherUserStr = otherUserStr;
	}

	public String getHasRoleUserString() {
		return hasRoleUserString;
	}

	public void setHasRoleUserString(String hasRoleUserString) {
		this.hasRoleUserString = hasRoleUserString;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getOrgID() {
		return orgID;
	}

	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

}
