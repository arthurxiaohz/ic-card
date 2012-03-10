package cn.net.iccard.bm.accounting.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.accounting.action.ActAccountPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblActDebitCreditVoucherPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_voucherNo;
 	protected  String  f_voucherNo_op;
	protected  Integer  f_amount;
 	protected  String  f_amount_op;
	protected  Integer  f_debitOrCredit;
 	protected  String  f_debitOrCredit_op;
	protected  Integer  f_bizType;
 	protected  String  f_bizType_op;
	protected  Integer  f_bizLogId;
 	protected  String  f_bizLogId_op;
	protected  String  f_remark;
 	protected  String  f_remark_op;
	protected  Timestamp  f_createdDateTime;
 	protected  String  f_createdDateTime_op;
	protected  Timestamp  f_createdDateTime01;
	protected  String  f_createdDateTime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  ActAccountPageInfo actAccount;
 	protected  HiUserPageInfo lastUpdatedBy;
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
   
    public Integer getF_debitOrCredit() {
        return this.f_debitOrCredit;
    }
    
    public void setF_debitOrCredit(Integer f_debitOrCredit) {
        this.f_debitOrCredit = f_debitOrCredit;
    }
    
    public String getF_debitOrCredit_op() {
        return this.f_debitOrCredit_op;
    }
    
    public void setF_debitOrCredit_op(String f_debitOrCredit_op) {
        this.f_debitOrCredit_op = f_debitOrCredit_op;
    }
   
    public Integer getF_bizType() {
        return this.f_bizType;
    }
    
    public void setF_bizType(Integer f_bizType) {
        this.f_bizType = f_bizType;
    }
    
    public String getF_bizType_op() {
        return this.f_bizType_op;
    }
    
    public void setF_bizType_op(String f_bizType_op) {
        this.f_bizType_op = f_bizType_op;
    }
   
    public Integer getF_bizLogId() {
        return this.f_bizLogId;
    }
    
    public void setF_bizLogId(Integer f_bizLogId) {
        this.f_bizLogId = f_bizLogId;
    }
    
    public String getF_bizLogId_op() {
        return this.f_bizLogId_op;
    }
    
    public void setF_bizLogId_op(String f_bizLogId_op) {
        this.f_bizLogId_op = f_bizLogId_op;
    }
   
    public String getF_remark() {
        return this.f_remark;
    }
    
    public void setF_remark(String f_remark) {
        this.f_remark = f_remark;
    }
    
    public String getF_remark_op() {
        return this.f_remark_op;
    }
    
    public void setF_remark_op(String f_remark_op) {
        this.f_remark_op = f_remark_op;
    }
   
    public Timestamp getF_createdDateTime() {
        return this.f_createdDateTime;
    }
    
    public void setF_createdDateTime(Timestamp f_createdDateTime) {
        this.f_createdDateTime = f_createdDateTime;
    }
    
    public String getF_createdDateTime_op() {
        return this.f_createdDateTime_op;
    }
    
    public void setF_createdDateTime_op(String f_createdDateTime_op) {
        this.f_createdDateTime_op = f_createdDateTime_op;
    }
    public Timestamp getF_createdDateTime01() {
        return this.f_createdDateTime01;
    }
    
    public void setF_createdDateTime01(Timestamp f_createdDateTime01) {
        this.f_createdDateTime01 = f_createdDateTime01;
    }
    
    public String getF_createdDateTime01_op() {
        return this.f_createdDateTime01_op;
    }
    
    public void setF_createdDateTime01_op(String f_createdDateTime01_op) {
        this.f_createdDateTime01_op = f_createdDateTime01_op;
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
   
	public ActAccountPageInfo getActAccount() {
		return actAccount;
	}

	public void setActAccount(ActAccountPageInfo actAccount) {
		this.actAccount = actAccount;
	}
	public HiUserPageInfo getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(HiUserPageInfo lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
