package cn.net.iccard.member.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblMbPointDetailPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_point;
 	protected  String  f_point_op;
	protected  Integer  f_pointTxType;
 	protected  String  f_pointTxType_op;
	protected  Integer  f_voucherNo;
 	protected  String  f_voucherNo_op;
	protected  Integer  f_balance;
 	protected  String  f_balance_op;
	protected  Timestamp  f_createdDateTime;
 	protected  String  f_createdDateTime_op;
	protected  Timestamp  f_createdDateTime01;
	protected  String  f_createdDateTime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;

 	protected  HiUserPageInfo lastUpdatedBy;
 	protected  HiUserPageInfo tblMbInfo;
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
   
    public Integer getF_point() {
        return this.f_point;
    }
    
    public void setF_point(Integer f_point) {
        this.f_point = f_point;
    }
    
    public String getF_point_op() {
        return this.f_point_op;
    }
    
    public void setF_point_op(String f_point_op) {
        this.f_point_op = f_point_op;
    }
   
    public Integer getF_pointTxType() {
        return this.f_pointTxType;
    }
    
    public void setF_pointTxType(Integer f_pointTxType) {
        this.f_pointTxType = f_pointTxType;
    }
    
    public String getF_pointTxType_op() {
        return this.f_pointTxType_op;
    }
    
    public void setF_pointTxType_op(String f_pointTxType_op) {
        this.f_pointTxType_op = f_pointTxType_op;
    }
   
    public Integer getF_voucherNo() {
        return this.f_voucherNo;
    }
    
    public void setF_voucherNo(Integer f_voucherNo) {
        this.f_voucherNo = f_voucherNo;
    }
    
    public String getF_voucherNo_op() {
        return this.f_voucherNo_op;
    }
    
    public void setF_voucherNo_op(String f_voucherNo_op) {
        this.f_voucherNo_op = f_voucherNo_op;
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
   
	public HiUserPageInfo getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(HiUserPageInfo lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public HiUserPageInfo getTblMbInfo() {
		return tblMbInfo;
	}

	public void setTblMbInfo(HiUserPageInfo tblMbInfo) {
		this.tblMbInfo = tblMbInfo;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
