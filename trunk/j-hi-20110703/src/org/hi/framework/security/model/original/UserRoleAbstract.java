package org.hi.framework.security.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.framework.security.model.Role;
import org.hi.framework.security.model.UserRole;
import org.hi.base.organization.model.HiUser;

public abstract class UserRoleAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 用户
	 */	
 	protected  HiUser securityUser;

 	 /**
	 * 角色
	 */	
 	protected  Role role;


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
    		if((id != null && this.id == null) || 
				this.id != null && (!this.id.equals(id) || id == null)){
        		this.setDirty(true);
        		this.oldValues.put("id", this.id);
        	}
        this.id = id;
    }
    
     public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
    		if((version != null && this.version == null) || 
				this.version != null && (!this.version.equals(version) || version == null)){
        		this.setDirty(true);
        		this.oldValues.put("version", this.version);
        	}
        this.version = version;
    }
    
    public HiUser getSecurityUser() {
        return this.securityUser;
    }
    
    public void setSecurityUser(HiUser securityUser) {
    		if((securityUser != null && this.securityUser == null) || 
				this.securityUser != null && (!this.securityUser.equals(securityUser) || securityUser == null)){
        		this.setDirty(true);
        		this.oldValues.put("securityUser", this.securityUser);
        	}
        this.securityUser = securityUser;
    }
    
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
    		if((role != null && this.role == null) || 
				this.role != null && (!this.role.equals(role) || role == null)){
        		this.setDirty(true);
        		this.oldValues.put("role", this.role);
        	}
        this.role = role;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserRole) ) return false;
		 UserRole castOther = ( UserRole ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("UserRole".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}