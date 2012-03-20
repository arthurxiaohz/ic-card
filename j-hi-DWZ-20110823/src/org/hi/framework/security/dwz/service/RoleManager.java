package org.hi.framework.security.dwz.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.model.Role;

public interface RoleManager extends org.hi.framework.security.service.RoleManager{
    
    /**
     * 根据当前部门下对应的用户赋给相应的角色
     * @param role：需要赋给用户的角色
     * @param orgID：部门
     * @param users  部门下赋角色的人员，没在这个List中的人员会被移除
     */
	public void saveUserRole(Role role, int orgID, List<HiUser> users);
    
    
}
