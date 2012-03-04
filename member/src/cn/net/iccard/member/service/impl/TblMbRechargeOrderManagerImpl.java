package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;

public class TblMbRechargeOrderManagerImpl extends ManagerImpl implements TblMbRechargeOrderManager{
    
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
    
    public void saveTblMbRechargeOrder(TblMbRechargeOrder tblMbRechargeOrder){
    	saveObject(tblMbRechargeOrder);
    
    }

    public void removeTblMbRechargeOrderById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbRechargeOrder getTblMbRechargeOrderById(Integer id){
   		return (TblMbRechargeOrder) getObjectById(id);
    }

    public List<TblMbRechargeOrder> getTblMbRechargeOrderList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbRechargeOrder(TblMbRechargeOrder tblMbRechargeOrder){
    	saveObject(tblMbRechargeOrder);
    
    }

    public void removeSecurityTblMbRechargeOrderById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbRechargeOrder getSecurityTblMbRechargeOrderById(Integer id){
   		return (TblMbRechargeOrder) getObjectById(id);
    }

    public List<TblMbRechargeOrder> getSecurityTblMbRechargeOrderList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
