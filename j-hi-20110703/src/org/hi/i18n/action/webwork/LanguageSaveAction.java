package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;
import org.hi.framework.web.SynchronizationData;

public class LanguageSaveAction extends BaseAction implements SynchronizationData{
	private Language language;
	
	public String execute() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		if(super.perExecute(language)!= null) return returnCommand();
		languageMgr.saveLanguage(language);
		super.postExecute(language);
		return returnCommand();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
