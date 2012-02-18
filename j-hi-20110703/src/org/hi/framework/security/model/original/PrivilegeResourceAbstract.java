package org.hi.framework.security.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.framework.security.model.PrivilegeResource;

public abstract class PrivilegeResourceAbstract extends BaseObject implements Serializable{

 	
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
	 * 表现层
	 */	
 	protected  String viewLayer;

 	 /**
	 * 表现层权限扩展
	 */	
 	protected  String veiwExtAuthNames;

 	 /**
	 * 业务层
	 */	
 	protected  String businessLayer;

 	 /**
	 * 业务层权限扩展
	 */	
 	protected  String bizExtAuthNames;


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
    
    public String getViewLayer() {
        return this.viewLayer;
    }
    
    public void setViewLayer(String viewLayer) {
    		if((viewLayer != null && this.viewLayer == null) || 
				this.viewLayer != null && (!this.viewLayer.equals(viewLayer) || viewLayer == null)){
        		this.setDirty(true);
        		this.oldValues.put("viewLayer", this.viewLayer);
        	}
        this.viewLayer = viewLayer;
    }
    
    public String getVeiwExtAuthNames() {
        return this.veiwExtAuthNames;
    }
    
    public void setVeiwExtAuthNames(String veiwExtAuthNames) {
    		if((veiwExtAuthNames != null && this.veiwExtAuthNames == null) || 
				this.veiwExtAuthNames != null && (!this.veiwExtAuthNames.equals(veiwExtAuthNames) || veiwExtAuthNames == null)){
        		this.setDirty(true);
        		this.oldValues.put("veiwExtAuthNames", this.veiwExtAuthNames);
        	}
        this.veiwExtAuthNames = veiwExtAuthNames;
    }
    
    public String getBusinessLayer() {
        return this.businessLayer;
    }
    
    public void setBusinessLayer(String businessLayer) {
    		if((businessLayer != null && this.businessLayer == null) || 
				this.businessLayer != null && (!this.businessLayer.equals(businessLayer) || businessLayer == null)){
        		this.setDirty(true);
        		this.oldValues.put("businessLayer", this.businessLayer);
        	}
        this.businessLayer = businessLayer;
    }
    
    public String getBizExtAuthNames() {
        return this.bizExtAuthNames;
    }
    
    public void setBizExtAuthNames(String bizExtAuthNames) {
    		if((bizExtAuthNames != null && this.bizExtAuthNames == null) || 
				this.bizExtAuthNames != null && (!this.bizExtAuthNames.equals(bizExtAuthNames) || bizExtAuthNames == null)){
        		this.setDirty(true);
        		this.oldValues.put("bizExtAuthNames", this.bizExtAuthNames);
        	}
        this.bizExtAuthNames = bizExtAuthNames;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PrivilegeResource) ) return false;
		 PrivilegeResource castOther = ( PrivilegeResource ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("PrivilegeResource".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("authorityName", this.authorityName)
		.append("viewLayer", this.viewLayer)
		.append("veiwExtAuthNames", this.veiwExtAuthNames)
		.append("businessLayer", this.businessLayer)
		.append("bizExtAuthNames", this.bizExtAuthNames);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}