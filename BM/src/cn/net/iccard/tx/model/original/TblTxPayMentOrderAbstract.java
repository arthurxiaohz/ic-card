package cn.net.iccard.tx.model.original;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.framework.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.net.iccard.tx.model.TblTxPayMentOrder;
import org.hi.base.organization.model.HiUser;

public abstract class TblTxPayMentOrderAbstract extends BaseObject implements Serializable{

 	
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
	 * 会员账号
	 */	
 	protected  String userName;

 	 /**
	 * 交易类型
	 */	
 	protected  String txTypeId;

 	 /**
	 * 商户号
	 */	
 	protected  String mchtNo;

 	 /**
	 * 交易发生时间
	 */	
 	protected  String mchtTxTime;

 	 /**
	 * 原始交易发生时间
	 */	
 	protected  String lastMchtTxTime;

 	 /**
	 * 商户交易流水号
	 */	
 	protected  String mchtTxTraceNo;

 	 /**
	 * 原始商户交易流水号
	 */	
 	protected  String lastMchtTxTraceNo;

 	 /**
	 * 订单金额
	 */	
 	protected  Integer orderAmount;

 	 /**
	 * 交易结果通知地址
	 */	
 	protected  String notifyUrl;

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
	 * 凭证号
	 */	
 	protected  String voucherNo;

 	 /**
	 * 撤销凭证号
	 */	
 	protected  String backVoucherNo;

 	 /**
	 * 是否使用优惠券
	 */	
 	protected  Integer useCoupon;

 	 /**
	 * 优惠券信息
	 */	
 	protected  String couponMsg;

 	 /**
	 * 返回商户优惠券信息
	 */	
 	protected  String resCouponMsg;

 	 /**
	 * 商品展示URL
	 */	
 	protected  String showUrl;

 	 /**
	 * 商品描述
	 */	
 	protected  String txBody;

 	 /**
	 * 付款人手机号码
	 */	
 	protected  String payerPhone;

 	 /**
	 * 验证码
	 */	
 	protected  String verifyCode;

 	 /**
	 * 确认码
	 */	
 	protected  String confirmCode;

 	 /**
	 * 确认过期时间
	 */	
 	protected  String orderExpireDatetime;

 	 /**
	 * 异常代码
	 */	
 	protected  String errorCode;

 	 /**
	 * 异常描述
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
	 * 手续费金额
	 */	
 	protected  Integer feeAmount;

 	 /**
	 * 是否已计算手续费
	 */	
 	protected  Integer hasCountFee;

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
	 * 交易后台通知地址
	 */	
 	protected  String bgNotifyUrl;

 	 /**
	 * 商户名称
	 */	
 	protected  String mchtName;

 	 /**
	 * 支付金额
	 */	
 	protected  Integer payAmount;

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
    
    public String getLastMchtTxTime() {
        return this.lastMchtTxTime;
    }
    
    public void setLastMchtTxTime(String lastMchtTxTime) {
    		if((lastMchtTxTime != null && this.lastMchtTxTime == null) || 
				this.lastMchtTxTime != null && (!this.lastMchtTxTime.equals(lastMchtTxTime) || lastMchtTxTime == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastMchtTxTime", this.lastMchtTxTime);
        	}
        this.lastMchtTxTime = lastMchtTxTime;
    }
    
    public String getMchtTxTraceNo() {
        return this.mchtTxTraceNo;
    }
    
    public void setMchtTxTraceNo(String mchtTxTraceNo) {
    		if((mchtTxTraceNo != null && this.mchtTxTraceNo == null) || 
				this.mchtTxTraceNo != null && (!this.mchtTxTraceNo.equals(mchtTxTraceNo) || mchtTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("mchtTxTraceNo", this.mchtTxTraceNo);
        	}
        this.mchtTxTraceNo = mchtTxTraceNo;
    }
    
    public String getLastMchtTxTraceNo() {
        return this.lastMchtTxTraceNo;
    }
    
    public void setLastMchtTxTraceNo(String lastMchtTxTraceNo) {
    		if((lastMchtTxTraceNo != null && this.lastMchtTxTraceNo == null) || 
				this.lastMchtTxTraceNo != null && (!this.lastMchtTxTraceNo.equals(lastMchtTxTraceNo) || lastMchtTxTraceNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("lastMchtTxTraceNo", this.lastMchtTxTraceNo);
        	}
        this.lastMchtTxTraceNo = lastMchtTxTraceNo;
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
    
    public String getNotifyUrl() {
        return this.notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
    		if((notifyUrl != null && this.notifyUrl == null) || 
				this.notifyUrl != null && (!this.notifyUrl.equals(notifyUrl) || notifyUrl == null)){
        		this.setDirty(true);
        		this.oldValues.put("notifyUrl", this.notifyUrl);
        	}
        this.notifyUrl = notifyUrl;
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
    
    public String getBackVoucherNo() {
        return this.backVoucherNo;
    }
    
    public void setBackVoucherNo(String backVoucherNo) {
    		if((backVoucherNo != null && this.backVoucherNo == null) || 
				this.backVoucherNo != null && (!this.backVoucherNo.equals(backVoucherNo) || backVoucherNo == null)){
        		this.setDirty(true);
        		this.oldValues.put("backVoucherNo", this.backVoucherNo);
        	}
        this.backVoucherNo = backVoucherNo;
    }
    
    public Integer getUseCoupon() {
        return this.useCoupon;
    }
    
    public void setUseCoupon(Integer useCoupon) {
    		if((useCoupon != null && this.useCoupon == null) || 
				this.useCoupon != null && (!this.useCoupon.equals(useCoupon) || useCoupon == null)){
        		this.setDirty(true);
        		this.oldValues.put("useCoupon", this.useCoupon);
        	}
        this.useCoupon = useCoupon;
    }
    
    public String getCouponMsg() {
        return this.couponMsg;
    }
    
    public void setCouponMsg(String couponMsg) {
    		if((couponMsg != null && this.couponMsg == null) || 
				this.couponMsg != null && (!this.couponMsg.equals(couponMsg) || couponMsg == null)){
        		this.setDirty(true);
        		this.oldValues.put("couponMsg", this.couponMsg);
        	}
        this.couponMsg = couponMsg;
    }
    
    public String getResCouponMsg() {
        return this.resCouponMsg;
    }
    
    public void setResCouponMsg(String resCouponMsg) {
    		if((resCouponMsg != null && this.resCouponMsg == null) || 
				this.resCouponMsg != null && (!this.resCouponMsg.equals(resCouponMsg) || resCouponMsg == null)){
        		this.setDirty(true);
        		this.oldValues.put("resCouponMsg", this.resCouponMsg);
        	}
        this.resCouponMsg = resCouponMsg;
    }
    
    public String getShowUrl() {
        return this.showUrl;
    }
    
    public void setShowUrl(String showUrl) {
    		if((showUrl != null && this.showUrl == null) || 
				this.showUrl != null && (!this.showUrl.equals(showUrl) || showUrl == null)){
        		this.setDirty(true);
        		this.oldValues.put("showUrl", this.showUrl);
        	}
        this.showUrl = showUrl;
    }
    
    public String getTxBody() {
        return this.txBody;
    }
    
    public void setTxBody(String txBody) {
    		if((txBody != null && this.txBody == null) || 
				this.txBody != null && (!this.txBody.equals(txBody) || txBody == null)){
        		this.setDirty(true);
        		this.oldValues.put("txBody", this.txBody);
        	}
        this.txBody = txBody;
    }
    
    public String getPayerPhone() {
        return this.payerPhone;
    }
    
    public void setPayerPhone(String payerPhone) {
    		if((payerPhone != null && this.payerPhone == null) || 
				this.payerPhone != null && (!this.payerPhone.equals(payerPhone) || payerPhone == null)){
        		this.setDirty(true);
        		this.oldValues.put("payerPhone", this.payerPhone);
        	}
        this.payerPhone = payerPhone;
    }
    
    public String getVerifyCode() {
        return this.verifyCode;
    }
    
    public void setVerifyCode(String verifyCode) {
    		if((verifyCode != null && this.verifyCode == null) || 
				this.verifyCode != null && (!this.verifyCode.equals(verifyCode) || verifyCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("verifyCode", this.verifyCode);
        	}
        this.verifyCode = verifyCode;
    }
    
    public String getConfirmCode() {
        return this.confirmCode;
    }
    
    public void setConfirmCode(String confirmCode) {
    		if((confirmCode != null && this.confirmCode == null) || 
				this.confirmCode != null && (!this.confirmCode.equals(confirmCode) || confirmCode == null)){
        		this.setDirty(true);
        		this.oldValues.put("confirmCode", this.confirmCode);
        	}
        this.confirmCode = confirmCode;
    }
    
    public String getOrderExpireDatetime() {
        return this.orderExpireDatetime;
    }
    
    public void setOrderExpireDatetime(String orderExpireDatetime) {
    		if((orderExpireDatetime != null && this.orderExpireDatetime == null) || 
				this.orderExpireDatetime != null && (!this.orderExpireDatetime.equals(orderExpireDatetime) || orderExpireDatetime == null)){
        		this.setDirty(true);
        		this.oldValues.put("orderExpireDatetime", this.orderExpireDatetime);
        	}
        this.orderExpireDatetime = orderExpireDatetime;
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
    
    public Integer getFeeAmount() {
        return this.feeAmount;
    }
    
    public void setFeeAmount(Integer feeAmount) {
    		if((feeAmount != null && this.feeAmount == null) || 
				this.feeAmount != null && (!this.feeAmount.equals(feeAmount) || feeAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("feeAmount", this.feeAmount);
        	}
        this.feeAmount = feeAmount;
    }
    
    public Integer getHasCountFee() {
        return this.hasCountFee;
    }
    
    public void setHasCountFee(Integer hasCountFee) {
    		if((hasCountFee != null && this.hasCountFee == null) || 
				this.hasCountFee != null && (!this.hasCountFee.equals(hasCountFee) || hasCountFee == null)){
        		this.setDirty(true);
        		this.oldValues.put("hasCountFee", this.hasCountFee);
        	}
        this.hasCountFee = hasCountFee;
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
    
    public String getBgNotifyUrl() {
        return this.bgNotifyUrl;
    }
    
    public void setBgNotifyUrl(String bgNotifyUrl) {
    		if((bgNotifyUrl != null && this.bgNotifyUrl == null) || 
				this.bgNotifyUrl != null && (!this.bgNotifyUrl.equals(bgNotifyUrl) || bgNotifyUrl == null)){
        		this.setDirty(true);
        		this.oldValues.put("bgNotifyUrl", this.bgNotifyUrl);
        	}
        this.bgNotifyUrl = bgNotifyUrl;
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
    
    public Integer getPayAmount() {
        return this.payAmount;
    }
    
    public void setPayAmount(Integer payAmount) {
    		if((payAmount != null && this.payAmount == null) || 
				this.payAmount != null && (!this.payAmount.equals(payAmount) || payAmount == null)){
        		this.setDirty(true);
        		this.oldValues.put("payAmount", this.payAmount);
        	}
        this.payAmount = payAmount;
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
		 if ( !(other instanceof TblTxPayMentOrder) ) return false;
		 TblTxPayMentOrder castOther = ( TblTxPayMentOrder ) other; 
		 
		 return  ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(getId());
		hcb.append("TblTxPayMentOrder".hashCode());
        return hcb.toHashCode();
    }

   public String toString() {
       ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
       sb.append("id", this.id)
		.append("plTxTraceNo", this.plTxTraceNo)
		.append("userName", this.userName)
		.append("txTypeId", this.txTypeId)
		.append("mchtNo", this.mchtNo)
		.append("mchtTxTime", this.mchtTxTime)
		.append("lastMchtTxTime", this.lastMchtTxTime)
		.append("mchtTxTraceNo", this.mchtTxTraceNo)
		.append("lastMchtTxTraceNo", this.lastMchtTxTraceNo)
		.append("orderAmount", this.orderAmount)
		.append("notifyUrl", this.notifyUrl)
		.append("txIp", this.txIp)
		.append("plTxTime", this.plTxTime)
		.append("voucherNo", this.voucherNo)
		.append("backVoucherNo", this.backVoucherNo)
		.append("couponMsg", this.couponMsg)
		.append("resCouponMsg", this.resCouponMsg)
		.append("showUrl", this.showUrl)
		.append("txBody", this.txBody)
		.append("payerPhone", this.payerPhone)
		.append("verifyCode", this.verifyCode)
		.append("confirmCode", this.confirmCode)
		.append("orderExpireDatetime", this.orderExpireDatetime)
		.append("errorCode", this.errorCode)
		.append("errorMsg", this.errorMsg)
		.append("settleBatchNo", this.settleBatchNo)
		.append("settleDate", this.settleDate)
		.append("feeAmount", this.feeAmount)
		.append("lastUpdatedBy", this.lastUpdatedBy)
		.append("bgNotifyUrl", this.bgNotifyUrl)
		.append("mchtName", this.mchtName)
		.append("payAmount", this.payAmount)
		.append("deleted", this.deleted);
      
        return sb.toString();
   }

   public Serializable getPrimarykey(){
   		return id;
   }



}