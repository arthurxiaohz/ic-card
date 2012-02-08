package org.hi.base.report.excel.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class ExcelReportDesignPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_reportName;
 	protected  String  f_reportName_op;
	protected  String  f_reportNum;
 	protected  String  f_reportNum_op;
	protected  String  f_template;
 	protected  String  f_template_op;
	protected  Date  f_createDate;
 	protected  String  f_createDate_op;
	protected  Date  f_createDate01;
	protected  String  f_createDate01_op;
	protected  Integer  f_enabled;
 	protected  String  f_enabled_op;
	protected  String  f_actionName;
 	protected  String  f_actionName_op;
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
   
    public String getF_reportName() {
        return this.f_reportName;
    }
    
    public void setF_reportName(String f_reportName) {
        this.f_reportName = f_reportName;
    }
    
    public String getF_reportName_op() {
        return this.f_reportName_op;
    }
    
    public void setF_reportName_op(String f_reportName_op) {
        this.f_reportName_op = f_reportName_op;
    }
   
    public String getF_reportNum() {
        return this.f_reportNum;
    }
    
    public void setF_reportNum(String f_reportNum) {
        this.f_reportNum = f_reportNum;
    }
    
    public String getF_reportNum_op() {
        return this.f_reportNum_op;
    }
    
    public void setF_reportNum_op(String f_reportNum_op) {
        this.f_reportNum_op = f_reportNum_op;
    }
   
    public String getF_template() {
        return this.f_template;
    }
    
    public void setF_template(String f_template) {
        this.f_template = f_template;
    }
    
    public String getF_template_op() {
        return this.f_template_op;
    }
    
    public void setF_template_op(String f_template_op) {
        this.f_template_op = f_template_op;
    }
   
    public Date getF_createDate() {
        return this.f_createDate;
    }
    
    public void setF_createDate(Date f_createDate) {
        this.f_createDate = f_createDate;
    }
    
    public String getF_createDate_op() {
        return this.f_createDate_op;
    }
    
    public void setF_createDate_op(String f_createDate_op) {
        this.f_createDate_op = f_createDate_op;
    }
    public Date getF_createDate01() {
        return this.f_createDate01;
    }
    
    public void setF_createDate01(Date f_createDate01) {
        this.f_createDate01 = f_createDate01;
    }
    
    public String getF_createDate01_op() {
        return this.f_createDate01_op;
    }
    
    public void setF_createDate01_op(String f_createDate01_op) {
        this.f_createDate01_op = f_createDate01_op;
    }
   
    public Integer getF_enabled() {
        return this.f_enabled;
    }
    
    public void setF_enabled(Integer f_enabled) {
        this.f_enabled = f_enabled;
    }
    
    public String getF_enabled_op() {
        return this.f_enabled_op;
    }
    
    public void setF_enabled_op(String f_enabled_op) {
        this.f_enabled_op = f_enabled_op;
    }
   
    public String getF_actionName() {
        return this.f_actionName;
    }
    
    public void setF_actionName(String f_actionName) {
        this.f_actionName = f_actionName;
    }
    
    public String getF_actionName_op() {
        return this.f_actionName_op;
    }
    
    public void setF_actionName_op(String f_actionName_op) {
        this.f_actionName_op = f_actionName_op;
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
