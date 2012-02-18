package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;
import org.hi.framework.web.SynchronizationData;

public class AuthoritySaveAction extends BaseAction implements SynchronizationData{
	private Authority authority;
	
	public String execute() throws Exception {
		if(super.perExecute(authority)!= null) return returnCommand();
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		authorityMgr.saveAuthority(authority);
		super.postExecute(authority);
		return returnCommand();
	}
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
