package cn.net.iccard.bm.checkservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlAdjustDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager;

public class TblStlAdjustDetailManagerImpl extends ManagerImpl implements TblStlAdjustDetailManager{
    
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
    
    public void saveTblStlAdjustDetail(TblStlAdjustDetail tblStlAdjustDetail){
    	saveObject(tblStlAdjustDetail);
    
    }

    public void removeTblStlAdjustDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlAdjustDetail getTblStlAdjustDetailById(Integer id){
   		return (TblStlAdjustDetail) getObjectById(id);
    }

    public List<TblStlAdjustDetail> getTblStlAdjustDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlAdjustDetail(TblStlAdjustDetail tblStlAdjustDetail){
    	saveObject(tblStlAdjustDetail);
    
    }

    public void removeSecurityTblStlAdjustDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlAdjustDetail getSecurityTblStlAdjustDetailById(Integer id){
   		return (TblStlAdjustDetail) getObjectById(id);
    }

    public List<TblStlAdjustDetail> getSecurityTblStlAdjustDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
