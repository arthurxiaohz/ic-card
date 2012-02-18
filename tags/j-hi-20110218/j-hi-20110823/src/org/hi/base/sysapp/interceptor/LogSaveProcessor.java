package org.hi.base.sysapp.interceptor;

import java.util.List;

import org.hi.base.sysapp.model.HiLog;

public interface LogSaveProcessor {
	public void saveLog(List<HiLog> logs);
}
