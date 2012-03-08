package cn.net.iccard.bm.accounting.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.impl.ActAccountManagerImpl;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;

public class TblActAccountBalanceManagerImpl extends ActAccountManagerImpl implements TblActAccountBalanceManager{
    
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
    
    public void saveTblActAccountBalance(TblActAccountBalance tblActAccountBalance){
    	saveObject(tblActAccountBalance);
    
    }

    public void removeTblActAccountBalanceById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActAccountBalance getTblActAccountBalanceById(Integer id){
   		return (TblActAccountBalance) getObjectById(id);
    }

    public List<TblActAccountBalance> getTblActAccountBalanceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblActAccountBalance(TblActAccountBalance tblActAccountBalance){
    	saveObject(tblActAccountBalance);
    
    }

    public void removeSecurityTblActAccountBalanceById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActAccountBalance getSecurityTblActAccountBalanceById(Integer id){
   		return (TblActAccountBalance) getObjectById(id);
    }

    public List<TblActAccountBalance> getSecurityTblActAccountBalanceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
