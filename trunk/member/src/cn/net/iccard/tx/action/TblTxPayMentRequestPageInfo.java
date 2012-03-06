package cn.net.iccard.tx.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblTxPayMentRequestPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_mchtTxTraceNo;
 	protected  String  f_mchtTxTraceNo_op;
	protected  String  f_lastMchtTxTraceNo;
 	protected  String  f_lastMchtTxTraceNo_op;
	protected  String  f_mchtNo;
 	protected  String  f_mchtNo_op;
	protected  Integer  f_amount;
 	protected  String  f_amount_op;
	protected  String  f_lastMchtTxTime;
 	protected  String  f_lastMchtTxTime_op;
	protected  String  f_mchtTxTime;
 	protected  String  f_mchtTxTime_op;
	protected  String  f_txStatus;
 	protected  String  f_txStatus_op;
	protected  String  f_txTypeId;
 	protected  String  f_txTypeId_op;
	protected  String  f_msgext;
 	protected  String  f_msgext_op;
	protected  String  f_mchtRawMessage;
 	protected  String  f_mchtRawMessage_op;
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
   
    public Integer getF_amount() {
        return this.f_amount;
    }
    
    public void setF_amount(Integer f_amount) {
        this.f_amount = f_amount;
    }
    
    public String getF_amount_op() {
        return this.f_amount_op;
    }
    
    public void setF_amount_op(String f_amount_op) {
        this.f_amount_op = f_amount_op;
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
   
    public String getF_txStatus() {
        return this.f_txStatus;
    }
    
    public void setF_txStatus(String f_txStatus) {
        this.f_txStatus = f_txStatus;
    }
    
    public String getF_txStatus_op() {
        return this.f_txStatus_op;
    }
    
    public void setF_txStatus_op(String f_txStatus_op) {
        this.f_txStatus_op = f_txStatus_op;
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
   
    public String getF_msgext() {
        return this.f_msgext;
    }
    
    public void setF_msgext(String f_msgext) {
        this.f_msgext = f_msgext;
    }
    
    public String getF_msgext_op() {
        return this.f_msgext_op;
    }
    
    public void setF_msgext_op(String f_msgext_op) {
        this.f_msgext_op = f_msgext_op;
    }
   
    public String getF_mchtRawMessage() {
        return this.f_mchtRawMessage;
    }
    
    public void setF_mchtRawMessage(String f_mchtRawMessage) {
        this.f_mchtRawMessage = f_mchtRawMessage;
    }
    
    public String getF_mchtRawMessage_op() {
        return this.f_mchtRawMessage_op;
    }
    
    public void setF_mchtRawMessage_op(String f_mchtRawMessage_op) {
        this.f_mchtRawMessage_op = f_mchtRawMessage_op;
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
