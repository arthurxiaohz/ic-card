package org.hi.base.sysapp.interceptor;

import java.util.List;
import org.hi.base.sysapp.model.HiLog;

public abstract interface LogSaveProcessor
{
  public abstract void saveLog(List<HiLog> paramList);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogSaveProcessor
 * JD-Core Version:    0.6.0
 */