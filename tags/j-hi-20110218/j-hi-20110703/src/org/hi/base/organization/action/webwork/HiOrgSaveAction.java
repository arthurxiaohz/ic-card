package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.framework.web.SynchronizationData;

public class HiOrgSaveAction extends BaseAction implements SynchronizationData{
	private HiOrg hiOrg;
	
	public String execute() throws Exception {
		if(super.perExecute(hiOrg)!= null) return returnCommand();
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		hiOrgMgr.saveHiOrg(hiOrg);
		super.postExecute(hiOrg);
		return returnCommand();
	}
	
	public HiOrg getHiOrg() {
		return hiOrg;
	}

	public void setHiOrg(HiOrg hiOrg) {
		this.hiOrg = hiOrg;
	}

}
