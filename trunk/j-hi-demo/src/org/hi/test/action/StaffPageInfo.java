package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.test.action.JobPositionPageInfo;
import org.hi.common.attachment.action.AttachmentPageInfo;
import org.hi.test.action.NationPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class StaffPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_useNum;
 	protected  String  f_useNum_op;
	protected  String  f_nativePlace;
 	protected  String  f_nativePlace_op;
	protected  Integer  f_degree;
 	protected  String  f_degree_op;
	protected  String  f_specialty;
 	protected  String  f_specialty_op;
	protected  Timestamp  f_jobDate;
 	protected  String  f_jobDate_op;
	protected  Timestamp  f_jobDate01;
	protected  String  f_jobDate01_op;
	protected  Integer  f_marry;
 	protected  String  f_marry_op;
	protected  String  f_interest;
 	protected  String  f_interest_op;
	protected  Integer  f_employedStatus;
 	protected  String  f_employedStatus_op;

 	protected  JobPositionPageInfo jobPosition;
 	protected  AttachmentPageInfo photo_attachment;
 	protected  NationPageInfo nation;
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
   
    public String getF_useNum() {
        return this.f_useNum;
    }
    
    public void setF_useNum(String f_useNum) {
        this.f_useNum = f_useNum;
    }
    
    public String getF_useNum_op() {
        return this.f_useNum_op;
    }
    
    public void setF_useNum_op(String f_useNum_op) {
        this.f_useNum_op = f_useNum_op;
    }
   
    public String getF_nativePlace() {
        return this.f_nativePlace;
    }
    
    public void setF_nativePlace(String f_nativePlace) {
        this.f_nativePlace = f_nativePlace;
    }
    
    public String getF_nativePlace_op() {
        return this.f_nativePlace_op;
    }
    
    public void setF_nativePlace_op(String f_nativePlace_op) {
        this.f_nativePlace_op = f_nativePlace_op;
    }
   
    public Integer getF_degree() {
        return this.f_degree;
    }
    
    public void setF_degree(Integer f_degree) {
        this.f_degree = f_degree;
    }
    
    public String getF_degree_op() {
        return this.f_degree_op;
    }
    
    public void setF_degree_op(String f_degree_op) {
        this.f_degree_op = f_degree_op;
    }
   
    public String getF_specialty() {
        return this.f_specialty;
    }
    
    public void setF_specialty(String f_specialty) {
        this.f_specialty = f_specialty;
    }
    
    public String getF_specialty_op() {
        return this.f_specialty_op;
    }
    
    public void setF_specialty_op(String f_specialty_op) {
        this.f_specialty_op = f_specialty_op;
    }
   
    public Timestamp getF_jobDate() {
        return this.f_jobDate;
    }
    
    public void setF_jobDate(Timestamp f_jobDate) {
        this.f_jobDate = f_jobDate;
    }
    
    public String getF_jobDate_op() {
        return this.f_jobDate_op;
    }
    
    public void setF_jobDate_op(String f_jobDate_op) {
        this.f_jobDate_op = f_jobDate_op;
    }
    public Timestamp getF_jobDate01() {
        return this.f_jobDate01;
    }
    
    public void setF_jobDate01(Timestamp f_jobDate01) {
        this.f_jobDate01 = f_jobDate01;
    }
    
    public String getF_jobDate01_op() {
        return this.f_jobDate01_op;
    }
    
    public void setF_jobDate01_op(String f_jobDate01_op) {
        this.f_jobDate01_op = f_jobDate01_op;
    }
   
    public Integer getF_marry() {
        return this.f_marry;
    }
    
    public void setF_marry(Integer f_marry) {
        this.f_marry = f_marry;
    }
    
    public String getF_marry_op() {
        return this.f_marry_op;
    }
    
    public void setF_marry_op(String f_marry_op) {
        this.f_marry_op = f_marry_op;
    }
   
    public String getF_interest() {
        return this.f_interest;
    }
    
    public void setF_interest(String f_interest) {
        this.f_interest = f_interest;
    }
    
    public String getF_interest_op() {
        return this.f_interest_op;
    }
    
    public void setF_interest_op(String f_interest_op) {
        this.f_interest_op = f_interest_op;
    }
   
    public Integer getF_employedStatus() {
        return this.f_employedStatus;
    }
    
    public void setF_employedStatus(Integer f_employedStatus) {
        this.f_employedStatus = f_employedStatus;
    }
    
    public String getF_employedStatus_op() {
        return this.f_employedStatus_op;
    }
    
    public void setF_employedStatus_op(String f_employedStatus_op) {
        this.f_employedStatus_op = f_employedStatus_op;
    }
   
	public JobPositionPageInfo getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPositionPageInfo jobPosition) {
		this.jobPosition = jobPosition;
	}
	public AttachmentPageInfo getPhoto_attachment() {
		return photo_attachment;
	}

	public void setPhoto_attachment(AttachmentPageInfo photo_attachment) {
		this.photo_attachment = photo_attachment;
	}
	public NationPageInfo getNation() {
		return nation;
	}

	public void setNation(NationPageInfo nation) {
		this.nation = nation;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
