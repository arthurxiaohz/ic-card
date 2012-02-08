package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.AppSettingPageInfo;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.sysapp.service.AppSettingManager;

public class AppSettingListAction extends BaseAction{
	private AppSetting appSetting;
	private AppSettingPageInfo pageInfo;
	private List<AppSetting> appSettings;
	
	public String execute() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		pageInfo = pageInfo == null ? new AppSettingPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo ,this);
		
		appSettings = appSettingMgr.getSecurityAppSettingList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public AppSetting getAppSetting() {
		return appSetting;
	}

	public void setAppSetting(AppSetting appSetting) {
		this.appSetting = appSetting;
	}
	
	public List<AppSetting> getAppSettings() {
		return appSettings;
	}

	public void setAppSettings(List<AppSetting> appSettings) {
		this.appSettings = appSettings;
	}

	public AppSettingPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(AppSettingPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
