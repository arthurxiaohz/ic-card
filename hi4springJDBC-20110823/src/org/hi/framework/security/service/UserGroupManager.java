package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.service.Manager;

public abstract interface UserGroupManager extends Manager
{
  public abstract void saveUserGroup(UserGroup paramUserGroup);

  public abstract void removeUserGroupById(Integer paramInteger);

  public abstract UserGroup getUserGroupById(Integer paramInteger);

  public abstract List<UserGroup> getUserGroupList(PageInfo paramPageInfo);

  public abstract void removeUserGroupByUser(Integer paramInteger);

  public abstract void saveSecurityUserGroup(UserGroup paramUserGroup);

  public abstract void removeSecurityUserGroupById(Integer paramInteger);

  public abstract UserGroup getSecurityUserGroupById(Integer paramInteger);

  public abstract List<UserGroup> getSecurityUserGroupList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.UserGroupManager
 * JD-Core Version:    0.6.0
 */