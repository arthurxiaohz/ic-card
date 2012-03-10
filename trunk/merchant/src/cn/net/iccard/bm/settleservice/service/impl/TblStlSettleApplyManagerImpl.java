package cn.net.iccard.bm.settleservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager;

public class TblStlSettleApplyManagerImpl extends ManagerImpl implements TblStlSettleApplyManager{
    
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
    
    public void saveTblStlSettleApply(TblStlSettleApply tblStlSettleApply){
    	saveObject(tblStlSettleApply);
    
    }

    public void removeTblStlSettleApplyById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlSettleApply getTblStlSettleApplyById(Integer id){
   		return (TblStlSettleApply) getObjectById(id);
    }

    public List<TblStlSettleApply> getTblStlSettleApplyList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlSettleApply(TblStlSettleApply tblStlSettleApply){
    	saveObject(tblStlSettleApply);
    
    }

    public void removeSecurityTblStlSettleApplyById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlSettleApply getSecurityTblStlSettleApplyById(Integer id){
   		return (TblStlSettleApply) getObjectById(id);
    }

    public List<TblStlSettleApply> getSecurityTblStlSettleApplyList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
