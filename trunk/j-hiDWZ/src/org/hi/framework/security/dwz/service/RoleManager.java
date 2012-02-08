package org.hi.framework.security.dwz.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.framework.security.model.Role;

public interface RoleManager extends org.hi.framework.security.service.RoleManager{
    
    /**
     * ���ݵ�ǰ�����¶�Ӧ���û�������Ӧ�Ľ�ɫ
     * @param role����Ҫ�����û��Ľ�ɫ
     * @param orgID������
     * @param users  �����¸���ɫ����Ա��û�����List�е���Ա�ᱻ�Ƴ�
     */
	public void saveUserRole(Role role, int orgID, List<HiUser> users);
    
    
}
