package cn.net.iccard.bm.settleservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlSettleBatchAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 结算批次号
	 */	
 	protected  String settleNo;

 	 /**
	 * 商户
	 */	
 	protected  TblMchtInfo tblMchtInfo;

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
 	protected  HiUser lastUpdatedBy;

 	 /**
	 * 支付总比数
	 */	
 	protected  Integer orderCount;

 	 /**
	 * 支付总金额
	 */	
 	protected  String balance;

 	 /**
	 * 支付总手续费
	 */	
 	protected  String fee;

 	 /**
	 * 退款总笔数
	 */	
 	protected  Integer refundCount;

 	 /**
	 * 退款总金额
	 */	
 	protected  String refundBalance;

 	 /**
	 * 退款总手续费
	 */	
 	protected  String refundFee;

 	 /**
	 * 结算金额
	 */	
 	protected  String settleAmount;

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
    
    public String getSettleNo() {
        return this.settleNo;
    }
    
    public void setSettleNo(String settleNo) {
    		if((settleNo != null && this.settleNo == null) || 
				this.settleNo != null && (!this.settleNo.equals(settleNo) || settleNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleNo", this.settleNo);
        	}
        this.settleNo = settleNo;
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
    
    public Integer getOrderCount() {
        return this.orderCount;
    }
    
    public void setOrderCount(Integer orderCount) {
    		if((orderCount != null && this.orderCount == null) || 
				this.orderCount != null && (!this.orderCount.equals(orderCount) || orderCount == null)){
        		this.setDirty(true);
        		this.oldValues.put("orderCount", this.orderCount);
        	}
        this.orderCount = orderCount;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public void setBalance(String balance) {
    		if((balance != null && this.balance == null) || 
				this.balance != null && (!this.balance.equals(balance) || balance == null)){
        		this.setDirty(true);
        		this.oldValues.put("balance", this.balance);
        	}
        this.balance = balance;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setFee(String fee) {
    		if((fee != null && this.fee == null) || 
				this.fee != null && (!this.fee.equals(fee) || fee == null)){
        		this.setDirty(true);
        		this.oldValues.put("fee", this.fee);
        	}
        this.fee = fee;
    }
    
    public Integer getRefundCount() {
        return this.refundCount;
    }
    
    public void setRefundCount(Integer refundCount) {
    		if((refundCount != null && this.refundCount == null) || 
				this.refundCount != null && (!this.refundCount.equals(refundCount) || refundCount == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundCount", this.refundCount);
        	}
        this.refundCount = refundCount;
    }
    
    public String getRefundBalance() {
        return this.refundBalance;
    }
    
    public void setRefundBalance(String refundBalance) {
    		if((refundBalance != null && this.refundBalance == null) || 
				this.refundBalance != null && (!this.refundBalance.equals(refundBalance) || refundBalance == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundBalance", this.refundBalance);
        	}
        this.refundBalance = refundBalance;
    }
    
    public String getRefundFee() {
        return this.refundFee;
    }
    
    public void setRefundFee(String refundFee) {
    		if((refundFee != null && this.refundFee == null) || 
				this.refundFee != null && (!this.refundFee.equals(refundFee) || refundFee == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundFee", this.refundFee);
        	}
        this.refundFee = refundFee;
    }
    
    public String getSettleAmount() {
        return this.settleAmount;
    }
    
    public void setSettleAmount(String settleAmount) {
    		if((settleAmount != null && this.settleAmount == null) || 
				this.settleAmount != null && (!this.settleAmount.equals(settleAmount) || settleAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleAmount", this.settleAmount);
        	}
        this.settleAmount = settleAmount;
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
		 if ( !(other instanceof TblStlSettleBatch) ) return false;
		 TblStlSettleBatch castOther = ( TblStlSettleBatch ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlSettleBatch".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("settleNo", this.settleNo)
		.append("orderCount", this.orderCount)
		.append("balance", this.balance)
		.append("fee", this.fee)
		.append("refundCount", this.refundCount)
		.append("refundBalance", this.refundBalance)
		.append("refundFee", this.refundFee)
		.append("settleAmount", this.settleAmount)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}