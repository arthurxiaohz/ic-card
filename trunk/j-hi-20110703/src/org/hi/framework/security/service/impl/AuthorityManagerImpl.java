package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.dao.AuthorityDAO;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.service.impl.ManagerImpl;

public class AuthorityManagerImpl extends ManagerImpl implements AuthorityManager{
    
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
    
    public void saveAuthority(Authority Authority){
    	saveObject(Authority);
    
    }

    public void removeAuthorityById(Integer id){
    	removeObjectById(id);
    	
    }

    public Authority getAuthorityById(Integer id){
   		return (Authority) getObjectById(id);
    }

    public List<Authority> getAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    public void saveSecurityAuthority(Authority authority){
    	saveObject(authority);
    }
    public void removeSecurityAuthorityById(Integer id){
    	removeObjectById(id);
    }
    public Authority getSecurityAuthorityById(Integer id){
    	return (Authority) getObjectById(id);
    }
    public List<Authority> getSecurityAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
