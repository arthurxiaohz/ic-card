package org.hi.base.menu.model;

import org.hi.base.menu.model.original.MenuAbstract;
import org.hi.framework.HiConfigHolder;
import org.hi.i18n.util.I18NUtil;


public class Menu extends MenuAbstract{
	
	public String getDisplay(){
		if(HiConfigHolder.getI18NLanguage() == null)
			return this.description;
		return I18NUtil.getString(this.displayRef);
	}

}