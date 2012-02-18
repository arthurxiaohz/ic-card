package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.service.Manager;

public interface RoleManager extends Manager{
    
    public void saveRole(Role role);

    public void removeRoleById(Integer id);

    public Role getRoleById(Integer id);

    public List<Role> getRoleList(PageInfo pageInfo);
    
    
    /**
     * 修改角色实际上就是修改角色权限,同时更改用户权限信息
     */
    public void saveRoleAndAuthority(Role role, List<RoleAuthority> roleAuthories, String[] indexs);

	/**
	 * 在给用户分派角色的同时,实现上也是在给用户分派权限,会更改用户权限信息
	 */
	public void saveUserRole(Role role, List<HiUser> users);
	
	/**
	 * 删除一个角色会影响到用户角色/用户权限,一并删除.即一个角色会有多个用户,一个用户会有
	 * 多个权限
	 */
	public void removeRoleUserAuthority(Integer roleId);
	
    public void saveSecurityRole(Role role);
    public void removeSecurityRoleById(Integer id);
    public Role getSecurityRoleById(Integer id);
    public List<Role> getSecurityRoleList(PageInfo pageInfo);
}
