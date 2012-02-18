package org.hi.framework.security.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.menu.model.MenuLink;
import org.hi.framework.security.model.Authority;

public abstract class AuthorityAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 权限名称
	 */	
 	protected  String authorityName;

 	 /**
	 * 显示信息
	 */	
 	protected  String displayRef;

 	 /**
	 * 属性资源
	 */	
 	protected  String propertedResource;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 权限类型
	 */	
 	protected  Integer authorityType;

 	 /**
	 * 菜单项
	 */	
 	protected  MenuLink menuLink;


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
    
    public String getAuthorityName() {
        return this.authorityName;
    }
    
    public void setAuthorityName(String authorityName) {
    		if((authorityName != null && this.authorityName == null) || 
				this.authorityName != null && (!this.authorityName.equals(authorityName) || authorityName == null)){
        		this.setDirty(true);
        		this.oldValues.put("authorityName", this.authorityName);
        	}
        this.authorityName = authorityName;
    }
    
    public String getDisplayRef() {
        return this.displayRef;
    }
    
    public void setDisplayRef(String displayRef) {
    		if((displayRef != null && this.displayRef == null) || 
				this.displayRef != null && (!this.displayRef.equals(displayRef) || displayRef == null)){
        		this.setDirty(true);
        		this.oldValues.put("displayRef", this.displayRef);
        	}
        this.displayRef = displayRef;
    }
    
    public String getPropertedResource() {
        return this.propertedResource;
    }
    
    public void setPropertedResource(String propertedResource) {
    		if((propertedResource != null && this.propertedResource == null) || 
				this.propertedResource != null && (!this.propertedResource.equals(propertedResource) || propertedResource == null)){
        		this.setDirty(true);
        		this.oldValues.put("propertedResource", this.propertedResource);
        	}
        this.propertedResource = propertedResource;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
    		if((description != null && this.description == null) || 
				this.description != null && (!this.description.equals(description) || description == null)){
        		this.setDirty(true);
        		this.oldValues.put("description", this.description);
        	}
        this.description = description;
    }
    
    public Integer getAuthorityType() {
        return this.authorityType;
    }
    
    public void setAuthorityType(Integer authorityType) {
    		if((authorityType != null && this.authorityType == null) || 
				this.authorityType != null && (!this.authorityType.equals(authorityType) || authorityType == null)){
        		this.setDirty(true);
        		this.oldValues.put("authorityType", this.authorityType);
        	}
        this.authorityType = authorityType;
    }
    
    public MenuLink getMenuLink() {
        return this.menuLink;
    }
    
    public void setMenuLink(MenuLink menuLink) {
    		if((menuLink != null && this.menuLink == null) || 
				this.menuLink != null && (!this.menuLink.equals(menuLink) || menuLink == null)){
        		this.setDirty(true);
        		this.oldValues.put("menuLink", this.menuLink);
        	}
        this.menuLink = menuLink;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Authority) ) return false;
		 Authority castOther = ( Authority ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Authority".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("authorityName", this.authorityName)
		.append("displayRef", this.displayRef)
		.append("propertedResource", this.propertedResource)
		.append("description", this.description)
		.append("authorityType", this.authorityType);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}