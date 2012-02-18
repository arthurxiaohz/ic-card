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
     * �޸Ľ�ɫʵ���Ͼ����޸Ľ�ɫȨ��,ͬʱ�����û�Ȩ����Ϣ
     */
    public void saveRoleAndAuthority(Role role, List<RoleAuthority> roleAuthories, String[] indexs);

	/**
	 * �ڸ��û����ɽ�ɫ��ͬʱ,ʵ����Ҳ���ڸ��û�����Ȩ��,������û�Ȩ����Ϣ
	 */
	public void saveUserRole(Role role, List<HiUser> users);
	
	/**
	 * ɾ��һ����ɫ��Ӱ�쵽�û���ɫ/�û�Ȩ��,һ��ɾ��.��һ����ɫ���ж���û�,һ���û�����
	 * ���Ȩ��
	 */
	public void removeRoleUserAuthority(Integer roleId);
	
    public void saveSecurityRole(Role role);
    public void removeSecurityRoleById(Integer id);
    public Role getSecurityRoleById(Integer id);
    public List<Role> getSecurityRoleList(PageInfo pageInfo);
}
