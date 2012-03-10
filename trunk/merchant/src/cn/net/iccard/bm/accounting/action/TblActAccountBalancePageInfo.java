package cn.net.iccard.bm.accounting.action;

import java.sql.Timestamp;
import java.util.Date;

import cn.net.iccard.bm.accounting.action.ActAccountPageInfo;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblActAccountBalancePageInfo extends ActAccountPageInfo{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  Integer  f_availableBalance;
 	protected  String  f_availableBalance_op;
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
   
    public Integer getF_availableBalance() {
        return this.f_availableBalance;
    }
    
    public void setF_availableBalance(Integer f_availableBalance) {
        this.f_availableBalance = f_availableBalance;
    }
    
    public String getF_availableBalance_op() {
        return this.f_availableBalance_op;
    }
    
    public void setF_availableBalance_op(String f_availableBalance_op) {
        this.f_availableBalance_op = f_availableBalance_op;
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
