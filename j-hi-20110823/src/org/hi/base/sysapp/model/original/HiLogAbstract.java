package org.hi.base.sysapp.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.sysapp.model.HiLog;
import org.hi.base.organization.model.HiUser;

public abstract class HiLogAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 操作人
	 */	
 	protected  HiUser operator;

 	 /**
	 * 操作时间
	 */	
 	protected  Timestamp operateDate;

 	 /**
	 * 动作
	 */	
 	protected  String action;

 	 /**
	 * 操作内容
	 */	
 	protected  String actionContext;


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
    
    public HiUser getOperator() {
        return this.operator;
    }
    
    public void setOperator(HiUser operator) {
    		if((operator != null && this.operator == null) || 
				this.operator != null && (!this.operator.equals(operator) || operator == null)){
        		this.setDirty(true);
        		this.oldValues.put("operator", this.operator);
        	}
        this.operator = operator;
    }
    
    public Timestamp getOperateDate() {
        return this.operateDate;
    }
    
    public void setOperateDate(Timestamp operateDate) {
    		if((operateDate != null && this.operateDate == null) || 
				this.operateDate != null && (!this.operateDate.equals(operateDate) || operateDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("operateDate", this.operateDate);
        	}
        this.operateDate = operateDate;
    }
    
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
    		if((action != null && this.action == null) || 
				this.action != null && (!this.action.equals(action) || action == null)){
        		this.setDirty(true);
        		this.oldValues.put("action", this.action);
        	}
        this.action = action;
    }
    
    public String getActionContext() {
        return this.actionContext;
    }
    
    public void setActionContext(String actionContext) {
    		if((actionContext != null && this.actionContext == null) || 
				this.actionContext != null && (!this.actionContext.equals(actionContext) || actionContext == null)){
        		this.setDirty(true);
        		this.oldValues.put("actionContext", this.actionContext);
        	}
        this.actionContext = actionContext;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HiLog) ) return false;
		 HiLog castOther = ( HiLog ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("HiLog".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("action", this.action)
		.append("actionContext", this.actionContext);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}