package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Nation;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.NationManager;

public class NationManagerImpl extends ManagerImpl implements NationManager{
    
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
    
    public void saveNation(Nation nation){
    	saveObject(nation);
    
    }

    public void removeNationById(Integer id){
    	removeObjectById(id);
    	
    }

    public Nation getNationById(Integer id){
   		return (Nation) getObjectById(id);
    }

    public List<Nation> getNationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityNation(Nation nation){
    	saveObject(nation);
    
    }

    public void removeSecurityNationById(Integer id){
    	removeObjectById(id);
    	
    }

    public Nation getSecurityNationById(Integer id){
   		return (Nation) getObjectById(id);
    }

    public List<Nation> getSecurityNationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
