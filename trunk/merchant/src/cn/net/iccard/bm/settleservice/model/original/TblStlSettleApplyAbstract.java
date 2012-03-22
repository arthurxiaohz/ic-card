package cn.net.iccard.bm.settleservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlSettleApplyAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 商户
	 */	
 	protected  TblMchtInfo tblMchtInfo;

 	 /**
	 * 账户可用余额
	 */	
 	protected  Integer availableBalance;

 	 /**
	 * 申请结算金额
	 */	
 	protected  Integer amount;

 	 /**
	 * 状态
	 */	
 	protected  Integer settleApplyStatus;

 	 /**
	 * 审核意见
	 */	
 	protected  String auditOpinion;

 	 /**
	 * 备注
	 */	
 	protected  String remark;

 	 /**
	 * 结算批次
	 */	
 	protected  TblStlSettleBatch tblStlSettleBatch;

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
    
    public Integer getAvailableBalance() {
        return this.availableBalance;
    }
    
    public void setAvailableBalance(Integer availableBalance) {
    		if((availableBalance != null && this.availableBalance == null) || 
				this.availableBalance != null && (!this.availableBalance.equals(availableBalance) || availableBalance == null)){
        		this.setDirty(true);
        		this.oldValues.put("availableBalance", this.availableBalance);
        	}
        this.availableBalance = availableBalance;
    }
    
    public Integer getAmount() {
        return this.amount;
    }
    
    public void setAmount(Integer amount) {
    		if((amount != null && this.amount == null) || 
				this.amount != null && (!this.amount.equals(amount) || amount == null)){
        		this.setDirty(true);
        		this.oldValues.put("amount", this.amount);
        	}
        this.amount = amount;
    }
    
    public Integer getSettleApplyStatus() {
        return this.settleApplyStatus;
    }
    
    public void setSettleApplyStatus(Integer settleApplyStatus) {
    		if((settleApplyStatus != null && this.settleApplyStatus == null) || 
				this.settleApplyStatus != null && (!this.settleApplyStatus.equals(settleApplyStatus) || settleApplyStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleApplyStatus", this.settleApplyStatus);
        	}
        this.settleApplyStatus = settleApplyStatus;
    }
    
    public String getAuditOpinion() {
        return this.auditOpinion;
    }
    
    public void setAuditOpinion(String auditOpinion) {
    		if((auditOpinion != null && this.auditOpinion == null) || 
				this.auditOpinion != null && (!this.auditOpinion.equals(auditOpinion) || auditOpinion == null)){
        		this.setDirty(true);
        		this.oldValues.put("auditOpinion", this.auditOpinion);
        	}
        this.auditOpinion = auditOpinion;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
    		if((remark != null && this.remark == null) || 
				this.remark != null && (!this.remark.equals(remark) || remark == null)){
        		this.setDirty(true);
        		this.oldValues.put("remark", this.remark);
        	}
        this.remark = remark;
    }
    
    public TblStlSettleBatch getTblStlSettleBatch() {
        return this.tblStlSettleBatch;
    }
    
    public void setTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch) {
    		if((tblStlSettleBatch != null && this.tblStlSettleBatch == null) || 
				this.tblStlSettleBatch != null && (!this.tblStlSettleBatch.equals(tblStlSettleBatch) || tblStlSettleBatch == null)){
        		this.setDirty(true);
        		this.oldValues.put("tblStlSettleBatch", this.tblStlSettleBatch);
        	}
        this.tblStlSettleBatch = tblStlSettleBatch;
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
    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TblStlSettleApply) ) return false;
		 TblStlSettleApply castOther = ( TblStlSettleApply ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlSettleApply".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("availableBalance", this.availableBalance)
		.append("amount", this.amount)
		.append("remark", this.remark);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}