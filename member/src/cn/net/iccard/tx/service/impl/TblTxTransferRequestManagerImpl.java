package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransferRequest;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxTransferRequestManager;

public class TblTxTransferRequestManagerImpl extends ManagerImpl implements TblTxTransferRequestManager{
    
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
    
    public void saveTblTxTransferRequest(TblTxTransferRequest tblTxTransferRequest){
    	saveObject(tblTxTransferRequest);
    
    }

    public void removeTblTxTransferRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransferRequest getTblTxTransferRequestById(Integer id){
   		return (TblTxTransferRequest) getObjectById(id);
    }

    public List<TblTxTransferRequest> getTblTxTransferRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxTransferRequest(TblTxTransferRequest tblTxTransferRequest){
    	saveObject(tblTxTransferRequest);
    
    }

    public void removeSecurityTblTxTransferRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransferRequest getSecurityTblTxTransferRequestById(Integer id){
   		return (TblTxTransferRequest) getObjectById(id);
    }

    public List<TblTxTransferRequest> getSecurityTblTxTransferRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
