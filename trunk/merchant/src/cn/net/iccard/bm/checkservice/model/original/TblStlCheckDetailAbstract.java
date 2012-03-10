package cn.net.iccard.bm.checkservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.checkservice.model.TblStlCheckDetail;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlCheckDetailAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 对账批次号
	 */	
 	protected  String checkBatchId;

 	 /**
	 * 机构代码
	 */	
 	protected  String orgId;

 	 /**
	 * 机构类型
	 */	
 	protected  String orgType;

 	 /**
	 * 对账日期
	 */	
 	protected  String checkDate;

 	 /**
	 * 状态
	 */	
 	protected  Integer status;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDatetime;

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  Integer lastUpdatedBy;

 	 /**
	 * 是否正在处理
	 */	
 	protected  Integer inProcess;

 	 /**
	 * 交易机构流水号
	 */	
 	protected  String txOrgOrderId;

 	 /**
	 * 交易金额
	 */	
 	protected  Integer txAmount;

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
    
    public String getCheckBatchId() {
        return this.checkBatchId;
    }
    
    public void setCheckBatchId(String checkBatchId) {
    		if((checkBatchId != null && this.checkBatchId == null) || 
				this.checkBatchId != null && (!this.checkBatchId.equals(checkBatchId) || checkBatchId == null)){
        		this.setDirty(true);
        		this.oldValues.put("checkBatchId", this.checkBatchId);
        	}
        this.checkBatchId = checkBatchId;
    }
    
    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(String orgId) {
    		if((orgId != null && this.orgId == null) || 
				this.orgId != null && (!this.orgId.equals(orgId) || orgId == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgId", this.orgId);
        	}
        this.orgId = orgId;
    }
    
    public String getOrgType() {
        return this.orgType;
    }
    
    public void setOrgType(String orgType) {
    		if((orgType != null && this.orgType == null) || 
				this.orgType != null && (!this.orgType.equals(orgType) || orgType == null)){
        		this.setDirty(true);
        		this.oldValues.put("orgType", this.orgType);
        	}
        this.orgType = orgType;
    }
    
    public String getCheckDate() {
        return this.checkDate;
    }
    
    public void setCheckDate(String checkDate) {
    		if((checkDate != null && this.checkDate == null) || 
				this.checkDate != null && (!this.checkDate.equals(checkDate) || checkDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("checkDate", this.checkDate);
        	}
        this.checkDate = checkDate;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
    		if((status != null && this.status == null) || 
				this.status != null && (!this.status.equals(status) || status == null)){
        		this.setDirty(true);
        		this.oldValues.put("status", this.status);
        	}
        this.status = status;
    }
    
    public Timestamp getCreatedDatetime() {
        return this.createdDatetime;
    }
    
    public void setCreatedDatetime(Timestamp createdDatetime) {
    		if((createdDatetime != null && this.createdDatetime == null) || 
				this.createdDatetime != null && (!this.createdDatetime.equals(createdDatetime) || createdDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("createdDatetime", this.createdDatetime);
        	}
        this.createdDatetime = createdDatetime;
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
    
    public Integer getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(Integer lastUpdatedBy) {
    		if((lastUpdatedBy != null && this.lastUpdatedBy == null) || 
				this.lastUpdatedBy != null && (!this.lastUpdatedBy.equals(lastUpdatedBy) || lastUpdatedBy == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastUpdatedBy", this.lastUpdatedBy);
        	}
        this.lastUpdatedBy = lastUpdatedBy;
    }
    
    public Integer getInProcess() {
        return this.inProcess;
    }
    
    public void setInProcess(Integer inProcess) {
    		if((inProcess != null && this.inProcess == null) || 
				this.inProcess != null && (!this.inProcess.equals(inProcess) || inProcess == null)){
        		this.setDirty(true);
        		this.oldValues.put("inProcess", this.inProcess);
        	}
        this.inProcess = inProcess;
    }
    
    public String getTxOrgOrderId() {
        return this.txOrgOrderId;
    }
    
    public void setTxOrgOrderId(String txOrgOrderId) {
    		if((txOrgOrderId != null && this.txOrgOrderId == null) || 
				this.txOrgOrderId != null && (!this.txOrgOrderId.equals(txOrgOrderId) || txOrgOrderId == null)){
        		this.setDirty(true);
        		this.oldValues.put("txOrgOrderId", this.txOrgOrderId);
        	}
        this.txOrgOrderId = txOrgOrderId;
    }
    
    public Integer getTxAmount() {
        return this.txAmount;
    }
    
    public void setTxAmount(Integer txAmount) {
    		if((txAmount != null && this.txAmount == null) || 
				this.txAmount != null && (!this.txAmount.equals(txAmount) || txAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("txAmount", this.txAmount);
        	}
        this.txAmount = txAmount;
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
		 if ( !(other instanceof TblStlCheckDetail) ) return false;
		 TblStlCheckDetail castOther = ( TblStlCheckDetail ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlCheckDetail".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("checkBatchId", this.checkBatchId)
		.append("orgId", this.orgId)
		.append("orgType", this.orgType)
		.append("checkDate", this.checkDate)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("txOrgOrderId", this.txOrgOrderId)
		.append("txAmount", this.txAmount)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}