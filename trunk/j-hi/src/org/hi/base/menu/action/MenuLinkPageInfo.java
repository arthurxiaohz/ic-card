package org.hi.base.menu.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.framework.security.action.AuthorityPageInfo;
import org.hi.base.menu.action.MenuPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class MenuLinkPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_linkUrl;
 	protected  String  f_linkUrl_op;
	protected  String  f_displayRef;
 	protected  String  f_displayRef_op;
	protected  String  f_description;
 	protected  String  f_description_op;
	protected  Double  f_sequence;
 	protected  String  f_sequence_op;
	protected  Integer  f_menuLinkType;
 	protected  String  f_menuLinkType_op;

 	protected  AuthorityPageInfo authority;
 	protected  MenuPageInfo menu;
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
   
    public String getF_linkUrl() {
        return this.f_linkUrl;
    }
    
    public void setF_linkUrl(String f_linkUrl) {
        this.f_linkUrl = f_linkUrl;
    }
    
    public String getF_linkUrl_op() {
        return this.f_linkUrl_op;
    }
    
    public void setF_linkUrl_op(String f_linkUrl_op) {
        this.f_linkUrl_op = f_linkUrl_op;
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
   
    public Integer getF_menuLinkType() {
        return this.f_menuLinkType;
    }
    
    public void setF_menuLinkType(Integer f_menuLinkType) {
        this.f_menuLinkType = f_menuLinkType;
    }
    
    public String getF_menuLinkType_op() {
        return this.f_menuLinkType_op;
    }
    
    public void setF_menuLinkType_op(String f_menuLinkType_op) {
        this.f_menuLinkType_op = f_menuLinkType_op;
    }
   
	public AuthorityPageInfo getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityPageInfo authority) {
		this.authority = authority;
	}
	public MenuPageInfo getMenu() {
		return menu;
	}

	public void setMenu(MenuPageInfo menu) {
		this.menu = menu;
	}
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
