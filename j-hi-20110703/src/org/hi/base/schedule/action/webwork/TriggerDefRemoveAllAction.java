package org.hi.base.schedule.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.TriggerDefManager;

public class TriggerDefRemoveAllAction extends BaseAction{
	private TriggerDef triggerDef;
	private String orderIndexs;
	
	public String execute() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer triggerDefid = new Integer( ids[i] );
				triggerDefMgr.removeTriggerDefById(triggerDefid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public TriggerDef getTriggerDef() {
		return triggerDef;
	}

	public void setTriggerDef(TriggerDef triggerDef) {
		this.triggerDef = triggerDef;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
