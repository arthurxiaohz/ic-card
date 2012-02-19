package org.hi.test.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class NationPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_chineseName;
 	protected  String  f_chineseName_op;
	protected  String  f_englishName;
 	protected  String  f_englishName_op;

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
   
    public String getF_chineseName() {
        return this.f_chineseName;
    }
    
    public void setF_chineseName(String f_chineseName) {
        this.f_chineseName = f_chineseName;
    }
    
    public String getF_chineseName_op() {
        return this.f_chineseName_op;
    }
    
    public void setF_chineseName_op(String f_chineseName_op) {
        this.f_chineseName_op = f_chineseName_op;
    }
   
    public String getF_englishName() {
        return this.f_englishName;
    }
    
    public void setF_englishName(String f_englishName) {
        this.f_englishName = f_englishName;
    }
    
    public String getF_englishName_op() {
        return this.f_englishName_op;
    }
    
    public void setF_englishName_op(String f_englishName_op) {
        this.f_englishName_op = f_englishName_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
