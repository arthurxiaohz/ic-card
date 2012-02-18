package org.hi.base.enumeration.model;

import org.hi.base.enumeration.model.original.EnumerationAbstract;
import org.hi.framework.HiConfigHolder;
import org.hi.i18n.util.I18NUtil;


public class Enumeration extends EnumerationAbstract{
    /**
     * ∂‡”Ô—‘÷ß≥÷
     */
	public String getDescription(){
		if(HiConfigHolder.getI18NLanguage() == null)
   		 return this.description;
		
		return I18NUtil.getString(this.displayRef);
	}

}