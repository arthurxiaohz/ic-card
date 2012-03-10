package cn.net.iccard.member.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;
import cn.net.iccard.member.action.TblMbCouponPageInfo;

public class TblMbCouponDetailPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_amount;
 	protected  String  f_amount_op;
	protected  String  f_plTxTraceNo;
 	protected  String  f_plTxTraceNo_op;
	protected  String  f_balance;
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
 	protected  TblMbCouponPageInfo tblMbCoupon;
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
   
    public String getF_amount() {
        return this.f_amount;
    }
    
    public void setF_amount(String f_amount) {
        this.f_amount = f_amount;
    }
    
    public String getF_amount_op() {
        return this.f_amount_op;
    }
    
    public void setF_amount_op(String f_amount_op) {
        this.f_amount_op = f_amount_op;
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
   
    public String getF_balance() {
        return this.f_balance;
    }
    
    public void setF_balance(String f_balance) {
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
	public TblMbCouponPageInfo getTblMbCoupon() {
		return tblMbCoupon;
	}

	public void setTblMbCoupon(TblMbCouponPageInfo tblMbCoupon) {
		this.tblMbCoupon = tblMbCoupon;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
