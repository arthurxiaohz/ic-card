package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.sysapp.service.AppSettingManager;

public class AppSettingRemoveAllAction extends BaseAction{
	private AppSetting appSetting;
	private String orderIndexs;
	
	public String execute() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer appSettingid = new Integer( ids[i] );
				appSettingMgr.removeAppSettingById(appSettingid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public AppSetting getAppSetting() {
		return appSetting;
	}

	public void setAppSetting(AppSetting appSetting) {
		this.appSetting = appSetting;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
