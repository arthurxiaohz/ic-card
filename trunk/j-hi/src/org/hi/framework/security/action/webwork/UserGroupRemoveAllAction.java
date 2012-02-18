package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.service.UserGroupManager;

public class UserGroupRemoveAllAction extends BaseAction{
	private UserGroup userGroup;
	private String orderIndexs;
	
	public String execute() throws Exception {
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
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
