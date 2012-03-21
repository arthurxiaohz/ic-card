package cn.net.iccard.bm.mcht.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
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
	 * 结算频度间隔
	 */	
 	protected  Integer settleInterval;

 	 /**
	 * 最小结算金额
	 */	
 	protected  Integer threshold;

 	 /**
	 * 备付金
	 */	
 	protected  Integer excessReserve;

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
	 * tblMchtInfo
	 */	
 	protected  TblMchtInfo tblMchtInfo;

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
    
    public Integer getSettleInterval() {
        return this.settleInterval;
    }
    
    public void setSettleInterval(Integer settleInterval) {
    		if((settleInterval != null && this.settleInterval == null) || 
				this.settleInterval != null && (!this.settleInterval.equals(settleInterval) || settleInterval == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleInterval", this.settleInterval);
        	}
        this.settleInterval = settleInterval;
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
    
    public Integer getExcessReserve() {
        return this.excessReserve;
    }
    
    public void setExcessReserve(Integer excessReserve) {
    		if((excessReserve != null && this.excessReserve == null) || 
				this.excessReserve != null && (!this.excessReserve.equals(excessReserve) || excessReserve == null)){
        		this.setDirty(true);
        		this.oldValues.put("excessReserve", this.excessReserve);
        	}
        this.excessReserve = excessReserve;
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
    
    public TblMchtInfo getTblMchtInfo() {
        return this.tblMchtInfo;
    }
    
    public void setTblMchtInfo(TblMchtInfo tblMchtInfo) {
    		if((tblMchtInfo != null && this.tblMchtInfo == null) || 
				this.tblMchtInfo != null && (!this.tblMchtInfo.equals(tblMchtInfo) || tblMchtInfo == null)){
        		this.setDirty(true);
        		this.oldValues.put("tblMchtInfo", this.tblMchtInfo);
        	}
        this.tblMchtInfo = tblMchtInfo;
    }
    
   public BaseObject getParentEntity(){
	   return this.tblMchtInfo;
   }
   
   public void setParentEntity(BaseObject parent){
	   this.tblMchtInfo = (TblMchtInfo)parent;
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
		.append("settleInterval", this.settleInterval)
		.append("threshold", this.threshold)
		.append("excessReserve", this.excessReserve)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}