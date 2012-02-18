package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.UserType;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserRole;
import org.hi.framework.security.service.RoleAuthorityManager;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.security.service.UserRoleManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class RoleAssignViewAction extends BaseAction{
	private Role role;
	private List<RoleAuthority> roleAuthorities;
	private List<UserRole> userRoles;
	
	public String execute() throws Exception {
		if(UserContextHelper.getUser().getUserMgrType() == null || 
				UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MENUAL){
			throw new BusinessException(I18NUtil.getString("您是一般用户,不能分派角色", "Role"));
		}
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		RoleAuthorityManager roleAuthMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		UserRoleManager userRoleMgr = (UserRoleManager)SpringContextHolder.getBean(UserRole.class);
		
		role = roleMgr.getRoleById(role.getId());
		
		if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER && (role.getCreator() == null || 
				!role.getCreator().equals(UserContextHelper.getUser()))){
			throw new BusinessException(I18NUtil.getString("您的用户类型是管理员,必须是您自己创建的角色才可以为该角色分派用户角色", "Role"));
		}
		
		Filter filter = FilterFactory.getSimpleFilter("role.id", role.getId(), Filter.OPERATOR_EQ);
		roleAuthorities = roleAuthMgr.getObjects(filter);
		
		userRoles = userRoleMgr.getObjects(filter);
		
		return returnCommand();
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<RoleAuthority> getRoleAuthorities() {
		return roleAuthorities;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}


}
