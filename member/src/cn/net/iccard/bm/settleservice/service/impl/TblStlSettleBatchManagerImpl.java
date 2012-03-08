package cn.net.iccard.bm.settleservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager;

public class TblStlSettleBatchManagerImpl extends ManagerImpl implements TblStlSettleBatchManager{
    
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
    
    public void saveTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch){
    	saveObject(tblStlSettleBatch);
    
    }

    public void removeTblStlSettleBatchById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlSettleBatch getTblStlSettleBatchById(Integer id){
   		return (TblStlSettleBatch) getObjectById(id);
    }

    public List<TblStlSettleBatch> getTblStlSettleBatchList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch){
    	saveObject(tblStlSettleBatch);
    
    }

    public void removeSecurityTblStlSettleBatchById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlSettleBatch getSecurityTblStlSettleBatchById(Integer id){
   		return (TblStlSettleBatch) getObjectById(id);
    }

    public List<TblStlSettleBatch> getSecurityTblStlSettleBatchList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
