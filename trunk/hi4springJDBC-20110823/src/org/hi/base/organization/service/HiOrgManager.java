package org.hi.base.organization.service;

import java.util.List;
import org.hi.base.organization.model.HiOrg;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface HiOrgManager extends Manager
{
  public abstract void saveHiOrg(HiOrg paramHiOrg);

  public abstract void removeHiOrgById(Integer paramInteger);

  public abstract HiOrg getHiOrgById(Integer paramInteger);

  public abstract List<HiOrg> getHiOrgList(PageInfo paramPageInfo);

  public abstract void saveSecurityHiOrg(HiOrg paramHiOrg);

  public abstract void removeSecurityHiOrgById(Integer paramInteger);

  public abstract HiOrg getSecurityHiOrgById(Integer paramInteger);

  public abstract List<HiOrg> getSecurityHiOrgList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.service.HiOrgManager
 * JD-Core Version:    0.6.0
 */