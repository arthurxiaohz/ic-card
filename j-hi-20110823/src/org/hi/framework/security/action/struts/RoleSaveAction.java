package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.RoleManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class RoleSaveAction extends BaseAction {
	private Role role;
	private List<RoleAuthority> roleAuthorities;
	private String roleAuthorityIndex;
	
	public String execute() throws Exception {
		if(super.perExecute(null)!= null) return returnCommand();
		RoleManager roleMgr = (RoleManager)SpringContextHolder.getBean(Role.class);
		Filter filter = FilterFactory.getSimpleFilter("roleName", role.getRoleName(), Filter.OPERATOR_EQ);
		List<Role> roles = roleMgr.getObjects(filter);
		if((role.getId() == null && roles.size() > 0) || (role.getId() != null && roles.size() > 1) )
			throw new BusinessException(I18NUtil.getStringByParameter("½ÇÉ«ÃûÖØ¸´", "Role", role.getRoleName()));
		String[] indexs = null;
		if(roleAuthorityIndex != null)
			indexs= roleAuthorityIndex.split(",");
		
		if(roles.size() == 0){
			if(role.getId() == null)
				roles.add(new Role());
			else{
				roles.add(role);
			}
		}
		Role _role = roles.get(0);
		
		_role.setDescription(role.getDescription());
		_role.setDisplayRef(role.getDisplayRef());
		_role.setRoleName(role.getRoleName());
//		_role.setVersion(role.getVersion());
		roleMgr.saveRoleAndAuthority(_role, roleAuthorities, indexs);
		super.postExecute(null);
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

	public void setRoleAuthorities(List<RoleAuthority> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}

	public String getRoleAuthorityIndex() {
		return roleAuthorityIndex;
	}

	public void setRoleAuthorityIndex(String roleAuthorityIndex) {
		this.roleAuthorityIndex = roleAuthorityIndex;
	}

}
