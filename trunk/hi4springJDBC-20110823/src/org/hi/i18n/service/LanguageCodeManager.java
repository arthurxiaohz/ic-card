package org.hi.i18n.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.i18n.model.LanguageCode;

public abstract interface LanguageCodeManager extends Manager
{
  public abstract void saveLanguageCode(LanguageCode paramLanguageCode);

  public abstract void removeLanguageCodeById(Integer paramInteger);

  public abstract LanguageCode getLanguageCodeById(Integer paramInteger);

  public abstract List<LanguageCode> getLanguageCodeList(PageInfo paramPageInfo);

  public abstract void saveSecurityLanguageCode(LanguageCode paramLanguageCode);

  public abstract void removeSecurityLanguageCodeById(Integer paramInteger);

  public abstract LanguageCode getSecurityLanguageCodeById(Integer paramInteger);

  public abstract List<LanguageCode> getSecurityLanguageCodeList(PageInfo paramPageInfo);

  public abstract List<String> getAllLanguageCode();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.service.LanguageCodeManager
 * JD-Core Version:    0.6.0
 */