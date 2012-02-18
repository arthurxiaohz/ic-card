package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageStrManager;
import org.hi.framework.web.SynchronizationData;

public class LanguageStrSaveAction extends BaseAction implements SynchronizationData{
	private LanguageStr languageStr;
	
	public String execute() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		if(super.perExecute(languageStr)!= null) return returnCommand();
		languageStrMgr.saveLanguageStr(languageStr);
		super.postExecute(languageStr);
		return returnCommand();
	}
	
	public LanguageStr getLanguageStr() {
		return languageStr;
	}

	public void setLanguageStr(LanguageStr languageStr) {
		this.languageStr = languageStr;
	}

}
