package org.hi.base.enumeration.service;

import java.util.List;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface EnumerationValueManager extends Manager
{
  public abstract void saveEnumerationValue(EnumerationValue paramEnumerationValue);

  public abstract void removeEnumerationValueById(Integer paramInteger);

  public abstract EnumerationValue getEnumerationValueById(Integer paramInteger);

  public abstract List<EnumerationValue> getEnumerationValueList(PageInfo paramPageInfo);

  public abstract void saveSecurityEnumerationValue(EnumerationValue paramEnumerationValue);

  public abstract void removeSecurityEnumerationValueById(Integer paramInteger);

  public abstract EnumerationValue getSecurityEnumerationValueById(Integer paramInteger);

  public abstract List<EnumerationValue> getSecurityEnumerationValueList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.service.EnumerationValueManager
 * JD-Core Version:    0.6.0
 */