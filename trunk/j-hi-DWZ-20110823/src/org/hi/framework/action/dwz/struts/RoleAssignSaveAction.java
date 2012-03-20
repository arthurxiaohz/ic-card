package org.hi.framework.action.dwz.struts;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.security.dwz.service.RoleManager;
import org.hi.framework.security.model.Role;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.struts.BaseAction;

public class RoleAssignSaveAction extends  BaseAction implements SynchronizationData {
	private Role role;
	private String userIndexs;
	private int orgID;
	
	public String execute() throws Exception {
		if(super.perExecute(role)!= null) return returnCommand();
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(RoleManager.class);
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		if(userIndexs == null || userIndexs.length()<= 0 )
			return returnCommand();
		
		List<HiUser> users = new ArrayList<HiUser>();
		String[] ids= userIndexs.split(",");
		for( int i=0; i<ids.length; i++)
		{
			if(ids[i].trim().equals(""))
				continue;
			
			Integer userid = new Integer( ids[i] );
			HiUser user = (HiUser)userMgr.getHiUserById(userid);
			
			if(user.getUserMgrType() != UserType.USERTYPE_ADMINISTRATOR)
				users.add(user);
		}
		
		roleMgr.saveUserRole(role,orgID, users);
		super.postExecute(role);
		return returnCommand();
	}


	public String getUserIndexs() {
		return userIndexs;
	}

	public void setUserIndexs(String userIndexs) {
		this.userIndexs = userIndexs;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public int getOrgID() {
		return orgID;
	}


	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}
	
	

}
