package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperRefManager;
import org.hi.framework.web.SynchronizationData;

public class HelperRefSaveAction extends BaseAction implements SynchronizationData{
	private HelperRef helperRef;
	
	public String execute() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		if(super.perExecute(helperRef)!= null) return returnCommand();
		helperRefMgr.saveHelperRef(helperRef);
		super.postExecute(helperRef);
		return returnCommand();
	}
	
	public HelperRef getHelperRef() {
		return helperRef;
	}

	public void setHelperRef(HelperRef helperRef) {
		this.helperRef = helperRef;
	}

}
