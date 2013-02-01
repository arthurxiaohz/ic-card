package org.hi.i18n.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.i18n.model.LanguageStr;

public abstract interface LanguageStrManager extends Manager
{
  public abstract void saveLanguageStr(LanguageStr paramLanguageStr);

  public abstract void removeLanguageStrById(Integer paramInteger);

  public abstract LanguageStr getLanguageStrById(Integer paramInteger);

  public abstract List<LanguageStr> getLanguageStrList(PageInfo paramPageInfo);

  public abstract void saveSecurityLanguageStr(LanguageStr paramLanguageStr);

  public abstract void removeSecurityLanguageStrById(Integer paramInteger);

  public abstract LanguageStr getSecurityLanguageStrById(Integer paramInteger);

  public abstract List<LanguageStr> getSecurityLanguageStrList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.service.LanguageStrManager
 * JD-Core Version:    0.6.0
 */