package org.hi.i18n.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.i18n.model.LanguageStr;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.i18n.service.LanguageStrManager;

public class LanguageStrManagerImpl extends ManagerImpl implements LanguageStrManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveLanguageStr(LanguageStr languageStr){
    	saveObject(languageStr);
    
    }

    public void removeLanguageStrById(Integer id){
    	removeObjectById(id);
    	
    }

    public LanguageStr getLanguageStrById(Integer id){
   		return (LanguageStr) getObjectById(id);
    }

    public List<LanguageStr> getLanguageStrList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityLanguageStr(LanguageStr languageStr){
    	saveObject(languageStr);
    
    }

    public void removeSecurityLanguageStrById(Integer id){
    	removeObjectById(id);
    	
    }

    public LanguageStr getSecurityLanguageStrById(Integer id){
   		return (LanguageStr) getObjectById(id);
    }

    public List<LanguageStr> getSecurityLanguageStrList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
