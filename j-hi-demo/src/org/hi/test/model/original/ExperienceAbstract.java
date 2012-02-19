package org.hi.test.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.test.model.Experience;
import org.hi.test.model.Staff;
import org.hi.base.organization.model.HiUser;

public abstract class ExperienceAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 开始时间
	 */	
 	protected  Timestamp startTime;

 	 /**
	 * 结束时间
	 */	
 	protected  Timestamp endTime;

 	 /**
	 * 地点
	 */	
 	protected  String place;

 	 /**
	 * 任务
	 */	
 	protected  String task;

 	 /**
	 * 证明人
	 */	
 	protected  String people;

 	 /**
	 * staff
	 */	
 	protected  Staff staff;

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
    
    public Timestamp getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Timestamp startTime) {
    		if((startTime != null && this.startTime == null) || 
				this.startTime != null && (!this.startTime.equals(startTime) || startTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("startTime", this.startTime);
        	}
        this.startTime = startTime;
    }
    
    public Timestamp getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
    		if((endTime != null && this.endTime == null) || 
				this.endTime != null && (!this.endTime.equals(endTime) || endTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("endTime", this.endTime);
        	}
        this.endTime = endTime;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
    		if((place != null && this.place == null) || 
				this.place != null && (!this.place.equals(place) || place == null)){
        		this.setDirty(true);
        		this.oldValues.put("place", this.place);
        	}
        this.place = place;
    }
    
    public String getTask() {
        return this.task;
    }
    
    public void setTask(String task) {
    		if((task != null && this.task == null) || 
				this.task != null && (!this.task.equals(task) || task == null)){
        		this.setDirty(true);
        		this.oldValues.put("task", this.task);
        	}
        this.task = task;
    }
    
    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
    		if((people != null && this.people == null) || 
				this.people != null && (!this.people.equals(people) || people == null)){
        		this.setDirty(true);
        		this.oldValues.put("people", this.people);
        	}
        this.people = people;
    }
    
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
    		if((staff != null && this.staff == null) || 
				this.staff != null && (!this.staff.equals(staff) || staff == null)){
        		this.setDirty(true);
        		this.oldValues.put("staff", this.staff);
        	}
        this.staff = staff;
    }
    
   public BaseObject getParentEntity(){
	   return this.staff;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.staff = (Staff)parent;
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
		 if ( !(other instanceof Experience) ) return false;
		 Experience castOther = ( Experience ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("Experience".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("place", this.place)
		.append("task", this.task)
		.append("people", this.people);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}