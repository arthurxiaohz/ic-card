package org.hi.i18n.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.action.LanguagePageInfo;
import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;

public class LanguageListAction extends BaseAction{
	private Language language;
	private LanguagePageInfo pageInfo;
	private List<Language> languages;
	
	public String execute() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		pageInfo = pageInfo == null ? new LanguagePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		languages = languageMgr.getLanguageList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public LanguagePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(LanguagePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
