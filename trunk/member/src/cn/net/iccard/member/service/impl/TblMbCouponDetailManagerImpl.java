package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbCouponDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbCouponDetailManager;

public class TblMbCouponDetailManagerImpl extends ManagerImpl implements TblMbCouponDetailManager{
    
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
    
    public void saveTblMbCouponDetail(TblMbCouponDetail tblMbCouponDetail){
    	saveObject(tblMbCouponDetail);
    
    }

    public void removeTblMbCouponDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCouponDetail getTblMbCouponDetailById(Integer id){
   		return (TblMbCouponDetail) getObjectById(id);
    }

    public List<TblMbCouponDetail> getTblMbCouponDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbCouponDetail(TblMbCouponDetail tblMbCouponDetail){
    	saveObject(tblMbCouponDetail);
    
    }

    public void removeSecurityTblMbCouponDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbCouponDetail getSecurityTblMbCouponDetailById(Integer id){
   		return (TblMbCouponDetail) getObjectById(id);
    }

    public List<TblMbCouponDetail> getSecurityTblMbCouponDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
