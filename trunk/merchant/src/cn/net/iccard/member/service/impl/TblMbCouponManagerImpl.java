package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCoupon;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbCouponManager;

public class TblMbCouponManagerImpl extends ManagerImpl implements TblMbCouponManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveTblMbCoupon(TblMbCoupon tblMbCoupon){
    	saveObject(tblMbCoupon);
    
    }

    public void removeTblMbCouponById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCoupon getTblMbCouponById(Integer id){
   		return (TblMbCoupon) getObjectById(id);
    }

    public List<TblMbCoupon> getTblMbCouponList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbCoupon(TblMbCoupon tblMbCoupon){
    	saveObject(tblMbCoupon);
    
    }

    public void removeSecurityTblMbCouponById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCoupon getSecurityTblMbCouponById(Integer id){
   		return (TblMbCoupon) getObjectById(id);
    }

    public List<TblMbCoupon> getSecurityTblMbCouponList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
