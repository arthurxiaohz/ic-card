package org.hi.framework.security.action;

import org.hi.base.organization.model.HiOrg;
import org.hi.framework.security.model.Authority;

public class UserAuthorityForm {
 	protected  Authority authority;
 	protected  HiOrg org;
 	protected  Integer scope;
 	
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public HiOrg getOrg() {
		return org;
	}
	public void setOrg(HiOrg org) {
		this.org = org;
	}
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
}
