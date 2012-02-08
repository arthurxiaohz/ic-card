package org.hi.framework.security.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.menu.action.MenuLinkPageInfo;

public class AuthorityPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_authorityName;
 	protected  String  f_authorityName_op;
	protected  String  f_displayRef;
 	protected  String  f_displayRef_op;
	protected  String  f_propertedResource;
 	protected  String  f_propertedResource_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Integer  f_authorityType;
 	protected  String  f_authorityType_op;

 	protected  MenuLinkPageInfo menuLink;

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
   
    public String getF_authorityName() {
        return this.f_authorityName;
    }
    
    public void setF_authorityName(String f_authorityName) {
        this.f_authorityName = f_authorityName;
    }
    
    public String getF_authorityName_op() {
        return this.f_authorityName_op;
    }
    
    public void setF_authorityName_op(String f_authorityName_op) {
        this.f_authorityName_op = f_authorityName_op;
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
   
    public String getF_propertedResource() {
        return this.f_propertedResource;
    }
    
    public void setF_propertedResource(String f_propertedResource) {
        this.f_propertedResource = f_propertedResource;
    }
    
    public String getF_propertedResource_op() {
        return this.f_propertedResource_op;
    }
    
    public void setF_propertedResource_op(String f_propertedResource_op) {
        this.f_propertedResource_op = f_propertedResource_op;
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
   
    public Integer getF_authorityType() {
        return this.f_authorityType;
    }
    
    public void setF_authorityType(Integer f_authorityType) {
        this.f_authorityType = f_authorityType;
    }
    
    public String getF_authorityType_op() {
        return this.f_authorityType_op;
    }
    
    public void setF_authorityType_op(String f_authorityType_op) {
        this.f_authorityType_op = f_authorityType_op;
    }
   
	public MenuLinkPageInfo getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(MenuLinkPageInfo menuLink) {
		this.menuLink = menuLink;
	}

}
