package org.hi.base.enumeration.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.enumeration.action.EnumerationValuePageInfo;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationValueManager;

public class EnumerationValueListAction extends BaseAction{
	private EnumerationValue enumerationValue;
	private EnumerationValuePageInfo pageInfo;
	private List<EnumerationValue> enumerationValues;
	
	public String execute() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		pageInfo = pageInfo == null ? new EnumerationValuePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		enumerationValues = enumerationValueMgr.getSecurityEnumerationValueList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public EnumerationValue getEnumerationValue() {
		return enumerationValue;
	}

	public void setEnumerationValue(EnumerationValue enumerationValue) {
		this.enumerationValue = enumerationValue;
	}
	
	public List<EnumerationValue> getEnumerationValues() {
		return enumerationValues;
	}

	public void setEnumerationValues(List<EnumerationValue> enumerationValues) {
		this.enumerationValues = enumerationValues;
	}

	public EnumerationValuePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(EnumerationValuePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
