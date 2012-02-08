package org.hi.base.enumeration.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class EnumerationPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_enName;
 	protected  String  f_enName_op;
	protected  String  f_displayRef;
 	protected  String  f_displayRef_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Integer  f_enumerationType;
 	protected  String  f_enumerationType_op;

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
   
    public String getF_enName() {
        return this.f_enName;
    }
    
    public void setF_enName(String f_enName) {
        this.f_enName = f_enName;
    }
    
    public String getF_enName_op() {
        return this.f_enName_op;
    }
    
    public void setF_enName_op(String f_enName_op) {
        this.f_enName_op = f_enName_op;
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
   
    public Integer getF_enumerationType() {
        return this.f_enumerationType;
    }
    
    public void setF_enumerationType(Integer f_enumerationType) {
        this.f_enumerationType = f_enumerationType;
    }
    
    public String getF_enumerationType_op() {
        return this.f_enumerationType_op;
    }
    
    public void setF_enumerationType_op(String f_enumerationType_op) {
        this.f_enumerationType_op = f_enumerationType_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
