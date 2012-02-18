package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;

public class HiLogRemoveAction extends BaseAction{
	private HiLog hiLog;
	
	public String execute() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		hiLogMgr.removeHiLogById(hiLog.getId());
		return returnCommand();
	}
	
	public HiLog getHiLog() {
		return hiLog;
	}

	public void setHiLog(HiLog hiLog) {
		this.hiLog = hiLog;
	}
}
