package cn.net.iccard.bm.accounting.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class ActAccountPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_accountNo;
 	protected  String  f_accountNo_op;
	protected  Integer  f_accountCatalog;
 	protected  String  f_accountCatalog_op;
	protected  Integer  f_accountPartyType;
 	protected  String  f_accountPartyType_op;
	protected  String  f_accountParty;
 	protected  String  f_accountParty_op;
	protected  String  f_accountName;
 	protected  String  f_accountName_op;
	protected  Integer  f_status;
 	protected  String  f_status_op;
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
   
    public String getF_accountNo() {
        return this.f_accountNo;
    }
    
    public void setF_accountNo(String f_accountNo) {
        this.f_accountNo = f_accountNo;
    }
    
    public String getF_accountNo_op() {
        return this.f_accountNo_op;
    }
    
    public void setF_accountNo_op(String f_accountNo_op) {
        this.f_accountNo_op = f_accountNo_op;
    }
   
    public Integer getF_accountCatalog() {
        return this.f_accountCatalog;
    }
    
    public void setF_accountCatalog(Integer f_accountCatalog) {
        this.f_accountCatalog = f_accountCatalog;
    }
    
    public String getF_accountCatalog_op() {
        return this.f_accountCatalog_op;
    }
    
    public void setF_accountCatalog_op(String f_accountCatalog_op) {
        this.f_accountCatalog_op = f_accountCatalog_op;
    }
   
    public Integer getF_accountPartyType() {
        return this.f_accountPartyType;
    }
    
    public void setF_accountPartyType(Integer f_accountPartyType) {
        this.f_accountPartyType = f_accountPartyType;
    }
    
    public String getF_accountPartyType_op() {
        return this.f_accountPartyType_op;
    }
    
    public void setF_accountPartyType_op(String f_accountPartyType_op) {
        this.f_accountPartyType_op = f_accountPartyType_op;
    }
   
    public String getF_accountParty() {
        return this.f_accountParty;
    }
    
    public void setF_accountParty(String f_accountParty) {
        this.f_accountParty = f_accountParty;
    }
    
    public String getF_accountParty_op() {
        return this.f_accountParty_op;
    }
    
    public void setF_accountParty_op(String f_accountParty_op) {
        this.f_accountParty_op = f_accountParty_op;
    }
   
    public String getF_accountName() {
        return this.f_accountName;
    }
    
    public void setF_accountName(String f_accountName) {
        this.f_accountName = f_accountName;
    }
    
    public String getF_accountName_op() {
        return this.f_accountName_op;
    }
    
    public void setF_accountName_op(String f_accountName_op) {
        this.f_accountName_op = f_accountName_op;
    }
   
    public Integer getF_status() {
        return this.f_status;
    }
    
    public void setF_status(Integer f_status) {
        this.f_status = f_status;
    }
    
    public String getF_status_op() {
        return this.f_status_op;
    }
    
    public void setF_status_op(String f_status_op) {
        this.f_status_op = f_status_op;
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
