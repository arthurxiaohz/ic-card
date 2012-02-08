package org.hi.i18n.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class LanguagePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_keyStr;
 	protected  String  f_keyStr_op;
	protected  String  f_service;
 	protected  String  f_service_op;
	protected  String  f_entity;
 	protected  String  f_entity_op;
	protected  Integer  f_isSystem;
 	protected  String  f_isSystem_op;

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
   
    public String getF_keyStr() {
        return this.f_keyStr;
    }
    
    public void setF_keyStr(String f_keyStr) {
        this.f_keyStr = f_keyStr;
    }
    
    public String getF_keyStr_op() {
        return this.f_keyStr_op;
    }
    
    public void setF_keyStr_op(String f_keyStr_op) {
        this.f_keyStr_op = f_keyStr_op;
    }
   
    public String getF_service() {
        return this.f_service;
    }
    
    public void setF_service(String f_service) {
        this.f_service = f_service;
    }
    
    public String getF_service_op() {
        return this.f_service_op;
    }
    
    public void setF_service_op(String f_service_op) {
        this.f_service_op = f_service_op;
    }
   
    public String getF_entity() {
        return this.f_entity;
    }
    
    public void setF_entity(String f_entity) {
        this.f_entity = f_entity;
    }
    
    public String getF_entity_op() {
        return this.f_entity_op;
    }
    
    public void setF_entity_op(String f_entity_op) {
        this.f_entity_op = f_entity_op;
    }
   
    public Integer getF_isSystem() {
        return this.f_isSystem;
    }
    
    public void setF_isSystem(Integer f_isSystem) {
        this.f_isSystem = f_isSystem;
    }
    
    public String getF_isSystem_op() {
        return this.f_isSystem_op;
    }
    
    public void setF_isSystem_op(String f_isSystem_op) {
        this.f_isSystem_op = f_isSystem_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
