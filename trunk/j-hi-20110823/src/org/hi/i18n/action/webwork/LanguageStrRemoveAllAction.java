package org.hi.i18n.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageStrManager;

public class LanguageStrRemoveAllAction extends BaseAction{
	private LanguageStr languageStr;
	private String orderIndexs;
	
	public String execute() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer languageStrid = new Integer( ids[i] );
				languageStrMgr.removeLanguageStrById(languageStrid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public LanguageStr getLanguageStr() {
		return languageStr;
	}

	public void setLanguageStr(LanguageStr languageStr) {
		this.languageStr = languageStr;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
