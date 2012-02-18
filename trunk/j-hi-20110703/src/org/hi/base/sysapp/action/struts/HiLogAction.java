package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.sysapp.action.HiLogPageInfo;
import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;

public class HiLogAction extends BaseAction{
	private HiLog hiLog;
	private HiLogPageInfo pageInfo;
	private List<HiLog> hiLogs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存系统日志
	 */
	public String saveHiLog() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		if(super.perExecute(hiLog)!= null) return returnCommand();
		hiLogMgr.saveHiLog(hiLog);
		super.postExecute(hiLog);
		return returnCommand();
	}
	
	
	/**
	 * 删除系统日志
	 */
	public String removeHiLog() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		hiLogMgr.removeHiLogById(hiLog.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些系统日志
	 */
	public String removeAllHiLog() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer hiLogid = new Integer( ids[i] );
				hiLogMgr.removeHiLogById(hiLogid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看系统日志
	 */
	public String viewHiLog() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		hiLog = hiLogMgr.getHiLogById(hiLog.getId());
		return returnCommand();
	}
	
	/**
	 * 系统日志列表
	 */
	public String hiLogList() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		pageInfo = pageInfo == null ? new HiLogPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		hiLogs = hiLogMgr.getSecurityHiLogList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public HiLog getHiLog() {
		return hiLog;
	}

	public void setHiLog(HiLog hiLog) {
		this.hiLog = hiLog;
	}
	
	public List<HiLog> getHiLogs() {
		return hiLogs;
	}

	public void setHiLogs(List<HiLog> hiLogs) {
		this.hiLogs = hiLogs;
	}

	public HiLogPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HiLogPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
