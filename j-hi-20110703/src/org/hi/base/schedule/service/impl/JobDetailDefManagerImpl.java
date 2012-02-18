package org.hi.base.schedule.service.impl;

import java.util.List;

import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.schedule.context.ScheduleDefChangeEvent;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.framework.security.context.SecurityOrgFilterEvent;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.schedule.service.JobDetailDefManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class JobDetailDefManagerImpl extends ManagerImpl implements JobDetailDefManager{
	private ApplicationEventPublisher applicationEventPublisher;
	
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
		super.postSaveObject(obj);
//    	if(((BaseObject)obj).isDirty())
//    		publishEvent(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
    	super.preRemoveObject(obj);
//    	if(((BaseObject)obj).isDirty())
//    		publishEvent(obj);
        
    }
    
    public void saveJobDetailDef(JobDetailDef jobDetailDef){
    	saveObject(jobDetailDef);
    
    }

    public void removeJobDetailDefById(Integer id){
    	removeObjectById(id);
    	
    }

    public JobDetailDef getJobDetailDefById(Integer id){
   		return (JobDetailDef) getObjectById(id);
    }

    public List<JobDetailDef> getJobDetailDefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

//	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//		this.applicationEventPublisher = applicationEventPublisher;
//	}
//	
//	protected void publishEvent(Object obj){
//        if ( applicationEventPublisher != null && obj instanceof JobDetailDef) {
//        	ScheduleDefChangeEvent event = new ScheduleDefChangeEvent(obj);
//            applicationEventPublisher.publishEvent( event );
//        }
//	}
	
    public void saveSecurityJobDetailDef(JobDetailDef jobDetailDef){
    	saveObject(jobDetailDef);
    }
    public void removeSecurityJobDetailDefById(Integer id){
    	removeObjectById(id);
    }
    public JobDetailDef getSecurityJobDetailDefById(Integer id){
    	return (JobDetailDef) getObjectById(id);
    }
    public List<JobDetailDef> getSecurityJobDetailDefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
