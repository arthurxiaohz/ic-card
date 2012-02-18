package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;

public class HiOrgViewAction extends BaseAction{
	private HiOrg hiOrg;
	
	public String execute() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		hiOrg = hiOrgMgr.getHiOrgById(hiOrg.getId());
		return returnCommand();
	}
	
	public HiOrg getHiOrg() {
		return hiOrg;
	}

	public void setHiOrg(HiOrg hiOrg) {
		this.hiOrg = hiOrg;
	}
}
