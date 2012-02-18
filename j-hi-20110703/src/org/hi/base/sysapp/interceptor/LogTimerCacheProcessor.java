package org.hi.base.sysapp.interceptor;

import java.util.Timer;
import java.util.TimerTask;

import org.hi.base.sysapp.model.HiLog;
import org.springframework.beans.factory.InitializingBean;

public class LogTimerCacheProcessor extends AbstractLogCacheProcessor implements InitializingBean {
	//间隔时间,以分钟为单位
	private int period;
	
	Timer timer = new Timer();
	public void addHiLog(HiLog log) {
		addHiLogToCache(log);
	}


	public void afterPropertiesSet() throws Exception {
		if(this.period == 0)
			this.period = 10;
		timer.scheduleAtFixedRate(new SaveTimerTask(),20000,period * 1000 * 60);
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}
	
	class SaveTimerTask extends TimerTask{

		public void run() {
			if(getHiLogs().size() == 0) return;
				LogSaveProcessor saveProcessor =  getInterceptor().getSaveProcessor();
				saveProcessor.saveLog(getHiLogs());
		}
		
	}

}
