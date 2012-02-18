package org.hi.base.sysapp.interceptor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.hi.base.sysapp.model.HiLog;

public abstract class AbstractLogCacheProcessor implements LogCacheProcessor{
	MethodLogInterceptor interceptor;
	protected List<HiLog> logCache = Collections.synchronizedList(new LinkedList<HiLog>());

	public final synchronized List<HiLog> getHiLogs() {
		List<HiLog> result = new LinkedList<HiLog>();
		synchronized (logCache) {
			for (HiLog hiLog : logCache) {
				result.add(hiLog);
			}
			logCache.clear();
		}
		
		return result;
	}
	
	public final synchronized void addHiLogToCache(HiLog log){
		logCache.add(log);
	}
	
	public MethodLogInterceptor getInterceptor() {
		return interceptor;
	}

	public void setInterceptor(MethodLogInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	
}
