package org.hi.base.sysapp.interceptor;

import java.util.List;
import org.hi.base.sysapp.model.HiLog;

public abstract interface LogCacheProcessor
{
  public abstract List<HiLog> getHiLogs();

  public abstract void addHiLog(HiLog paramHiLog);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogCacheProcessor
 * JD-Core Version:    0.6.0
 */