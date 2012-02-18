package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.action.HelperPageInfo;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.service.HelperManager;

public class HelperListAction extends BaseAction{
	private Helper helper;
	private HelperPageInfo pageInfo;
	private List<Helper> helpers;
	
	public String execute() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		pageInfo = pageInfo == null ? new HelperPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		helpers = helperMgr.getSecurityHelperList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	public List<Helper> getHelpers() {
		return helpers;
	}

	public void setHelpers(List<Helper> helpers) {
		this.helpers = helpers;
	}

	public HelperPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HelperPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
