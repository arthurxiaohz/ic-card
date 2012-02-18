package org.hi.base.enumeration.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationValueManager;

public class EnumerationValueViewAction extends BaseAction{
	private EnumerationValue enumerationValue;
	
	public String execute() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		enumerationValue = enumerationValueMgr.getEnumerationValueById(enumerationValue.getId());
		return returnCommand();
	}
	
	public EnumerationValue getEnumerationValue() {
		return enumerationValue;
	}

	public void setEnumerationValue(EnumerationValue enumerationValue) {
		this.enumerationValue = enumerationValue;
	}
}
