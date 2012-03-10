package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class TblTxPayMentOrderManagerImpl extends ManagerImpl implements TblTxPayMentOrderManager{
    
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
    
    public void saveTblTxPayMentOrder(TblTxPayMentOrder tblTxPayMentOrder){
    	saveObject(tblTxPayMentOrder);
    
    }

    public void removeTblTxPayMentOrderById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentOrder getTblTxPayMentOrderById(Integer id){
   		return (TblTxPayMentOrder) getObjectById(id);
    }

    public List<TblTxPayMentOrder> getTblTxPayMentOrderList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxPayMentOrder(TblTxPayMentOrder tblTxPayMentOrder){
    	saveObject(tblTxPayMentOrder);
    
    }

    public void removeSecurityTblTxPayMentOrderById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentOrder getSecurityTblTxPayMentOrderById(Integer id){
   		return (TblTxPayMentOrder) getObjectById(id);
    }

    public List<TblTxPayMentOrder> getSecurityTblTxPayMentOrderList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
