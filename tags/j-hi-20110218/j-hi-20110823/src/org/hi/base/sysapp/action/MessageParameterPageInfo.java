package org.hi.base.sysapp.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.sysapp.action.MessagePageInfo;

public class MessageParameterPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_parameterKey;
 	protected  String  f_parameterKey_op;
	protected  String  f_parameterValue;
 	protected  String  f_parameterValue_op;

 	protected  MessagePageInfo message;

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
   
    public String getF_parameterKey() {
        return this.f_parameterKey;
    }
    
    public void setF_parameterKey(String f_parameterKey) {
        this.f_parameterKey = f_parameterKey;
    }
    
    public String getF_parameterKey_op() {
        return this.f_parameterKey_op;
    }
    
    public void setF_parameterKey_op(String f_parameterKey_op) {
        this.f_parameterKey_op = f_parameterKey_op;
    }
   
    public String getF_parameterValue() {
        return this.f_parameterValue;
    }
    
    public void setF_parameterValue(String f_parameterValue) {
        this.f_parameterValue = f_parameterValue;
    }
    
    public String getF_parameterValue_op() {
        return this.f_parameterValue_op;
    }
    
    public void setF_parameterValue_op(String f_parameterValue_op) {
        this.f_parameterValue_op = f_parameterValue_op;
    }
   
	public MessagePageInfo getMessage() {
		return message;
	}

	public void setMessage(MessagePageInfo message) {
		this.message = message;
	}

}
