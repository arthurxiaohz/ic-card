package org.hi.i18n.util;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.taglib.i18n.MLBean;
import org.hi.i18n.model.Language;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;
import org.hi.i18n.service.LanguageManager;

public class I18NUtil {
	

	/**
	 * 根据键值获最一个多语言的字符串
	 * @param key 键值
	 * @return
	 */
	public static String getString(String key )
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		return languageMgr.getLanguageStr(key,I18NUtil.getUserLanguageCode());
	}
	
	
	/**
	 * 根据键值与实体名获最一个多语言的字符串
	 * @param key 键值
	 * @param entity 实体名称
	 * @return
	 */
	public static String getString(String key ,String entity )
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		return languageMgr.getLanguageStr(key,entity,I18NUtil.getUserLanguageCode());
	}
	
	/**
	 * 得到一个多语言字符串，可以使用多个参数
	 * @param key 键值
	 * @param parameterValues 多个参数是使用parameterValues传递
	 * @return
	 */
	public static String getString(String key ,List<String> parameterValues)
	{
		return getString(key, null, parameterValues);
	}
	
	
	/**
	 * 得到一个多语言字符串，可以使用多个参数
	 * @param key 键值
	 * @param  entity 实体名称
	 * @param parameterValues 多个参数是使用parameterValues传递
	 * @return
	 */
	public static String getString(String key ,String entity,List<String> parameterValues)
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		String languageStr = languageMgr.getLanguageStr(key,entity,I18NUtil.getUserLanguageCode());
		
		return replaceParameterValues(languageStr,parameterValues);
	}
	
	/**
	 * 得到一个多语言字符串，可以使用一个参数
	 * @param key
	 * @param parameterValues 一个以,逗号分隔的字符串参数列表
	 * @return
	 */
	public static String getStringByParameter(String key ,String parameterValues)
	{
		return getStringByParameter(key, null ,parameterValues);
	}
	
	/**
	 * 得到一个多语言字符串
	 * @param key 键值
	 * @param entity 实体名称
	 * @param parameterValues 一个以,逗号分隔的字符串参数列表
	 * @return
	 */
	public static String getStringByParameter(String key ,String entity, String parameterValues)
	{
		if(parameterValues == null || parameterValues.equals(""))
			return getString(key, entity);
		
		List<String> _parameterValues= StringUtils.strToArrayList(parameterValues);
		return getString(key,entity, _parameterValues);
	}

	
	public static String getStringByLanguage(String xmlString,String languageCode)
	{
		if (xmlString== null || xmlString.length() ==0 || languageCode == null || languageCode.length()==0 )
			return "";
		 List<MLBean> mlBeans =getMLBeansByLanguageStr(xmlString);
		 if (mlBeans != null && mlBeans.size()>0)
			 for (MLBean mlBean : mlBeans) {
				if (languageCode.equals(mlBean.getLg() ))
					return mlBean.getVl();
			}
		return "";
	}
	
	public static List<MLBean> getMLBeansByLanguageStr(String xmlString)
	{
		 List<MLBean> result = new ArrayList<MLBean>();
		 List<String> subValues = StringUtils.subStringList(xmlString, "<ml>", "</ml>");
			for (String subValue : subValues) {
				String subXML = "<ml>"+subValue+"</ml>";
				try {
					Object obj = BeanUtil.getXML2Bean(subXML, MLBean.class);
					result.add((MLBean)obj);
					
				 
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			return result;
	}
	
	public static  String getUserLanguageCode() {
		String userLanguageCode = HiConfigHolder.getI18NLanguage();
		
//		如果没找到用户所使用的语种，取服务器上当前操作系统的国家与语种
		if(userLanguageCode == null || userLanguageCode.trim().equals("")){
			String language = System.getProperties().getProperty("user.language");
			String country =   System.getProperties().getProperty("user.country");
			userLanguageCode =  language+"_" +country ;
			
		}
		Integer languageCodeID = null;
		if(UserContextHelper.getUser() != null)	
			languageCodeID = UserContextHelper.getUser().getCountry();
		LanguageCodeManager languageMgr = (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
		if (languageCodeID != null && languageCodeID >0 )
		{
			LanguageCode languageCode = languageMgr.getLanguageCodeById(languageCodeID);
			if (languageCode != null && languageCode.getLanguageCode() != null && languageCode.getLanguageCode().trim().length() > 0 )
				userLanguageCode = languageCode.getLanguageCode();
		}
		 
		return userLanguageCode;
	}
	
	

	/**
	 * 将多语言字符串中的所有参数都替换成相应的值，以多语言字符中的参数为准，如果对应的参数没有值就替换成空字符串
	 * @param mlString 取出的多语言字符串
	 * @param parameterValues 参数值
	 */
	public static  String replaceParameterValues(String mlString,List<String> parameterValues) {
		if (mlString == null || mlString.equals("") || parameterValues == null || parameterValues.size()==0 )
			return mlString;
		int position=0;
		for (String parameterValue : parameterValues) {
			position ++;
			if ( mlString.indexOf("{") <0 )
				mlString = mlString + parameterValue;
			else
				mlString = mlString.replaceFirst("\\{"+position+"\\}", parameterValue);
			
		}
		//多个参数，如果参数值不够就将其他的参数预留字符替换成空字符串
		int leftParameterFlag = mlString.indexOf("{");
		int rightParameter = mlString.indexOf("}");
		
		while ( leftParameterFlag >=0 && ( rightParameter > leftParameterFlag) )
		{
			String parameterIndex= mlString.substring(leftParameterFlag+1,rightParameter);
			mlString = mlString.replaceFirst("\\{"+parameterIndex+"\\}", "");
			
			leftParameterFlag = mlString.indexOf("{");
			rightParameter = mlString.indexOf("}");
		}
		
		return mlString;
	}
	
	public static void main(String[] args)
	{
		
	
		java.util.Enumeration enum2 =System.getProperties().propertyNames();
		String language = System.getProperties().getProperty("user.language");
		String country =   System.getProperties().getProperty("user.country");
		   

		 System.out.println(language+"_" +country );
		
	}
		 
		
	

	

}
