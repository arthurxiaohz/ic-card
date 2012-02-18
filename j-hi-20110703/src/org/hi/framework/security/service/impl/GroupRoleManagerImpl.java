package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.GroupRole;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.GroupRoleManager;

public class GroupRoleManagerImpl extends ManagerImpl implements GroupRoleManager{
    
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
    
    public void saveGroupRole(GroupRole GroupRole){
    	saveObject(GroupRole);
    
    }

    public void removeGroupRoleById(Integer id){
    	removeObjectById(id);
    	
    }

    public GroupRole getGroupRoleById(Integer id){
   		return (GroupRole) getObjectById(id);
    }

    public List<GroupRole> getGroupRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityGroupRole(GroupRole groupRole){
    	saveObject(groupRole);
    }
    public void removeSecurityGroupRoleById(Integer id){
    	removeObjectById(id);
    }
    public GroupRole getSecurityGroupRoleById(Integer id){
    	return (GroupRole) getObjectById(id);
    }
    public List<GroupRole> getSecurityGroupRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
