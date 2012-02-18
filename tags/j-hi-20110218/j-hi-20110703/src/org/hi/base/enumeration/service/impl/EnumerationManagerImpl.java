package org.hi.base.enumeration.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hi.base.enumeration.dao.EnumerationDAO;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.service.EnumerationManager;
import org.hi.common.util.BeanUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.impl.ManagerImpl;

public class EnumerationManagerImpl extends ManagerImpl implements EnumerationManager{
    
	protected List<Enumeration> enumerations = Collections.synchronizedList(new ArrayList<Enumeration>());
	
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
    	loadEnumeration();

    }
    /**
	 * 删除之前的操作
	 */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
	 * 删除之前的操作
	 */
    protected void postRemoveObject(Object obj) {
    	loadEnumeration();
        
    }
    /**
     * 保存一个枚举实体
     */
    public void saveEnumeration(Enumeration Enumeration){
    	saveObject(Enumeration);
    
    }
    /**
     * 根据ID删除枚举对象
     */
    public void removeEnumerationById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * 根据ID查询
     */
    public Enumeration getEnumerationById(Integer id){
   		return (Enumeration) getObjectById(id);
    }
    /**
     * 取得页面展示枚举列表
     */
    public List<Enumeration> getEnumerationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    
    //zhanghao
    protected void loadEnumeration(){
    	List<Enumeration> _enumerations = new ArrayList<Enumeration>();
    	
    	_enumerations = this.getObjects();
    	synchronized(enumerations){
    			enumerations.clear();
	    	for (Enumeration _enumeration : _enumerations) {
	    		Enumeration enumeration = new Enumeration();
	    		BeanUtil.setBean2Bean(_enumeration, enumeration);
	    		enumerations.add(enumeration);
			}
    	}
    }
    
	public List<Enumeration> getEnumerations() {
		if(enumerations.size() == 0 || !HiConfigHolder.getPublished())
			loadEnumeration();
		
		return enumerations;
	}
    
	public void reloadEnumeration(){
		loadEnumeration();
	}
	
	/**
	 * 保存一个安全枚举实体
	 */
    public void saveSecurityEnumeration(Enumeration enumeration){
    	saveObject(enumeration);
    }
    public void removeSecurityEnumerationById(Integer id){
    	removeObjectById(id);
    }
    public Enumeration getSecurityEnumerationById(Integer id){
    	return (Enumeration) getObjectById(id);
    }
    public List<Enumeration> getSecurityEnumerationList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
}
