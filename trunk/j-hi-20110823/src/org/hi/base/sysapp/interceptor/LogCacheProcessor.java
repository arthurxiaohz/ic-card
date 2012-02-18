package org.hi.base.sysapp.interceptor;

import java.util.List;

import org.hi.base.sysapp.model.HiLog;

public interface LogCacheProcessor {
	
	public List<HiLog> getHiLogs();
	
	public void addHiLog(HiLog log);
	
}
