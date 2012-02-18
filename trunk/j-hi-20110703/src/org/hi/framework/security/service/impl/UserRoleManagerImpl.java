package org.hi.framework.security.service.impl;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.security.service.UserRoleManager;

public class UserRoleManagerImpl extends ManagerImpl implements UserRoleManager{
    
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
    
    public void saveUserRole(UserRole UserRole){
    	saveObject(UserRole);
    
    }

    public void removeUserRoleById(Integer id){
    	removeObjectById(id);
    	
    }

    public UserRole getUserRoleById(Integer id){
   		return (UserRole) getObjectById(id);
    }

    public List<UserRole> getUserRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

	@SuppressWarnings("unchecked")
	public void removeUserRoleAndAuthorityById(Integer userRoleId) {
		UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		UserRole userRole =  this.getUserRoleById(userRoleId);
		
		Filter filter = FilterFactory.getSimpleFilter("roleAuthority.role.id", userRole.getRole().getId(), Filter.OPERATOR_EQ)
				.addCondition("securityUser.id", userRole.getSecurityUser().getId(), Filter.OPERATOR_EQ);
		
		List<UserAuthority> userAuthorities = userAuthMgr.getObjects(filter);
		for (UserAuthority userAuthority : userAuthorities) {
			userAuthMgr.removeUserAuthorityById(userAuthority.getId());
		}
		
		this.removeUserRoleById(userRole.getId());
	}	
	
	
	public void removeUserRoleByUser(Integer userId){
		Filter filter = FilterFactory.getSimpleFilter("securityUser.id", userId, Filter.OPERATOR_EQ);
		List<UserRole> userRoles = this.getObjects(filter);
		for (UserRole userRole : userRoles) {
			removeUserRoleAndAuthorityById(userRole.getId());
		}
	}
	
	
    public void saveSecurityUserRole(UserRole userRole){
    	saveObject(userRole);
    }
    public void removeSecurityUserRoleById(Integer id){
    	removeObjectById(id);
    }
    public UserRole getSecurityUserRoleById(Integer id){
    	return (UserRole) getObjectById(id);
    }
    public List<UserRole> getSecurityUserRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
