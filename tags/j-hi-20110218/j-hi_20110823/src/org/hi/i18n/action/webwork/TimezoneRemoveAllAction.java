package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.Timezone;
import org.hi.i18n.service.TimezoneManager;

public class TimezoneRemoveAllAction extends BaseAction{
	private Timezone timezone;
	private String orderIndexs;
	
	public String execute() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer timezoneid = new Integer( ids[i] );
				timezoneMgr.removeTimezoneById(timezoneid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
