package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.service.RoleManager;
import org.hi.i18n.util.I18NUtil;

public class RoleRemoveAction extends BaseAction{
	private Role role;
	
	public String execute() throws Exception {
		if(UserContextHelper.getUser().getUserMgrType() == null || 
				UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MENUAL){
			throw new BusinessException(I18NUtil.getString("����һ���û�,����ɾ������ɫ", "Role"));
		}
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		role = roleMgr.getRoleById(role.getId());
		HiUser currentUsre = UserContextHelper.getUser();
		
		if(currentUsre.getUserMgrType() == UserType.USERTYPE_MANAGER && (role.getCreator() == null 
			|| !role.getCreator().equals(currentUsre)))
			throw new BusinessException(I18NUtil.getString("�����û�����Ϊ����Ա,ֻ��ɾ�����Լ��������Ľ�ɫ", "Role"));
		
		roleMgr.removeRoleUserAuthority(role.getId());
		return returnCommand();
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
