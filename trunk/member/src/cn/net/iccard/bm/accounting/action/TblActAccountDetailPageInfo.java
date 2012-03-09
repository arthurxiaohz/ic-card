package cn.net.iccard.bm.accounting.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.accounting.action.ActAccountPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblActAccountDetailPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_voucherType;
 	protected  String  f_voucherType_op;
	protected  String  f_voucherNo;
 	protected  String  f_voucherNo_op;
	protected  Integer  f_amount;
 	protected  String  f_amount_op;
	protected  Integer  f_debitOrCredit;
 	protected  String  f_debitOrCredit_op;
	protected  Integer  f_balance;
 	protected  String  f_balance_op;
	protected  String  f_remark;
 	protected  String  f_remark_op;
	protected  String  f_expiredDate;
 	protected  String  f_expiredDate_op;
	protected  Integer  f_settleStatus;
 	protected  String  f_settleStatus_op;
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
   
    public Integer getF_voucherType() {
        return this.f_voucherType;
    }
    
    public void setF_voucherType(Integer f_voucherType) {
        this.f_voucherType = f_voucherType;
    }
    
    public String getF_voucherType_op() {
        return this.f_voucherType_op;
    }
    
    public void setF_voucherType_op(String f_voucherType_op) {
        this.f_voucherType_op = f_voucherType_op;
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
   
    public Integer getF_balance() {
        return this.f_balance;
    }
    
    public void setF_balance(Integer f_balance) {
        this.f_balance = f_balance;
    }
    
    public String getF_balance_op() {
        return this.f_balance_op;
    }
    
    public void setF_balance_op(String f_balance_op) {
        this.f_balance_op = f_balance_op;
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
   
    public String getF_expiredDate() {
        return this.f_expiredDate;
    }
    
    public void setF_expiredDate(String f_expiredDate) {
        this.f_expiredDate = f_expiredDate;
    }
    
    public String getF_expiredDate_op() {
        return this.f_expiredDate_op;
    }
    
    public void setF_expiredDate_op(String f_expiredDate_op) {
        this.f_expiredDate_op = f_expiredDate_op;
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
