package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager;

public class TblMchtFeeConfigManagerImpl extends ManagerImpl implements TblMchtFeeConfigManager{
    
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
    
    public void saveTblMchtFeeConfig(TblMchtFeeConfig tblMchtFeeConfig){
    	saveObject(tblMchtFeeConfig);
    
    }

    public void removeTblMchtFeeConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtFeeConfig getTblMchtFeeConfigById(Integer id){
   		return (TblMchtFeeConfig) getObjectById(id);
    }

    public List<TblMchtFeeConfig> getTblMchtFeeConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMchtFeeConfig(TblMchtFeeConfig tblMchtFeeConfig){
    	saveObject(tblMchtFeeConfig);
    
    }

    public void removeSecurityTblMchtFeeConfigById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMchtFeeConfig getSecurityTblMchtFeeConfigById(Integer id){
   		return (TblMchtFeeConfig) getObjectById(id);
    }

    public List<TblMchtFeeConfig> getSecurityTblMchtFeeConfigList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
