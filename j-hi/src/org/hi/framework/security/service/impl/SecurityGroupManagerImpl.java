package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.SecurityGroup;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.SecurityGroupManager;

public class SecurityGroupManagerImpl extends ManagerImpl implements SecurityGroupManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveSecurityGroup(SecurityGroup SecurityGroup){
    	saveObject(SecurityGroup);
    
    }

    public void removeSecurityGroupById(Integer id){
    	removeObjectById(id);
    	
    }

    public SecurityGroup getSecurityGroupById(Integer id){
   		return (SecurityGroup) getObjectById(id);
    }

    public List<SecurityGroup> getSecurityGroupList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecuritySecurityGroup(SecurityGroup securityGroup){
    	saveObject(securityGroup);
    }
    public void removeSecuritySecurityGroupById(Integer id){
    	removeObjectById(id);
    }
    public SecurityGroup getSecuritySecurityGroupById(Integer id){
    	return (SecurityGroup) getObjectById(id);
    }
    public List<SecurityGroup> getSecuritySecurityGroupList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
