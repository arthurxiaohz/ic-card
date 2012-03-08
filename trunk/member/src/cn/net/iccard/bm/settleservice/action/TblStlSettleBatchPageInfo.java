package cn.net.iccard.bm.settleservice.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblStlSettleBatchPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_settleNo;
 	protected  String  f_settleNo_op;
	protected  Timestamp  f_createdDatetime;
 	protected  String  f_createdDatetime_op;
	protected  Timestamp  f_createdDatetime01;
	protected  String  f_createdDatetime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_orderCount;
 	protected  String  f_orderCount_op;
	protected  String  f_balance;
 	protected  String  f_balance_op;
	protected  String  f_fee;
 	protected  String  f_fee_op;
	protected  Integer  f_refundCount;
 	protected  String  f_refundCount_op;
	protected  String  f_refundBalance;
 	protected  String  f_refundBalance_op;
	protected  String  f_refundFee;
 	protected  String  f_refundFee_op;
	protected  String  f_settleAmount;
 	protected  String  f_settleAmount_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  TblMchtInfoPageInfo tblMchtInfo;
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
   
    public String getF_settleNo() {
        return this.f_settleNo;
    }
    
    public void setF_settleNo(String f_settleNo) {
        this.f_settleNo = f_settleNo;
    }
    
    public String getF_settleNo_op() {
        return this.f_settleNo_op;
    }
    
    public void setF_settleNo_op(String f_settleNo_op) {
        this.f_settleNo_op = f_settleNo_op;
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
   
    public Integer getF_orderCount() {
        return this.f_orderCount;
    }
    
    public void setF_orderCount(Integer f_orderCount) {
        this.f_orderCount = f_orderCount;
    }
    
    public String getF_orderCount_op() {
        return this.f_orderCount_op;
    }
    
    public void setF_orderCount_op(String f_orderCount_op) {
        this.f_orderCount_op = f_orderCount_op;
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
   
    public String getF_fee() {
        return this.f_fee;
    }
    
    public void setF_fee(String f_fee) {
        this.f_fee = f_fee;
    }
    
    public String getF_fee_op() {
        return this.f_fee_op;
    }
    
    public void setF_fee_op(String f_fee_op) {
        this.f_fee_op = f_fee_op;
    }
   
    public Integer getF_refundCount() {
        return this.f_refundCount;
    }
    
    public void setF_refundCount(Integer f_refundCount) {
        this.f_refundCount = f_refundCount;
    }
    
    public String getF_refundCount_op() {
        return this.f_refundCount_op;
    }
    
    public void setF_refundCount_op(String f_refundCount_op) {
        this.f_refundCount_op = f_refundCount_op;
    }
   
    public String getF_refundBalance() {
        return this.f_refundBalance;
    }
    
    public void setF_refundBalance(String f_refundBalance) {
        this.f_refundBalance = f_refundBalance;
    }
    
    public String getF_refundBalance_op() {
        return this.f_refundBalance_op;
    }
    
    public void setF_refundBalance_op(String f_refundBalance_op) {
        this.f_refundBalance_op = f_refundBalance_op;
    }
   
    public String getF_refundFee() {
        return this.f_refundFee;
    }
    
    public void setF_refundFee(String f_refundFee) {
        this.f_refundFee = f_refundFee;
    }
    
    public String getF_refundFee_op() {
        return this.f_refundFee_op;
    }
    
    public void setF_refundFee_op(String f_refundFee_op) {
        this.f_refundFee_op = f_refundFee_op;
    }
   
    public String getF_settleAmount() {
        return this.f_settleAmount;
    }
    
    public void setF_settleAmount(String f_settleAmount) {
        this.f_settleAmount = f_settleAmount;
    }
    
    public String getF_settleAmount_op() {
        return this.f_settleAmount_op;
    }
    
    public void setF_settleAmount_op(String f_settleAmount_op) {
        this.f_settleAmount_op = f_settleAmount_op;
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
   
	public TblMchtInfoPageInfo getTblMchtInfo() {
		return tblMchtInfo;
	}

	public void setTblMchtInfo(TblMchtInfoPageInfo tblMchtInfo) {
		this.tblMchtInfo = tblMchtInfo;
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
