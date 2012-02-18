package org.hi.i18n.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TimezonePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_timezone;
 	protected  String  f_timezone_op;
	protected  String  f_description;
 	protected  String  f_description_op;

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
   
    public Integer getF_timezone() {
        return this.f_timezone;
    }
    
    public void setF_timezone(Integer f_timezone) {
        this.f_timezone = f_timezone;
    }
    
    public String getF_timezone_op() {
        return this.f_timezone_op;
    }
    
    public void setF_timezone_op(String f_timezone_op) {
        this.f_timezone_op = f_timezone_op;
    }
   
    public String getF_description() {
        return this.f_description;
    }
    
    public void setF_description(String f_description) {
        this.f_description = f_description;
    }
    
    public String getF_description_op() {
        return this.f_description_op;
    }
    
    public void setF_description_op(String f_description_op) {
        this.f_description_op = f_description_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
