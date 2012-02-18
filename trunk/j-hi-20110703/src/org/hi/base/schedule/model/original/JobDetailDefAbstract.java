package org.hi.base.schedule.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.enumeration.model.YesNo;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.organization.model.HiUser;

public abstract class JobDetailDefAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * ����id
	 */	
	protected  Integer id;

	/**
	 * �汾����version
	 */	
 	protected  Integer version;

 	 /**
	 * ��������
	 */	
 	protected  String jobName;

 	 /**
	 * ������
	 */	
 	protected  String jobGroup;

 	 /**
	 * ��ȫ��
	 */	
 	protected  String jobClassName;

 	 /**
	 * ִ��֮�־û�
	 * 
	 */	
 	protected  Integer durable;

 	 /**
	 * ִ��֮��־û�
	 * 
	 */	
 	protected  Integer volatiled;

 	 /**
	 * �����������ִ��
	 * 
	 */	
 	protected  Integer shouldRecover;

 	 /**
	 * ��������
	 */	
 	protected  String description;

 	 /**
	 * ������
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
    
    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobName(String jobName) {
    		if((jobName != null && this.jobName == null) || 
				this.jobName != null && (!this.jobName.equals(jobName) || jobName == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobName", this.jobName);
        	}
        this.jobName = jobName;
    }
    
    public String getJobGroup() {
        return this.jobGroup;
    }
    
    public void setJobGroup(String jobGroup) {
    		if((jobGroup != null && this.jobGroup == null) || 
				this.jobGroup != null && (!this.jobGroup.equals(jobGroup) || jobGroup == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobGroup", this.jobGroup);
        	}
        this.jobGroup = jobGroup;
    }
    
    public String getJobClassName() {
        return this.jobClassName;
    }
    
    public void setJobClassName(String jobClassName) {
    		if((jobClassName != null && this.jobClassName == null) || 
				this.jobClassName != null && (!this.jobClassName.equals(jobClassName) || jobClassName == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobClassName", this.jobClassName);
        	}
        this.jobClassName = jobClassName;
    }
    
    public Integer getDurable() {
        return this.durable;
    }
    
    public void setDurable(Integer durable) {
    		if((durable != null && this.durable == null) || 
				this.durable != null && (!this.durable.equals(durable) || durable == null)){
        		this.setDirty(true);
        		this.oldValues.put("durable", this.durable);
        	}
        this.durable = durable;
    }
    
    public Integer getVolatiled() {
        return this.volatiled;
    }
    
    public void setVolatiled(Integer volatiled) {
    		if((volatiled != null && this.volatiled == null) || 
				this.volatiled != null && (!this.volatiled.equals(volatiled) || volatiled == null)){
        		this.setDirty(true);
        		this.oldValues.put("volatiled", this.volatiled);
        	}
        this.volatiled = volatiled;
    }
    
    public Integer getShouldRecover() {
        return this.shouldRecover;
    }
    
    public void setShouldRecover(Integer shouldRecover) {
    		if((shouldRecover != null && this.shouldRecover == null) || 
				this.shouldRecover != null && (!this.shouldRecover.equals(shouldRecover) || shouldRecover == null)){
        		this.setDirty(true);
        		this.oldValues.put("shouldRecover", this.shouldRecover);
        	}
        this.shouldRecover = shouldRecover;
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
		 if ( !(other instanceof JobDetailDef) ) return false;
		 JobDetailDef castOther = ( JobDetailDef ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("JobDetailDef".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("jobName", this.jobName)
		.append("jobGroup", this.jobGroup)
		.append("jobClassName", this.jobClassName)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}