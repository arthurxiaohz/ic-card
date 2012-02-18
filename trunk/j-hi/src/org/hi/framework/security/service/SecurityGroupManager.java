package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.service.Manager;

public interface SecurityGroupManager extends Manager{
    
    public void saveSecurityGroup(SecurityGroup securityGroup);

    public void removeSecurityGroupById(Integer id);

    public SecurityGroup getSecurityGroupById(Integer id);

    public List<SecurityGroup> getSecurityGroupList(PageInfo pageInfo);
    
    public void saveSecuritySecurityGroup(SecurityGroup securityGroup);
    public void removeSecuritySecurityGroupById(Integer id);
    public SecurityGroup getSecuritySecurityGroupById(Integer id);
    public List<SecurityGroup> getSecuritySecurityGroupList(PageInfo pageInfo);
}
