package org.hi.base.sysapp.service;

import java.util.List;
import org.hi.base.sysapp.model.HiLog;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface HiLogManager extends Manager
{
  public abstract void saveHiLog(HiLog paramHiLog);

  public abstract void removeHiLogById(Integer paramInteger);

  public abstract HiLog getHiLogById(Integer paramInteger);

  public abstract List<HiLog> getHiLogList(PageInfo paramPageInfo);

  public abstract void saveSecurityHiLog(HiLog paramHiLog);

  public abstract void removeSecurityHiLogById(Integer paramInteger);

  public abstract HiLog getSecurityHiLogById(Integer paramInteger);

  public abstract List<HiLog> getSecurityHiLogList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.service.HiLogManager
 * JD-Core Version:    0.6.0
 */