package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;

public class LanguageRemoveAllAction extends BaseAction{
	private Language language;
	private String orderIndexs;
	
	public String execute() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer languageid = new Integer( ids[i] );
				languageMgr.removeLanguageById(languageid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
