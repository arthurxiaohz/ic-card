package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.web.SynchronizationData;

public class HiUserSaveAction extends BaseAction implements SynchronizationData{
	private HiUser hiUser;
	
	public String execute() throws Exception {
		if(super.perExecute(hiUser)!= null) return returnCommand();
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		hiUserMgr.saveHiUser(hiUser);
		super.postExecute(hiUser);
		return returnCommand();
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}

}
