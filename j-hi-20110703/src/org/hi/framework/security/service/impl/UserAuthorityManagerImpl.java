package org.hi.framework.security.service.impl;

import java.util.Iterator;
import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.security.service.UserAuthorityManager;

public class UserAuthorityManagerImpl extends ManagerImpl implements UserAuthorityManager{
    
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
    
    public void saveUserAuthority(UserAuthority UserAuthority){
    	saveObject(UserAuthority);
    
    }

    public void removeUserAuthorityById(Integer id){
    	removeObjectById(id);
    	
    }

    public UserAuthority getUserAuthorityById(Integer id){
   		return (UserAuthority) getObjectById(id);
    }

    public List<UserAuthority> getUserAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    //zhanghao
    public void saveBatchUserAuthority(List<HiUser> users, List<UserAuthority> userAuthorities){
    	
    	if(users == null || users.size()<0)
    		return;
    	
    	for (HiUser user : users) {
			
    		for (UserAuthority userAuthority : userAuthorities) {
    			if(userAuthority.getAuthority() == null)
    				continue;
    			
    			UserAuthority persistence = new UserAuthority();
    			persistence.setSecurityUser(user);
    			persistence.setAuthority(userAuthority.getAuthority());
    			persistence.setOrg(userAuthority.getOrg());
    			persistence.setScope(userAuthority.getScope());
    			userAuthority.setSecurityUser(user);
    			this.saveUserAuthority(persistence);
			}
		}
    }
    
    public List<UserAuthority> getUserAuthority(HiUser user){
    	Filter  filter = FilterFactory.getSimpleFilter("securityUser.id", user.getId());
    	return this.getObjects(filter);
    }
    
    public void saveBatchSingleUserAuthority(String[] indexs, List<UserAuthority> userAuthorities, HiUser user){
    	for (int i = 0; i < indexs.length; i++) {
    		UserAuthority userAuthority = userAuthorities.get(Integer.parseInt(indexs[i].trim()));
    		if(userAuthority.getId() == null){
    			userAuthority.setSecurityUser(user);
    			this.saveUserAuthority(userAuthority);
    		}
    		else{
    			UserAuthority persistent  = this.getUserAuthorityById(userAuthority.getId());
    			persistent.setAuthority(userAuthority.getAuthority());
    			persistent.setOrg(userAuthority.getOrg());
    			persistent.setSecurityUser(user);
    			persistent.setScope(userAuthority.getScope());
    			persistent.setRoleAuthority(userAuthority.getRoleAuthority());
    			this.saveUserAuthority(persistent);
    		}
		}
    }

	public void removeUserAuthorityByUser(Integer userId) {
		Filter filter = FilterFactory.getSimpleFilter("securityUser.id", userId, Filter.OPERATOR_EQ);
		List<UserAuthority> userAuthoites = this.getObjects(filter);
		for (UserAuthority userAuthority : userAuthoites) {
			this.removeObjectById(userAuthority.getId());
		}
	}
	
	
	public void removeUserAuthorityByRoleAuthority(RoleAuthority roleAuthority){
		if(roleAuthority == null || roleAuthority.getId() == null)
			return;
		Filter filter = FilterFactory.getSimpleFilter("roleAuthority.id", roleAuthority.getId(), Filter.OPERATOR_EQ);
		List<UserAuthority> userAuthoites = this.getObjects(filter);
		for (UserAuthority userAuthority : userAuthoites) {
			this.removeObjectById(userAuthority.getId());
		}
	}
	
    public void saveSecurityUserAuthority(UserAuthority userAuthority){
    	saveObject(userAuthority);
    }
    public void removeSecurityUserAuthorityById(Integer id){
    	removeObjectById(id);
    }
    public UserAuthority getSecurityUserAuthorityById(Integer id){
    	return (UserAuthority) getObjectById(id);
    }
    public List<UserAuthority> getSecurityUserAuthorityList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
    
}
