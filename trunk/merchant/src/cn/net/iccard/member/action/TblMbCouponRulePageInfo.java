package cn.net.iccard.member.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;

public class TblMbCouponRulePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_mchtType;
 	protected  String  f_mchtType_op;
	protected  Integer  f_merchandiseCategory;
 	protected  String  f_merchandiseCategory_op;
	protected  String  f_merchandiseNo;
 	protected  String  f_merchandiseNo_op;
	protected  Integer  f_couponType;
 	protected  String  f_couponType_op;
	protected  Integer  f_amount;
 	protected  String  f_amount_op;
	protected  Timestamp  f_startDatetime;
 	protected  String  f_startDatetime_op;
	protected  Timestamp  f_startDatetime01;
	protected  String  f_startDatetime01_op;
	protected  Timestamp  f_endDatetime;
 	protected  String  f_endDatetime_op;
	protected  Timestamp  f_endDatetime01;
	protected  String  f_endDatetime01_op;
	protected  Timestamp  f_createdDateTime;
 	protected  String  f_createdDateTime_op;
	protected  Timestamp  f_createdDateTime01;
	protected  String  f_createdDateTime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;

 	protected  HiUserPageInfo tblMbInfo;
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
   
    public Integer getF_merchandiseCategory() {
        return this.f_merchandiseCategory;
    }
    
    public void setF_merchandiseCategory(Integer f_merchandiseCategory) {
        this.f_merchandiseCategory = f_merchandiseCategory;
    }
    
    public String getF_merchandiseCategory_op() {
        return this.f_merchandiseCategory_op;
    }
    
    public void setF_merchandiseCategory_op(String f_merchandiseCategory_op) {
        this.f_merchandiseCategory_op = f_merchandiseCategory_op;
    }
   
    public String getF_merchandiseNo() {
        return this.f_merchandiseNo;
    }
    
    public void setF_merchandiseNo(String f_merchandiseNo) {
        this.f_merchandiseNo = f_merchandiseNo;
    }
    
    public String getF_merchandiseNo_op() {
        return this.f_merchandiseNo_op;
    }
    
    public void setF_merchandiseNo_op(String f_merchandiseNo_op) {
        this.f_merchandiseNo_op = f_merchandiseNo_op;
    }
   
    public Integer getF_couponType() {
        return this.f_couponType;
    }
    
    public void setF_couponType(Integer f_couponType) {
        this.f_couponType = f_couponType;
    }
    
    public String getF_couponType_op() {
        return this.f_couponType_op;
    }
    
    public void setF_couponType_op(String f_couponType_op) {
        this.f_couponType_op = f_couponType_op;
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
