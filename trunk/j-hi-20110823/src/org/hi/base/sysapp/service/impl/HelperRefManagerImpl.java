package org.hi.base.sysapp.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.HelperRefManager;

public class HelperRefManagerImpl extends ManagerImpl implements HelperRefManager{
    
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
    
    public void saveHelperRef(HelperRef helperRef){
    	saveObject(helperRef);
    
    }

    public void removeHelperRefById(Integer id){
    	removeObjectById(id);
    	
    }

    public HelperRef getHelperRefById(Integer id){
   		return (HelperRef) getObjectById(id);
    }

    public List<HelperRef> getHelperRefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityHelperRef(HelperRef helperRef){
    	saveObject(helperRef);
    
    }

    public void removeSecurityHelperRefById(Integer id){
    	removeObjectById(id);
    	
    }

    public HelperRef getSecurityHelperRefById(Integer id){
   		return (HelperRef) getObjectById(id);
    }

    public List<HelperRef> getSecurityHelperRefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
