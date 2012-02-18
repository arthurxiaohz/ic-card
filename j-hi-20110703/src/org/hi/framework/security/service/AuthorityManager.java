package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.service.Manager;

public interface AuthorityManager extends Manager{
    
    public void saveAuthority(Authority authority);

    public void removeAuthorityById(Integer id);

    public Authority getAuthorityById(Integer id);

    public List<Authority> getAuthorityList(PageInfo pageInfo);
    
    public void saveSecurityAuthority(Authority authority);
    public void removeSecurityAuthorityById(Integer id);
    public Authority getSecurityAuthorityById(Integer id);
    public List<Authority> getSecurityAuthorityList(PageInfo pageInfo);
}
