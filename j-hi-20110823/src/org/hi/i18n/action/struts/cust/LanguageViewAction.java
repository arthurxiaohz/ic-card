package org.hi.i18n.action.struts.cust;

import org.hi.SpringContextHolder;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;

public class LanguageViewAction extends BaseAction{
	private Language language;
	
	public String execute() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		language = languageMgr.getLanguageById(language.getId());
		//编辑的时候如果没有这个语言代码信息那么就自动添加并值是空
		languageMgr.addLanguageStr(language);
		return returnCommand();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
