package org.hi.framework.security.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.security.service.RoleAuthorityManager;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.security.service.UserRoleManager;
import org.hi.framework.service.impl.ManagerImpl;

public class RoleManagerImpl extends ManagerImpl implements RoleManager{
    
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
    
    public void saveRole(Role Role){
    	saveObject(Role);
    
    }

    public void removeRoleById(Integer id){
    	removeObjectById(id);
    	
    }

    public Role getRoleById(Integer id){
   		return (Role) getObjectById(id);
    }

    public List<Role> getRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    /* (non-Javadoc)
     * @see org.hi.framework.security.service.RoleManager#saveRoleAndAuthority(org.hi.framework.security.model.Role, java.util.List, java.lang.String[])
     */
    @SuppressWarnings("unchecked")
	public void saveRoleAndAuthority(Role role, List<RoleAuthority> roleAuthories, String[] indexs){
    	this.saveRole(role);
    	RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
    	UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
    	UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
    	
    	Set<HiUser> users = new HashSet<HiUser>();
    	if(role.getId() != null){
    		Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
    		List<RoleAuthority> delRoleAuths = roleAuthMgr.getObjects(filter);
    		for (RoleAuthority roleAuthority : delRoleAuths) {
    			Filter uAFilter = FilterFactory.getSimpleFilter("roleAuthority.id", roleAuthority.getId(), Filter.OPERATOR_EQ);
    			List<UserAuthority> userAuthrities = userAuthorityMgr.getObjects(uAFilter);
    			//删除用户权限中与该角色权限相关联的记录
    			for (UserAuthority userAuthority : userAuthrities) {
    				if(userAuthority.getSecurityUser() != null)
    					users.add(userAuthority.getSecurityUser());
    				userAuthorityMgr.removeObject(userAuthority);
				}
    			roleAuthMgr.removeRoleAuthorityById(roleAuthority.getId());
    			
			}
    	}
    	
    	if(indexs == null)
    		return;
    	
    	Filter userRoleFilter = FilterFactory.getSimpleFilter("role.id", role.getId());
    	List<UserRole> userRoles = userRoleMgr.getObjects(userRoleFilter);
    	for (UserRole userRole : userRoles) {
			if(!users.contains(userRole.getSecurityUser()))
				users.add(userRole.getSecurityUser());
		}
    	
    	AuthorityManager AuthorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
    	HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
    	for (int i = 0; i < indexs.length; i++) {
    		RoleAuthority roleAuthority = roleAuthories.get(Integer.parseInt(indexs[i].trim()));
    		Authority authority = (Authority)AuthorityMgr.getObjectById(roleAuthority.getAuthority().getId());
    		HiOrg org = roleAuthority.getOrg() == null || roleAuthority.getOrg().getId() == null ? null :(HiOrg)orgMgr.getObjectById(roleAuthority.getOrg().getId());
    		RoleAuthority persistent = new RoleAuthority();
    		persistent.setAuthority(authority);
    		persistent.setScope(roleAuthority.getScope());
    		persistent.setPrivilegeProcessor(roleAuthority.getPrivilegeProcessor());
    		persistent.setOrg(org);
    		persistent.setRole(role);
    		roleAuthMgr.saveRoleAuthority(persistent);
    		
    		//加用户权限记录
    		for (HiUser user : users) {
    			UserAuthority userAuthority = new UserAuthority();
    			userAuthority.setSecurityUser(user);
    			userAuthority.setAuthority(authority);
    			userAuthority.setOrg(org);
    			userAuthority.setScope(roleAuthority.getScope());
    			userAuthority.setPrivilegeProcessor(roleAuthority.getPrivilegeProcessor());
    			userAuthority.setRoleAuthority(persistent);
    			userAuthorityMgr.saveUserAuthority(userAuthority);
			}
    	}
    }

	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.RoleManager#saveUserRole(org.hi.framework.security.model.Role, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	public void saveUserRole(Role role, List<HiUser> users) {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		UserAuthorityManager userAuthMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		
		Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
		List<RoleAuthority> roleAuths = roleAuthMgr.getObjects(filter);
		
		List<UserRole> userRoles = userRoleMgr.getObjects(filter);
		Set<Integer> userIds = new HashSet<Integer>();
		
		for (UserRole userRole : userRoles) {
			userIds.add(userRole.getSecurityUser().getId());
		}
		
		
		for (HiUser user : users) {
			if(userIds.contains(user.getId()))
				continue;
			
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setSecurityUser(user);
			userRoleMgr.saveUserRole(userRole);
			
			for (RoleAuthority roleAuthority : roleAuths) {
				UserAuthority userAuthority = new UserAuthority();
				
				userAuthority.setAuthority(roleAuthority.getAuthority());
				userAuthority.setOrg(roleAuthority.getOrg());
				userAuthority.setRoleAuthority(roleAuthority);
				userAuthority.setScope(roleAuthority.getScope());
				userAuthority.setPrivilegeProcessor(roleAuthority.getPrivilegeProcessor());
				userAuthority.setSecurityUser(user);
				
				userAuthMgr.saveUserAuthority(userAuthority);
			}
		}
		
		
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.security.service.RoleManager#removeRoleUserAuthority(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public void removeRoleUserAuthority(Integer roleId) {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		
		Role role =this.getRoleById(roleId);

		
		Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
		//删除用户角色
		List<UserRole> userRoles = userRoleMgr.getObjects(filter);
		for (UserRole userRole : userRoles) {
			userRoleMgr.removeUserRoleAndAuthorityById(userRole.getId());
		}
		
		//删除角色权限,同时删除与该用户对所有用户权限
		List<RoleAuthority> roleAuths = roleAuthMgr.getObjects(filter);
		for (RoleAuthority roleAuthority : roleAuths) {
			userAuthorityMgr.removeUserAuthorityByRoleAuthority(roleAuthority);
			roleAuthMgr.removeRoleAuthorityById(roleAuthority.getId());
		}
		
		//删除角色
		this.removeRoleById(roleId);
	}
	
	
    public void saveSecurityRole(Role role){
    	saveObject(role);
    }
    public void removeSecurityRoleById(Integer id){
    	removeObjectById(id);
    }
    public Role getSecurityRoleById(Integer id){
    	return (Role) getObjectById(id);
    }
    public List<Role> getSecurityRoleList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
