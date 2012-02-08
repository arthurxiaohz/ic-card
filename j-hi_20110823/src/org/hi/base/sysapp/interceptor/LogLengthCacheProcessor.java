package org.hi.base.sysapp.interceptor;

import org.hi.base.sysapp.model.HiLog;

public class LogLengthCacheProcessor extends AbstractLogCacheProcessor  {
//	缓存空间的大小，以M为单位
	private int length;
	


	public synchronized void addHiLog(HiLog log) {
		addHiLogToCache(log);
		
		if(this.logCache.size() < length) return;
		LogSaveProcessor saveProcessor =  this.getInterceptor().getSaveProcessor();
		saveProcessor.saveLog(getHiLogs());
	}


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
