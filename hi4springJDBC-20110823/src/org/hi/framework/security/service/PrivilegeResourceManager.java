package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.service.Manager;

public abstract interface PrivilegeResourceManager extends Manager
{
  public abstract void savePrivilegeResource(PrivilegeResource paramPrivilegeResource);

  public abstract void removePrivilegeResourceById(Integer paramInteger);

  public abstract PrivilegeResource getPrivilegeResourceById(Integer paramInteger);

  public abstract List<PrivilegeResource> getPrivilegeResourceList(PageInfo paramPageInfo);

  public abstract void saveSecurityPrivilegeResource(PrivilegeResource paramPrivilegeResource);

  public abstract void removeSecurityPrivilegeResourceById(Integer paramInteger);

  public abstract PrivilegeResource getSecurityPrivilegeResourceById(Integer paramInteger);

  public abstract List<PrivilegeResource> getSecurityPrivilegeResourceList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.PrivilegeResourceManager
 * JD-Core Version:    0.6.0
 */