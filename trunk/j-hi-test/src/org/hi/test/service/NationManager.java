package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Nation;
import org.hi.framework.service.Manager;

public interface NationManager extends Manager{
    
    public void saveNation(Nation nation);

    public void removeNationById(Integer id);

    public Nation getNationById(Integer id);

    public List<Nation> getNationList(PageInfo pageInfo);
    
    public void saveSecurityNation(Nation nation);

    public void removeSecurityNationById(Integer id);

    public Nation getSecurityNationById(Integer id);

    public List<Nation> getSecurityNationList(PageInfo pageInfo);    
}
