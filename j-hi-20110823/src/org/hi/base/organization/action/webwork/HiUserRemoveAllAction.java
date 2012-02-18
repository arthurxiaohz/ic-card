package org.hi.base.organization.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;

public class HiUserRemoveAllAction extends BaseAction{
	private HiUser hiUser;
	private String orderIndexs;
	
	public String execute() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer hiUserid = new Integer( ids[i] );
				hiUserMgr.removeHiUserById(hiUserid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
