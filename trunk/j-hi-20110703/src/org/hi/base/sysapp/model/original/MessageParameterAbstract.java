package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;

public abstract class MessageParameterAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 参数键
	 */	
 	protected  String parameterKey;

 	 /**
	 * 参数值
	 */	
 	protected  String parameterValue;

 	 /**
	 * 消息
	 */	
 	protected  Message message;


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
    
    public String getParameterKey() {
        return this.parameterKey;
    }
    
    public void setParameterKey(String parameterKey) {
    		if((parameterKey != null && this.parameterKey == null) || 
				this.parameterKey != null && (!this.parameterKey.equals(parameterKey) || parameterKey == null)){
        		this.setDirty(true);
        		this.oldValues.put("parameterKey", this.parameterKey);
        	}
        this.parameterKey = parameterKey;
    }
    
    public String getParameterValue() {
        return this.parameterValue;
    }
    
    public void setParameterValue(String parameterValue) {
    		if((parameterValue != null && this.parameterValue == null) || 
				this.parameterValue != null && (!this.parameterValue.equals(parameterValue) || parameterValue == null)){
        		this.setDirty(true);
        		this.oldValues.put("parameterValue", this.parameterValue);
        	}
        this.parameterValue = parameterValue;
    }
    
    public Message getMessage() {
        return this.message;
    }
    
    public void setMessage(Message message) {
    		if((message != null && this.message == null) || 
				this.message != null && (!this.message.equals(message) || message == null)){
        		this.setDirty(true);
        		this.oldValues.put("message", this.message);
        	}
        this.message = message;
    }
    
   public BaseObject getParentEntity(){
	   return this.message;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.message = (Message)parent;
   }
   


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MessageParameter) ) return false;
		 MessageParameter castOther = ( MessageParameter ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("MessageParameter".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("parameterKey", this.parameterKey)
		.append("parameterValue", this.parameterValue);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}