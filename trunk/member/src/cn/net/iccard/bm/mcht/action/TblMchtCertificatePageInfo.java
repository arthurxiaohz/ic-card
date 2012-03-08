package cn.net.iccard.bm.mcht.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblMchtCertificatePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_certSn;
 	protected  String  f_certSn_op;
	protected  String  f_issuerCertDn;
 	protected  String  f_issuerCertDn_op;
	protected  String  f_certDn;
 	protected  String  f_certDn_op;
	protected  String  f_startTime;
 	protected  String  f_startTime_op;
	protected  String  f_endTime;
 	protected  String  f_endTime_op;
	protected  String  f_certContent;
 	protected  String  f_certContent_op;
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
   
    public String getF_certSn() {
        return this.f_certSn;
    }
    
    public void setF_certSn(String f_certSn) {
        this.f_certSn = f_certSn;
    }
    
    public String getF_certSn_op() {
        return this.f_certSn_op;
    }
    
    public void setF_certSn_op(String f_certSn_op) {
        this.f_certSn_op = f_certSn_op;
    }
   
    public String getF_issuerCertDn() {
        return this.f_issuerCertDn;
    }
    
    public void setF_issuerCertDn(String f_issuerCertDn) {
        this.f_issuerCertDn = f_issuerCertDn;
    }
    
    public String getF_issuerCertDn_op() {
        return this.f_issuerCertDn_op;
    }
    
    public void setF_issuerCertDn_op(String f_issuerCertDn_op) {
        this.f_issuerCertDn_op = f_issuerCertDn_op;
    }
   
    public String getF_certDn() {
        return this.f_certDn;
    }
    
    public void setF_certDn(String f_certDn) {
        this.f_certDn = f_certDn;
    }
    
    public String getF_certDn_op() {
        return this.f_certDn_op;
    }
    
    public void setF_certDn_op(String f_certDn_op) {
        this.f_certDn_op = f_certDn_op;
    }
   
    public String getF_startTime() {
        return this.f_startTime;
    }
    
    public void setF_startTime(String f_startTime) {
        this.f_startTime = f_startTime;
    }
    
    public String getF_startTime_op() {
        return this.f_startTime_op;
    }
    
    public void setF_startTime_op(String f_startTime_op) {
        this.f_startTime_op = f_startTime_op;
    }
   
    public String getF_endTime() {
        return this.f_endTime;
    }
    
    public void setF_endTime(String f_endTime) {
        this.f_endTime = f_endTime;
    }
    
    public String getF_endTime_op() {
        return this.f_endTime_op;
    }
    
    public void setF_endTime_op(String f_endTime_op) {
        this.f_endTime_op = f_endTime_op;
    }
   
    public String getF_certContent() {
        return this.f_certContent;
    }
    
    public void setF_certContent(String f_certContent) {
        this.f_certContent = f_certContent;
    }
    
    public String getF_certContent_op() {
        return this.f_certContent_op;
    }
    
    public void setF_certContent_op(String f_certContent_op) {
        this.f_certContent_op = f_certContent_op;
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
