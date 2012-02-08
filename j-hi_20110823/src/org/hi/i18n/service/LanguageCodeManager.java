package org.hi.i18n.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.LanguageCode;
import org.hi.framework.service.Manager;

public interface LanguageCodeManager extends Manager{
    
    public void saveLanguageCode(LanguageCode languageCode);

    public void removeLanguageCodeById(Integer id);

    public LanguageCode getLanguageCodeById(Integer id);

    public List<LanguageCode> getLanguageCodeList(PageInfo pageInfo);
    
    public void saveSecurityLanguageCode(LanguageCode languageCode);

    public void removeSecurityLanguageCodeById(Integer id);

    public LanguageCode getSecurityLanguageCodeById(Integer id);

    public List<LanguageCode> getSecurityLanguageCodeList(PageInfo pageInfo);

	public List<String> getAllLanguageCode();    
}
