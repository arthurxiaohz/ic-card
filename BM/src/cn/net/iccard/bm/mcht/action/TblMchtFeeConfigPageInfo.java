package cn.net.iccard.bm.mcht.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblMchtFeeConfigPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_mchtFeeType;
 	protected  String  f_mchtFeeType_op;
	protected  Double  f_ruleValue;
 	protected  String  f_ruleValue_op;
	protected  Integer  f_minVal;
 	protected  String  f_minVal_op;
	protected  Integer  f_maxVal;
 	protected  String  f_maxVal_op;
	protected  Integer  f_isFeeReturn;
 	protected  String  f_isFeeReturn_op;
	protected  Timestamp  f_createdDateTime;
 	protected  String  f_createdDateTime_op;
	protected  Timestamp  f_createdDateTime01;
	protected  String  f_createdDateTime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;

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
   
    public Integer getF_mchtFeeType() {
        return this.f_mchtFeeType;
    }
    
    public void setF_mchtFeeType(Integer f_mchtFeeType) {
        this.f_mchtFeeType = f_mchtFeeType;
    }
    
    public String getF_mchtFeeType_op() {
        return this.f_mchtFeeType_op;
    }
    
    public void setF_mchtFeeType_op(String f_mchtFeeType_op) {
        this.f_mchtFeeType_op = f_mchtFeeType_op;
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
   
    public Integer getF_minVal() {
        return this.f_minVal;
    }
    
    public void setF_minVal(Integer f_minVal) {
        this.f_minVal = f_minVal;
    }
    
    public String getF_minVal_op() {
        return this.f_minVal_op;
    }
    
    public void setF_minVal_op(String f_minVal_op) {
        this.f_minVal_op = f_minVal_op;
    }
   
    public Integer getF_maxVal() {
        return this.f_maxVal;
    }
    
    public void setF_maxVal(Integer f_maxVal) {
        this.f_maxVal = f_maxVal;
    }
    
    public String getF_maxVal_op() {
        return this.f_maxVal_op;
    }
    
    public void setF_maxVal_op(String f_maxVal_op) {
        this.f_maxVal_op = f_maxVal_op;
    }
   
    public Integer getF_isFeeReturn() {
        return this.f_isFeeReturn;
    }
    
    public void setF_isFeeReturn(Integer f_isFeeReturn) {
        this.f_isFeeReturn = f_isFeeReturn;
    }
    
    public String getF_isFeeReturn_op() {
        return this.f_isFeeReturn_op;
    }
    
    public void setF_isFeeReturn_op(String f_isFeeReturn_op) {
        this.f_isFeeReturn_op = f_isFeeReturn_op;
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
