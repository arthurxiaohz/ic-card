package org.hi.base.schedule.service;

import java.util.List;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface TriggerDefManager extends Manager
{
  public abstract void saveTriggerDef(TriggerDef paramTriggerDef);

  public abstract void removeTriggerDefById(Integer paramInteger);

  public abstract TriggerDef getTriggerDefById(Integer paramInteger);

  public abstract List<TriggerDef> getTriggerDefList(PageInfo paramPageInfo);

  public abstract void saveSecurityTriggerDef(TriggerDef paramTriggerDef);

  public abstract void removeSecurityTriggerDefById(Integer paramInteger);

  public abstract TriggerDef getSecurityTriggerDefById(Integer paramInteger);

  public abstract List<TriggerDef> getSecurityTriggerDefList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.service.TriggerDefManager
 * JD-Core Version:    0.6.0
 */