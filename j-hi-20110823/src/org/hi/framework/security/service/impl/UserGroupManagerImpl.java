package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.UserGroupManager;

public class UserGroupManagerImpl extends ManagerImpl implements UserGroupManager{
    
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
    
    public void saveUserGroup(UserGroup UserGroup){
    	saveObject(UserGroup);
    
    }

    public void removeUserGroupById(Integer id){
    	removeObjectById(id);
    	
    }

    public UserGroup getUserGroupById(Integer id){
   		return (UserGroup) getObjectById(id);
    }

    public List<UserGroup> getUserGroupList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

	public void removeUserGroupByUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}
	
	
    public void saveSecurityUserGroup(UserGroup userGroup){
    	saveObject(userGroup);
    }
    public void removeSecurityUserGroupById(Integer id){
    	removeObjectById(id);
    }
    public UserGroup getSecurityUserGroupById(Integer id){
    	return (UserGroup) getObjectById(id);
    }
    public List<UserGroup> getSecurityUserGroupList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
