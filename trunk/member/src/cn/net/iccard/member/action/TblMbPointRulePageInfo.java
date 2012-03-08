package cn.net.iccard.member.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;

public class TblMbPointRulePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_mchtType;
 	protected  String  f_mchtType_op;
	protected  Timestamp  f_startDatetime;
 	protected  String  f_startDatetime_op;
	protected  Timestamp  f_startDatetime01;
	protected  String  f_startDatetime01_op;
	protected  Timestamp  f_endDatetime;
 	protected  String  f_endDatetime_op;
	protected  Timestamp  f_endDatetime01;
	protected  String  f_endDatetime01_op;
	protected  String  f_minAmount;
 	protected  String  f_minAmount_op;
	protected  String  f_maxAmount;
 	protected  String  f_maxAmount_op;
	protected  Integer  f_pointRuleType;
 	protected  String  f_pointRuleType_op;
	protected  Double  f_ruleValue;
 	protected  String  f_ruleValue_op;
	protected  Timestamp  f_createdDateTime;
 	protected  String  f_createdDateTime_op;
	protected  Timestamp  f_createdDateTime01;
	protected  String  f_createdDateTime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_lastUpdatedBy;
 	protected  String  f_lastUpdatedBy_op;

 	protected  HiUserPageInfo tblMbInfo;
 	protected  TblMchtInfoPageInfo tblMchtInfo;
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
   
    public Integer getF_mchtType() {
        return this.f_mchtType;
    }
    
    public void setF_mchtType(Integer f_mchtType) {
        this.f_mchtType = f_mchtType;
    }
    
    public String getF_mchtType_op() {
        return this.f_mchtType_op;
    }
    
    public void setF_mchtType_op(String f_mchtType_op) {
        this.f_mchtType_op = f_mchtType_op;
    }
   
    public Timestamp getF_startDatetime() {
        return this.f_startDatetime;
    }
    
    public void setF_startDatetime(Timestamp f_startDatetime) {
        this.f_startDatetime = f_startDatetime;
    }
    
    public String getF_startDatetime_op() {
        return this.f_startDatetime_op;
    }
    
    public void setF_startDatetime_op(String f_startDatetime_op) {
        this.f_startDatetime_op = f_startDatetime_op;
    }
    public Timestamp getF_startDatetime01() {
        return this.f_startDatetime01;
    }
    
    public void setF_startDatetime01(Timestamp f_startDatetime01) {
        this.f_startDatetime01 = f_startDatetime01;
    }
    
    public String getF_startDatetime01_op() {
        return this.f_startDatetime01_op;
    }
    
    public void setF_startDatetime01_op(String f_startDatetime01_op) {
        this.f_startDatetime01_op = f_startDatetime01_op;
    }
   
    public Timestamp getF_endDatetime() {
        return this.f_endDatetime;
    }
    
    public void setF_endDatetime(Timestamp f_endDatetime) {
        this.f_endDatetime = f_endDatetime;
    }
    
    public String getF_endDatetime_op() {
        return this.f_endDatetime_op;
    }
    
    public void setF_endDatetime_op(String f_endDatetime_op) {
        this.f_endDatetime_op = f_endDatetime_op;
    }
    public Timestamp getF_endDatetime01() {
        return this.f_endDatetime01;
    }
    
    public void setF_endDatetime01(Timestamp f_endDatetime01) {
        this.f_endDatetime01 = f_endDatetime01;
    }
    
    public String getF_endDatetime01_op() {
        return this.f_endDatetime01_op;
    }
    
    public void setF_endDatetime01_op(String f_endDatetime01_op) {
        this.f_endDatetime01_op = f_endDatetime01_op;
    }
   
    public String getF_minAmount() {
        return this.f_minAmount;
    }
    
    public void setF_minAmount(String f_minAmount) {
        this.f_minAmount = f_minAmount;
    }
    
    public String getF_minAmount_op() {
        return this.f_minAmount_op;
    }
    
    public void setF_minAmount_op(String f_minAmount_op) {
        this.f_minAmount_op = f_minAmount_op;
    }
   
    public String getF_maxAmount() {
        return this.f_maxAmount;
    }
    
    public void setF_maxAmount(String f_maxAmount) {
        this.f_maxAmount = f_maxAmount;
    }
    
    public String getF_maxAmount_op() {
        return this.f_maxAmount_op;
    }
    
    public void setF_maxAmount_op(String f_maxAmount_op) {
        this.f_maxAmount_op = f_maxAmount_op;
    }
   
    public Integer getF_pointRuleType() {
        return this.f_pointRuleType;
    }
    
    public void setF_pointRuleType(Integer f_pointRuleType) {
        this.f_pointRuleType = f_pointRuleType;
    }
    
    public String getF_pointRuleType_op() {
        return this.f_pointRuleType_op;
    }
    
    public void setF_pointRuleType_op(String f_pointRuleType_op) {
        this.f_pointRuleType_op = f_pointRuleType_op;
    }
   
    public Double getF_ruleValue() {
        return this.f_ruleValue;
    }
    
    public void setF_ruleValue(Double f_ruleValue) {
        this.f_ruleValue = f_ruleValue;
    }
    
    public String getF_ruleValue_op() {
        return this.f_ruleValue_op;
    }
    
    public void setF_ruleValue_op(String f_ruleValue_op) {
        this.f_ruleValue_op = f_ruleValue_op;
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
   
	public HiUserPageInfo getTblMbInfo() {
		return tblMbInfo;
	}

	public void setTblMbInfo(HiUserPageInfo tblMbInfo) {
		this.tblMbInfo = tblMbInfo;
	}
	public TblMchtInfoPageInfo getTblMchtInfo() {
		return tblMchtInfo;
	}

	public void setTblMchtInfo(TblMchtInfoPageInfo tblMchtInfo) {
		this.tblMchtInfo = tblMchtInfo;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
