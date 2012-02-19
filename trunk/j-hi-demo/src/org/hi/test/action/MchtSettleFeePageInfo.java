package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.test.action.MbMchtInfPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class MchtSettleFeePageInfo extends MbMchtInfPageInfo{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Double  f_byRate;
 	protected  String  f_byRate_op;
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
   
    public Double getF_byRate() {
        return this.f_byRate;
    }
    
    public void setF_byRate(Double f_byRate) {
        this.f_byRate = f_byRate;
    }
    
    public String getF_byRate_op() {
        return this.f_byRate_op;
    }
    
    public void setF_byRate_op(String f_byRate_op) {
        this.f_byRate_op = f_byRate_op;
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
