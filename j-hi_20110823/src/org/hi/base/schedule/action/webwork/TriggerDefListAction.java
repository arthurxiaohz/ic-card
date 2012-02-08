package org.hi.base.schedule.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.schedule.action.TriggerDefPageInfo;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.TriggerDefManager;

public class TriggerDefListAction extends BaseAction{
	private TriggerDef triggerDef;
	private TriggerDefPageInfo pageInfo;
	private List<TriggerDef> triggerDefs;
	
	public String execute() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		pageInfo = pageInfo == null ? new TriggerDefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		triggerDefs = triggerDefMgr.getTriggerDefList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public TriggerDef getTriggerDef() {
		return triggerDef;
	}

	public void setTriggerDef(TriggerDef triggerDef) {
		this.triggerDef = triggerDef;
	}
	
	public List<TriggerDef> getTriggerDefs() {
		return triggerDefs;
	}

	public void setTriggerDefs(List<TriggerDef> triggerDefs) {
		this.triggerDefs = triggerDefs;
	}

	public TriggerDefPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TriggerDefPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
