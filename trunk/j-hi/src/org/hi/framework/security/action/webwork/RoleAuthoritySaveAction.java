package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.RoleAuthorityManager;
import org.hi.framework.web.SynchronizationData;

public class RoleAuthoritySaveAction extends BaseAction implements SynchronizationData{
	private RoleAuthority roleAuthority;
	
	public String execute() throws Exception {
		if(super.perExecute(roleAuthority)!= null) return returnCommand();
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		roleAuthorityMgr.saveRoleAuthority(roleAuthority);
		super.postExecute(roleAuthority);
		return returnCommand();
	}
	
	public RoleAuthority getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthority roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

}
