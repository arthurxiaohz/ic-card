package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.service.Manager;

public abstract interface RoleAuthorityManager extends Manager
{
  public abstract void saveRoleAuthority(RoleAuthority paramRoleAuthority);

  public abstract void removeRoleAuthorityById(Integer paramInteger);

  public abstract RoleAuthority getRoleAuthorityById(Integer paramInteger);

  public abstract List<RoleAuthority> getRoleAuthorityList(PageInfo paramPageInfo);

  public abstract void saveSecurityRoleAuthority(RoleAuthority paramRoleAuthority);

  public abstract void removeSecurityRoleAuthorityById(Integer paramInteger);

  public abstract RoleAuthority getSecurityRoleAuthorityById(Integer paramInteger);

  public abstract List<RoleAuthority> getSecurityRoleAuthorityList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.RoleAuthorityManager
 * JD-Core Version:    0.6.0
 */