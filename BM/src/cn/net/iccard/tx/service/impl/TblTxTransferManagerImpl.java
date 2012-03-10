package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransfer;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxTransferManager;

public class TblTxTransferManagerImpl extends ManagerImpl implements TblTxTransferManager{
    
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
    
    public void saveTblTxTransfer(TblTxTransfer tblTxTransfer){
    	saveObject(tblTxTransfer);
    
    }

    public void removeTblTxTransferById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransfer getTblTxTransferById(Integer id){
   		return (TblTxTransfer) getObjectById(id);
    }

    public List<TblTxTransfer> getTblTxTransferList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxTransfer(TblTxTransfer tblTxTransfer){
    	saveObject(tblTxTransfer);
    
    }

    public void removeSecurityTblTxTransferById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransfer getSecurityTblTxTransferById(Integer id){
   		return (TblTxTransfer) getObjectById(id);
    }

    public List<TblTxTransfer> getSecurityTblTxTransferList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
