package cn.net.iccard.tx.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblTxSmsLogPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_senderId;
 	protected  String  f_senderId_op;
	protected  String  f_seqNo;
 	protected  String  f_seqNo_op;
	protected  String  f_phoneNum;
 	protected  String  f_phoneNum_op;
	protected  String  f_phoneMessage;
 	protected  String  f_phoneMessage_op;
	protected  String  f_status;
 	protected  String  f_status_op;
	protected  Timestamp  f_createdDatetime;
 	protected  String  f_createdDatetime_op;
	protected  Timestamp  f_createdDatetime01;
	protected  String  f_createdDatetime01_op;
	protected  Timestamp  f_lastUpdatedDdatetime;
 	protected  String  f_lastUpdatedDdatetime_op;
	protected  Timestamp  f_lastUpdatedDdatetime01;
	protected  String  f_lastUpdatedDdatetime01_op;
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
   
    public String getF_senderId() {
        return this.f_senderId;
    }
    
    public void setF_senderId(String f_senderId) {
        this.f_senderId = f_senderId;
    }
    
    public String getF_senderId_op() {
        return this.f_senderId_op;
    }
    
    public void setF_senderId_op(String f_senderId_op) {
        this.f_senderId_op = f_senderId_op;
    }
   
    public String getF_seqNo() {
        return this.f_seqNo;
    }
    
    public void setF_seqNo(String f_seqNo) {
        this.f_seqNo = f_seqNo;
    }
    
    public String getF_seqNo_op() {
        return this.f_seqNo_op;
    }
    
    public void setF_seqNo_op(String f_seqNo_op) {
        this.f_seqNo_op = f_seqNo_op;
    }
   
    public String getF_phoneNum() {
        return this.f_phoneNum;
    }
    
    public void setF_phoneNum(String f_phoneNum) {
        this.f_phoneNum = f_phoneNum;
    }
    
    public String getF_phoneNum_op() {
        return this.f_phoneNum_op;
    }
    
    public void setF_phoneNum_op(String f_phoneNum_op) {
        this.f_phoneNum_op = f_phoneNum_op;
    }
   
    public String getF_phoneMessage() {
        return this.f_phoneMessage;
    }
    
    public void setF_phoneMessage(String f_phoneMessage) {
        this.f_phoneMessage = f_phoneMessage;
    }
    
    public String getF_phoneMessage_op() {
        return this.f_phoneMessage_op;
    }
    
    public void setF_phoneMessage_op(String f_phoneMessage_op) {
        this.f_phoneMessage_op = f_phoneMessage_op;
    }
   
    public String getF_status() {
        return this.f_status;
    }
    
    public void setF_status(String f_status) {
        this.f_status = f_status;
    }
    
    public String getF_status_op() {
        return this.f_status_op;
    }
    
    public void setF_status_op(String f_status_op) {
        this.f_status_op = f_status_op;
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
   
    public Timestamp getF_lastUpdatedDdatetime() {
        return this.f_lastUpdatedDdatetime;
    }
    
    public void setF_lastUpdatedDdatetime(Timestamp f_lastUpdatedDdatetime) {
        this.f_lastUpdatedDdatetime = f_lastUpdatedDdatetime;
    }
    
    public String getF_lastUpdatedDdatetime_op() {
        return this.f_lastUpdatedDdatetime_op;
    }
    
    public void setF_lastUpdatedDdatetime_op(String f_lastUpdatedDdatetime_op) {
        this.f_lastUpdatedDdatetime_op = f_lastUpdatedDdatetime_op;
    }
    public Timestamp getF_lastUpdatedDdatetime01() {
        return this.f_lastUpdatedDdatetime01;
    }
    
    public void setF_lastUpdatedDdatetime01(Timestamp f_lastUpdatedDdatetime01) {
        this.f_lastUpdatedDdatetime01 = f_lastUpdatedDdatetime01;
    }
    
    public String getF_lastUpdatedDdatetime01_op() {
        return this.f_lastUpdatedDdatetime01_op;
    }
    
    public void setF_lastUpdatedDdatetime01_op(String f_lastUpdatedDdatetime01_op) {
        this.f_lastUpdatedDdatetime01_op = f_lastUpdatedDdatetime01_op;
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
