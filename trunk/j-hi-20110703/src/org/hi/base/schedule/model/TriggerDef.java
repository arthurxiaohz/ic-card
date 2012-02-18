package org.hi.base.schedule.model;

import org.hi.base.schedule.model.original.TriggerDefAbstract;


public class TriggerDef extends TriggerDefAbstract{

	private String jobDetailName;
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup != null && triggerGroup.trim().equals("") ? null : triggerGroup;
    }
	public String getJobDetailName() {
		return jobDetailName;
	}
	public void setJobDetailName(String jobDetailName) {
		this.jobDetailName = jobDetailName;
	}
    
}