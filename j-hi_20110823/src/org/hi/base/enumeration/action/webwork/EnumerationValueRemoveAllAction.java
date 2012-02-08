package org.hi.base.enumeration.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationValueManager;

public class EnumerationValueRemoveAllAction extends BaseAction{
	private EnumerationValue enumerationValue;
	private String orderIndexs;
	
	public String execute() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer enumerationValueid = new Integer( ids[i] );
				enumerationValueMgr.removeEnumerationValueById(enumerationValueid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public EnumerationValue getEnumerationValue() {
		return enumerationValue;
	}

	public void setEnumerationValue(EnumerationValue enumerationValue) {
		this.enumerationValue = enumerationValue;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
