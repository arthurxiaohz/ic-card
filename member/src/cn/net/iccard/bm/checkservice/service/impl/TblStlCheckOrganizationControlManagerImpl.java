package cn.net.iccard.bm.checkservice.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckOrganizationControl;
import org.hi.framework.service.impl.ManagerImpl;
import cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager;

public class TblStlCheckOrganizationControlManagerImpl extends ManagerImpl implements TblStlCheckOrganizationControlManager{
    
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
    
    public void saveTblStlCheckOrganizationControl(TblStlCheckOrganizationControl tblStlCheckOrganizationControl){
    	saveObject(tblStlCheckOrganizationControl);
    
    }

    public void removeTblStlCheckOrganizationControlById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCheckOrganizationControl getTblStlCheckOrganizationControlById(Integer id){
   		return (TblStlCheckOrganizationControl) getObjectById(id);
    }

    public List<TblStlCheckOrganizationControl> getTblStlCheckOrganizationControlList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTblStlCheckOrganizationControl(TblStlCheckOrganizationControl tblStlCheckOrganizationControl){
    	saveObject(tblStlCheckOrganizationControl);
    
    }

    public void removeSecurityTblStlCheckOrganizationControlById(Integer id){
    	removeObjectById(id);
    	
    }

    public TblStlCheckOrganizationControl getSecurityTblStlCheckOrganizationControlById(Integer id){
   		return (TblStlCheckOrganizationControl) getObjectById(id);
    }

    public List<TblStlCheckOrganizationControl> getSecurityTblStlCheckOrganizationControlList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
