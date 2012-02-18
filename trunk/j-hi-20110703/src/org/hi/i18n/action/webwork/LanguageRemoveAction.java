package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;

public class LanguageRemoveAction extends BaseAction{
	private Language language;
	
	public String execute() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		languageMgr.removeLanguageById(language.getId());
		return returnCommand();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
