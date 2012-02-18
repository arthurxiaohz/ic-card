package org.hi.base.enumeration.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.organization.model.HiUser;

public abstract class EnumerationAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;
   
 	 /**
	 * 枚举名称
	 */	
 	protected  String enName;

 	 /**
	 * 显示信息
	 */	
 	protected  String displayRef;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**    
	 * 枚举类型
	 */	
 	protected  Integer enumerationType = 0;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

	private  List<EnumerationValue> enumerationValues;

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
    
    public String getEnName() {
        return this.enName;
    }
    
    public void setEnName(String enName) {
    		if((enName != null && this.enName == null) || 
				this.enName != null && (!this.enName.equals(enName) || enName == null)){
        		this.setDirty(true);
        		this.oldValues.put("enName", this.enName);
        	}
        this.enName = enName;
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
    
    public Integer getEnumerationType() {
        return this.enumerationType;
    }
    
    public void setEnumerationType(Integer enumerationType) {
    		if((enumerationType != null && this.enumerationType == null) || 
				this.enumerationType != null && (!this.enumerationType.equals(enumerationType) || enumerationType == null)){
        		this.setDirty(true);
        		this.oldValues.put("enumerationType", this.enumerationType);
        	}
        this.enumerationType = enumerationType;
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
    

    public void setEnumerationValues(List<EnumerationValue> enumerationValues) {
        this.enumerationValues = enumerationValues;
    }

    public List<EnumerationValue> getEnumerationValues() {
        return this.enumerationValues;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Enumeration) ) return false;
		 Enumeration castOther = ( Enumeration ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Enumeration".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("enName", this.enName)
		.append("displayRef", this.displayRef)
		.append("description", this.description)
		.append("enumerationType", this.enumerationType);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}