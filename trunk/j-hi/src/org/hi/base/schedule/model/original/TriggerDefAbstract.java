package org.hi.base.schedule.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.organization.model.HiUser;

public abstract class TriggerDefAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 触发名称
	 */	
 	protected  String triggerName;

 	 /**
	 * 触发器组
	 */	
 	protected  String triggerGroup;

 	 /**
	 * 工作项
	 */	
 	protected  JobDetailDef jobDetail;

 	 /**
	 * 执行之后持久化
	 * 
	 */	
 	protected  Integer volatiled;

 	 /**
	 * 下一次触发时间
	 */	
 	protected  Timestamp nextFireTime;

 	 /**
	 * 上一次触发时间
	 */	
 	protected  Timestamp prevFireTime;

 	 /**
	 * 优先级
	 */	
 	protected  Integer priority;

 	 /**
	 * 触发器状态
	 */	
 	protected  Integer triggerStats;

 	 /**
	 * 开始时间
	 */	
 	protected  Timestamp startTime;

 	 /**
	 * 截止时间
	 */	
 	protected  Timestamp endTime;

 	 /**
	 * 触发指令类型
	 */	
 	protected  Integer misfireInstr;

 	 /**
	 * 表达式
	 */	
 	protected  String cronExpression;

 	 /**
	 * 激活
	 * 
	 */	
 	protected  Integer enabled;

 	 /**
	 * 时区
	 */	
 	protected  Integer timeZone;

 	 /**
	 * 触发器描述
	 */	
 	protected  String description;

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
    
    public String getTriggerName() {
        return this.triggerName;
    }
    
    public void setTriggerName(String triggerName) {
    		if((triggerName != null && this.triggerName == null) || 
				this.triggerName != null && (!this.triggerName.equals(triggerName) || triggerName == null)){
        		this.setDirty(true);
        		this.oldValues.put("triggerName", this.triggerName);
        	}
        this.triggerName = triggerName;
    }
    
    public String getTriggerGroup() {
        return this.triggerGroup;
    }
    
    public void setTriggerGroup(String triggerGroup) {
    		if((triggerGroup != null && this.triggerGroup == null) || 
				this.triggerGroup != null && (!this.triggerGroup.equals(triggerGroup) || triggerGroup == null)){
        		this.setDirty(true);
        		this.oldValues.put("triggerGroup", this.triggerGroup);
        	}
        this.triggerGroup = triggerGroup;
    }
    
    public JobDetailDef getJobDetail() {
        return this.jobDetail;
    }
    
    public void setJobDetail(JobDetailDef jobDetail) {
    		if((jobDetail != null && this.jobDetail == null) || 
				this.jobDetail != null && (!this.jobDetail.equals(jobDetail) || jobDetail == null)){
        		this.setDirty(true);
        		this.oldValues.put("jobDetail", this.jobDetail);
        	}
        this.jobDetail = jobDetail;
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
    
    public Timestamp getNextFireTime() {
        return this.nextFireTime;
    }
    
    public void setNextFireTime(Timestamp nextFireTime) {
    		if((nextFireTime != null && this.nextFireTime == null) || 
				this.nextFireTime != null && (!this.nextFireTime.equals(nextFireTime) || nextFireTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("nextFireTime", this.nextFireTime);
        	}
        this.nextFireTime = nextFireTime;
    }
    
    public Timestamp getPrevFireTime() {
        return this.prevFireTime;
    }
    
    public void setPrevFireTime(Timestamp prevFireTime) {
    		if((prevFireTime != null && this.prevFireTime == null) || 
				this.prevFireTime != null && (!this.prevFireTime.equals(prevFireTime) || prevFireTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("prevFireTime", this.prevFireTime);
        	}
        this.prevFireTime = prevFireTime;
    }
    
    public Integer getPriority() {
        return this.priority;
    }
    
    public void setPriority(Integer priority) {
    		if((priority != null && this.priority == null) || 
				this.priority != null && (!this.priority.equals(priority) || priority == null)){
        		this.setDirty(true);
        		this.oldValues.put("priority", this.priority);
        	}
        this.priority = priority;
    }
    
    public Integer getTriggerStats() {
        return this.triggerStats;
    }
    
    public void setTriggerStats(Integer triggerStats) {
    		if((triggerStats != null && this.triggerStats == null) || 
				this.triggerStats != null && (!this.triggerStats.equals(triggerStats) || triggerStats == null)){
        		this.setDirty(true);
        		this.oldValues.put("triggerStats", this.triggerStats);
        	}
        this.triggerStats = triggerStats;
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
    
    public Integer getMisfireInstr() {
        return this.misfireInstr;
    }
    
    public void setMisfireInstr(Integer misfireInstr) {
    		if((misfireInstr != null && this.misfireInstr == null) || 
				this.misfireInstr != null && (!this.misfireInstr.equals(misfireInstr) || misfireInstr == null)){
        		this.setDirty(true);
        		this.oldValues.put("misfireInstr", this.misfireInstr);
        	}
        this.misfireInstr = misfireInstr;
    }
    
    public String getCronExpression() {
        return this.cronExpression;
    }
    
    public void setCronExpression(String cronExpression) {
    		if((cronExpression != null && this.cronExpression == null) || 
				this.cronExpression != null && (!this.cronExpression.equals(cronExpression) || cronExpression == null)){
        		this.setDirty(true);
        		this.oldValues.put("cronExpression", this.cronExpression);
        	}
        this.cronExpression = cronExpression;
    }
    
    public Integer getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Integer enabled) {
    		if((enabled != null && this.enabled == null) || 
				this.enabled != null && (!this.enabled.equals(enabled) || enabled == null)){
        		this.setDirty(true);
        		this.oldValues.put("enabled", this.enabled);
        	}
        this.enabled = enabled;
    }
    
    public Integer getTimeZone() {
        return this.timeZone;
    }
    
    public void setTimeZone(Integer timeZone) {
    		if((timeZone != null && this.timeZone == null) || 
				this.timeZone != null && (!this.timeZone.equals(timeZone) || timeZone == null)){
        		this.setDirty(true);
        		this.oldValues.put("timeZone", this.timeZone);
        	}
        this.timeZone = timeZone;
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
		 if ( !(other instanceof TriggerDef) ) return false;
		 TriggerDef castOther = ( TriggerDef ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TriggerDef".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("triggerName", this.triggerName)
		.append("triggerGroup", this.triggerGroup)
		.append("priority", this.priority)
		.append("triggerStats", this.triggerStats)
		.append("misfireInstr", this.misfireInstr)
		.append("cronExpression", this.cronExpression)
		.append("timeZone", this.timeZone)
		.append("description", this.description);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}