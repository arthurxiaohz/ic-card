package org.hi.base.enumeration.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationManager;
import org.hi.base.enumeration.service.EnumerationValueManager;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.webwork.BaseAction;

public class EnumerationValueSaveAction extends BaseAction implements SynchronizationData{
	private EnumerationValue enumerationValue;
	
	public String execute() throws Exception {
		if(super.perExecute(enumerationValue)!= null) return returnCommand();
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		if(enumerationValue.getEnumeration() !=null && enumerationValue.getEnumeration().getId() != null && enumerationValue.getId() == null){
			Enumeration enumeration = enumerationMgr.getEnumerationById(enumerationValue.getEnumeration().getId());
			enumerationValue.setEnumeration(enumeration);
			enumeration.getEnumerationValues().add(enumerationValue);
		}
		enumerationValueMgr.saveEnumerationValue(enumerationValue);
		super.postExecute(enumerationValue);
		return returnCommand();
	}
	
	public EnumerationValue getEnumerationValue() {
		return enumerationValue;
	}

	public void setEnumerationValue(EnumerationValue enumerationValue) {
		this.enumerationValue = enumerationValue;
	}

}
