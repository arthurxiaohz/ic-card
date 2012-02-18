package org.hi.i18n.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.action.LanguageStrPageInfo;
import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageStrManager;

public class LanguageStrListAction extends BaseAction{
	private LanguageStr languageStr;
	private LanguageStrPageInfo pageInfo;
	private List<LanguageStr> languageStrs;
	
	public String execute() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		pageInfo = pageInfo == null ? new LanguageStrPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		languageStrs = languageStrMgr.getLanguageStrList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public LanguageStr getLanguageStr() {
		return languageStr;
	}

	public void setLanguageStr(LanguageStr languageStr) {
		this.languageStr = languageStr;
	}
	
	public List<LanguageStr> getLanguageStrs() {
		return languageStrs;
	}

	public void setLanguageStrs(List<LanguageStr> languageStrs) {
		this.languageStrs = languageStrs;
	}

	public LanguageStrPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(LanguageStrPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
