package org.hi.base.enumeration.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.service.EnumerationManager;

public class EnumerationViewAction extends BaseAction{
	private Enumeration enumeration;
	
	public String execute() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		enumeration = enumerationMgr.getEnumerationById(enumeration.getId());
		return returnCommand();
	}
	
	public Enumeration getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
}
