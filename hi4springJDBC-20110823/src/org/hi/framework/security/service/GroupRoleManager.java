package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.service.Manager;

public abstract interface GroupRoleManager extends Manager
{
  public abstract void saveGroupRole(GroupRole paramGroupRole);

  public abstract void removeGroupRoleById(Integer paramInteger);

  public abstract GroupRole getGroupRoleById(Integer paramInteger);

  public abstract List<GroupRole> getGroupRoleList(PageInfo paramPageInfo);

  public abstract void saveSecurityGroupRole(GroupRole paramGroupRole);

  public abstract void removeSecurityGroupRoleById(Integer paramInteger);

  public abstract GroupRole getSecurityGroupRoleById(Integer paramInteger);

  public abstract List<GroupRole> getSecurityGroupRoleList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.GroupRoleManager
 * JD-Core Version:    0.6.0
 */