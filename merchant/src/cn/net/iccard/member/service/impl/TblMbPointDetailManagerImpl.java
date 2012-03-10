package cn.net.iccard.member.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.member.model.TblMbPointDetail;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.member.service.TblMbPointDetailManager;

public class TblMbPointDetailManagerImpl extends ManagerImpl implements TblMbPointDetailManager{
    
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
    
    public void saveTblMbPointDetail(TblMbPointDetail tblMbPointDetail){
    	saveObject(tblMbPointDetail);
    
    }

    public void removeTblMbPointDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointDetail getTblMbPointDetailById(Integer id){
   		return (TblMbPointDetail) getObjectById(id);
    }

    public List<TblMbPointDetail> getTblMbPointDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblMbPointDetail(TblMbPointDetail tblMbPointDetail){
    	saveObject(tblMbPointDetail);
    
    }

    public void removeSecurityTblMbPointDetailById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblMbPointDetail getSecurityTblMbPointDetailById(Integer id){
   		return (TblMbPointDetail) getObjectById(id);
    }

    public List<TblMbPointDetail> getSecurityTblMbPointDetailList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
