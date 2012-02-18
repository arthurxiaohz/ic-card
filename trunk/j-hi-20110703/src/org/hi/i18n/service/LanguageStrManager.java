package org.hi.i18n.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.LanguageStr;
import org.hi.framework.service.Manager;

public interface LanguageStrManager extends Manager{
    
    public void saveLanguageStr(LanguageStr languageStr);

    public void removeLanguageStrById(Integer id);

    public LanguageStr getLanguageStrById(Integer id);

    public List<LanguageStr> getLanguageStrList(PageInfo pageInfo);
    
    public void saveSecurityLanguageStr(LanguageStr languageStr);

    public void removeSecurityLanguageStrById(Integer id);

    public LanguageStr getSecurityLanguageStrById(Integer id);

    public List<LanguageStr> getSecurityLanguageStrList(PageInfo pageInfo);    
}
