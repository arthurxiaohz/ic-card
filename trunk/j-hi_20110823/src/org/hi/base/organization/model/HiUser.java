package org.hi.base.organization.model;

import org.hi.base.organization.model.original.HiUserAbstract;
import org.hi.framework.security.constant.ScurityUserMgrType;


public class HiUser extends HiUserAbstract{
	
    public boolean isSupperManager(){
    	if(this.userMgrType == null)
    		return false;
    	return this.userMgrType.equals(UserType.USERTYPE_ADMINISTRATOR);
    }

    public String getDataSymbol(){
    	return this.fullName;
    }
    
    public Integer getUserMgrType() {
    	if(this.userMgrType == null)
    		return UserType.USERTYPE_MENUAL;
    	return this.userMgrType;
    }
}