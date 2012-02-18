package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.service.Manager;

public interface UserGroupManager extends Manager{
    
    public void saveUserGroup(UserGroup userGroup);

    public void removeUserGroupById(Integer id);

    public UserGroup getUserGroupById(Integer id);

    public List<UserGroup> getUserGroupList(PageInfo pageInfo);
    
    
    /**
     * ɾ������û���Ӧ����
     * @param userId �û�ID
     */
    public void removeUserGroupByUser(Integer userId);
    
    public void saveSecurityUserGroup(UserGroup userGroup);
    public void removeSecurityUserGroupById(Integer id);
    public UserGroup getSecurityUserGroupById(Integer id);
    public List<UserGroup> getSecurityUserGroupList(PageInfo pageInfo);
}
