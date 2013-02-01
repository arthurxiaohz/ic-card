package org.hi.framework.security.service;

import java.util.List;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.service.Manager;

public abstract interface SecurityGroupManager extends Manager
{
  public abstract void saveSecurityGroup(SecurityGroup paramSecurityGroup);

  public abstract void removeSecurityGroupById(Integer paramInteger);

  public abstract SecurityGroup getSecurityGroupById(Integer paramInteger);

  public abstract List<SecurityGroup> getSecurityGroupList(PageInfo paramPageInfo);

  public abstract void saveSecuritySecurityGroup(SecurityGroup paramSecurityGroup);

  public abstract void removeSecuritySecurityGroupById(Integer paramInteger);

  public abstract SecurityGroup getSecuritySecurityGroupById(Integer paramInteger);

  public abstract List<SecurityGroup> getSecuritySecurityGroupList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.SecurityGroupManager
 * JD-Core Version:    0.6.0
 */