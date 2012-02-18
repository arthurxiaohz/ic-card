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
     * 保存之前的操作
     */
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }
    /**
     * 保存之后的操作
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
     * 删除之前的操作
     */
    protected void preRemoveObject(Object obj) {    	 
        super.preRemoveObject(obj);
    }
    /**
     * 删除之后的操作
     */
    protected void postRemoveObject(Object obj) {
    	EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
    	enumMgr.reloadEnumeration();
        super.postRemoveObject(obj);
    }
    /**
     * 保存一个枚举值实体
     */
    public void saveEnumerationValue(EnumerationValue enumerationValue){
    	EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
    	enumMgr.saveEnumeration(enumerationValue.getEnumeration());
    }
    /**
     * 根据ID删除枚举值对象
     */
    public void removeEnumerationValueById(Integer id){
    	EnumerationValue enumerationValue = this.getEnumerationValueById(id);
    	Enumeration enumeration = enumerationValue.getEnumeration();
    	enumeration.getEnumerationValues().remove(enumerationValue);
    	enumerationValue.setEnumeration(null);
    	this.removeObject(enumerationValue);
    	
    }
    /**
     * 根据ID查询枚举值对象
     */
    public EnumerationValue getEnumerationValueById(Integer id){
   		return (EnumerationValue) getObjectById(id);
    }
    /**
     * 返回枚举值列表
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
