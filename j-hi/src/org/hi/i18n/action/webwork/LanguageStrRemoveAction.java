package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageStrManager;

public class LanguageStrRemoveAction extends BaseAction{
	private LanguageStr languageStr;
	
	public String execute() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		languageStrMgr.removeLanguageStrById(languageStr.getId());
		return returnCommand();
	}
	
	public LanguageStr getLanguageStr() {
		return languageStr;
	}

	public void setLanguageStr(LanguageStr languageStr) {
		this.languageStr = languageStr;
	}
}
