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
import org.hi.base.organization.model.HiOrg;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.Authority;

public abstract class RoleAuthorityAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 角色
	 */	
 	protected  Role role;

 	 /**
	 * 权限
	 */	
 	protected  Authority authority;

 	 /**
	 * 部门
	 */	
 	protected  HiOrg org;

 	 /**
	 * 范围
	 * 
	 */	
 	protected  Integer scope;


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
    
    public Authority getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(Authority authority) {
    		if((authority != null && this.authority == null) || 
				this.authority != null && (!this.authority.equals(authority) || authority == null)){
        		this.setDirty(true);
        		this.oldValues.put("authority", this.authority);
        	}
        this.authority = authority;
    }
    
    public HiOrg getOrg() {
        return this.org;
    }
    
    public void setOrg(HiOrg org) {
    		if((org != null && this.org == null) || 
				this.org != null && (!this.org.equals(org) || org == null)){
        		this.setDirty(true);
        		this.oldValues.put("org", this.org);
        	}
        this.org = org;
    }
    
    public Integer getScope() {
        return this.scope;
    }
    
    public void setScope(Integer scope) {
    		if((scope != null && this.scope == null) || 
				this.scope != null && (!this.scope.equals(scope) || scope == null)){
        		this.setDirty(true);
        		this.oldValues.put("scope", this.scope);
        	}
        this.scope = scope;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RoleAuthority) ) return false;
		 RoleAuthority castOther = ( RoleAuthority ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("RoleAuthority".hashCode());
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