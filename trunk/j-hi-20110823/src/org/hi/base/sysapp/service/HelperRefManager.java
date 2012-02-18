package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.framework.service.Manager;

public interface HelperRefManager extends Manager{
    
    public void saveHelperRef(HelperRef helperRef);

    public void removeHelperRefById(Integer id);

    public HelperRef getHelperRefById(Integer id);

    public List<HelperRef> getHelperRefList(PageInfo pageInfo);
    
    public void saveSecurityHelperRef(HelperRef helperRef);

    public void removeSecurityHelperRefById(Integer id);

    public HelperRef getSecurityHelperRefById(Integer id);

    public List<HelperRef> getSecurityHelperRefList(PageInfo pageInfo);    
}
