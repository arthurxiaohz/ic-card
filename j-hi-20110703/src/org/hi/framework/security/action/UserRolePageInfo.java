package org.hi.framework.security.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;
import org.hi.framework.security.action.RolePageInfo;

public class UserRolePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;

 	protected  HiUserPageInfo securityUser;
 	protected  RolePageInfo role;

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
   
	public HiUserPageInfo getSecurityUser() {
		return securityUser;
	}

	public void setSecurityUser(HiUserPageInfo securityUser) {
		this.securityUser = securityUser;
	}
	public RolePageInfo getRole() {
		return role;
	}

	public void setRole(RolePageInfo role) {
		this.role = role;
	}

}
