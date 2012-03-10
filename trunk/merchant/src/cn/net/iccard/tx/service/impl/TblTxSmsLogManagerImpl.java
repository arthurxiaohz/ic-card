package cn.net.iccard.tx.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.tx.model.TblTxSmsLog;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.tx.service.TblTxSmsLogManager;

public class TblTxSmsLogManagerImpl extends ManagerImpl implements TblTxSmsLogManager{
    
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
    
    public void saveTblTxSmsLog(TblTxSmsLog tblTxSmsLog){
    	saveObject(tblTxSmsLog);
    
    }

    public void removeTblTxSmsLogById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxSmsLog getTblTxSmsLogById(Integer id){
   		return (TblTxSmsLog) getObjectById(id);
    }

    public List<TblTxSmsLog> getTblTxSmsLogList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblTxSmsLog(TblTxSmsLog tblTxSmsLog){
    	saveObject(tblTxSmsLog);
    
    }

    public void removeSecurityTblTxSmsLogById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblTxSmsLog getSecurityTblTxSmsLogById(Integer id){
   		return (TblTxSmsLog) getObjectById(id);
    }

    public List<TblTxSmsLog> getSecurityTblTxSmsLogList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
