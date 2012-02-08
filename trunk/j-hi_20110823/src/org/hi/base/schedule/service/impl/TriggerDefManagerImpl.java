package org.hi.base.schedule.service.impl;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.schedule.context.ScheduleDefChangeEvent;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.schedule.service.JobDetailDefManager;
import org.hi.base.schedule.service.TriggerDefManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class TriggerDefManagerImpl extends ManagerImpl implements TriggerDefManager, ApplicationEventPublisherAware{
    
    private ApplicationEventPublisher applicationEventPublisher;

	protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);
    	if(((BaseObject)obj).isDirty())
    		publishEvent(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
    	publishEvent(obj);
        
    }
    
    public void saveTriggerDef(TriggerDef triggerDef){
    	String jobClassName = triggerDef.getJobDetailName();
    	JobDetailDef jobDetailDef = triggerDef.getJobDetail();
    	if(jobDetailDef == null) jobDetailDef = new JobDetailDef();
    	if(!jobClassName.equals(jobDetailDef.getJobClassName())){
    		JobDetailDefManager jobDefMrg = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
    		jobDetailDef.setJobClassName(jobClassName);
    		jobDetailDef.setJobName(jobClassName);
    		jobDefMrg.saveObject(jobDetailDef);
    	}
    	triggerDef.setJobDetail(jobDetailDef);
    	saveObject(triggerDef);
    }

    public void removeTriggerDefById(Integer id){
    	TriggerDef triggerDef = (TriggerDef) getObjectById(id);
    	if(triggerDef != null){
	    	JobDetailDefManager jobDefMrg = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
	    	jobDefMrg.removeObject(triggerDef.getJobDetail());
	    	removeObjectById(id);
    	}
    	
    }

    public TriggerDef getTriggerDefById(Integer id){
   		return (TriggerDef) getObjectById(id);
    }

    public List<TriggerDef> getTriggerDefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	protected void publishEvent(Object obj){
        if ( applicationEventPublisher != null && obj instanceof TriggerDef) {
        	ScheduleDefChangeEvent event = new ScheduleDefChangeEvent(obj);
            applicationEventPublisher.publishEvent( event );
        }
	}
	
    public void saveSecurityTriggerDef(TriggerDef triggerDef){
    	saveObject(triggerDef);
    }
    public void removeSecurityTriggerDefById(Integer id){
    	removeObjectById(id);
    }
    public TriggerDef getSecurityTriggerDefById(Integer id){
    	return (TriggerDef) getObjectById(id);
    }
    public List<TriggerDef> getSecurityTriggerDefList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
