package org.hi.base.sysapp.interceptor;

import java.util.LinkedList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;

public class LogDataBaseProcessor implements LogSaveProcessor {

	public void saveLog(List<HiLog> logs) {
		SaveLog logThread = new SaveLog(logs);
		logThread.start();
	}
	
    private class SaveLog extends Thread{
    	List<HiLog> logs;
    	SaveLog(List<HiLog> logs){
    		this.logs = new LinkedList<HiLog>();
    		for (HiLog hiLog : logs) {
				this.logs.add(hiLog);
			}
    	}
    	
    	public void run() {
    		HiLogManager logMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
    		for (HiLog log : logs) {
    			logMgr.saveHiLog(log);
			}
    	}
    }

}
