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
     * ɾ�����û���ɫͬʱɾ������û���Ӧ������Ȩ��
     */
    public void removeUserRoleAndAuthorityById(Integer userRoleId);
    
    /**
     * ɾ������û���Ӧ�����н�ɫ���û�Ȩ��
     * @param user �û�ID
     */
    public void removeUserRoleByUser(Integer userId);
    
    public void saveSecurityUserRole(UserRole userRole);
    public void removeSecurityUserRoleById(Integer id);
    public UserRole getSecurityUserRoleById(Integer id);
    public List<UserRole> getSecurityUserRoleList(PageInfo pageInfo);
}
