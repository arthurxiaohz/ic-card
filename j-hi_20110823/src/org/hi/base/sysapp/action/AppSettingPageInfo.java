package org.hi.base.sysapp.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class AppSettingPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_appGroup;
 	protected  String  f_appGroup_op;
	protected  String  f_appName;
 	protected  String  f_appName_op;
	protected  String  f_appValue;
 	protected  String  f_appValue_op;
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
   
    public String getF_appGroup() {
        return this.f_appGroup;
    }
    
    public void setF_appGroup(String f_appGroup) {
        this.f_appGroup = f_appGroup;
    }
    
    public String getF_appGroup_op() {
        return this.f_appGroup_op;
    }
    
    public void setF_appGroup_op(String f_appGroup_op) {
        this.f_appGroup_op = f_appGroup_op;
    }
   
    public String getF_appName() {
        return this.f_appName;
    }
    
    public void setF_appName(String f_appName) {
        this.f_appName = f_appName;
    }
    
    public String getF_appName_op() {
        return this.f_appName_op;
    }
    
    public void setF_appName_op(String f_appName_op) {
        this.f_appName_op = f_appName_op;
    }
   
    public String getF_appValue() {
        return this.f_appValue;
    }
    
    public void setF_appValue(String f_appValue) {
        this.f_appValue = f_appValue;
    }
    
    public String getF_appValue_op() {
        return this.f_appValue_op;
    }
    
    public void setF_appValue_op(String f_appValue_op) {
        this.f_appValue_op = f_appValue_op;
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
