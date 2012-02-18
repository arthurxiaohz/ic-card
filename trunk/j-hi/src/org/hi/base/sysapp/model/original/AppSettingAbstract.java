package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.organization.model.HiUser;

public abstract class AppSettingAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 组名
	 */	
 	protected  String appGroup;

 	 /**
	 * 配置名
	 */	
 	protected  String appName;

 	 /**
	 * 配置值
	 */	
 	protected  String appValue;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = 
				org.hi.framework.security.context.UserContextHelper.getUser()
			;


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
    
    public String getAppGroup() {
        return this.appGroup;
    }
    
    public void setAppGroup(String appGroup) {
    		if((appGroup != null && this.appGroup == null) || 
				this.appGroup != null && (!this.appGroup.equals(appGroup) || appGroup == null)){
        		this.setDirty(true);
        		this.oldValues.put("appGroup", this.appGroup);
        	}
        this.appGroup = appGroup;
    }
    
    public String getAppName() {
        return this.appName;
    }
    
    public void setAppName(String appName) {
    		if((appName != null && this.appName == null) || 
				this.appName != null && (!this.appName.equals(appName) || appName == null)){
        		this.setDirty(true);
        		this.oldValues.put("appName", this.appName);
        	}
        this.appName = appName;
    }
    
    public String getAppValue() {
        return this.appValue;
    }
    
    public void setAppValue(String appValue) {
    		if((appValue != null && this.appValue == null) || 
				this.appValue != null && (!this.appValue.equals(appValue) || appValue == null)){
        		this.setDirty(true);
        		this.oldValues.put("appValue", this.appValue);
        	}
        this.appValue = appValue;
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AppSetting) ) return false;
		 AppSetting castOther = ( AppSetting ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("AppSetting".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("appGroup", this.appGroup)
		.append("appName", this.appName)
		.append("appValue", this.appValue)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}