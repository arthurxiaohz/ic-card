package org.hi.base.schedule.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.service.JobDetailDefManager;

public class JobDetailDefRemoveAction extends BaseAction{
	private JobDetailDef jobDetailDef;
	
	public String execute() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		jobDetailDefMgr.removeJobDetailDefById(jobDetailDef.getId());
		return returnCommand();
	}
	
	public JobDetailDef getJobDetailDef() {
		return jobDetailDef;
	}

	public void setJobDetailDef(JobDetailDef jobDetailDef) {
		this.jobDetailDef = jobDetailDef;
	}
}
