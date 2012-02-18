package org.hi.base.sysapp.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.sysapp.model.HiLog;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.HiLogManager;

public class HiLogManagerImpl extends ManagerImpl implements HiLogManager{
    
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
    
    public void saveHiLog(HiLog hiLog){
    	saveObject(hiLog);
    
    }

    public void removeHiLogById(Integer id){
    	removeObjectById(id);
    	
    }

    public HiLog getHiLogById(Integer id){
   		return (HiLog) getObjectById(id);
    }

    public List<HiLog> getHiLogList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityHiLog(HiLog hiLog){
    	saveObject(hiLog);
    
    }

    public void removeSecurityHiLogById(Integer id){
    	removeObjectById(id);
    	
    }

    public HiLog getSecurityHiLogById(Integer id){
   		return (HiLog) getObjectById(id);
    }

    public List<HiLog> getSecurityHiLogList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
