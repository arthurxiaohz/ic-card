package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;

public class TblTxPayMentResponseManagerImpl extends ManagerImpl implements TblTxPayMentResponseManager{
    
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
    
    public void saveTblTxPayMentResponse(TblTxPayMentResponse tblTxPayMentResponse){
    	saveObject(tblTxPayMentResponse);
    
    }

    public void removeTblTxPayMentResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentResponse getTblTxPayMentResponseById(Integer id){
   		return (TblTxPayMentResponse) getObjectById(id);
    }

    public List<TblTxPayMentResponse> getTblTxPayMentResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxPayMentResponse(TblTxPayMentResponse tblTxPayMentResponse){
    	saveObject(tblTxPayMentResponse);
    
    }

    public void removeSecurityTblTxPayMentResponseById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxPayMentResponse getSecurityTblTxPayMentResponseById(Integer id){
   		return (TblTxPayMentResponse) getObjectById(id);
    }

    public List<TblTxPayMentResponse> getSecurityTblTxPayMentResponseList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
