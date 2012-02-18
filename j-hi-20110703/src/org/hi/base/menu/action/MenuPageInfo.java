package org.hi.base.menu.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class MenuPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_menuName;
 	protected  String  f_menuName_op;
	protected  String  f_displayRef;
 	protected  String  f_displayRef_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Double  f_sequence;
 	protected  String  f_sequence_op;
	protected  Integer  f_menuType;
 	protected  String  f_menuType_op;

 	protected  MenuPageInfo parentMenu;
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
   
    public String getF_menuName() {
        return this.f_menuName;
    }
    
    public void setF_menuName(String f_menuName) {
        this.f_menuName = f_menuName;
    }
    
    public String getF_menuName_op() {
        return this.f_menuName_op;
    }
    
    public void setF_menuName_op(String f_menuName_op) {
        this.f_menuName_op = f_menuName_op;
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
   
    public Double getF_sequence() {
        return this.f_sequence;
    }
    
    public void setF_sequence(Double f_sequence) {
        this.f_sequence = f_sequence;
    }
    
    public String getF_sequence_op() {
        return this.f_sequence_op;
    }
    
    public void setF_sequence_op(String f_sequence_op) {
        this.f_sequence_op = f_sequence_op;
    }
   
    public Integer getF_menuType() {
        return this.f_menuType;
    }
    
    public void setF_menuType(Integer f_menuType) {
        this.f_menuType = f_menuType;
    }
    
    public String getF_menuType_op() {
        return this.f_menuType_op;
    }
    
    public void setF_menuType_op(String f_menuType_op) {
        this.f_menuType_op = f_menuType_op;
    }
   
	public MenuPageInfo getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuPageInfo parentMenu) {
		this.parentMenu = parentMenu;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
