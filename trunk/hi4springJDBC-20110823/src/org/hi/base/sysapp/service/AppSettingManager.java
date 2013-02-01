package org.hi.base.sysapp.service;

import java.util.List;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface AppSettingManager extends Manager
{
  public abstract void saveAppSetting(AppSetting paramAppSetting);

  public abstract void removeAppSettingById(Integer paramInteger);

  public abstract AppSetting getAppSettingById(Integer paramInteger);

  public abstract List<AppSetting> getAppSettingList(PageInfo paramPageInfo);

  public abstract void saveSecurityAppSetting(AppSetting paramAppSetting);

  public abstract void removeSecurityAppSettingById(Integer paramInteger);

  public abstract AppSetting getSecurityAppSettingById(Integer paramInteger);

  public abstract List<AppSetting> getSecurityAppSettingList(PageInfo paramPageInfo);

  public abstract List<AppSetting> getSecurityAppSettingToChach();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.service.AppSettingManager
 * JD-Core Version:    0.6.0
 */