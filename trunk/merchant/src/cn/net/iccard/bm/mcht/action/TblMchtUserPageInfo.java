package cn.net.iccard.bm.mcht.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.base.organization.action.HiUserPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblMchtUserPageInfo extends HiUserPageInfo{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_mchtNo;
 	protected  String  f_mchtNo_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

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
   
    public String getF_mchtNo() {
        return this.f_mchtNo;
    }
    
    public void setF_mchtNo(String f_mchtNo) {
        this.f_mchtNo = f_mchtNo;
    }
    
    public String getF_mchtNo_op() {
        return this.f_mchtNo_op;
    }
    
    public void setF_mchtNo_op(String f_mchtNo_op) {
        this.f_mchtNo_op = f_mchtNo_op;
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
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
