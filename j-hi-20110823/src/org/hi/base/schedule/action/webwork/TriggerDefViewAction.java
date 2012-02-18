package org.hi.base.schedule.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.TriggerDefManager;

public class TriggerDefViewAction extends BaseAction{
	private TriggerDef triggerDef;
	
	public String execute() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		triggerDef = triggerDefMgr.getTriggerDefById(triggerDef.getId());
		return returnCommand();
	}
	
	public TriggerDef getTriggerDef() {
		return triggerDef;
	}

	public void setTriggerDef(TriggerDef triggerDef) {
		this.triggerDef = triggerDef;
	}
}
