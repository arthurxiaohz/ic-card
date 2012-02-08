package org.hi.base.sysapp.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class MessagePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_receivers;
 	protected  String  f_receivers_op;
	protected  String  f_receiverNames;
 	protected  String  f_receiverNames_op;
	protected  String  f_sender;
 	protected  String  f_sender_op;
	protected  Integer  f_messageType;
 	protected  String  f_messageType_op;
	protected  String  f_messageText;
 	protected  String  f_messageText_op;
	protected  Timestamp  f_createDate;
 	protected  String  f_createDate_op;
	protected  Timestamp  f_createDate01;
	protected  String  f_createDate01_op;
	protected  Timestamp  f_sendDate;
 	protected  String  f_sendDate_op;
	protected  Timestamp  f_sendDate01;
	protected  String  f_sendDate01_op;
	protected  Integer  f_isSent;
 	protected  String  f_isSent_op;
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
   
    public String getF_receivers() {
        return this.f_receivers;
    }
    
    public void setF_receivers(String f_receivers) {
        this.f_receivers = f_receivers;
    }
    
    public String getF_receivers_op() {
        return this.f_receivers_op;
    }
    
    public void setF_receivers_op(String f_receivers_op) {
        this.f_receivers_op = f_receivers_op;
    }
   
    public String getF_receiverNames() {
        return this.f_receiverNames;
    }
    
    public void setF_receiverNames(String f_receiverNames) {
        this.f_receiverNames = f_receiverNames;
    }
    
    public String getF_receiverNames_op() {
        return this.f_receiverNames_op;
    }
    
    public void setF_receiverNames_op(String f_receiverNames_op) {
        this.f_receiverNames_op = f_receiverNames_op;
    }
   
    public String getF_sender() {
        return this.f_sender;
    }
    
    public void setF_sender(String f_sender) {
        this.f_sender = f_sender;
    }
    
    public String getF_sender_op() {
        return this.f_sender_op;
    }
    
    public void setF_sender_op(String f_sender_op) {
        this.f_sender_op = f_sender_op;
    }
   
    public Integer getF_messageType() {
        return this.f_messageType;
    }
    
    public void setF_messageType(Integer f_messageType) {
        this.f_messageType = f_messageType;
    }
    
    public String getF_messageType_op() {
        return this.f_messageType_op;
    }
    
    public void setF_messageType_op(String f_messageType_op) {
        this.f_messageType_op = f_messageType_op;
    }
   
    public String getF_messageText() {
        return this.f_messageText;
    }
    
    public void setF_messageText(String f_messageText) {
        this.f_messageText = f_messageText;
    }
    
    public String getF_messageText_op() {
        return this.f_messageText_op;
    }
    
    public void setF_messageText_op(String f_messageText_op) {
        this.f_messageText_op = f_messageText_op;
    }
   
    public Timestamp getF_createDate() {
        return this.f_createDate;
    }
    
    public void setF_createDate(Timestamp f_createDate) {
        this.f_createDate = f_createDate;
    }
    
    public String getF_createDate_op() {
        return this.f_createDate_op;
    }
    
    public void setF_createDate_op(String f_createDate_op) {
        this.f_createDate_op = f_createDate_op;
    }
    public Timestamp getF_createDate01() {
        return this.f_createDate01;
    }
    
    public void setF_createDate01(Timestamp f_createDate01) {
        this.f_createDate01 = f_createDate01;
    }
    
    public String getF_createDate01_op() {
        return this.f_createDate01_op;
    }
    
    public void setF_createDate01_op(String f_createDate01_op) {
        this.f_createDate01_op = f_createDate01_op;
    }
   
    public Timestamp getF_sendDate() {
        return this.f_sendDate;
    }
    
    public void setF_sendDate(Timestamp f_sendDate) {
        this.f_sendDate = f_sendDate;
    }
    
    public String getF_sendDate_op() {
        return this.f_sendDate_op;
    }
    
    public void setF_sendDate_op(String f_sendDate_op) {
        this.f_sendDate_op = f_sendDate_op;
    }
    public Timestamp getF_sendDate01() {
        return this.f_sendDate01;
    }
    
    public void setF_sendDate01(Timestamp f_sendDate01) {
        this.f_sendDate01 = f_sendDate01;
    }
    
    public String getF_sendDate01_op() {
        return this.f_sendDate01_op;
    }
    
    public void setF_sendDate01_op(String f_sendDate01_op) {
        this.f_sendDate01_op = f_sendDate01_op;
    }
   
    public Integer getF_isSent() {
        return this.f_isSent;
    }
    
    public void setF_isSent(Integer f_isSent) {
        this.f_isSent = f_isSent;
    }
    
    public String getF_isSent_op() {
        return this.f_isSent_op;
    }
    
    public void setF_isSent_op(String f_isSent_op) {
        this.f_isSent_op = f_isSent_op;
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
