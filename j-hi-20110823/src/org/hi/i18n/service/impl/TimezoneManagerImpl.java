package org.hi.i18n.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.Timezone;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.i18n.service.TimezoneManager;

public class TimezoneManagerImpl extends ManagerImpl implements TimezoneManager{
    
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
    
    public void saveTimezone(Timezone timezone){
    	saveObject(timezone);
    
    }

    public void removeTimezoneById(Integer id){
    	removeObjectById(id);
    	
    }

    public Timezone getTimezoneById(Integer id){
   		return (Timezone) getObjectById(id);
    }

    public List<Timezone> getTimezoneList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityTimezone(Timezone timezone){
    	saveObject(timezone);
    
    }

    public void removeSecurityTimezoneById(Integer id){
    	removeObjectById(id);
    	
    }

    public Timezone getSecurityTimezoneById(Integer id){
   		return (Timezone) getObjectById(id);
    }

    public List<Timezone> getSecurityTimezoneList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
