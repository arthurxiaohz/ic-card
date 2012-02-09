package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.JobPosition;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.test.service.JobPositionManager;

public class JobPositionManagerImpl extends ManagerImpl implements JobPositionManager{
    
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
    
    public void saveJobPosition(JobPosition jobPosition){
    	saveObject(jobPosition);
    
    }

    public void removeJobPositionById(Integer id){
    	removeObjectById(id);
    	
    }

    public JobPosition getJobPositionById(Integer id){
   		return (JobPosition) getObjectById(id);
    }

    public List<JobPosition> getJobPositionList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityJobPosition(JobPosition jobPosition){
    	saveObject(jobPosition);
    
    }

    public void removeSecurityJobPositionById(Integer id){
    	removeObjectById(id);
    	
    }

    public JobPosition getSecurityJobPositionById(Integer id){
   		return (JobPosition) getObjectById(id);
    }

    public List<JobPosition> getSecurityJobPositionList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
