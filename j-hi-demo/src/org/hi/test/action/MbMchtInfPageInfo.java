package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class MbMchtInfPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_mchtCd;
 	protected  String  f_mchtCd_op;
	protected  String  f_mchtName;
 	protected  String  f_mchtName_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

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
   
    public String getF_mchtCd() {
        return this.f_mchtCd;
    }
    
    public void setF_mchtCd(String f_mchtCd) {
        this.f_mchtCd = f_mchtCd;
    }
    
    public String getF_mchtCd_op() {
        return this.f_mchtCd_op;
    }
    
    public void setF_mchtCd_op(String f_mchtCd_op) {
        this.f_mchtCd_op = f_mchtCd_op;
    }
   
    public String getF_mchtName() {
        return this.f_mchtName;
    }
    
    public void setF_mchtName(String f_mchtName) {
        this.f_mchtName = f_mchtName;
    }
    
    public String getF_mchtName_op() {
        return this.f_mchtName_op;
    }
    
    public void setF_mchtName_op(String f_mchtName_op) {
        this.f_mchtName_op = f_mchtName_op;
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
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
