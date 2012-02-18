package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.sysapp.model.Helper;
import org.hi.framework.service.Manager;

public interface HelperManager extends Manager{
    
    public void saveHelper(Helper helper);

    public void removeHelperById(Integer id);

    public Helper getHelperById(Integer id);

    public List<Helper> getHelperList(PageInfo pageInfo);
    
    public void saveSecurityHelper(Helper helper);

    public void removeSecurityHelperById(Integer id);

    public Helper getSecurityHelperById(Integer id);

    public List<Helper> getSecurityHelperList(PageInfo pageInfo);  
    
    public Helper getRefHelper(String url);
    
    public Helper getLinkHelper(Helper helper);
}
