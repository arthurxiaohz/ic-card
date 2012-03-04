package cn.net.iccard.tx.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblTxPayMentResponsePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_responseId;
 	protected  String  f_responseId_op;
	protected  String  f_versionNo;
 	protected  String  f_versionNo_op;
	protected  String  f_signMsg;
 	protected  String  f_signMsg_op;
	protected  String  f_payResult;
 	protected  String  f_payResult_op;
	protected  String  f_mchtNo;
 	protected  String  f_mchtNo_op;
	protected  String  f_merchantOrderNo;
 	protected  String  f_merchantOrderNo_op;
	protected  Integer  f_orderAmount;
 	protected  String  f_orderAmount_op;
	protected  String  f_txTypeId;
 	protected  String  f_txTypeId_op;
	protected  Integer  f_payAmount;
 	protected  String  f_payAmount_op;
	protected  String  f_payDatetime;
 	protected  String  f_payDatetime_op;
	protected  String  f_ext1;
 	protected  String  f_ext1_op;
	protected  Date  f_ext2;
 	protected  String  f_ext2_op;
	protected  Date  f_ext201;
	protected  String  f_ext201_op;
	protected  String  f_errorCode;
 	protected  String  f_errorCode_op;
	protected  String  f_context;
 	protected  String  f_context_op;
	protected  String  f_responseContent;
 	protected  String  f_responseContent_op;
	protected  Timestamp  f_createdDatetime;
 	protected  String  f_createdDatetime_op;
	protected  Timestamp  f_createdDatetime01;
	protected  String  f_createdDatetime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_lastUpdatedBy;
 	protected  String  f_lastUpdatedBy_op;
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
   
    public String getF_responseId() {
        return this.f_responseId;
    }
    
    public void setF_responseId(String f_responseId) {
        this.f_responseId = f_responseId;
    }
    
    public String getF_responseId_op() {
        return this.f_responseId_op;
    }
    
    public void setF_responseId_op(String f_responseId_op) {
        this.f_responseId_op = f_responseId_op;
    }
   
    public String getF_versionNo() {
        return this.f_versionNo;
    }
    
    public void setF_versionNo(String f_versionNo) {
        this.f_versionNo = f_versionNo;
    }
    
    public String getF_versionNo_op() {
        return this.f_versionNo_op;
    }
    
    public void setF_versionNo_op(String f_versionNo_op) {
        this.f_versionNo_op = f_versionNo_op;
    }
   
    public String getF_signMsg() {
        return this.f_signMsg;
    }
    
    public void setF_signMsg(String f_signMsg) {
        this.f_signMsg = f_signMsg;
    }
    
    public String getF_signMsg_op() {
        return this.f_signMsg_op;
    }
    
    public void setF_signMsg_op(String f_signMsg_op) {
        this.f_signMsg_op = f_signMsg_op;
    }
   
    public String getF_payResult() {
        return this.f_payResult;
    }
    
    public void setF_payResult(String f_payResult) {
        this.f_payResult = f_payResult;
    }
    
    public String getF_payResult_op() {
        return this.f_payResult_op;
    }
    
    public void setF_payResult_op(String f_payResult_op) {
        this.f_payResult_op = f_payResult_op;
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
   
    public String getF_merchantOrderNo() {
        return this.f_merchantOrderNo;
    }
    
    public void setF_merchantOrderNo(String f_merchantOrderNo) {
        this.f_merchantOrderNo = f_merchantOrderNo;
    }
    
    public String getF_merchantOrderNo_op() {
        return this.f_merchantOrderNo_op;
    }
    
    public void setF_merchantOrderNo_op(String f_merchantOrderNo_op) {
        this.f_merchantOrderNo_op = f_merchantOrderNo_op;
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
   
    public String getF_payDatetime() {
        return this.f_payDatetime;
    }
    
    public void setF_payDatetime(String f_payDatetime) {
        this.f_payDatetime = f_payDatetime;
    }
    
    public String getF_payDatetime_op() {
        return this.f_payDatetime_op;
    }
    
    public void setF_payDatetime_op(String f_payDatetime_op) {
        this.f_payDatetime_op = f_payDatetime_op;
    }
   
    public String getF_ext1() {
        return this.f_ext1;
    }
    
    public void setF_ext1(String f_ext1) {
        this.f_ext1 = f_ext1;
    }
    
    public String getF_ext1_op() {
        return this.f_ext1_op;
    }
    
    public void setF_ext1_op(String f_ext1_op) {
        this.f_ext1_op = f_ext1_op;
    }
   
    public Date getF_ext2() {
        return this.f_ext2;
    }
    
    public void setF_ext2(Date f_ext2) {
        this.f_ext2 = f_ext2;
    }
    
    public String getF_ext2_op() {
        return this.f_ext2_op;
    }
    
    public void setF_ext2_op(String f_ext2_op) {
        this.f_ext2_op = f_ext2_op;
    }
    public Date getF_ext201() {
        return this.f_ext201;
    }
    
    public void setF_ext201(Date f_ext201) {
        this.f_ext201 = f_ext201;
    }
    
    public String getF_ext201_op() {
        return this.f_ext201_op;
    }
    
    public void setF_ext201_op(String f_ext201_op) {
        this.f_ext201_op = f_ext201_op;
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
   
    public String getF_context() {
        return this.f_context;
    }
    
    public void setF_context(String f_context) {
        this.f_context = f_context;
    }
    
    public String getF_context_op() {
        return this.f_context_op;
    }
    
    public void setF_context_op(String f_context_op) {
        this.f_context_op = f_context_op;
    }
   
    public String getF_responseContent() {
        return this.f_responseContent;
    }
    
    public void setF_responseContent(String f_responseContent) {
        this.f_responseContent = f_responseContent;
    }
    
    public String getF_responseContent_op() {
        return this.f_responseContent_op;
    }
    
    public void setF_responseContent_op(String f_responseContent_op) {
        this.f_responseContent_op = f_responseContent_op;
    }
   
    public Timestamp getF_createdDatetime() {
        return this.f_createdDatetime;
    }
    
    public void setF_createdDatetime(Timestamp f_createdDatetime) {
        this.f_createdDatetime = f_createdDatetime;
    }
    
    public String getF_createdDatetime_op() {
        return this.f_createdDatetime_op;
    }
    
    public void setF_createdDatetime_op(String f_createdDatetime_op) {
        this.f_createdDatetime_op = f_createdDatetime_op;
    }
    public Timestamp getF_createdDatetime01() {
        return this.f_createdDatetime01;
    }
    
    public void setF_createdDatetime01(Timestamp f_createdDatetime01) {
        this.f_createdDatetime01 = f_createdDatetime01;
    }
    
    public String getF_createdDatetime01_op() {
        return this.f_createdDatetime01_op;
    }
    
    public void setF_createdDatetime01_op(String f_createdDatetime01_op) {
        this.f_createdDatetime01_op = f_createdDatetime01_op;
    }
   
    public Timestamp getF_lastUpdatedDatetime() {
        return this.f_lastUpdatedDatetime;
    }
    
    public void setF_lastUpdatedDatetime(Timestamp f_lastUpdatedDatetime) {
        this.f_lastUpdatedDatetime = f_lastUpdatedDatetime;
    }
    
    public String getF_lastUpdatedDatetime_op() {
        return this.f_lastUpdatedDatetime_op;
    }
    
    public void setF_lastUpdatedDatetime_op(String f_lastUpdatedDatetime_op) {
        this.f_lastUpdatedDatetime_op = f_lastUpdatedDatetime_op;
    }
    public Timestamp getF_lastUpdatedDatetime01() {
        return this.f_lastUpdatedDatetime01;
    }
    
    public void setF_lastUpdatedDatetime01(Timestamp f_lastUpdatedDatetime01) {
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
