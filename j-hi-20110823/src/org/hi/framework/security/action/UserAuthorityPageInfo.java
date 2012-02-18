package org.hi.framework.security.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;
import org.hi.framework.security.action.AuthorityPageInfo;
import org.hi.base.organization.action.HiOrgPageInfo;
import org.hi.framework.security.action.RoleAuthorityPageInfo;

public class UserAuthorityPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_scope;
 	protected  String  f_scope_op;

 	protected  HiUserPageInfo securityUser;
 	protected  AuthorityPageInfo authority;
 	protected  HiOrgPageInfo org;
 	protected  RoleAuthorityPageInfo roleAuthority;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public Integer getF_scope() {
        return this.f_scope;
    }
    
    public void setF_scope(Integer f_scope) {
        this.f_scope = f_scope;
    }
    
    public String getF_scope_op() {
        return this.f_scope_op;
    }
    
    public void setF_scope_op(String f_scope_op) {
        this.f_scope_op = f_scope_op;
    }
   
	public HiUserPageInfo getSecurityUser() {
		return securityUser;
	}

	public void setSecurityUser(HiUserPageInfo securityUser) {
		this.securityUser = securityUser;
	}
	public AuthorityPageInfo getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityPageInfo authority) {
		this.authority = authority;
	}
	public HiOrgPageInfo getOrg() {
		return org;
	}

	public void setOrg(HiOrgPageInfo org) {
		this.org = org;
	}
	public RoleAuthorityPageInfo getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthorityPageInfo roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

}
