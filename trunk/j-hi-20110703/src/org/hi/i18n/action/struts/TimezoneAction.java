package org.hi.i18n.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.i18n.action.TimezonePageInfo;
import org.hi.i18n.model.Timezone;
import org.hi.i18n.service.TimezoneManager;

public class TimezoneAction extends BaseAction{
	private Timezone timezone;
	private TimezonePageInfo pageInfo;
	private List<Timezone> timezones;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存时区
	 */
	public String saveTimezone() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		if(super.perExecute(timezone)!= null) return returnCommand();
		timezoneMgr.saveTimezone(timezone);
		super.postExecute(timezone);
		return returnCommand();
	}
	
	
	/**
	 * 删除时区
	 */
	public String removeTimezone() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		timezoneMgr.removeTimezoneById(timezone.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些时区
	 */
	public String removeAllTimezone() throws Exception {
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
	
	/**
	 *查看时区
	 */
	public String viewTimezone() throws Exception {
		TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
		timezone = timezoneMgr.getTimezoneById(timezone.getId());
		return returnCommand();
	}
	
	/**
	 * 时区列表
	 */
	public String timezoneList() throws Exception {
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
