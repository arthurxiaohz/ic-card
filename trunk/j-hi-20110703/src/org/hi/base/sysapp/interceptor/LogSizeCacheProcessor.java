package org.hi.base.sysapp.interceptor;

import org.hi.base.sysapp.model.HiLog;

import com.vladium.utils.IObjectProfileNode;
import com.vladium.utils.ObjectProfiler;

public class LogSizeCacheProcessor extends AbstractLogCacheProcessor {
	private int size;
	
	public synchronized void addHiLog(HiLog log) {
		addHiLogToCache(log);
		IObjectProfileNode profile = ObjectProfiler.profile (this.logCache);
		int cacheSize = profile.size(); //beans所占用的空间
		if(cacheSize < getSize() * 1024) return;
		LogSaveProcessor saveProcessor =  this.getInterceptor().getSaveProcessor();
		saveProcessor.saveLog(getHiLogs());
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	
}
