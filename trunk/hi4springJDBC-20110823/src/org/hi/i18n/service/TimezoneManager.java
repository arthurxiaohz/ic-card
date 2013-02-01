package org.hi.i18n.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.i18n.model.Timezone;

public abstract interface TimezoneManager extends Manager
{
  public abstract void saveTimezone(Timezone paramTimezone);

  public abstract void removeTimezoneById(Integer paramInteger);

  public abstract Timezone getTimezoneById(Integer paramInteger);

  public abstract List<Timezone> getTimezoneList(PageInfo paramPageInfo);

  public abstract void saveSecurityTimezone(Timezone paramTimezone);

  public abstract void removeSecurityTimezoneById(Integer paramInteger);

  public abstract Timezone getSecurityTimezoneById(Integer paramInteger);

  public abstract List<Timezone> getSecurityTimezoneList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.service.TimezoneManager
 * JD-Core Version:    0.6.0
 */