package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.UserGroupPageInfo;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.service.UserGroupManager;

public class UserGroupAction extends BaseAction{
	private UserGroup userGroup;
	private UserGroupPageInfo pageInfo;
	private List<UserGroup> userGroups;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存用户与组
	 */
	public String saveUserGroup() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		if(super.perExecute(userGroup)!= null) return returnCommand();
		userGroupMgr.saveUserGroup(userGroup);
		super.postExecute(userGroup);
		return returnCommand();
	}
	
	
	/**
	 * 删除用户与组
	 */
	public String removeUserGroup() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		userGroupMgr.removeUserGroupById(userGroup.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些用户与组
	 */
	public String removeAllUserGroup() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer userGroupid = new Integer( ids[i] );
				userGroupMgr.removeUserGroupById(userGroupid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看用户与组
	 */
	public String viewUserGroup() throws Exception {
		UserGroupManager userGroupMgr = (UserGroupManager)SpringContextHolder.getBean(UserGroup.class);
		userGroup = userGroupMgr.getUserGroupById(userGroup.getId());
		return returnCommand();
	}
	
	/**
	 * 用户与组列表
	 */
	public String userGroupList() throws Exception {
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
