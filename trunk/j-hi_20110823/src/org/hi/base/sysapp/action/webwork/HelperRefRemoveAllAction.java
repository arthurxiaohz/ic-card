package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperRefManager;

public class HelperRefRemoveAllAction extends BaseAction{
	private HelperRef helperRef;
	private String orderIndexs;
	
	public String execute() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer helperRefid = new Integer( ids[i] );
				helperRefMgr.removeHelperRefById(helperRefid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public HelperRef getHelperRef() {
		return helperRef;
	}

	public void setHelperRef(HelperRef helperRef) {
		this.helperRef = helperRef;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
