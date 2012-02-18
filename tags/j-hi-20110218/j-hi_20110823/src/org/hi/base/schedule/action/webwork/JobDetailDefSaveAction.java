package org.hi.base.schedule.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.service.JobDetailDefManager;
import org.hi.framework.web.SynchronizationData;

public class JobDetailDefSaveAction extends BaseAction implements SynchronizationData{
	private JobDetailDef jobDetailDef;
	
	public String execute() throws Exception {
		if(super.perExecute(jobDetailDef)!= null) return returnCommand();
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		jobDetailDefMgr.saveJobDetailDef(jobDetailDef);
		super.postExecute(jobDetailDef);
		return returnCommand();
	}
	
	public JobDetailDef getJobDetailDef() {
		return jobDetailDef;
	}

	public void setJobDetailDef(JobDetailDef jobDetailDef) {
		this.jobDetailDef = jobDetailDef;
	}

}
