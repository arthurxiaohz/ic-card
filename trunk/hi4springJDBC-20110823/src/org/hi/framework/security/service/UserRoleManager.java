package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.service.Manager;

public abstract interface UserRoleManager extends Manager
{
  public abstract void saveUserRole(UserRole paramUserRole);

  public abstract void removeUserRoleById(Integer paramInteger);

  public abstract UserRole getUserRoleById(Integer paramInteger);

  public abstract List<UserRole> getUserRoleList(PageInfo paramPageInfo);

  public abstract void removeUserRoleAndAuthorityById(Integer paramInteger);

  public abstract void removeUserRoleByUser(Integer paramInteger);

  public abstract void saveSecurityUserRole(UserRole paramUserRole);

  public abstract void removeSecurityUserRoleById(Integer paramInteger);

  public abstract UserRole getSecurityUserRoleById(Integer paramInteger);

  public abstract List<UserRole> getSecurityUserRoleList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.UserRoleManager
 * JD-Core Version:    0.6.0
 */