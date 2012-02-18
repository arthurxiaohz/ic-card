package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.model.Timezone;
import org.hi.i18n.service.TimezoneManager;
import org.hi.framework.web.SynchronizationData;

public class TimezoneSaveAction extends BaseAction implements SynchronizationData{
	private Timezone timezone;
	
	public String execute() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		if(super.perExecute(timezone)!= null) return returnCommand();
		timezoneMgr.saveTimezone(timezone);
		super.postExecute(timezone);
		return returnCommand();
	}
	
	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}

}
