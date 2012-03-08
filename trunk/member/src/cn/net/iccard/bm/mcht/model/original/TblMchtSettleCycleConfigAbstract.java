package cn.net.iccard.bm.mcht.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtSettleCycleConfig;
import org.hi.base.organization.model.HiUser;

public abstract class TblMchtSettleCycleConfigAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 结算周期类型
	 */	
 	protected  Integer settleCycleType;

 	 /**
	 * 参数值
	 */	
 	protected  Integer ruleValue;

 	 /**
	 * 最小结算金额
	 */	
 	protected  Integer threshold;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDateTime = new Timestamp(System.currentTimeMillis());

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  HiUser lastUpdatedBy;

 	 /**
	 * 创建人
	 */	
 	protected  HiUser creator = org.hi.framework.security.context.UserContextHelper.getUser();

 	 /**
	 * 删除标识
	 */	
 	protected  Integer deleted = 0;


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
    
    public Integer getSettleCycleType() {
        return this.settleCycleType;
    }
    
    public void setSettleCycleType(Integer settleCycleType) {
    		if((settleCycleType != null && this.settleCycleType == null) || 
				this.settleCycleType != null && (!this.settleCycleType.equals(settleCycleType) || settleCycleType == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleCycleType", this.settleCycleType);
        	}
        this.settleCycleType = settleCycleType;
    }
    
    public Integer getRuleValue() {
        return this.ruleValue;
    }
    
    public void setRuleValue(Integer ruleValue) {
    		if((ruleValue != null && this.ruleValue == null) || 
				this.ruleValue != null && (!this.ruleValue.equals(ruleValue) || ruleValue == null)){
        		this.setDirty(true);
        		this.oldValues.put("ruleValue", this.ruleValue);
        	}
        this.ruleValue = ruleValue;
    }
    
    public Integer getThreshold() {
        return this.threshold;
    }
    
    public void setThreshold(Integer threshold) {
    		if((threshold != null && this.threshold == null) || 
				this.threshold != null && (!this.threshold.equals(threshold) || threshold == null)){
        		this.setDirty(true);
        		this.oldValues.put("threshold", this.threshold);
        	}
        this.threshold = threshold;
    }
    
    public Timestamp getCreatedDateTime() {
        return this.createdDateTime;
    }
    
    public void setCreatedDateTime(Timestamp createdDateTime) {
    		if((createdDateTime != null && this.createdDateTime == null) || 
				this.createdDateTime != null && (!this.createdDateTime.equals(createdDateTime) || createdDateTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("createdDateTime", this.createdDateTime);
        	}
        this.createdDateTime = createdDateTime;
    }
    
    public Timestamp getLastUpdatedDatetime() {
        return this.lastUpdatedDatetime;
    }
    
    public void setLastUpdatedDatetime(Timestamp lastUpdatedDatetime) {
    		if((lastUpdatedDatetime != null && this.lastUpdatedDatetime == null) || 
				this.lastUpdatedDatetime != null && (!this.lastUpdatedDatetime.equals(lastUpdatedDatetime) || lastUpdatedDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedDatetime", this.lastUpdatedDatetime);
        	}
        this.lastUpdatedDatetime = lastUpdatedDatetime;
    }
    
    public HiUser getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(HiUser lastUpdatedBy) {
    		if((lastUpdatedBy != null && this.lastUpdatedBy == null) || 
				this.lastUpdatedBy != null && (!this.lastUpdatedBy.equals(lastUpdatedBy) || lastUpdatedBy == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedBy", this.lastUpdatedBy);
        	}
        this.lastUpdatedBy = lastUpdatedBy;
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
    
    public Integer getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(Integer deleted) {
    		if((deleted != null && this.deleted == null) || 
				this.deleted != null && (!this.deleted.equals(deleted) || deleted == null)){
        		this.setDirty(true);
        		this.oldValues.put("deleted", this.deleted);
        	}
        this.deleted = deleted;
    }
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblMchtSettleCycleConfig) ) return false;
		 TblMchtSettleCycleConfig castOther = ( TblMchtSettleCycleConfig ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMchtSettleCycleConfig".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("ruleValue", this.ruleValue)
		.append("threshold", this.threshold)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}