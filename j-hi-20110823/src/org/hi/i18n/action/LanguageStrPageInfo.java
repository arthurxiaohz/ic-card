package org.hi.i18n.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.i18n.action.LanguagePageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class LanguageStrPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_languageCode;
 	protected  String  f_languageCode_op;
	protected  String  f_value;
 	protected  String  f_value_op;

 	protected  LanguagePageInfo language;
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
   
    public String getF_languageCode() {
        return this.f_languageCode;
    }
    
    public void setF_languageCode(String f_languageCode) {
        this.f_languageCode = f_languageCode;
    }
    
    public String getF_languageCode_op() {
        return this.f_languageCode_op;
    }
    
    public void setF_languageCode_op(String f_languageCode_op) {
        this.f_languageCode_op = f_languageCode_op;
    }
   
    public String getF_value() {
        return this.f_value;
    }
    
    public void setF_value(String f_value) {
        this.f_value = f_value;
    }
    
    public String getF_value_op() {
        return this.f_value_op;
    }
    
    public void setF_value_op(String f_value_op) {
        this.f_value_op = f_value_op;
    }
   
	public LanguagePageInfo getLanguage() {
		return language;
	}

	public void setLanguage(LanguagePageInfo language) {
		this.language = language;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
