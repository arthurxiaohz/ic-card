package org.hi.i18n.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hi.common.util.BeanUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.i18n.model.LanguageCode;
import org.hi.i18n.service.LanguageCodeManager;
import org.springframework.beans.factory.InitializingBean;

public class LanguageCodeManagerImpl extends ManagerImpl implements LanguageCodeManager, InitializingBean{
	private Map<Integer,LanguageCode> languageCodeCache = Collections.synchronizedMap(new HashMap<Integer,LanguageCode>());
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);
        reLoadLanguageCode();

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        reLoadLanguageCode();
        
    }
    
    public void saveLanguageCode(LanguageCode languageCode){
    	saveObject(languageCode);
    
    }

    public void removeLanguageCodeById(Integer id){
    	removeObjectById(id);
    	
    }

    public LanguageCode getLanguageCodeById(Integer id){
    	if(HiConfigHolder.getI18NLanguage() == null)
    		return (LanguageCode) getObjectById(id);
    	
    	return languageCodeCache.get(id);
    }

    public List<LanguageCode> getLanguageCodeList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityLanguageCode(LanguageCode languageCode){
    	saveObject(languageCode);
    
    }

    public void removeSecurityLanguageCodeById(Integer id){
    	removeObjectById(id);
    	
    }

    public LanguageCode getSecurityLanguageCodeById(Integer id){
    	return (LanguageCode) getObjectById(id);
    	
    }

    public List<LanguageCode> getSecurityLanguageCodeList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

	public List<String> getAllLanguageCode() {
		List<String> allLanguageCodes =new ArrayList<String>();
		if(HiConfigHolder.getI18NLanguage() == null)
			return allLanguageCodes;

		Collection<LanguageCode> allLanguageCode = languageCodeCache.values();
		for (LanguageCode languageCode : allLanguageCode) {
			if (languageCode.getLanguageCode()!= null && !languageCode.equals("") )
				allLanguageCodes.add(languageCode.getLanguageCode());
		}
		return allLanguageCodes;
	}
	
	protected void reLoadLanguageCode(){
		if(HiConfigHolder.getPublished())	//发布模式下将不再重载数据
			return;
		
		loadLanguageCode();
	}
	
	protected void loadLanguageCode(){
		if(HiConfigHolder.getI18NLanguage() == null)	//如果不支持多语言就不加载数据
			return;
		
		List<LanguageCode> _languages = this.getObjects();
		languageCodeCache.clear();
		for (LanguageCode _language : _languages) {
			
			LanguageCode language = new LanguageCode();
			BeanUtil.setBean2Bean(_language, language);
			
			languageCodeCache.put(language.getId(), language);
		}
	}
	public void afterPropertiesSet() throws Exception {
		loadLanguageCode();
	}    
}
