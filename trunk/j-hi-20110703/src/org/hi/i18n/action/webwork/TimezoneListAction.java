package org.hi.i18n.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.action.TimezonePageInfo;
import org.hi.i18n.model.Timezone;
import org.hi.i18n.service.TimezoneManager;

public class TimezoneListAction extends BaseAction{
	private Timezone timezone;
	private TimezonePageInfo pageInfo;
	private List<Timezone> timezones;
	
	public String execute() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		pageInfo = pageInfo == null ? new TimezonePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		timezones = timezoneMgr.getTimezoneList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
	
	public List<Timezone> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<Timezone> timezones) {
		this.timezones = timezones;
	}

	public TimezonePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TimezonePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
