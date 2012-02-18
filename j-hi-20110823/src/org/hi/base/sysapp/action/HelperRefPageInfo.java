package org.hi.base.sysapp.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.sysapp.action.HelperPageInfo;

public class HelperRefPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;

 	protected  HelperPageInfo refHelper;
 	protected  HelperPageInfo helper;

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
   
	public HelperPageInfo getRefHelper() {
		return refHelper;
	}

	public void setRefHelper(HelperPageInfo refHelper) {
		this.refHelper = refHelper;
	}
	public HelperPageInfo getHelper() {
		return helper;
	}

	public void setHelper(HelperPageInfo helper) {
		this.helper = helper;
	}

}
