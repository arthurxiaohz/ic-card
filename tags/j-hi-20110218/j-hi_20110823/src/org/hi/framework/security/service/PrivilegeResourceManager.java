package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.service.Manager;

public interface PrivilegeResourceManager extends Manager{
    
    public void savePrivilegeResource(PrivilegeResource privilegeResource);

    public void removePrivilegeResourceById(Integer id);

    public PrivilegeResource getPrivilegeResourceById(Integer id);

    public List<PrivilegeResource> getPrivilegeResourceList(PageInfo pageInfo);
    
    public void saveSecurityPrivilegeResource(PrivilegeResource privilegeResource);
    public void removeSecurityPrivilegeResourceById(Integer id);
    public PrivilegeResource getSecurityPrivilegeResourceById(Integer id);
    public List<PrivilegeResource> getSecurityPrivilegeResourceList(PageInfo pageInfo);
}
