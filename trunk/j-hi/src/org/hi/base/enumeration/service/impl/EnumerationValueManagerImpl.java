package org.hi.base.enumeration.service.impl;

import java.util.Iterator;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.enumeration.service.EnumerationManager;
import org.hi.base.enumeration.service.EnumerationValueManager;

public class EnumerationValueManagerImpl extends ManagerImpl implements EnumerationValueManager{
    /**
     * ����֮ǰ�Ĳ���
     */
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }
    /**
     * ����֮��Ĳ���
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
     * ɾ��֮ǰ�Ĳ���
     */
    protected void preRemoveObject(Object obj) {    	 
        super.preRemoveObject(obj);
    }
    /**
     * ɾ��֮��Ĳ���
     */
    protected void postRemoveObject(Object obj) {
    	EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
    	enumMgr.reloadEnumeration();
        super.postRemoveObject(obj);
    }
    /**
     * ����һ��ö��ֵʵ��
     */
    public void saveEnumerationValue(EnumerationValue enumerationValue){
    	EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
    	enumMgr.saveEnumeration(enumerationValue.getEnumeration());
    }
    /**
     * ����IDɾ��ö��ֵ����
     */
    public void removeEnumerationValueById(Integer id){
    	EnumerationValue enumerationValue = this.getEnumerationValueById(id);
    	Enumeration enumeration = enumerationValue.getEnumeration();
    	enumeration.getEnumerationValues().remove(enumerationValue);
    	enumerationValue.setEnumeration(null);
    	this.removeObject(enumerationValue);
    	
    }
    /**
     * ����ID��ѯö��ֵ����
     */
    public EnumerationValue getEnumerationValueById(Integer id){
   		return (EnumerationValue) getObjectById(id);
    }
    /**
     * ����ö��ֵ�б�
     */
    public List<EnumerationValue> getEnumerationValueList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    public void saveSecurityEnumerationValue(EnumerationValue enumerationValue){
    	saveObject(enumerationValue);
    }
    public void removeSecurityEnumerationValueById(Integer id){
    	removeObjectById(id);
    }
    public EnumerationValue getSecurityEnumerationValueById(Integer id){
    	return (EnumerationValue) getObjectById(id);
    }
    public List<EnumerationValue> getSecurityEnumerationValueList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
}
