package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;

public class TblMbTransactionRequestManagerImpl extends ManagerImpl implements TblMbTransactionRequestManager{
    
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
    
    public void saveTblMbTransactionRequest(TblMbTransactionRequest tblMbTransactionRequest){
    	saveObject(tblMbTransactionRequest);
    
    }

    public void removeTblMbTransactionRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbTransactionRequest getTblMbTransactionRequestById(Integer id){
   		return (TblMbTransactionRequest) getObjectById(id);
    }

    public List<TblMbTransactionRequest> getTblMbTransactionRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbTransactionRequest(TblMbTransactionRequest tblMbTransactionRequest){
    	saveObject(tblMbTransactionRequest);
    
    }

    public void removeSecurityTblMbTransactionRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbTransactionRequest getSecurityTblMbTransactionRequestById(Integer id){
   		return (TblMbTransactionRequest) getObjectById(id);
    }

    public List<TblMbTransactionRequest> getSecurityTblMbTransactionRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
