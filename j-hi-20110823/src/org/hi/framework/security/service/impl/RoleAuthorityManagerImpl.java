package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.RoleAuthorityManager;

public class RoleAuthorityManagerImpl extends ManagerImpl implements RoleAuthorityManager{
    
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
    
    public void saveRoleAuthority(RoleAuthority RoleAuthority){
    	saveObject(RoleAuthority);
    
    }

    public void removeRoleAuthorityById(Integer id){
    	removeObjectById(id);
    	
    }

    public RoleAuthority getRoleAuthorityById(Integer id){
   		return (RoleAuthority) getObjectById(id);
    }

    public List<RoleAuthority> getRoleAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityRoleAuthority(RoleAuthority roleAuthority){
    	saveObject(roleAuthority);
    }
    public void removeSecurityRoleAuthorityById(Integer id){
    	removeObjectById(id);
    }
    public RoleAuthority getSecurityRoleAuthorityById(Integer id){
    	return (RoleAuthority) getObjectById(id);
    }
    public List<RoleAuthority> getSecurityRoleAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
