package cn.net.iccard.member.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.member.model.TblMbRechargeOrder;
import org.hi.base.organization.model.HiUser;

public abstract class TblMbRechargeOrderAbstract extends BaseObject implements Serializable{

 	
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
	 * 账号
	 */	
 	protected  String userName;

 	 /**
	 * 账户类型
	 */	
 	protected  String accountType;

 	 /**
	 * 账户号码
	 */	
 	protected  String accountNo;

 	 /**
	 * 持卡人卡号
	 */	
 	protected  String pan;

 	 /**
	 * 持卡人个人信息
	 */	
 	protected  String chinfo;

 	 /**
	 * 交易类型
	 */	
 	protected  String txTypeId;

 	 /**
	 * 交易发生时间
	 */	
 	protected  String mchtTxTime;

 	 /**
	 * 交易金额
	 */	
 	protected  Integer txAmount;

 	 /**
	 * 交易IP地址
	 */	
 	protected  String txIp;

 	 /**
	 * 交易完成时间
	 */	
 	protected  String plTxTime;

 	 /**
	 * 交易状态
	 */	
 	protected  Integer txStatus;

 	 /**
	 * 异常代码
	 */	
 	protected  String errorCode;

 	 /**
	 * 实名认证状态
	 */	
 	protected  String errorMsg;

 	 /**
	 * 结算批次号
	 */	
 	protected  String settleBatchNo;

 	 /**
	 * 结算状态
	 */	
 	protected  Integer settleStatus;

 	 /**
	 * 结算日期
	 */	
 	protected  String settleDate;

 	 /**
	 * 创建时间
	 */	
 	protected  Timestamp createdDatetime = new Timestamp(System.currentTimeMillis());

 	 /**
	 * 最后修改时间
	 */	
 	protected  Timestamp lastUpdatedDatetime;

 	 /**
	 * 最后修改人
	 */	
 	protected  Integer lastUpdatedBy;

 	 /**
	 * 银行交易状态
	 */	
 	protected  Integer bankTxStatus;

 	 /**
	 * 对账批次号
	 */	
 	protected  String checkBatchNo;

 	 /**
	 * 对账状态
	 */	
 	protected  Integer checkStatus;

 	 /**
	 * 凭证号
	 */	
 	protected  String voucherNo;

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
    
    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
    		if((accountType != null && this.accountType == null) || 
				this.accountType != null && (!this.accountType.equals(accountType) || accountType == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountType", this.accountType);
        	}
        this.accountType = accountType;
    }
    
    public String getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo) {
    		if((accountNo != null && this.accountNo == null) || 
				this.accountNo != null && (!this.accountNo.equals(accountNo) || accountNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("accountNo", this.accountNo);
        	}
        this.accountNo = accountNo;
    }
    
    public String getPan() {
        return this.pan;
    }
    
    public void setPan(String pan) {
    		if((pan != null && this.pan == null) || 
				this.pan != null && (!this.pan.equals(pan) || pan == null)){
        		this.setDirty(true);
        		this.oldValues.put("pan", this.pan);
        	}
        this.pan = pan;
    }
    
    public String getChinfo() {
        return this.chinfo;
    }
    
    public void setChinfo(String chinfo) {
    		if((chinfo != null && this.chinfo == null) || 
				this.chinfo != null && (!this.chinfo.equals(chinfo) || chinfo == null)){
        		this.setDirty(true);
        		this.oldValues.put("chinfo", this.chinfo);
        	}
        this.chinfo = chinfo;
    }
    
    public String getTxTypeId() {
        return this.txTypeId;
    }
    
    public void setTxTypeId(String txTypeId) {
    		if((txTypeId != null && this.txTypeId == null) || 
				this.txTypeId != null && (!this.txTypeId.equals(txTypeId) || txTypeId == null)){
        		this.setDirty(true);
        		this.oldValues.put("txTypeId", this.txTypeId);
        	}
        this.txTypeId = txTypeId;
    }
    
    public String getMchtTxTime() {
        return this.mchtTxTime;
    }
    
    public void setMchtTxTime(String mchtTxTime) {
    		if((mchtTxTime != null && this.mchtTxTime == null) || 
				this.mchtTxTime != null && (!this.mchtTxTime.equals(mchtTxTime) || mchtTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtTxTime", this.mchtTxTime);
        	}
        this.mchtTxTime = mchtTxTime;
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
    
    public String getTxIp() {
        return this.txIp;
    }
    
    public void setTxIp(String txIp) {
    		if((txIp != null && this.txIp == null) || 
				this.txIp != null && (!this.txIp.equals(txIp) || txIp == null)){
        		this.setDirty(true);
        		this.oldValues.put("txIp", this.txIp);
        	}
        this.txIp = txIp;
    }
    
    public String getPlTxTime() {
        return this.plTxTime;
    }
    
    public void setPlTxTime(String plTxTime) {
    		if((plTxTime != null && this.plTxTime == null) || 
				this.plTxTime != null && (!this.plTxTime.equals(plTxTime) || plTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("plTxTime", this.plTxTime);
        	}
        this.plTxTime = plTxTime;
    }
    
    public Integer getTxStatus() {
        return this.txStatus;
    }
    
    public void setTxStatus(Integer txStatus) {
    		if((txStatus != null && this.txStatus == null) || 
				this.txStatus != null && (!this.txStatus.equals(txStatus) || txStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("txStatus", this.txStatus);
        	}
        this.txStatus = txStatus;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public void setErrorCode(String errorCode) {
    		if((errorCode != null && this.errorCode == null) || 
				this.errorCode != null && (!this.errorCode.equals(errorCode) || errorCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("errorCode", this.errorCode);
        	}
        this.errorCode = errorCode;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public void setErrorMsg(String errorMsg) {
    		if((errorMsg != null && this.errorMsg == null) || 
				this.errorMsg != null && (!this.errorMsg.equals(errorMsg) || errorMsg == null)){
        		this.setDirty(true);
        		this.oldValues.put("errorMsg", this.errorMsg);
        	}
        this.errorMsg = errorMsg;
    }
    
    public String getSettleBatchNo() {
        return this.settleBatchNo;
    }
    
    public void setSettleBatchNo(String settleBatchNo) {
    		if((settleBatchNo != null && this.settleBatchNo == null) || 
				this.settleBatchNo != null && (!this.settleBatchNo.equals(settleBatchNo) || settleBatchNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleBatchNo", this.settleBatchNo);
        	}
        this.settleBatchNo = settleBatchNo;
    }
    
    public Integer getSettleStatus() {
        return this.settleStatus;
    }
    
    public void setSettleStatus(Integer settleStatus) {
    		if((settleStatus != null && this.settleStatus == null) || 
				this.settleStatus != null && (!this.settleStatus.equals(settleStatus) || settleStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleStatus", this.settleStatus);
        	}
        this.settleStatus = settleStatus;
    }
    
    public String getSettleDate() {
        return this.settleDate;
    }
    
    public void setSettleDate(String settleDate) {
    		if((settleDate != null && this.settleDate == null) || 
				this.settleDate != null && (!this.settleDate.equals(settleDate) || settleDate == null)){
        		this.setDirty(true);
        		this.oldValues.put("settleDate", this.settleDate);
        	}
        this.settleDate = settleDate;
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
    
    public Integer getBankTxStatus() {
        return this.bankTxStatus;
    }
    
    public void setBankTxStatus(Integer bankTxStatus) {
    		if((bankTxStatus != null && this.bankTxStatus == null) || 
				this.bankTxStatus != null && (!this.bankTxStatus.equals(bankTxStatus) || bankTxStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("bankTxStatus", this.bankTxStatus);
        	}
        this.bankTxStatus = bankTxStatus;
    }
    
    public String getCheckBatchNo() {
        return this.checkBatchNo;
    }
    
    public void setCheckBatchNo(String checkBatchNo) {
    		if((checkBatchNo != null && this.checkBatchNo == null) || 
				this.checkBatchNo != null && (!this.checkBatchNo.equals(checkBatchNo) || checkBatchNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("checkBatchNo", this.checkBatchNo);
        	}
        this.checkBatchNo = checkBatchNo;
    }
    
    public Integer getCheckStatus() {
        return this.checkStatus;
    }
    
    public void setCheckStatus(Integer checkStatus) {
    		if((checkStatus != null && this.checkStatus == null) || 
				this.checkStatus != null && (!this.checkStatus.equals(checkStatus) || checkStatus == null)){
        		this.setDirty(true);
        		this.oldValues.put("checkStatus", this.checkStatus);
        	}
        this.checkStatus = checkStatus;
    }
    
    public String getVoucherNo() {
        return this.voucherNo;
    }
    
    public void setVoucherNo(String voucherNo) {
    		if((voucherNo != null && this.voucherNo == null) || 
				this.voucherNo != null && (!this.voucherNo.equals(voucherNo) || voucherNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("voucherNo", this.voucherNo);
        	}
        this.voucherNo = voucherNo;
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
		 if ( !(other instanceof TblMbRechargeOrder) ) return false;
		 TblMbRechargeOrder castOther = ( TblMbRechargeOrder ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblMbRechargeOrder".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("userName", this.userName)
		.append("accountType", this.accountType)
		.append("accountNo", this.accountNo)
		.append("pan", this.pan)
		.append("chinfo", this.chinfo)
		.append("txTypeId", this.txTypeId)
		.append("mchtTxTime", this.mchtTxTime)
		.append("txAmount", this.txAmount)
		.append("txIp", this.txIp)
		.append("plTxTime", this.plTxTime)
		.append("errorCode", this.errorCode)
		.append("errorMsg", this.errorMsg)
		.append("settleBatchNo", this.settleBatchNo)
		.append("settleDate", this.settleDate)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("checkBatchNo", this.checkBatchNo)
		.append("voucherNo", this.voucherNo)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}