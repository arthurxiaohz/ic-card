package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtSettleCycleConfig;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager;

public class TblMchtSettleCycleConfigManagerImpl extends ManagerImpl implements TblMchtSettleCycleConfigManager{
    
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
    
    public void saveTblMchtSettleCycleConfig(TblMchtSettleCycleConfig tblMchtSettleCycleConfig){
    	saveObject(tblMchtSettleCycleConfig);
    
    }

    public void removeTblMchtSettleCycleConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtSettleCycleConfig getTblMchtSettleCycleConfigById(Integer id){
   		return (TblMchtSettleCycleConfig) getObjectById(id);
    }

    public List<TblMchtSettleCycleConfig> getTblMchtSettleCycleConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMchtSettleCycleConfig(TblMchtSettleCycleConfig tblMchtSettleCycleConfig){
    	saveObject(tblMchtSettleCycleConfig);
    
    }

    public void removeSecurityTblMchtSettleCycleConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtSettleCycleConfig getSecurityTblMchtSettleCycleConfigById(Integer id){
   		return (TblMchtSettleCycleConfig) getObjectById(id);
    }

    public List<TblMchtSettleCycleConfig> getSecurityTblMchtSettleCycleConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
