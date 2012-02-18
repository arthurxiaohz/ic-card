package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.service.Manager;

public interface UserRoleManager extends Manager{
    
    public void saveUserRole(UserRole userRole);

    public void removeUserRoleById(Integer id);

    public UserRole getUserRoleById(Integer id);

    public List<UserRole> getUserRoleList(PageInfo pageInfo);
    
    /**
     * 删除该用户角色同时删除与该用户对应的所有权限
     */
    public void removeUserRoleAndAuthorityById(Integer userRoleId);
    
    /**
     * 删除与该用户对应的所有角色及用户权限
     * @param user 用户ID
     */
    public void removeUserRoleByUser(Integer userId);
    
    public void saveSecurityUserRole(UserRole userRole);
    public void removeSecurityUserRoleById(Integer id);
    public UserRole getSecurityUserRoleById(Integer id);
    public List<UserRole> getSecurityUserRoleList(PageInfo pageInfo);
}
