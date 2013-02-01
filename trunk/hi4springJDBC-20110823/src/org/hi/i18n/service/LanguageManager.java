package org.hi.i18n.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.i18n.model.Language;

public abstract interface LanguageManager extends Manager
{
  public abstract void saveLanguage(Language paramLanguage);

  public abstract void removeLanguageById(Integer paramInteger);

  public abstract Language getLanguageById(Integer paramInteger);

  public abstract List<Language> getLanguageList(PageInfo paramPageInfo);

  public abstract void saveSecurityLanguage(Language paramLanguage);

  public abstract void removeSecurityLanguageById(Integer paramInteger);

  public abstract Language getSecurityLanguageById(Integer paramInteger);

  public abstract List<Language> getSecurityLanguageList(PageInfo paramPageInfo);

  public abstract void addLanguageStr(Language paramLanguage);

  public abstract String getLanguageStr(String paramString1, String paramString2);

  public abstract String getLanguageStr(String paramString1, String paramString2, String paramString3);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.i18n.service.LanguageManager
 * JD-Core Version:    0.6.0
 */