package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.service.HelperManager;

public class HelperViewAction extends BaseAction{
	private Helper helper;
	
	public String execute() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		helper = helperMgr.getHelperById(helper.getId());
		return returnCommand();
	}
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
}
