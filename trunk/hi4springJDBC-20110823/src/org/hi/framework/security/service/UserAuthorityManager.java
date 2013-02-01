package org.hi.framework.security.service;

import java.util.List;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.service.Manager;

public abstract interface UserAuthorityManager extends Manager
{
  public abstract void saveUserAuthority(UserAuthority paramUserAuthority);

  public abstract void removeUserAuthorityById(Integer paramInteger);

  public abstract UserAuthority getUserAuthorityById(Integer paramInteger);

  public abstract List<UserAuthority> getUserAuthorityList(PageInfo paramPageInfo);

  public abstract void saveBatchUserAuthority(List<HiUser> paramList, List<UserAuthority> paramList1);

  public abstract List<UserAuthority> getUserAuthority(HiUser paramHiUser);

  public abstract void saveBatchSingleUserAuthority(String[] paramArrayOfString, List<UserAuthority> paramList, HiUser paramHiUser);

  public abstract void removeUserAuthorityByUser(Integer paramInteger);

  public abstract void removeUserAuthorityByRoleAuthority(RoleAuthority paramRoleAuthority);

  public abstract void saveSecurityUserAuthority(UserAuthority paramUserAuthority);

  public abstract void removeSecurityUserAuthorityById(Integer paramInteger);

  public abstract UserAuthority getSecurityUserAuthorityById(Integer paramInteger);

  public abstract List<UserAuthority> getSecurityUserAuthorityList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.UserAuthorityManager
 * JD-Core Version:    0.6.0
 */