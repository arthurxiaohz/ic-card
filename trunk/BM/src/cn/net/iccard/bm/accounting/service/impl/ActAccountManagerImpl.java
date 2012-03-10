package cn.net.iccard.bm.accounting.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.ActAccount;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.accounting.service.ActAccountManager;

public class ActAccountManagerImpl extends ManagerImpl implements ActAccountManager{
    
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
    
    public void saveActAccount(ActAccount actAccount){
    	saveObject(actAccount);
    
    }

    public void removeActAccountById(Integer id){
    	removeObjectById(id);
    	
    }

    public ActAccount getActAccountById(Integer id){
   		return (ActAccount) getObjectById(id);
    }

    public List<ActAccount> getActAccountList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityActAccount(ActAccount actAccount){
    	saveObject(actAccount);
    
    }

    public void removeSecurityActAccountById(Integer id){
    	removeObjectById(id);
    	
    }

    public ActAccount getSecurityActAccountById(Integer id){
   		return (ActAccount) getObjectById(id);
    }

    public List<ActAccount> getSecurityActAccountList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
