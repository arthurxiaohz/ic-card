package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtPaymentConfig;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager;

public class TblMchtPaymentConfigManagerImpl extends ManagerImpl implements TblMchtPaymentConfigManager{
    
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
    
    public void saveTblMchtPaymentConfig(TblMchtPaymentConfig tblMchtPaymentConfig){
    	saveObject(tblMchtPaymentConfig);
    
    }

    public void removeTblMchtPaymentConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtPaymentConfig getTblMchtPaymentConfigById(Integer id){
   		return (TblMchtPaymentConfig) getObjectById(id);
    }

    public List<TblMchtPaymentConfig> getTblMchtPaymentConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMchtPaymentConfig(TblMchtPaymentConfig tblMchtPaymentConfig){
    	saveObject(tblMchtPaymentConfig);
    
    }

    public void removeSecurityTblMchtPaymentConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtPaymentConfig getSecurityTblMchtPaymentConfigById(Integer id){
   		return (TblMchtPaymentConfig) getObjectById(id);
    }

    public List<TblMchtPaymentConfig> getSecurityTblMchtPaymentConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
