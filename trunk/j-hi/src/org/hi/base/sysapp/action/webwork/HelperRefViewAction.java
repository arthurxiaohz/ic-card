package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperRefManager;

public class HelperRefViewAction extends BaseAction{
	private HelperRef helperRef;
	
	public String execute() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		helperRef = helperRefMgr.getHelperRefById(helperRef.getId());
		return returnCommand();
	}
	
	public HelperRef getHelperRef() {
		return helperRef;
	}

	public void setHelperRef(HelperRef helperRef) {
		this.helperRef = helperRef;
	}
}
