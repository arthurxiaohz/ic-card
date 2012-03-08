package cn.net.iccard.bm.checkservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlErrorDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager;

public class TblStlErrorDetailManagerImpl extends ManagerImpl implements TblStlErrorDetailManager{
    
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
    
    public void saveTblStlErrorDetail(TblStlErrorDetail tblStlErrorDetail){
    	saveObject(tblStlErrorDetail);
    
    }

    public void removeTblStlErrorDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlErrorDetail getTblStlErrorDetailById(Integer id){
   		return (TblStlErrorDetail) getObjectById(id);
    }

    public List<TblStlErrorDetail> getTblStlErrorDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlErrorDetail(TblStlErrorDetail tblStlErrorDetail){
    	saveObject(tblStlErrorDetail);
    
    }

    public void removeSecurityTblStlErrorDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlErrorDetail getSecurityTblStlErrorDetailById(Integer id){
   		return (TblStlErrorDetail) getObjectById(id);
    }

    public List<TblStlErrorDetail> getSecurityTblStlErrorDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
