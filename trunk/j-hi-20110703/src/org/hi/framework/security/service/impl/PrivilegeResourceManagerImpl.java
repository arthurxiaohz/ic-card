package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.PrivilegeResource;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.PrivilegeResourceManager;

public class PrivilegeResourceManagerImpl extends ManagerImpl implements PrivilegeResourceManager{
    
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
    
    public void savePrivilegeResource(PrivilegeResource privilegeResource){
    	saveObject(privilegeResource);
    
    }

    public void removePrivilegeResourceById(Integer id){
    	removeObjectById(id);
    	
    }

    public PrivilegeResource getPrivilegeResourceById(Integer id){
   		return (PrivilegeResource) getObjectById(id);
    }

    public List<PrivilegeResource> getPrivilegeResourceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityPrivilegeResource(PrivilegeResource privilegeResource){
    	saveObject(privilegeResource);
    }
    public void removeSecurityPrivilegeResourceById(Integer id){
    	removeObjectById(id);
    }
    public PrivilegeResource getSecurityPrivilegeResourceById(Integer id){
    	return (PrivilegeResource) getObjectById(id);
    }
    public List<PrivilegeResource> getSecurityPrivilegeResourceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
