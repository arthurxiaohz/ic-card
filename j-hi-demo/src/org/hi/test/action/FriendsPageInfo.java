package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.test.action.StaffPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class FriendsPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_name;
 	protected  String  f_name_op;
	protected  Integer  f_age;
 	protected  String  f_age_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  StaffPageInfo staff;
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
   
    public String getF_name() {
        return this.f_name;
    }
    
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    
    public String getF_name_op() {
        return this.f_name_op;
    }
    
    public void setF_name_op(String f_name_op) {
        this.f_name_op = f_name_op;
    }
   
    public Integer getF_age() {
        return this.f_age;
    }
    
    public void setF_age(Integer f_age) {
        this.f_age = f_age;
    }
    
    public String getF_age_op() {
        return this.f_age_op;
    }
    
    public void setF_age_op(String f_age_op) {
        this.f_age_op = f_age_op;
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
   
	public StaffPageInfo getStaff() {
		return staff;
	}

	public void setStaff(StaffPageInfo staff) {
		this.staff = staff;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
