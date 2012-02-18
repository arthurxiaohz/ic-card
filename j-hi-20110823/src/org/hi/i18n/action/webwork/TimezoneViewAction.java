package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.Timezone;
import org.hi.i18n.service.TimezoneManager;

public class TimezoneViewAction extends BaseAction{
	private Timezone timezone;
	
	public String execute() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		timezone = timezoneMgr.getTimezoneById(timezone.getId());
		return returnCommand();
	}
	
	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
}
