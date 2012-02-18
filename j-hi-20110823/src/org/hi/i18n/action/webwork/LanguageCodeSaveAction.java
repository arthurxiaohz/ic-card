package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;
import org.hi.framework.web.SynchronizationData;

public class LanguageCodeSaveAction extends BaseAction implements SynchronizationData{
	private LanguageCode languageCode;
	
	public String execute() throws Exception {
		LanguageCodeManager languageCodeMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
		if(super.perExecute(languageCode)!= null) return returnCommand();
		languageCodeMgr.saveLanguageCode(languageCode);
		super.postExecute(languageCode);
		return returnCommand();
	}
	
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

}
