package org.hi.base.sysapp.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class HiLogPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Timestamp  f_operateDate;
 	protected  String  f_operateDate_op;
	protected  Timestamp  f_operateDate01;
	protected  String  f_operateDate01_op;
	protected  String  f_action;
 	protected  String  f_action_op;
	protected  String  f_actionContext;
 	protected  String  f_actionContext_op;

 	protected  HiUserPageInfo operator;

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
   
    public Timestamp getF_operateDate() {
        return this.f_operateDate;
    }
    
    public void setF_operateDate(Timestamp f_operateDate) {
        this.f_operateDate = f_operateDate;
    }
    
    public String getF_operateDate_op() {
        return this.f_operateDate_op;
    }
    
    public void setF_operateDate_op(String f_operateDate_op) {
        this.f_operateDate_op = f_operateDate_op;
    }
    public Timestamp getF_operateDate01() {
        return this.f_operateDate01;
    }
    
    public void setF_operateDate01(Timestamp f_operateDate01) {
        this.f_operateDate01 = f_operateDate01;
    }
    
    public String getF_operateDate01_op() {
        return this.f_operateDate01_op;
    }
    
    public void setF_operateDate01_op(String f_operateDate01_op) {
        this.f_operateDate01_op = f_operateDate01_op;
    }
   
    public String getF_action() {
        return this.f_action;
    }
    
    public void setF_action(String f_action) {
        this.f_action = f_action;
    }
    
    public String getF_action_op() {
        return this.f_action_op;
    }
    
    public void setF_action_op(String f_action_op) {
        this.f_action_op = f_action_op;
    }
   
    public String getF_actionContext() {
        return this.f_actionContext;
    }
    
    public void setF_actionContext(String f_actionContext) {
        this.f_actionContext = f_actionContext;
    }
    
    public String getF_actionContext_op() {
        return this.f_actionContext_op;
    }
    
    public void setF_actionContext_op(String f_actionContext_op) {
        this.f_actionContext_op = f_actionContext_op;
    }
   
	public HiUserPageInfo getOperator() {
		return operator;
	}

	public void setOperator(HiUserPageInfo operator) {
		this.operator = operator;
	}

}
