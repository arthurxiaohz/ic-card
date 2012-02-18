package org.hi.framework.security.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.organization.model.HiOrg;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.Authority;
import org.hi.base.organization.model.HiUser;

public abstract class UserAuthorityAbstract extends BaseObject implements Serializable{

 	
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
	 * 权限
	 */	
 	protected  Authority authority;

 	 /**
	 * 部门
	 */	
 	protected  HiOrg org;

 	 /**
	 * 范围
	 */	
 	protected  Integer scope;

 	 /**
	 * 角色权限
	 */	
 	protected  RoleAuthority roleAuthority;

 	 /**
	 * 权限处理器
	 */	
 	protected  String privilegeProcessor;


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
    
    public RoleAuthority getRoleAuthority() {
        return this.roleAuthority;
    }
    
    public void setRoleAuthority(RoleAuthority roleAuthority) {
    		if((roleAuthority != null && this.roleAuthority == null) || 
				this.roleAuthority != null && (!this.roleAuthority.equals(roleAuthority) || roleAuthority == null)){
        		this.setDirty(true);
        		this.oldValues.put("roleAuthority", this.roleAuthority);
        	}
        this.roleAuthority = roleAuthority;
    }
    
    public String getPrivilegeProcessor() {
        return this.privilegeProcessor;
    }
    
    public void setPrivilegeProcessor(String privilegeProcessor) {
    		if((privilegeProcessor != null && this.privilegeProcessor == null) || 
				this.privilegeProcessor != null && (!this.privilegeProcessor.equals(privilegeProcessor) || privilegeProcessor == null)){
        		this.setDirty(true);
        		this.oldValues.put("privilegeProcessor", this.privilegeProcessor);
        	}
        this.privilegeProcessor = privilegeProcessor;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserAuthority) ) return false;
		 UserAuthority castOther = ( UserAuthority ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("UserAuthority".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("privilegeProcessor", this.privilegeProcessor);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}