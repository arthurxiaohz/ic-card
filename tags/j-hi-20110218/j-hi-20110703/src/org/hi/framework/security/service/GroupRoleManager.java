package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.service.Manager;

public interface GroupRoleManager extends Manager{
    
    public void saveGroupRole(GroupRole groupRole);

    public void removeGroupRoleById(Integer id);

    public GroupRole getGroupRoleById(Integer id);

    public List<GroupRole> getGroupRoleList(PageInfo pageInfo);
    
    public void saveSecurityGroupRole(GroupRole groupRole);
    public void removeSecurityGroupRoleById(Integer id);
    public GroupRole getSecurityGroupRoleById(Integer id);
    public List<GroupRole> getSecurityGroupRoleList(PageInfo pageInfo);
}
