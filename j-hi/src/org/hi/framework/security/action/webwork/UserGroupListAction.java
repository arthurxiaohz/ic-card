package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.UserGroupPageInfo;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.service.UserGroupManager;

public class UserGroupListAction extends BaseAction{
	private UserGroup userGroup;
	private UserGroupPageInfo pageInfo;
	private List<UserGroup> userGroups;
	
	public String execute() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		pageInfo = pageInfo == null ? new UserGroupPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		userGroups = userGroupMgr.getUserGroupList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserGroupPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(UserGroupPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
