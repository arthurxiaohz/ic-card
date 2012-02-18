package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;

public class HiOrgRemoveAllAction extends BaseAction{
	private HiOrg hiOrg;
	private String orderIndexs;
	
	public String execute() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer hiOrgid = new Integer( ids[i] );
				hiOrgMgr.removeHiOrgById(hiOrgid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public HiOrg getHiOrg() {
		return hiOrg;
	}

	public void setHiOrg(HiOrg hiOrg) {
		this.hiOrg = hiOrg;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
