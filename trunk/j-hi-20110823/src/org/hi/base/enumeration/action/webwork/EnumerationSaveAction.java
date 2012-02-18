package org.hi.base.enumeration.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.service.EnumerationManager;
import org.hi.framework.web.SynchronizationData;

public class EnumerationSaveAction extends BaseAction implements SynchronizationData{
	private Enumeration enumeration;
	
	public String execute() throws Exception {
		if(super.perExecute(enumeration)!= null) return returnCommand();
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		enumerationMgr.saveEnumeration(enumeration);
		super.postExecute(enumeration);
		return returnCommand();
	}
	
	public Enumeration getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(Enumeration enumeration) {
		this.enumeration = enumeration;
	}

}
