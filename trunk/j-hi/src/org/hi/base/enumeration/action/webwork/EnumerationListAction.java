package org.hi.base.enumeration.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.enumeration.action.EnumerationPageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.service.EnumerationManager;

public class EnumerationListAction extends BaseAction{
	private Enumeration enumeration;
	private EnumerationPageInfo pageInfo;
	private List<Enumeration> enumerations;
	
	public String execute() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		pageInfo = pageInfo == null ? new EnumerationPageInfo() : pageInfo;
		pageInfo.setF_enumerationType( 0 );
		pageInfo.setF_enumerationType_op(Filter.OPERATOR_EQ);
		
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		enumerations = enumerationMgr.getSecurityEnumerationList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Enumeration getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
	
	public List<Enumeration> getEnumerations() {
		return enumerations;
	}

	public void setEnumerations(List<Enumeration> enumerations) {
		this.enumerations = enumerations;
	}

	public EnumerationPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(EnumerationPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
