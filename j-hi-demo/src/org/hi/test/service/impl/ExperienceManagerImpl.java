package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.Experience;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.ExperienceManager;

public class ExperienceManagerImpl extends ManagerImpl implements ExperienceManager{
    
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
    
    public void saveExperience(Experience experience){
    	saveObject(experience);
    
    }

    public void removeExperienceById(Integer id){
    	removeObjectById(id);
    	
    }

    public Experience getExperienceById(Integer id){
   		return (Experience) getObjectById(id);
    }

    public List<Experience> getExperienceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityExperience(Experience experience){
    	saveObject(experience);
    
    }

    public void removeSecurityExperienceById(Integer id){
    	removeObjectById(id);
    	
    }

    public Experience getSecurityExperienceById(Integer id){
   		return (Experience) getObjectById(id);
    }

    public List<Experience> getSecurityExperienceList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
