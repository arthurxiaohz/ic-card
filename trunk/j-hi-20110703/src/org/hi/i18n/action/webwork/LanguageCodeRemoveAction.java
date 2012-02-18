package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;

public class LanguageCodeRemoveAction extends BaseAction{
	private LanguageCode languageCode;
	
	public String execute() throws Exception {
		LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
		languageCodeMgr.removeLanguageCodeById(languageCode.getId());
		return returnCommand();
	}
	
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}
}
