package org.hi.base.sysapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.AppSettingManager;

public class AppSettingManagerImpl extends ManagerImpl implements AppSettingManager{
    private List<AppSetting> appSettingCache = null;
	
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);
        

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
        
    }
    
    public void saveAppSetting(AppSetting appSetting){
    	saveObject(appSetting);
    
    }

    public void removeAppSettingById(Integer id){
    	removeObjectById(id);
    	
    }

    public AppSetting getAppSettingById(Integer id){
   		return (AppSetting) getObjectById(id);
    }

    public List<AppSetting> getAppSettingList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityAppSetting(AppSetting appSetting){
    	saveObject(appSetting);
    }
    public void removeSecurityAppSettingById(Integer id){
    	removeObjectById(id);
    }
    public AppSetting getSecurityAppSettingById(Integer id){
    	return (AppSetting) getObjectById(id);
    }
    public List<AppSetting> getSecurityAppSettingList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
    
    public List<AppSetting> getSecurityAppSettingToChach(){
    	if(!HiConfigHolder.getPublished())
    		return null;
    	
    	if(appSettingCache != null)
    		return appSettingCache;
    	
    	appSettingCache = new ArrayList<AppSetting>();
    	List<AppSetting> _appSettings = this.getObjects();
    	for (AppSetting appSetting : _appSettings) {
    		AppSetting _appSetting = new AppSetting();
    		_appSetting.setAppGroup(appSetting.getAppGroup());
    		_appSetting.setAppName(appSetting.getAppName());
    		_appSetting.setAppValue(appSetting.getAppValue());
    		_appSetting.setDescription(appSetting.getDescription());
    		appSettingCache.add(_appSetting);
		}
    	
    	return appSettingCache;
    }
}
