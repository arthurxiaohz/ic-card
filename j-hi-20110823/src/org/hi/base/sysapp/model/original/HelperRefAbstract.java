package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.model.Helper;

public abstract class HelperRefAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 相关主题
	 */	
 	protected  Helper refHelper;

 	 /**
	 * helper
	 */	
 	protected  Helper helper;


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
    
    public Helper getRefHelper() {
        return this.refHelper;
    }
    
    public void setRefHelper(Helper refHelper) {
    		if((refHelper != null && this.refHelper == null) || 
				this.refHelper != null && (!this.refHelper.equals(refHelper) || refHelper == null)){
        		this.setDirty(true);
        		this.oldValues.put("refHelper", this.refHelper);
        	}
        this.refHelper = refHelper;
    }
    
    public Helper getHelper() {
        return this.helper;
    }
    
    public void setHelper(Helper helper) {
    		if((helper != null && this.helper == null) || 
				this.helper != null && (!this.helper.equals(helper) || helper == null)){
        		this.setDirty(true);
        		this.oldValues.put("helper", this.helper);
        	}
        this.helper = helper;
    }
    
   public BaseObject getParentEntity(){
	   return this.helper;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.helper = (Helper)parent;
   }
   


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HelperRef) ) return false;
		 HelperRef castOther = ( HelperRef ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("HelperRef".hashCode());
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