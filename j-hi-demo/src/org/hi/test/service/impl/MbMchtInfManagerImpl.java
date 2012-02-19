package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.MbMchtInf;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.MbMchtInfManager;

public class MbMchtInfManagerImpl extends ManagerImpl implements MbMchtInfManager{
    
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
    
    public void saveMbMchtInf(MbMchtInf mbMchtInf){
    	saveObject(mbMchtInf);
    
    }

    public void removeMbMchtInfById(Integer id){
    	removeObjectById(id);
    	
    }

    public MbMchtInf getMbMchtInfById(Integer id){
   		return (MbMchtInf) getObjectById(id);
    }

    public List<MbMchtInf> getMbMchtInfList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityMbMchtInf(MbMchtInf mbMchtInf){
    	saveObject(mbMchtInf);
    
    }

    public void removeSecurityMbMchtInfById(Integer id){
    	removeObjectById(id);
    	
    }

    public MbMchtInf getSecurityMbMchtInfById(Integer id){
   		return (MbMchtInf) getObjectById(id);
    }

    public List<MbMchtInf> getSecurityMbMchtInfList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
