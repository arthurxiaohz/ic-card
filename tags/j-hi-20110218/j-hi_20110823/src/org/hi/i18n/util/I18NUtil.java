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
	 * ���ݼ�ֵ����һ�������Ե��ַ���
	 * @param key ��ֵ
	 * @return
	 */
	public static String getString(String key )
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		return languageMgr.getLanguageStr(key,I18NUtil.getUserLanguageCode());
	}
	
	
	/**
	 * ���ݼ�ֵ��ʵ��������һ�������Ե��ַ���
	 * @param key ��ֵ
	 * @param entity ʵ������
	 * @return
	 */
	public static String getString(String key ,String entity )
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		return languageMgr.getLanguageStr(key,entity,I18NUtil.getUserLanguageCode());
	}
	
	/**
	 * �õ�һ���������ַ���������ʹ�ö������
	 * @param key ��ֵ
	 * @param parameterValues ���������ʹ��parameterValues����
	 * @return
	 */
	public static String getString(String key ,List<String> parameterValues)
	{
		return getString(key, null, parameterValues);
	}
	
	
	/**
	 * �õ�һ���������ַ���������ʹ�ö������
	 * @param key ��ֵ
	 * @param  entity ʵ������
	 * @param parameterValues ���������ʹ��parameterValues����
	 * @return
	 */
	public static String getString(String key ,String entity,List<String> parameterValues)
	{
		LanguageManager languageMgr  =  (LanguageManager)SpringContextHolder.getBean(Language.class);
		String languageStr = languageMgr.getLanguageStr(key,entity,I18NUtil.getUserLanguageCode());
		
		return replaceParameterValues(languageStr,parameterValues);
	}
	
	/**
	 * �õ�һ���������ַ���������ʹ��һ������
	 * @param key
	 * @param parameterValues һ����,���ŷָ����ַ��������б�
	 * @return
	 */
	public static String getStringByParameter(String key ,String parameterValues)
	{
		return getStringByParameter(key, null ,parameterValues);
	}
	
	/**
	 * �õ�һ���������ַ���
	 * @param key ��ֵ
	 * @param entity ʵ������
	 * @param parameterValues һ����,���ŷָ����ַ��������б�
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
		
//		���û�ҵ��û���ʹ�õ����֣�ȡ�������ϵ�ǰ����ϵͳ�Ĺ���������
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
	 * ���������ַ����е����в������滻����Ӧ��ֵ���Զ������ַ��еĲ���Ϊ׼�������Ӧ�Ĳ���û��ֵ���滻�ɿ��ַ���
	 * @param mlString ȡ���Ķ������ַ���
	 * @param parameterValues ����ֵ
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
		//����������������ֵ�����ͽ������Ĳ���Ԥ���ַ��滻�ɿ��ַ���
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
