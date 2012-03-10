package cn.net.iccard.bm.settleservice.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import cn.net.iccard.bm.settleservice.action.TblStlSettleBatchPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblStlSettleApplyPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_availableBalance;
 	protected  String  f_availableBalance_op;
	protected  Integer  f_amount;
 	protected  String  f_amount_op;
	protected  Integer  f_settleApplyStatus;
 	protected  String  f_settleApplyStatus_op;
	protected  String  f_auditOpinion;
 	protected  String  f_auditOpinion_op;
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

 	protected  TblMchtInfoPageInfo tblMchtInfo;
 	protected  TblStlSettleBatchPageInfo tblStlSettleBatch;
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
   
    public Integer getF_availableBalance() {
        return this.f_availableBalance;
    }
    
    public void setF_availableBalance(Integer f_availableBalance) {
        this.f_availableBalance = f_availableBalance;
    }
    
    public String getF_availableBalance_op() {
        return this.f_availableBalance_op;
    }
    
    public void setF_availableBalance_op(String f_availableBalance_op) {
        this.f_availableBalance_op = f_availableBalance_op;
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
   
    public Integer getF_settleApplyStatus() {
        return this.f_settleApplyStatus;
    }
    
    public void setF_settleApplyStatus(Integer f_settleApplyStatus) {
        this.f_settleApplyStatus = f_settleApplyStatus;
    }
    
    public String getF_settleApplyStatus_op() {
        return this.f_settleApplyStatus_op;
    }
    
    public void setF_settleApplyStatus_op(String f_settleApplyStatus_op) {
        this.f_settleApplyStatus_op = f_settleApplyStatus_op;
    }
   
    public String getF_auditOpinion() {
        return this.f_auditOpinion;
    }
    
    public void setF_auditOpinion(String f_auditOpinion) {
        this.f_auditOpinion = f_auditOpinion;
    }
    
    public String getF_auditOpinion_op() {
        return this.f_auditOpinion_op;
    }
    
    public void setF_auditOpinion_op(String f_auditOpinion_op) {
        this.f_auditOpinion_op = f_auditOpinion_op;
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
   
	public TblMchtInfoPageInfo getTblMchtInfo() {
		return tblMchtInfo;
	}

	public void setTblMchtInfo(TblMchtInfoPageInfo tblMchtInfo) {
		this.tblMchtInfo = tblMchtInfo;
	}
	public TblStlSettleBatchPageInfo getTblStlSettleBatch() {
		return tblStlSettleBatch;
	}

	public void setTblStlSettleBatch(TblStlSettleBatchPageInfo tblStlSettleBatch) {
		this.tblStlSettleBatch = tblStlSettleBatch;
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
