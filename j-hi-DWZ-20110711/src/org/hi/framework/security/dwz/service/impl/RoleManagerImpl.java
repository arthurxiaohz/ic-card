package org.hi.framework.security.dwz.service.impl;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.dwz.service.RoleManager;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.UserRoleManager;

public class RoleManagerImpl extends org.hi.framework.security.service.impl.RoleManagerImpl implements RoleManager{
    
 	public void saveUserRole(Role role, int orgID, List<HiUser> users) {
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		Filter roleFilter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
		roleFilter.addCondition("securityUser.org.id", orgID,Filter.OPERATOR_EQ)  ;
		//得到部门下所有角色
		List<UserRole> userRoles = userRoleMgr.getObjects(roleFilter);
		
		if (userRoles!= null && userRoles.size()>0)
		{
			for(UserRole userRole : userRoles)
			{
				if (userRole.getSecurityUser() == null )
					continue;
				// 如果在选中的用户当中就删除
				if (!existIn(users,userRole.getSecurityUser().getId() ))
				{
					userRoleMgr.removeObject(userRole);
				}else// 如果在选中当中就将选中用户的List中删除这个记录
				{ 
					removeFormList(users,userRole.getSecurityUser().getId());
				}
			}
		}
		// 剩下的users就是需要增加的
		saveUserRole(role,users);
		
	}

	private void removeFormList(List<HiUser> users, Integer userID) {
		if (users == null)
			return ;
		for(int i=users.size()-1; i>=0 ; i--)
		{
			if (users.get(i).getId() .equals(userID) )
			{
				users.remove( i);
				return;
			}
		}
	}

	private boolean existIn(List<HiUser> users, Integer userID) {
		if (users == null || users.size() == 0 )
			return false;
		for(HiUser user : users )
		{
			if (user.getId() .equals(userID))
				return true;
		}
		return false;
	} 
}
