package org.hi.base.schedule.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.TriggerDefManager;
import org.hi.framework.web.SynchronizationData;

public class TriggerDefSaveAction extends BaseAction implements SynchronizationData{
	private TriggerDef triggerDef;
	
	public String execute() throws Exception {
		if(super.perExecute(triggerDef)!= null) return returnCommand();
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		triggerDefMgr.saveTriggerDef(triggerDef);
		super.postExecute(triggerDef);
		return returnCommand();
	}
	
	public TriggerDef getTriggerDef() {
		return triggerDef;
	}

	public void setTriggerDef(TriggerDef triggerDef) {
		this.triggerDef = triggerDef;
	}

}
