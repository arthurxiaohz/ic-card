package org.hi.base.organization.service;

import java.util.List;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface HiUserManager extends Manager
{
  public abstract void saveHiUser(HiUser paramHiUser);

  public abstract void removeHiUserById(Integer paramInteger);

  public abstract HiUser getHiUserById(Integer paramInteger);

  public abstract List<HiUser> getHiUserList(PageInfo paramPageInfo);

  public abstract void saveSecurityHiUser(HiUser paramHiUser);

  public abstract void removeSecurityHiUserById(Integer paramInteger);

  public abstract HiUser getSecurityHiUserById(Integer paramInteger);

  public abstract List<HiUser> getSecurityHiUserList(PageInfo paramPageInfo);

  public abstract String getAllOrgHTML();

  public abstract String getAllUserByOrgIdHTML(String paramString);

  public abstract String getAllUserHTML();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.service.HiUserManager
 * JD-Core Version:    0.6.0
 */