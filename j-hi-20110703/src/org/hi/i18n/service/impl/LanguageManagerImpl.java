package org.hi.i18n.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.i18n.model.Language;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageCodeManager;
import org.hi.i18n.service.LanguageManager;
import org.springframework.beans.factory.InitializingBean;

public class LanguageManagerImpl extends ManagerImpl implements LanguageManager ,InitializingBean {
    
	private Map<String,Language> languageCache = Collections.synchronizedMap(new HashMap<String,Language>());
	
	protected void loadLanuage(){
		if(HiConfigHolder.getI18NLanguage() == null)	//�����֧�ֶ����ԾͲ���������
			return;
		
		List<Language> _languages = this.getObjects();
		languageCache.clear();
		for (Language _language : _languages) {
			
			Language language = new Language();
			BeanUtil.setBean2Bean(_language, language);
			
			String keyName = language.getEntity() == null || language.getEntity().trim().equals("") ? "" : (language.getEntity() + ".");
			keyName += language.getKeyStr();
			
			languageCache.put(keyName, language);
		}
	}
	
	protected void reloadLanuage(){
		if(HiConfigHolder.getPublished())
			return;
		loadLanuage();
	}
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);
        reloadLanuage();

    }

    protected void preRemoveObject(Object obj) {
    	if (  ( (Language)obj).getIsSystem() != null && ( (Language)obj).getIsSystem().intValue() ==1)
    		throw new RuntimeException("The system  language info can not  be remove!");
    	
    	
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        reloadLanuage();
        
    }
    
    public void saveLanguage(Language language){
    	saveObject(language);
    
    }

    public void removeLanguageById(Integer id){
    	removeObjectById(id);
    	
    }

    public Language getLanguageById(Integer id){
   		return (Language) getObjectById(id);
    }

    public List<Language> getLanguageList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityLanguage(Language language){
    	saveObject(language);
    
    }

    public void removeSecurityLanguageById(Integer id){
    	removeObjectById(id);
    	
    }

    public Language getSecurityLanguageById(Integer id){
   		return (Language) getObjectById(id);
    }

    public List<Language> getSecurityLanguageList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    /**
     * ����ϸ������û�е����Դ������ڴ�����ʱ���ӵ����Դ���
     */
	public void addLanguageStr(Language language) {
		if (language == null )
			return ;
		LanguageCodeManager codeMgr =  (LanguageCodeManager)SpringContextHolder.getBean(LanguageCode.class);
		List<LanguageCode> allCodes  = codeMgr.getObjects();
		if (allCodes == null )
			return ;
		for (LanguageCode languageCode: allCodes)
		{
			if  ( getLanguageStrByCode(language,languageCode.getLanguageCode()  ) == null  ) 
			{
				addLanguageStr(language,languageCode);
			}
		}
		
		
	}

	
	/**
	 *  ����ϸ���������Դ���
	 * @param language
	 * @param languageCode
	 */
	private void addLanguageStr(Language language, LanguageCode languageCode) {
		List<LanguageStr> allStr = language.getLanguageStrs();
		if (allStr == null )
		{
			allStr  = new ArrayList<LanguageStr>();
			language.setLanguageStrs(allStr);
		}
		LanguageStr str = new LanguageStr();
		str.setLanguageCode(languageCode.getLanguageCode());
		allStr.add(str);
	}

	/**
	 * ͨ�����Դ���õ����language��������ϸ���ж�Ӧ��ֵ
	 * @param language
	 * @param languageCode
	 * @return
	 */
	private String getLanguageStrByCode(Language language, String languageCode) {
		List<LanguageStr> allStr = language.getLanguageStrs();
		if (allStr == null || allStr.size() ==0 )
			return null;
		for(LanguageStr languageStr :  allStr )
		{
			if ( languageStr.getLanguageCode() != null && 
					languageStr.getLanguageCode().equals( languageCode ))
			{
				if (languageStr.getValue() == null )// ����˵������������Ե�ֵ����˾Ͳ��ܷ��ؿ�
					return "";
				else
					return languageStr.getValue();
			}
			
		}
		return null;
	}

	
	/**
	 * ͨ��key�����Դ����ҵ��������ַ��� ���û�оͷ���key
	 */
	public String getLanguageStr(String key, String languageCode) {
		return getLanguageStr(  key,   null,   languageCode);
		
	}

	public void afterPropertiesSet() throws Exception {
		loadLanuage();
	}

	
	
	public String getLanguageStr(String key, String entity, String languageCode) {
		String keyName ="";
		
		if (entity == null || entity.equals(""))
				keyName= key;
		else
				keyName = entity + "." + key;
		 
		Language language = languageCache.get(keyName);
		
		if (language == null )
			return key;
		
		String langStr = getLanguageStrByCode( language ,languageCode) ;
		
		if (langStr == null || langStr.equals("") )
			return key;
		else
			return langStr;
		
	}    
	
	
	
}
