package org.hi.base.enumeration.service;

import java.util.List;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface EnumerationManager extends Manager
{
  public abstract void saveEnumeration(Enumeration paramEnumeration);

  public abstract void removeEnumerationById(Integer paramInteger);

  public abstract Enumeration getEnumerationById(Integer paramInteger);

  public abstract List<Enumeration> getEnumerationList(PageInfo paramPageInfo);

  public abstract List<Enumeration> getEnumerations();

  public abstract void reloadEnumeration();

  public abstract void saveSecurityEnumeration(Enumeration paramEnumeration);

  public abstract void removeSecurityEnumerationById(Integer paramInteger);

  public abstract Enumeration getSecurityEnumerationById(Integer paramInteger);

  public abstract List<Enumeration> getSecurityEnumerationList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.service.EnumerationManager
 * JD-Core Version:    0.6.0
 */