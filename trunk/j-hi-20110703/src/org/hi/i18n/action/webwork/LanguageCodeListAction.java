package org.hi.i18n.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.action.LanguageCodePageInfo;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;

public class LanguageCodeListAction extends BaseAction{
	private LanguageCode languageCode;
	private LanguageCodePageInfo pageInfo;
	private List<LanguageCode> languageCodes;
	
	public String execute() throws Exception {
		LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
		pageInfo = pageInfo == null ? new LanguageCodePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		languageCodes = languageCodeMgr.getLanguageCodeList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}
	
	public List<LanguageCode> getLanguageCodes() {
		return languageCodes;
	}

	public void setLanguageCodes(List<LanguageCode> languageCodes) {
		this.languageCodes = languageCodes;
	}

	public LanguageCodePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(LanguageCodePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
