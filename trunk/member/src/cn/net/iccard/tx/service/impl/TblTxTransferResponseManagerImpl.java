package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxTransferResponse;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxTransferResponseManager;

public class TblTxTransferResponseManagerImpl extends ManagerImpl implements TblTxTransferResponseManager{
    
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
    
    public void saveTblTxTransferResponse(TblTxTransferResponse tblTxTransferResponse){
    	saveObject(tblTxTransferResponse);
    
    }

    public void removeTblTxTransferResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransferResponse getTblTxTransferResponseById(Integer id){
   		return (TblTxTransferResponse) getObjectById(id);
    }

    public List<TblTxTransferResponse> getTblTxTransferResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxTransferResponse(TblTxTransferResponse tblTxTransferResponse){
    	saveObject(tblTxTransferResponse);
    
    }

    public void removeSecurityTblTxTransferResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxTransferResponse getSecurityTblTxTransferResponseById(Integer id){
   		return (TblTxTransferResponse) getObjectById(id);
    }

    public List<TblTxTransferResponse> getSecurityTblTxTransferResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
