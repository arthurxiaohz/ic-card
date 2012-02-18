package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.HiLogPageInfo;
import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;

public class HiLogListAction extends BaseAction{
	private HiLog hiLog;
	private HiLogPageInfo pageInfo;
	private List<HiLog> hiLogs;
	
	public String execute() throws Exception {
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
}
