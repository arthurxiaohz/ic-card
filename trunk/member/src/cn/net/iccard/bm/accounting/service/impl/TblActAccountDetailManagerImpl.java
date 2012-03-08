package cn.net.iccard.bm.accounting.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.accounting.service.TblActAccountDetailManager;

public class TblActAccountDetailManagerImpl extends ManagerImpl implements TblActAccountDetailManager{
    
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
    
    public void saveTblActAccountDetail(TblActAccountDetail tblActAccountDetail){
    	saveObject(tblActAccountDetail);
    
    }

    public void removeTblActAccountDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActAccountDetail getTblActAccountDetailById(Integer id){
   		return (TblActAccountDetail) getObjectById(id);
    }

    public List<TblActAccountDetail> getTblActAccountDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblActAccountDetail(TblActAccountDetail tblActAccountDetail){
    	saveObject(tblActAccountDetail);
    
    }

    public void removeSecurityTblActAccountDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblActAccountDetail getSecurityTblActAccountDetailById(Integer id){
   		return (TblActAccountDetail) getObjectById(id);
    }

    public List<TblActAccountDetail> getSecurityTblActAccountDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
