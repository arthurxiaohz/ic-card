package org.hi.base.enumeration.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.enumeration.action.EnumerationPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class EnumerationValuePageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_valueName;
 	protected  String  f_valueName_op;
	protected  String  f_displayRef;
 	protected  String  f_displayRef_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  String  f_valueCode;
 	protected  String  f_valueCode_op;

 	protected  EnumerationPageInfo enumeration;//枚举值类型
 	protected  HiUserPageInfo creator;//创建者

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
   
    public String getF_valueName() {
        return this.f_valueName;
    }
    
    public void setF_valueName(String f_valueName) {
        this.f_valueName = f_valueName;
    }
    
    public String getF_valueName_op() {
        return this.f_valueName_op;
    }
    
    public void setF_valueName_op(String f_valueName_op) {
        this.f_valueName_op = f_valueName_op;
    }
   
    public String getF_displayRef() {
        return this.f_displayRef;
    }
    
    public void setF_displayRef(String f_displayRef) {
        this.f_displayRef = f_displayRef;
    }
    
    public String getF_displayRef_op() {
        return this.f_displayRef_op;
    }
    
    public void setF_displayRef_op(String f_displayRef_op) {
        this.f_displayRef_op = f_displayRef_op;
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
   
    public String getF_valueCode() {
        return this.f_valueCode;
    }
    
    public void setF_valueCode(String f_valueCode) {
        this.f_valueCode = f_valueCode;
    }
    
    public String getF_valueCode_op() {
        return this.f_valueCode_op;
    }
    
    public void setF_valueCode_op(String f_valueCode_op) {
        this.f_valueCode_op = f_valueCode_op;
    }
   
	public EnumerationPageInfo getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(EnumerationPageInfo enumeration) {
		this.enumeration = enumeration;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
