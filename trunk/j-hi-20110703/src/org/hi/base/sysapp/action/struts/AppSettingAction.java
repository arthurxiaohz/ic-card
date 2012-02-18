package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.sysapp.action.AppSettingPageInfo;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.sysapp.service.AppSettingManager;

public class AppSettingAction extends BaseAction{
	private AppSetting appSetting;
	private AppSettingPageInfo pageInfo;
	private List<AppSetting> appSettings;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存应用配置
	 */
	public String saveAppSetting() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		if(super.perExecute(appSetting)!= null) return returnCommand();
		appSettingMgr.saveAppSetting(appSetting);
		super.postExecute(appSetting);
		return returnCommand();
	}
	
	
	/**
	 * 删除应用配置
	 */
	public String removeAppSetting() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		appSettingMgr.removeAppSettingById(appSetting.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些应用配置
	 */
	public String removeAllAppSetting() throws Exception {
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
	
	/**
	 *查看应用配置
	 */
	public String viewAppSetting() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		appSetting = appSettingMgr.getAppSettingById(appSetting.getId());
		return returnCommand();
	}
	
	/**
	 * 应用配置列表
	 */
	public String appSettingList() throws Exception {
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		pageInfo = pageInfo == null ? new AppSettingPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
