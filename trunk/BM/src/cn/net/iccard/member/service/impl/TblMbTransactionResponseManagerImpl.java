package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbTransactionResponse;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbTransactionResponseManager;

public class TblMbTransactionResponseManagerImpl extends ManagerImpl implements TblMbTransactionResponseManager{
    
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
    
    public void saveTblMbTransactionResponse(TblMbTransactionResponse tblMbTransactionResponse){
    	saveObject(tblMbTransactionResponse);
    
    }

    public void removeTblMbTransactionResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbTransactionResponse getTblMbTransactionResponseById(Integer id){
   		return (TblMbTransactionResponse) getObjectById(id);
    }

    public List<TblMbTransactionResponse> getTblMbTransactionResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbTransactionResponse(TblMbTransactionResponse tblMbTransactionResponse){
    	saveObject(tblMbTransactionResponse);
    
    }

    public void removeSecurityTblMbTransactionResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbTransactionResponse getSecurityTblMbTransactionResponseById(Integer id){
   		return (TblMbTransactionResponse) getObjectById(id);
    }

    public List<TblMbTransactionResponse> getSecurityTblMbTransactionResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
