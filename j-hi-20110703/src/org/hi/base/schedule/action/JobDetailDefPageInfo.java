package org.hi.base.schedule.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class JobDetailDefPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_jobName;
 	protected  String  f_jobName_op;
	protected  String  f_jobGroup;
 	protected  String  f_jobGroup_op;
	protected  String  f_jobClassName;
 	protected  String  f_jobClassName_op;
	protected  Integer  f_durable;
 	protected  String  f_durable_op;
	protected  Integer  f_volatiled;
 	protected  String  f_volatiled_op;
	protected  Integer  f_shouldRecover;
 	protected  String  f_shouldRecover_op;
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
   
    public String getF_jobName() {
        return this.f_jobName;
    }
    
    public void setF_jobName(String f_jobName) {
        this.f_jobName = f_jobName;
    }
    
    public String getF_jobName_op() {
        return this.f_jobName_op;
    }
    
    public void setF_jobName_op(String f_jobName_op) {
        this.f_jobName_op = f_jobName_op;
    }
   
    public String getF_jobGroup() {
        return this.f_jobGroup;
    }
    
    public void setF_jobGroup(String f_jobGroup) {
        this.f_jobGroup = f_jobGroup;
    }
    
    public String getF_jobGroup_op() {
        return this.f_jobGroup_op;
    }
    
    public void setF_jobGroup_op(String f_jobGroup_op) {
        this.f_jobGroup_op = f_jobGroup_op;
    }
   
    public String getF_jobClassName() {
        return this.f_jobClassName;
    }
    
    public void setF_jobClassName(String f_jobClassName) {
        this.f_jobClassName = f_jobClassName;
    }
    
    public String getF_jobClassName_op() {
        return this.f_jobClassName_op;
    }
    
    public void setF_jobClassName_op(String f_jobClassName_op) {
        this.f_jobClassName_op = f_jobClassName_op;
    }
   
    public Integer getF_durable() {
        return this.f_durable;
    }
    
    public void setF_durable(Integer f_durable) {
        this.f_durable = f_durable;
    }
    
    public String getF_durable_op() {
        return this.f_durable_op;
    }
    
    public void setF_durable_op(String f_durable_op) {
        this.f_durable_op = f_durable_op;
    }
   
    public Integer getF_volatiled() {
        return this.f_volatiled;
    }
    
    public void setF_volatiled(Integer f_volatiled) {
        this.f_volatiled = f_volatiled;
    }
    
    public String getF_volatiled_op() {
        return this.f_volatiled_op;
    }
    
    public void setF_volatiled_op(String f_volatiled_op) {
        this.f_volatiled_op = f_volatiled_op;
    }
   
    public Integer getF_shouldRecover() {
        return this.f_shouldRecover;
    }
    
    public void setF_shouldRecover(Integer f_shouldRecover) {
        this.f_shouldRecover = f_shouldRecover;
    }
    
    public String getF_shouldRecover_op() {
        return this.f_shouldRecover_op;
    }
    
    public void setF_shouldRecover_op(String f_shouldRecover_op) {
        this.f_shouldRecover_op = f_shouldRecover_op;
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
