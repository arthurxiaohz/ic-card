package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;

public class HiUserRemoveAction extends BaseAction{
	private HiUser hiUser;
	
	public String execute() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		hiUserMgr.removeHiUserById(hiUser.getId());
		return returnCommand();
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}
}
