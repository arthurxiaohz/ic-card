package org.hi.framework.security.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.framework.security.action.SecurityGroupPageInfo;
import org.hi.framework.security.action.RolePageInfo;

public class GroupRolePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;

 	protected  SecurityGroupPageInfo securityGroup;
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
   
	public SecurityGroupPageInfo getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroupPageInfo securityGroup) {
		this.securityGroup = securityGroup;
	}
	public RolePageInfo getRole() {
		return role;
	}

	public void setRole(RolePageInfo role) {
		this.role = role;
	}

}
