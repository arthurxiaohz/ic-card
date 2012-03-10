package cn.net.iccard.bm.checkservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager;

public class TblStlCheckDetailManagerImpl extends ManagerImpl implements TblStlCheckDetailManager{
    
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
    
    public void saveTblStlCheckDetail(TblStlCheckDetail tblStlCheckDetail){
    	saveObject(tblStlCheckDetail);
    
    }

    public void removeTblStlCheckDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCheckDetail getTblStlCheckDetailById(Integer id){
   		return (TblStlCheckDetail) getObjectById(id);
    }

    public List<TblStlCheckDetail> getTblStlCheckDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlCheckDetail(TblStlCheckDetail tblStlCheckDetail){
    	saveObject(tblStlCheckDetail);
    
    }

    public void removeSecurityTblStlCheckDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCheckDetail getSecurityTblStlCheckDetailById(Integer id){
   		return (TblStlCheckDetail) getObjectById(id);
    }

    public List<TblStlCheckDetail> getSecurityTblStlCheckDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
