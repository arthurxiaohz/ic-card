package cn.net.iccard.bm.checkservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlOrganization;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager;

public class TblStlOrganizationManagerImpl extends ManagerImpl implements TblStlOrganizationManager{
    
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
    
    public void saveTblStlOrganization(TblStlOrganization tblStlOrganization){
    	saveObject(tblStlOrganization);
    
    }

    public void removeTblStlOrganizationById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlOrganization getTblStlOrganizationById(Integer id){
   		return (TblStlOrganization) getObjectById(id);
    }

    public List<TblStlOrganization> getTblStlOrganizationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlOrganization(TblStlOrganization tblStlOrganization){
    	saveObject(tblStlOrganization);
    
    }

    public void removeSecurityTblStlOrganizationById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlOrganization getSecurityTblStlOrganizationById(Integer id){
   		return (TblStlOrganization) getObjectById(id);
    }

    public List<TblStlOrganization> getSecurityTblStlOrganizationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
