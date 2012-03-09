package cn.net.iccard.tx.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblTxPayMentOrderPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_plTxTraceNo;
 	protected  String  f_plTxTraceNo_op;
	protected  String  f_userName;
 	protected  String  f_userName_op;
	protected  String  f_txTypeId;
 	protected  String  f_txTypeId_op;
	protected  String  f_mchtNo;
 	protected  String  f_mchtNo_op;
	protected  String  f_mchtTxTime;
 	protected  String  f_mchtTxTime_op;
	protected  String  f_lastMchtTxTime;
 	protected  String  f_lastMchtTxTime_op;
	protected  String  f_mchtTxTraceNo;
 	protected  String  f_mchtTxTraceNo_op;
	protected  String  f_lastMchtTxTraceNo;
 	protected  String  f_lastMchtTxTraceNo_op;
	protected  Integer  f_orderAmount;
 	protected  String  f_orderAmount_op;
	protected  String  f_notifyUrl;
 	protected  String  f_notifyUrl_op;
	protected  String  f_txIp;
 	protected  String  f_txIp_op;
	protected  String  f_plTxTime;
 	protected  String  f_plTxTime_op;
	protected  Integer  f_txStatus;
 	protected  String  f_txStatus_op;
	protected  String  f_voucherNo;
 	protected  String  f_voucherNo_op;
	protected  String  f_backVoucherNo;
 	protected  String  f_backVoucherNo_op;
	protected  Integer  f_useCoupon;
 	protected  String  f_useCoupon_op;
	protected  String  f_couponMsg;
 	protected  String  f_couponMsg_op;
	protected  String  f_resCouponMsg;
 	protected  String  f_resCouponMsg_op;
	protected  String  f_showUrl;
 	protected  String  f_showUrl_op;
	protected  String  f_txBody;
 	protected  String  f_txBody_op;
	protected  String  f_payerPhone;
 	protected  String  f_payerPhone_op;
	protected  String  f_verifyCode;
 	protected  String  f_verifyCode_op;
	protected  String  f_confirmCode;
 	protected  String  f_confirmCode_op;
	protected  String  f_orderExpireDatetime;
 	protected  String  f_orderExpireDatetime_op;
	protected  String  f_errorCode;
 	protected  String  f_errorCode_op;
	protected  String  f_errorMsg;
 	protected  String  f_errorMsg_op;
	protected  String  f_settleBatchNo;
 	protected  String  f_settleBatchNo_op;
	protected  Integer  f_settleStatus;
 	protected  String  f_settleStatus_op;
	protected  String  f_settleDate;
 	protected  String  f_settleDate_op;
	protected  Integer  f_feeAmount;
 	protected  String  f_feeAmount_op;
	protected  Integer  f_hasCountFee;
 	protected  String  f_hasCountFee_op;
	protected  Date  f_createdDatetime;
 	protected  String  f_createdDatetime_op;
	protected  Date  f_createdDatetime01;
	protected  String  f_createdDatetime01_op;
	protected  Date  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Date  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_lastUpdatedBy;
 	protected  String  f_lastUpdatedBy_op;
	protected  String  f_bgNotifyUrl;
 	protected  String  f_bgNotifyUrl_op;
	protected  String  f_mchtName;
 	protected  String  f_mchtName_op;
	protected  Integer  f_payAmount;
 	protected  String  f_payAmount_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  HiUserPageInfo creator;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public String getF_plTxTraceNo() {
        return this.f_plTxTraceNo;
    }
    
    public void setF_plTxTraceNo(String f_plTxTraceNo) {
        this.f_plTxTraceNo = f_plTxTraceNo;
    }
    
    public String getF_plTxTraceNo_op() {
        return this.f_plTxTraceNo_op;
    }
    
    public void setF_plTxTraceNo_op(String f_plTxTraceNo_op) {
        this.f_plTxTraceNo_op = f_plTxTraceNo_op;
    }
   
    public String getF_userName() {
        return this.f_userName;
    }
    
    public void setF_userName(String f_userName) {
        this.f_userName = f_userName;
    }
    
    public String getF_userName_op() {
        return this.f_userName_op;
    }
    
    public void setF_userName_op(String f_userName_op) {
        this.f_userName_op = f_userName_op;
    }
   
    public String getF_txTypeId() {
        return this.f_txTypeId;
    }
    
    public void setF_txTypeId(String f_txTypeId) {
        this.f_txTypeId = f_txTypeId;
    }
    
    public String getF_txTypeId_op() {
        return this.f_txTypeId_op;
    }
    
    public void setF_txTypeId_op(String f_txTypeId_op) {
        this.f_txTypeId_op = f_txTypeId_op;
    }
   
    public String getF_mchtNo() {
        return this.f_mchtNo;
    }
    
    public void setF_mchtNo(String f_mchtNo) {
        this.f_mchtNo = f_mchtNo;
    }
    
    public String getF_mchtNo_op() {
        return this.f_mchtNo_op;
    }
    
    public void setF_mchtNo_op(String f_mchtNo_op) {
        this.f_mchtNo_op = f_mchtNo_op;
    }
   
    public String getF_mchtTxTime() {
        return this.f_mchtTxTime;
    }
    
    public void setF_mchtTxTime(String f_mchtTxTime) {
        this.f_mchtTxTime = f_mchtTxTime;
    }
    
    public String getF_mchtTxTime_op() {
        return this.f_mchtTxTime_op;
    }
    
    public void setF_mchtTxTime_op(String f_mchtTxTime_op) {
        this.f_mchtTxTime_op = f_mchtTxTime_op;
    }
   
    public String getF_lastMchtTxTime() {
        return this.f_lastMchtTxTime;
    }
    
    public void setF_lastMchtTxTime(String f_lastMchtTxTime) {
        this.f_lastMchtTxTime = f_lastMchtTxTime;
    }
    
    public String getF_lastMchtTxTime_op() {
        return this.f_lastMchtTxTime_op;
    }
    
    public void setF_lastMchtTxTime_op(String f_lastMchtTxTime_op) {
        this.f_lastMchtTxTime_op = f_lastMchtTxTime_op;
    }
   
    public String getF_mchtTxTraceNo() {
        return this.f_mchtTxTraceNo;
    }
    
    public void setF_mchtTxTraceNo(String f_mchtTxTraceNo) {
        this.f_mchtTxTraceNo = f_mchtTxTraceNo;
    }
    
    public String getF_mchtTxTraceNo_op() {
        return this.f_mchtTxTraceNo_op;
    }
    
    public void setF_mchtTxTraceNo_op(String f_mchtTxTraceNo_op) {
        this.f_mchtTxTraceNo_op = f_mchtTxTraceNo_op;
    }
   
    public String getF_lastMchtTxTraceNo() {
        return this.f_lastMchtTxTraceNo;
    }
    
    public void setF_lastMchtTxTraceNo(String f_lastMchtTxTraceNo) {
        this.f_lastMchtTxTraceNo = f_lastMchtTxTraceNo;
    }
    
    public String getF_lastMchtTxTraceNo_op() {
        return this.f_lastMchtTxTraceNo_op;
    }
    
    public void setF_lastMchtTxTraceNo_op(String f_lastMchtTxTraceNo_op) {
        this.f_lastMchtTxTraceNo_op = f_lastMchtTxTraceNo_op;
    }
   
    public Integer getF_orderAmount() {
        return this.f_orderAmount;
    }
    
    public void setF_orderAmount(Integer f_orderAmount) {
        this.f_orderAmount = f_orderAmount;
    }
    
    public String getF_orderAmount_op() {
        return this.f_orderAmount_op;
    }
    
    public void setF_orderAmount_op(String f_orderAmount_op) {
        this.f_orderAmount_op = f_orderAmount_op;
    }
   
    public String getF_notifyUrl() {
        return this.f_notifyUrl;
    }
    
    public void setF_notifyUrl(String f_notifyUrl) {
        this.f_notifyUrl = f_notifyUrl;
    }
    
    public String getF_notifyUrl_op() {
        return this.f_notifyUrl_op;
    }
    
    public void setF_notifyUrl_op(String f_notifyUrl_op) {
        this.f_notifyUrl_op = f_notifyUrl_op;
    }
   
    public String getF_txIp() {
        return this.f_txIp;
    }
    
    public void setF_txIp(String f_txIp) {
        this.f_txIp = f_txIp;
    }
    
    public String getF_txIp_op() {
        return this.f_txIp_op;
    }
    
    public void setF_txIp_op(String f_txIp_op) {
        this.f_txIp_op = f_txIp_op;
    }
   
    public String getF_plTxTime() {
        return this.f_plTxTime;
    }
    
    public void setF_plTxTime(String f_plTxTime) {
        this.f_plTxTime = f_plTxTime;
    }
    
    public String getF_plTxTime_op() {
        return this.f_plTxTime_op;
    }
    
    public void setF_plTxTime_op(String f_plTxTime_op) {
        this.f_plTxTime_op = f_plTxTime_op;
    }
   
    public Integer getF_txStatus() {
        return this.f_txStatus;
    }
    
    public void setF_txStatus(Integer f_txStatus) {
        this.f_txStatus = f_txStatus;
    }
    
    public String getF_txStatus_op() {
        return this.f_txStatus_op;
    }
    
    public void setF_txStatus_op(String f_txStatus_op) {
        this.f_txStatus_op = f_txStatus_op;
    }
   
    public String getF_voucherNo() {
        return this.f_voucherNo;
    }
    
    public void setF_voucherNo(String f_voucherNo) {
        this.f_voucherNo = f_voucherNo;
    }
    
    public String getF_voucherNo_op() {
        return this.f_voucherNo_op;
    }
    
    public void setF_voucherNo_op(String f_voucherNo_op) {
        this.f_voucherNo_op = f_voucherNo_op;
    }
   
    public String getF_backVoucherNo() {
        return this.f_backVoucherNo;
    }
    
    public void setF_backVoucherNo(String f_backVoucherNo) {
        this.f_backVoucherNo = f_backVoucherNo;
    }
    
    public String getF_backVoucherNo_op() {
        return this.f_backVoucherNo_op;
    }
    
    public void setF_backVoucherNo_op(String f_backVoucherNo_op) {
        this.f_backVoucherNo_op = f_backVoucherNo_op;
    }
   
    public Integer getF_useCoupon() {
        return this.f_useCoupon;
    }
    
    public void setF_useCoupon(Integer f_useCoupon) {
        this.f_useCoupon = f_useCoupon;
    }
    
    public String getF_useCoupon_op() {
        return this.f_useCoupon_op;
    }
    
    public void setF_useCoupon_op(String f_useCoupon_op) {
        this.f_useCoupon_op = f_useCoupon_op;
    }
   
    public String getF_couponMsg() {
        return this.f_couponMsg;
    }
    
    public void setF_couponMsg(String f_couponMsg) {
        this.f_couponMsg = f_couponMsg;
    }
    
    public String getF_couponMsg_op() {
        return this.f_couponMsg_op;
    }
    
    public void setF_couponMsg_op(String f_couponMsg_op) {
        this.f_couponMsg_op = f_couponMsg_op;
    }
   
    public String getF_resCouponMsg() {
        return this.f_resCouponMsg;
    }
    
    public void setF_resCouponMsg(String f_resCouponMsg) {
        this.f_resCouponMsg = f_resCouponMsg;
    }
    
    public String getF_resCouponMsg_op() {
        return this.f_resCouponMsg_op;
    }
    
    public void setF_resCouponMsg_op(String f_resCouponMsg_op) {
        this.f_resCouponMsg_op = f_resCouponMsg_op;
    }
   
    public String getF_showUrl() {
        return this.f_showUrl;
    }
    
    public void setF_showUrl(String f_showUrl) {
        this.f_showUrl = f_showUrl;
    }
    
    public String getF_showUrl_op() {
        return this.f_showUrl_op;
    }
    
    public void setF_showUrl_op(String f_showUrl_op) {
        this.f_showUrl_op = f_showUrl_op;
    }
   
    public String getF_txBody() {
        return this.f_txBody;
    }
    
    public void setF_txBody(String f_txBody) {
        this.f_txBody = f_txBody;
    }
    
    public String getF_txBody_op() {
        return this.f_txBody_op;
    }
    
    public void setF_txBody_op(String f_txBody_op) {
        this.f_txBody_op = f_txBody_op;
    }
   
    public String getF_payerPhone() {
        return this.f_payerPhone;
    }
    
    public void setF_payerPhone(String f_payerPhone) {
        this.f_payerPhone = f_payerPhone;
    }
    
    public String getF_payerPhone_op() {
        return this.f_payerPhone_op;
    }
    
    public void setF_payerPhone_op(String f_payerPhone_op) {
        this.f_payerPhone_op = f_payerPhone_op;
    }
   
    public String getF_verifyCode() {
        return this.f_verifyCode;
    }
    
    public void setF_verifyCode(String f_verifyCode) {
        this.f_verifyCode = f_verifyCode;
    }
    
    public String getF_verifyCode_op() {
        return this.f_verifyCode_op;
    }
    
    public void setF_verifyCode_op(String f_verifyCode_op) {
        this.f_verifyCode_op = f_verifyCode_op;
    }
   
    public String getF_confirmCode() {
        return this.f_confirmCode;
    }
    
    public void setF_confirmCode(String f_confirmCode) {
        this.f_confirmCode = f_confirmCode;
    }
    
    public String getF_confirmCode_op() {
        return this.f_confirmCode_op;
    }
    
    public void setF_confirmCode_op(String f_confirmCode_op) {
        this.f_confirmCode_op = f_confirmCode_op;
    }
   
    public String getF_orderExpireDatetime() {
        return this.f_orderExpireDatetime;
    }
    
    public void setF_orderExpireDatetime(String f_orderExpireDatetime) {
        this.f_orderExpireDatetime = f_orderExpireDatetime;
    }
    
    public String getF_orderExpireDatetime_op() {
        return this.f_orderExpireDatetime_op;
    }
    
    public void setF_orderExpireDatetime_op(String f_orderExpireDatetime_op) {
        this.f_orderExpireDatetime_op = f_orderExpireDatetime_op;
    }
   
    public String getF_errorCode() {
        return this.f_errorCode;
    }
    
    public void setF_errorCode(String f_errorCode) {
        this.f_errorCode = f_errorCode;
    }
    
    public String getF_errorCode_op() {
        return this.f_errorCode_op;
    }
    
    public void setF_errorCode_op(String f_errorCode_op) {
        this.f_errorCode_op = f_errorCode_op;
    }
   
    public String getF_errorMsg() {
        return this.f_errorMsg;
    }
    
    public void setF_errorMsg(String f_errorMsg) {
        this.f_errorMsg = f_errorMsg;
    }
    
    public String getF_errorMsg_op() {
        return this.f_errorMsg_op;
    }
    
    public void setF_errorMsg_op(String f_errorMsg_op) {
        this.f_errorMsg_op = f_errorMsg_op;
    }
   
    public String getF_settleBatchNo() {
        return this.f_settleBatchNo;
    }
    
    public void setF_settleBatchNo(String f_settleBatchNo) {
        this.f_settleBatchNo = f_settleBatchNo;
    }
    
    public String getF_settleBatchNo_op() {
        return this.f_settleBatchNo_op;
    }
    
    public void setF_settleBatchNo_op(String f_settleBatchNo_op) {
        this.f_settleBatchNo_op = f_settleBatchNo_op;
    }
   
    public Integer getF_settleStatus() {
        return this.f_settleStatus;
    }
    
    public void setF_settleStatus(Integer f_settleStatus) {
        this.f_settleStatus = f_settleStatus;
    }
    
    public String getF_settleStatus_op() {
        return this.f_settleStatus_op;
    }
    
    public void setF_settleStatus_op(String f_settleStatus_op) {
        this.f_settleStatus_op = f_settleStatus_op;
    }
   
    public String getF_settleDate() {
        return this.f_settleDate;
    }
    
    public void setF_settleDate(String f_settleDate) {
        this.f_settleDate = f_settleDate;
    }
    
    public String getF_settleDate_op() {
        return this.f_settleDate_op;
    }
    
    public void setF_settleDate_op(String f_settleDate_op) {
        this.f_settleDate_op = f_settleDate_op;
    }
   
    public Integer getF_feeAmount() {
        return this.f_feeAmount;
    }
    
    public void setF_feeAmount(Integer f_feeAmount) {
        this.f_feeAmount = f_feeAmount;
    }
    
    public String getF_feeAmount_op() {
        return this.f_feeAmount_op;
    }
    
    public void setF_feeAmount_op(String f_feeAmount_op) {
        this.f_feeAmount_op = f_feeAmount_op;
    }
   
    public Integer getF_hasCountFee() {
        return this.f_hasCountFee;
    }
    
    public void setF_hasCountFee(Integer f_hasCountFee) {
        this.f_hasCountFee = f_hasCountFee;
    }
    
    public String getF_hasCountFee_op() {
        return this.f_hasCountFee_op;
    }
    
    public void setF_hasCountFee_op(String f_hasCountFee_op) {
        this.f_hasCountFee_op = f_hasCountFee_op;
    }
   
    public Date getF_createdDatetime() {
        return this.f_createdDatetime;
    }
    
    public void setF_createdDatetime(Date f_createdDatetime) {
        this.f_createdDatetime = f_createdDatetime;
    }
    
    public String getF_createdDatetime_op() {
        return this.f_createdDatetime_op;
    }
    
    public void setF_createdDatetime_op(String f_createdDatetime_op) {
        this.f_createdDatetime_op = f_createdDatetime_op;
    }
    public Date getF_createdDatetime01() {
        return this.f_createdDatetime01;
    }
    
    public void setF_createdDatetime01(Date f_createdDatetime01) {
        this.f_createdDatetime01 = f_createdDatetime01;
    }
    
    public String getF_createdDatetime01_op() {
        return this.f_createdDatetime01_op;
    }
    
    public void setF_createdDatetime01_op(String f_createdDatetime01_op) {
        this.f_createdDatetime01_op = f_createdDatetime01_op;
    }
   
    public Date getF_lastUpdatedDatetime() {
        return this.f_lastUpdatedDatetime;
    }
    
    public void setF_lastUpdatedDatetime(Date f_lastUpdatedDatetime) {
        this.f_lastUpdatedDatetime = f_lastUpdatedDatetime;
    }
    
    public String getF_lastUpdatedDatetime_op() {
        return this.f_lastUpdatedDatetime_op;
    }
    
    public void setF_lastUpdatedDatetime_op(String f_lastUpdatedDatetime_op) {
        this.f_lastUpdatedDatetime_op = f_lastUpdatedDatetime_op;
    }
    public Date getF_lastUpdatedDatetime01() {
        return this.f_lastUpdatedDatetime01;
    }
    
    public void setF_lastUpdatedDatetime01(Date f_lastUpdatedDatetime01) {
        this.f_lastUpdatedDatetime01 = f_lastUpdatedDatetime01;
    }
    
    public String getF_lastUpdatedDatetime01_op() {
        return this.f_lastUpdatedDatetime01_op;
    }
    
    public void setF_lastUpdatedDatetime01_op(String f_lastUpdatedDatetime01_op) {
        this.f_lastUpdatedDatetime01_op = f_lastUpdatedDatetime01_op;
    }
   
    public Integer getF_lastUpdatedBy() {
        return this.f_lastUpdatedBy;
    }
    
    public void setF_lastUpdatedBy(Integer f_lastUpdatedBy) {
        this.f_lastUpdatedBy = f_lastUpdatedBy;
    }
    
    public String getF_lastUpdatedBy_op() {
        return this.f_lastUpdatedBy_op;
    }
    
    public void setF_lastUpdatedBy_op(String f_lastUpdatedBy_op) {
        this.f_lastUpdatedBy_op = f_lastUpdatedBy_op;
    }
   
    public String getF_bgNotifyUrl() {
        return this.f_bgNotifyUrl;
    }
    
    public void setF_bgNotifyUrl(String f_bgNotifyUrl) {
        this.f_bgNotifyUrl = f_bgNotifyUrl;
    }
    
    public String getF_bgNotifyUrl_op() {
        return this.f_bgNotifyUrl_op;
    }
    
    public void setF_bgNotifyUrl_op(String f_bgNotifyUrl_op) {
        this.f_bgNotifyUrl_op = f_bgNotifyUrl_op;
    }
   
    public String getF_mchtName() {
        return this.f_mchtName;
    }
    
    public void setF_mchtName(String f_mchtName) {
        this.f_mchtName = f_mchtName;
    }
    
    public String getF_mchtName_op() {
        return this.f_mchtName_op;
    }
    
    public void setF_mchtName_op(String f_mchtName_op) {
        this.f_mchtName_op = f_mchtName_op;
    }
   
    public Integer getF_payAmount() {
        return this.f_payAmount;
    }
    
    public void setF_payAmount(Integer f_payAmount) {
        this.f_payAmount = f_payAmount;
    }
    
    public String getF_payAmount_op() {
        return this.f_payAmount_op;
    }
    
    public void setF_payAmount_op(String f_payAmount_op) {
        this.f_payAmount_op = f_payAmount_op;
    }
   
    public Integer getF_deleted() {
        return this.f_deleted;
    }
    
    public void setF_deleted(Integer f_deleted) {
        this.f_deleted = f_deleted;
    }
    
    public String getF_deleted_op() {
        return this.f_deleted_op;
    }
    
    public void setF_deleted_op(String f_deleted_op) {
        this.f_deleted_op = f_deleted_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
