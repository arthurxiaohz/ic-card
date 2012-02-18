package org.hi.base.schedule.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.schedule.action.TriggerDefPageInfo;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.TriggerDefManager;

public class TriggerDefAction extends BaseAction{
	private TriggerDef triggerDef;
	private TriggerDefPageInfo pageInfo;
	private List<TriggerDef> triggerDefs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存触发器  
	 */
	public String saveTriggerDef() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		if(super.perExecute(triggerDef)!= null) return returnCommand();
		triggerDefMgr.saveTriggerDef(triggerDef);
		super.postExecute(triggerDef);
		return returnCommand();
	}
	
	
	/**
	 * 删除触发器
	 */
	public String removeTriggerDef() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		triggerDefMgr.removeTriggerDefById(triggerDef.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些触发器
	 */
	public String removeAllTriggerDef() throws Exception {
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
	
	/**
	 *查看触发器
	 */
	public String viewTriggerDef() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		triggerDef = triggerDefMgr.getTriggerDefById(triggerDef.getId());
		return returnCommand();
	}
	
	/**
	 * 触发器列表
	 */
	public String triggerDefList() throws Exception {
		TriggerDefManager triggerDefMgr = (TriggerDefManager)SpringContextHolder.getBean(TriggerDef.class);
		pageInfo = pageInfo == null ? new TriggerDefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		triggerDefs = triggerDefMgr.getSecurityTriggerDefList(sarchPageInfo);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
