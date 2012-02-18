package org.hi.base.sysapp.interceptor;

import org.hi.framework.service.Manager;
import org.hi.metadata.hsc.context.service.Entity;

public interface LogAnalysisor {
	public String perProcess(Object[] args, Entity entity, Manager manager);
	public String postProcess(Object result);
}
