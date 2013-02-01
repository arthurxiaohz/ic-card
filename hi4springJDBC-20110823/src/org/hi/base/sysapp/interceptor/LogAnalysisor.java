package org.hi.base.sysapp.interceptor;

import org.hi.framework.service.Manager;
import org.hi.metadata.hsc.context.service.Entity;

public abstract interface LogAnalysisor
{
  public abstract String perProcess(Object[] paramArrayOfObject, Entity paramEntity, Manager paramManager);

  public abstract String postProcess(Object paramObject);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.LogAnalysisor
 * JD-Core Version:    0.6.0
 */