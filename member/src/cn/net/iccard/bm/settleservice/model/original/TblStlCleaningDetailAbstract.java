package cn.net.iccard.bm.settleservice.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import org.hi.base.organization.model.HiUser;

public abstract class TblStlCleaningDetailAbstract extends BaseObject implements Serializable{

 	
 	/**
	 * 主键id
	 */	
	protected  Integer id;

	/**
	 * 版本控制version
	 */	
 	protected  Integer version;

 	 /**
	 * 平台交易流水号
	 */	
 	protected  String plTxTraceNo;

 	 /**
	 * 商户订单号
	 */	
 	protected  String mchtOrderId;

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
	 * 金额
	 */	
 	protected  Integer orderAmount;

 	 /**
	 * 交易时间
	 */	
 	protected  String transTime;

 	 /**
	 * 退款原始订单
	 */	
 	protected  String refundOrderId;

 	 /**
	 * 退款订单原始交易金额
	 */	
 	protected  Integer refundOrderAmt;

 	 /**
	 * 退款金额
	 */	
 	protected  Integer refundAmt;

 	 /**
	 * 退还的手续费用
	 */	
 	protected  Integer refundFee;

 	 /**
	 * 商户结算扣费金额
	 */	
 	protected  Integer mchtSettleFee;

 	 /**
	 * 备注信息
	 */	
 	protected  String reMark;

 	 /**
	 * 交易类型
	 */	
 	protected  String transType;

 	 /**
	 * 账号
	 */	
 	protected  String userName;

 	 /**
	 * 积分
	 */	
 	protected  Integer balance;

 	 /**
	 * 退还积分
	 */	
 	protected  Integer backBalance;

 	 /**
	 * 商户号
	 */	
 	protected  String mchtNo;

 	 /**
	 * 商户名称
	 */	
 	protected  String mchtName;

 	 /**
	 * 清分状态
	 */	
 	protected  Integer cleanStatus;

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
    
    public String getPlTxTraceNo() {
        return this.plTxTraceNo;
    }
    
    public void setPlTxTraceNo(String plTxTraceNo) {
    		if((plTxTraceNo != null && this.plTxTraceNo == null) || 
				this.plTxTraceNo != null && (!this.plTxTraceNo.equals(plTxTraceNo) || plTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("plTxTraceNo", this.plTxTraceNo);
        	}
        this.plTxTraceNo = plTxTraceNo;
    }
    
    public String getMchtOrderId() {
        return this.mchtOrderId;
    }
    
    public void setMchtOrderId(String mchtOrderId) {
    		if((mchtOrderId != null && this.mchtOrderId == null) || 
				this.mchtOrderId != null && (!this.mchtOrderId.equals(mchtOrderId) || mchtOrderId == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtOrderId", this.mchtOrderId);
        	}
        this.mchtOrderId = mchtOrderId;
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
    
    public Integer getOrderAmount() {
        return this.orderAmount;
    }
    
    public void setOrderAmount(Integer orderAmount) {
    		if((orderAmount != null && this.orderAmount == null) || 
				this.orderAmount != null && (!this.orderAmount.equals(orderAmount) || orderAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("orderAmount", this.orderAmount);
        	}
        this.orderAmount = orderAmount;
    }
    
    public String getTransTime() {
        return this.transTime;
    }
    
    public void setTransTime(String transTime) {
    		if((transTime != null && this.transTime == null) || 
				this.transTime != null && (!this.transTime.equals(transTime) || transTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("transTime", this.transTime);
        	}
        this.transTime = transTime;
    }
    
    public String getRefundOrderId() {
        return this.refundOrderId;
    }
    
    public void setRefundOrderId(String refundOrderId) {
    		if((refundOrderId != null && this.refundOrderId == null) || 
				this.refundOrderId != null && (!this.refundOrderId.equals(refundOrderId) || refundOrderId == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundOrderId", this.refundOrderId);
        	}
        this.refundOrderId = refundOrderId;
    }
    
    public Integer getRefundOrderAmt() {
        return this.refundOrderAmt;
    }
    
    public void setRefundOrderAmt(Integer refundOrderAmt) {
    		if((refundOrderAmt != null && this.refundOrderAmt == null) || 
				this.refundOrderAmt != null && (!this.refundOrderAmt.equals(refundOrderAmt) || refundOrderAmt == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundOrderAmt", this.refundOrderAmt);
        	}
        this.refundOrderAmt = refundOrderAmt;
    }
    
    public Integer getRefundAmt() {
        return this.refundAmt;
    }
    
    public void setRefundAmt(Integer refundAmt) {
    		if((refundAmt != null && this.refundAmt == null) || 
				this.refundAmt != null && (!this.refundAmt.equals(refundAmt) || refundAmt == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundAmt", this.refundAmt);
        	}
        this.refundAmt = refundAmt;
    }
    
    public Integer getRefundFee() {
        return this.refundFee;
    }
    
    public void setRefundFee(Integer refundFee) {
    		if((refundFee != null && this.refundFee == null) || 
				this.refundFee != null && (!this.refundFee.equals(refundFee) || refundFee == null)){
        		this.setDirty(true);
        		this.oldValues.put("refundFee", this.refundFee);
        	}
        this.refundFee = refundFee;
    }
    
    public Integer getMchtSettleFee() {
        return this.mchtSettleFee;
    }
    
    public void setMchtSettleFee(Integer mchtSettleFee) {
    		if((mchtSettleFee != null && this.mchtSettleFee == null) || 
				this.mchtSettleFee != null && (!this.mchtSettleFee.equals(mchtSettleFee) || mchtSettleFee == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtSettleFee", this.mchtSettleFee);
        	}
        this.mchtSettleFee = mchtSettleFee;
    }
    
    public String getReMark() {
        return this.reMark;
    }
    
    public void setReMark(String reMark) {
    		if((reMark != null && this.reMark == null) || 
				this.reMark != null && (!this.reMark.equals(reMark) || reMark == null)){
        		this.setDirty(true);
        		this.oldValues.put("reMark", this.reMark);
        	}
        this.reMark = reMark;
    }
    
    public String getTransType() {
        return this.transType;
    }
    
    public void setTransType(String transType) {
    		if((transType != null && this.transType == null) || 
				this.transType != null && (!this.transType.equals(transType) || transType == null)){
        		this.setDirty(true);
        		this.oldValues.put("transType", this.transType);
        	}
        this.transType = transType;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
    		if((userName != null && this.userName == null) || 
				this.userName != null && (!this.userName.equals(userName) || userName == null)){
        		this.setDirty(true);
        		this.oldValues.put("userName", this.userName);
        	}
        this.userName = userName;
    }
    
    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
    		if((balance != null && this.balance == null) || 
				this.balance != null && (!this.balance.equals(balance) || balance == null)){
        		this.setDirty(true);
        		this.oldValues.put("balance", this.balance);
        	}
        this.balance = balance;
    }
    
    public Integer getBackBalance() {
        return this.backBalance;
    }
    
    public void setBackBalance(Integer backBalance) {
    		if((backBalance != null && this.backBalance == null) || 
				this.backBalance != null && (!this.backBalance.equals(backBalance) || backBalance == null)){
        		this.setDirty(true);
        		this.oldValues.put("backBalance", this.backBalance);
        	}
        this.backBalance = backBalance;
    }
    
    public String getMchtNo() {
        return this.mchtNo;
    }
    
    public void setMchtNo(String mchtNo) {
    		if((mchtNo != null && this.mchtNo == null) || 
				this.mchtNo != null && (!this.mchtNo.equals(mchtNo) || mchtNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtNo", this.mchtNo);
        	}
        this.mchtNo = mchtNo;
    }
    
    public String getMchtName() {
        return this.mchtName;
    }
    
    public void setMchtName(String mchtName) {
    		if((mchtName != null && this.mchtName == null) || 
				this.mchtName != null && (!this.mchtName.equals(mchtName) || mchtName == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtName", this.mchtName);
        	}
        this.mchtName = mchtName;
    }
    
    public Integer getCleanStatus() {
        return this.cleanStatus;
    }
    
    public void setCleanStatus(Integer cleanStatus) {
    		if((cleanStatus != null && this.cleanStatus == null) || 
				this.cleanStatus != null && (!this.cleanStatus.equals(cleanStatus) || cleanStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("cleanStatus", this.cleanStatus);
        	}
        this.cleanStatus = cleanStatus;
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
		 if ( !(other instanceof TblStlCleaningDetail) ) return false;
		 TblStlCleaningDetail castOther = ( TblStlCleaningDetail ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblStlCleaningDetail".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("mchtOrderId", this.mchtOrderId)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("orderAmount", this.orderAmount)
		.append("transTime", this.transTime)
		.append("refundOrderId", this.refundOrderId)
		.append("refundOrderAmt", this.refundOrderAmt)
		.append("refundAmt", this.refundAmt)
		.append("refundFee", this.refundFee)
		.append("mchtSettleFee", this.mchtSettleFee)
		.append("reMark", this.reMark)
		.append("transType", this.transType)
		.append("userName", this.userName)
		.append("balance", this.balance)
		.append("backBalance", this.backBalance)
		.append("mchtNo", this.mchtNo)
		.append("mchtName", this.mchtName)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}