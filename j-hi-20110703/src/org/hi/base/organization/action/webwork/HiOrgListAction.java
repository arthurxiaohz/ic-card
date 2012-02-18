package org.hi.base.organization.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.action.HiOrgPageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;

public class HiOrgListAction extends BaseAction{
	private HiOrg hiOrg;
	private HiOrgPageInfo pageInfo;
	private List<HiOrg> hiOrgs;
	
	public String execute() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		pageInfo = pageInfo == null ? new HiOrgPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		hiOrgs = hiOrgMgr.getSecurityHiOrgList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public HiOrg getHiOrg() {
		return hiOrg;
	}

	public void setHiOrg(HiOrg hiOrg) {
		this.hiOrg = hiOrg;
	}
	
	public List<HiOrg> getHiOrgs() {
		return hiOrgs;
	}

	public void setHiOrgs(List<HiOrg> hiOrgs) {
		this.hiOrgs = hiOrgs;
	}

	public HiOrgPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HiOrgPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
