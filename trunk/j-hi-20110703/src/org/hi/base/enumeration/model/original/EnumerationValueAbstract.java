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

public abstract class EnumerationValueAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 枚举值名称
	 */	
 	protected  String valueName;

 	 /**
	 * 显示信息
	 */	
 	protected  String displayRef;

 	 /**
	 * 描述
	 */	
 	protected  String description;

 	 /**
	 * 枚举值编号
	 */	
 	protected  String valueCode;

 	 /**
	 * 枚举项
	 */	
 	protected  Enumeration enumeration;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();


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
    
    public String getValueName() {
        return this.valueName;
    }
    
    public void setValueName(String valueName) {
    		if((valueName != null && this.valueName == null) || 
				this.valueName != null && (!this.valueName.equals(valueName) || valueName == null)){
        		this.setDirty(true);
        		this.oldValues.put("valueName", this.valueName);
        	}
        this.valueName = valueName;
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
    
    public String getValueCode() {
        return this.valueCode;
    }
    
    public void setValueCode(String valueCode) {
    		if((valueCode != null && this.valueCode == null) || 
				this.valueCode != null && (!this.valueCode.equals(valueCode) || valueCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("valueCode", this.valueCode);
        	}
        this.valueCode = valueCode;
    }
    
    public Enumeration getEnumeration() {
        return this.enumeration;
    }
    
    public void setEnumeration(Enumeration enumeration) {
    		if((enumeration != null && this.enumeration == null) || 
				this.enumeration != null && (!this.enumeration.equals(enumeration) || enumeration == null)){
        		this.setDirty(true);
        		this.oldValues.put("enumeration", this.enumeration);
        	}
        this.enumeration = enumeration;
    }
    
   public BaseObject getParentEntity(){
	   return this.enumeration;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.enumeration = (Enumeration)parent;
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
		 if ( !(other instanceof EnumerationValue) ) return false;
		 EnumerationValue castOther = ( EnumerationValue ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("EnumerationValue".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("valueName", this.valueName)
		.append("displayRef", this.displayRef)
		.append("description", this.description)
		.append("valueCode", this.valueCode);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}