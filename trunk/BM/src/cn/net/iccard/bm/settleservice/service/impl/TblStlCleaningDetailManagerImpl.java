package cn.net.iccard.bm.settleservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;

public class TblStlCleaningDetailManagerImpl extends ManagerImpl implements TblStlCleaningDetailManager{
    
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
    
    public void saveTblStlCleaningDetail(TblStlCleaningDetail tblStlCleaningDetail){
    	saveObject(tblStlCleaningDetail);
    
    }

    public void removeTblStlCleaningDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCleaningDetail getTblStlCleaningDetailById(Integer id){
   		return (TblStlCleaningDetail) getObjectById(id);
    }

    public List<TblStlCleaningDetail> getTblStlCleaningDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlCleaningDetail(TblStlCleaningDetail tblStlCleaningDetail){
    	saveObject(tblStlCleaningDetail);
    
    }

    public void removeSecurityTblStlCleaningDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCleaningDetail getSecurityTblStlCleaningDetailById(Integer id){
   		return (TblStlCleaningDetail) getObjectById(id);
    }

    public List<TblStlCleaningDetail> getSecurityTblStlCleaningDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
