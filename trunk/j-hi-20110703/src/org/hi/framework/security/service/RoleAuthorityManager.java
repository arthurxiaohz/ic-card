package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.service.Manager;

public interface RoleAuthorityManager extends Manager{
    
    public void saveRoleAuthority(RoleAuthority roleAuthority);

    public void removeRoleAuthorityById(Integer id);

    public RoleAuthority getRoleAuthorityById(Integer id);

    public List<RoleAuthority> getRoleAuthorityList(PageInfo pageInfo);
    
    public void saveSecurityRoleAuthority(RoleAuthority roleAuthority);
    public void removeSecurityRoleAuthorityById(Integer id);
    public RoleAuthority getSecurityRoleAuthorityById(Integer id);
    public List<RoleAuthority> getSecurityRoleAuthorityList(PageInfo pageInfo);
}
