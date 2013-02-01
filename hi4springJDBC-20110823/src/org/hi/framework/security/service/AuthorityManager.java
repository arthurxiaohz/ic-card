package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.service.Manager;

public abstract interface AuthorityManager extends Manager
{
  public abstract void saveAuthority(Authority paramAuthority);

  public abstract void removeAuthorityById(Integer paramInteger);

  public abstract Authority getAuthorityById(Integer paramInteger);

  public abstract List<Authority> getAuthorityList(PageInfo paramPageInfo);

  public abstract void saveSecurityAuthority(Authority paramAuthority);

  public abstract void removeSecurityAuthorityById(Integer paramInteger);

  public abstract Authority getSecurityAuthorityById(Integer paramInteger);

  public abstract List<Authority> getSecurityAuthorityList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.AuthorityManager
 * JD-Core Version:    0.6.0
 */