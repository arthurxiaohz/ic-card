package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;

public class AuthorityRemoveAction extends BaseAction{
	private Authority authority;
	
	public String execute() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		authorityMgr.removeAuthorityById(authority.getId());
		return returnCommand();
	}
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
