package org.hi.framework.security.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.framework.security.action.RolePageInfo;
import org.hi.framework.security.action.AuthorityPageInfo;
import org.hi.base.organization.action.HiOrgPageInfo;

public class RoleAuthorityPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_scope;
 	protected  String  f_scope_op;

 	protected  RolePageInfo role;
 	protected  AuthorityPageInfo authority;
 	protected  HiOrgPageInfo org;

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
   
	public RolePageInfo getRole() {
		return role;
	}

	public void setRole(RolePageInfo role) {
		this.role = role;
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

}
