package org.hi.framework.security.service;

import java.util.List;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;
import org.springframework.dao.DataAccessException;

public abstract interface SecurityManager
{
  public abstract HiUser getUser(String paramString);

  public abstract List<UserAuthority> getUserAuthorities(HiUser paramHiUser)
    throws DataAccessException;

  public abstract List<UserRole> getUserRoles(HiUser paramHiUser);

  public abstract List<UserGroup> getUserGroups(HiUser paramHiUser);

  public abstract UserContext getUserContext(String paramString);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.SecurityManager
 * JD-Core Version:    0.6.0
 */