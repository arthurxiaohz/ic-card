package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.sysapp.service.AppSettingManager;
import org.hi.framework.web.SynchronizationData;

public class AppSettingSaveAction extends BaseAction implements SynchronizationData{
	private AppSetting appSetting;
	
	public String execute() throws Exception {
		if(super.perExecute(appSetting)!= null) return returnCommand();
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		appSettingMgr.saveAppSetting(appSetting);
		super.postExecute(appSetting);
		return returnCommand();
	}
	
	public AppSetting getAppSetting() {
		return appSetting;
	}

	public void setAppSetting(AppSetting appSetting) {
		this.appSetting = appSetting;
	}

}
