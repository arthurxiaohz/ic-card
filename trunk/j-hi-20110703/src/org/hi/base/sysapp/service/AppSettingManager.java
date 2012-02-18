package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.service.Manager;

public interface AppSettingManager extends Manager{
    
    public void saveAppSetting(AppSetting appSetting);

    public void removeAppSettingById(Integer id);

    public AppSetting getAppSettingById(Integer id);

    public List<AppSetting> getAppSettingList(PageInfo pageInfo);
    
    public void saveSecurityAppSetting(AppSetting appSetting);
    public void removeSecurityAppSettingById(Integer id);
    public AppSetting getSecurityAppSettingById(Integer id);
    public List<AppSetting> getSecurityAppSettingList(PageInfo pageInfo);
    
    public List<AppSetting> getSecurityAppSettingToChach();
}
