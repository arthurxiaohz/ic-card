package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;
import org.hi.framework.web.SynchronizationData;

public class HiLogSaveAction extends BaseAction implements SynchronizationData{
	private HiLog hiLog;
	
	public String execute() throws Exception {
		HiLogManager hiLogMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
		if(super.perExecute(hiLog)!= null) return returnCommand();
		hiLogMgr.saveHiLog(hiLog);
		super.postExecute(hiLog);
		return returnCommand();
	}
	
	public HiLog getHiLog() {
		return hiLog;
	}

	public void setHiLog(HiLog hiLog) {
		this.hiLog = hiLog;
	}

}
