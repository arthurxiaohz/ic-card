package org.hi.base.schedule.model;

import org.hi.base.schedule.model.original.JobDetailDefAbstract;


public class JobDetailDef extends JobDetailDefAbstract{
	
	public void setJobGroup(String jobGroup){
		this.jobGroup = jobGroup != null && jobGroup.trim().equals("") ? null : jobGroup;
	}
	

}