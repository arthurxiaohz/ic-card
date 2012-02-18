package org.hi.framework.web.taglib.i18n;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;

import org.hi.SpringContextHolder;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.taglib.AbstractTag;
import org.hi.i18n.model.Language;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;
import org.hi.i18n.service.LanguageManager;
import org.hi.i18n.util.I18NUtil;

/**
 * 取多语言的标签
 * @author xiao
 *
 */
public class TextTag extends AbstractTag {
	
	public String key ;
	private String languageCode;
	public String parameterValues;
	public String parameterLanguageKeys;
	public String entity;
	
	public int doEndTag() throws JspException {
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		List<String> parameterValues = getParameterValues();
		String _languageCode = "";
		String returnStr="";
		if (key != null || !key.equals(""))
		{
			if(languageCode == null || languageCode.equals("") )
				_languageCode = I18NUtil.getUserLanguageCode();
			else
				_languageCode = languageCode;
			if (entity != null && !entity.equals("") )
			{
				returnStr = languageMgr.getLanguageStr(key,entity,_languageCode);
			}else
			{
				returnStr = languageMgr.getLanguageStr(key,_languageCode);
			}
			
			
			returnStr = I18NUtil.replaceParameterValues(returnStr,parameterValues);
			
		}
			 
		
		try {
			pageContext.getOut().print(returnStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	

	/**
	 * 在request对象中得到参数值，先从parameterValueListKey里面取，如果没有再从parameterValueKeys里面取
	 * @return
	 */
	private List<String> getParameterValues() {
		if (parameterValues != null && !parameterValues.equals(""))
		{
			List<String> valueList = new ArrayList<String>() ;
			String[] parameterValue_arr= parameterValues.split(",");
			for (int i = 0; i < parameterValue_arr.length; i++) {
				valueList.add(parameterValue_arr[i]);
			}
			
			return valueList;
		}
		else if (parameterLanguageKeys != null && !parameterLanguageKeys.equals(""))
		{
			LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
			List<String> valueList = new ArrayList<String>() ;
			String[] parameterLanguageKey_arr= parameterLanguageKeys.split(",");
			for (int i = 0; i < parameterLanguageKey_arr.length; i++) {
				String languageStr = languageMgr.getLanguageStr(parameterLanguageKey_arr[i],languageCode);
				valueList.add(languageStr);
			}
			return valueList;
		}
		return null;
	}




	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getLanguageCode() {
		return languageCode;
	}


	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}



 

	public String getParameterLanguageKeys() {
		return parameterLanguageKeys;
	}



	public void setParameterLanguageKeys(String parameterLanguageKeys) {
		this.parameterLanguageKeys = parameterLanguageKeys;
	}



	public void setParameterValues(String parameterValues) {
		this.parameterValues = parameterValues;
	}
	
	public String getEntity() {
		return entity;
	}



	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	
	

}
	