package org.hi.framework.security.dwz.service;

import java.util.List;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.model.Role;

public abstract interface RoleManager extends org.hi.framework.security.service.RoleManager
{
  public abstract void saveUserRole(Role paramRole, int paramInt, List<HiUser> paramList);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.dwz.service.RoleManager
 * JD-Core Version:    0.6.0
 */