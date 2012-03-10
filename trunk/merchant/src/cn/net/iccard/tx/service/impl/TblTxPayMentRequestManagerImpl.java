package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;

public class TblTxPayMentRequestManagerImpl extends ManagerImpl implements TblTxPayMentRequestManager{
    
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
    
    public void saveTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest){
    	saveObject(tblTxPayMentRequest);
    
    }

    public void removeTblTxPayMentRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentRequest getTblTxPayMentRequestById(Integer id){
   		return (TblTxPayMentRequest) getObjectById(id);
    }

    public List<TblTxPayMentRequest> getTblTxPayMentRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest){
    	saveObject(tblTxPayMentRequest);
    
    }

    public void removeSecurityTblTxPayMentRequestById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentRequest getSecurityTblTxPayMentRequestById(Integer id){
   		return (TblTxPayMentRequest) getObjectById(id);
    }

    public List<TblTxPayMentRequest> getSecurityTblTxPayMentRequestList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
