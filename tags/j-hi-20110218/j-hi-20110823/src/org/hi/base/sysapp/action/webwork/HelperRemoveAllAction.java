package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.service.HelperManager;

public class HelperRemoveAllAction extends BaseAction{
	private Helper helper;
	private String orderIndexs;
	
	public String execute() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer helperid = new Integer( ids[i] );
				helperMgr.removeHelperById(helperid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
