package org.hi.framework.security.service;

import java.util.List;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.service.Manager;

public abstract interface RoleManager extends Manager
{
  public abstract void saveRole(Role paramRole);

  public abstract void removeRoleById(Integer paramInteger);

  public abstract Role getRoleById(Integer paramInteger);

  public abstract List<Role> getRoleList(PageInfo paramPageInfo);

  public abstract void saveRoleAndAuthority(Role paramRole, List<RoleAuthority> paramList, String[] paramArrayOfString);

  public abstract void saveUserRole(Role paramRole, List<HiUser> paramList);

  public abstract void removeRoleUserAuthority(Integer paramInteger);

  public abstract void saveSecurityRole(Role paramRole);

  public abstract void removeSecurityRoleById(Integer paramInteger);

  public abstract Role getSecurityRoleById(Integer paramInteger);

  public abstract List<Role> getSecurityRoleList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.RoleManager
 * JD-Core Version:    0.6.0
 */