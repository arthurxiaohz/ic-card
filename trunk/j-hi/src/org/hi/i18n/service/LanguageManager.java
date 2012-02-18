package org.hi.i18n.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.Language;
import org.hi.framework.service.Manager;

public interface LanguageManager extends Manager{
    
    public void saveLanguage(Language language);

    public void removeLanguageById(Integer id);

    public Language getLanguageById(Integer id);

    public List<Language> getLanguageList(PageInfo pageInfo);
    
    public void saveSecurityLanguage(Language language);

    public void removeSecurityLanguageById(Integer id);

    public Language getSecurityLanguageById(Integer id);

    public List<Language> getSecurityLanguageList(PageInfo pageInfo);

	public void addLanguageStr(Language language);

	public String getLanguageStr(String key, String languageCode);

	public String getLanguageStr(String key, String entity, String languageCode);    
}
