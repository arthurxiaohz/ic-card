package org.hi.i18n.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.model.Language;
import org.hi.base.organization.model.HiUser;

public abstract class LanguageAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * Key值
	 */	
 	protected  String keyStr;

 	 /**
	 * 服务
	 */	
 	protected  String service;

 	 /**
	 * 实体
	 */	
 	protected  String entity;

 	 /**
	 * 系统参数
	 */	
 	protected  Integer isSystem = 0;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

	private  List<LanguageStr> languageStrs;

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
    
    public String getKeyStr() {
        return this.keyStr;
    }
    
    public void setKeyStr(String keyStr) {
    		if((keyStr != null && this.keyStr == null) || 
				this.keyStr != null && (!this.keyStr.equals(keyStr) || keyStr == null)){
        		this.setDirty(true);
        		this.oldValues.put("keyStr", this.keyStr);
        	}
        this.keyStr = keyStr;
    }
    
    public String getService() {
        return this.service;
    }
    
    public void setService(String service) {
    		if((service != null && this.service == null) || 
				this.service != null && (!this.service.equals(service) || service == null)){
        		this.setDirty(true);
        		this.oldValues.put("service", this.service);
        	}
        this.service = service;
    }
    
    public String getEntity() {
        return this.entity;
    }
    
    public void setEntity(String entity) {
    		if((entity != null && this.entity == null) || 
				this.entity != null && (!this.entity.equals(entity) || entity == null)){
        		this.setDirty(true);
        		this.oldValues.put("entity", this.entity);
        	}
        this.entity = entity;
    }
    
    public Integer getIsSystem() {
        return this.isSystem;
    }
    
    public void setIsSystem(Integer isSystem) {
    		if((isSystem != null && this.isSystem == null) || 
				this.isSystem != null && (!this.isSystem.equals(isSystem) || isSystem == null)){
        		this.setDirty(true);
        		this.oldValues.put("isSystem", this.isSystem);
        	}
        this.isSystem = isSystem;
    }
    
    public HiUser getCreator() {
        return this.creator;
    }
    
    public void setCreator(HiUser creator) {
    		if((creator != null && this.creator == null) || 
				this.creator != null && (!this.creator.equals(creator) || creator == null)){
        		this.setDirty(true);
        		this.oldValues.put("creator", this.creator);
        	}
        this.creator = creator;
    }
    

    public void setLanguageStrs(List<LanguageStr> languageStrs) {
        this.languageStrs = languageStrs;
    }

    public List<LanguageStr> getLanguageStrs() {
        return this.languageStrs;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Language) ) return false;
		 Language castOther = ( Language ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Language".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("keyStr", this.keyStr)
		.append("service", this.service)
		.append("entity", this.entity)
		.append("isSystem", this.isSystem);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}