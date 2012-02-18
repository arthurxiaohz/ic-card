package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.HelperRefPageInfo;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperRefManager;

public class HelperRefListAction extends BaseAction{
	private HelperRef helperRef;
	private HelperRefPageInfo pageInfo;
	private List<HelperRef> helperRefs;
	
	public String execute() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		pageInfo = pageInfo == null ? new HelperRefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		helperRefs = helperRefMgr.getSecurityHelperRefList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public HelperRef getHelperRef() {
		return helperRef;
	}

	public void setHelperRef(HelperRef helperRef) {
		this.helperRef = helperRef;
	}
	
	public List<HelperRef> getHelperRefs() {
		return helperRefs;
	}

	public void setHelperRefs(List<HelperRef> helperRefs) {
		this.helperRefs = helperRefs;
	}

	public HelperRefPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HelperRefPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
