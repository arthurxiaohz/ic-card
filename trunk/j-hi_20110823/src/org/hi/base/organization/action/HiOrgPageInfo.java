package org.hi.base.organization.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class HiOrgPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_orgName;
 	protected  String  f_orgName_op;
	protected  String  f_orgNum;
 	protected  String  f_orgNum_op;
	protected  String  f_address;
 	protected  String  f_address_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  HiUserPageInfo manager;
 	protected  HiOrgPageInfo parentOrg;

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
   
    public String getF_orgName() {
        return this.f_orgName;
    }
    
    public void setF_orgName(String f_orgName) {
        this.f_orgName = f_orgName;
    }
    
    public String getF_orgName_op() {
        return this.f_orgName_op;
    }
    
    public void setF_orgName_op(String f_orgName_op) {
        this.f_orgName_op = f_orgName_op;
    }
   
    public String getF_orgNum() {
        return this.f_orgNum;
    }
    
    public void setF_orgNum(String f_orgNum) {
        this.f_orgNum = f_orgNum;
    }
    
    public String getF_orgNum_op() {
        return this.f_orgNum_op;
    }
    
    public void setF_orgNum_op(String f_orgNum_op) {
        this.f_orgNum_op = f_orgNum_op;
    }
   
    public String getF_address() {
        return this.f_address;
    }
    
    public void setF_address(String f_address) {
        this.f_address = f_address;
    }
    
    public String getF_address_op() {
        return this.f_address_op;
    }
    
    public void setF_address_op(String f_address_op) {
        this.f_address_op = f_address_op;
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
   
    public Integer getF_deleted() {
        return this.f_deleted;
    }
    
    public void setF_deleted(Integer f_deleted) {
        this.f_deleted = f_deleted;
    }
    
    public String getF_deleted_op() {
        return this.f_deleted_op;
    }
    
    public void setF_deleted_op(String f_deleted_op) {
        this.f_deleted_op = f_deleted_op;
    }
   
	public HiUserPageInfo getManager() {
		return manager;
	}

	public void setManager(HiUserPageInfo manager) {
		this.manager = manager;
	}
	public HiOrgPageInfo getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(HiOrgPageInfo parentOrg) {
		this.parentOrg = parentOrg;
	}

}
