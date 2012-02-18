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
	 * ����֮ǰ�Ĳ���
	 */
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }
    /**
     * ����֮��Ĳ���
     */
    protected void postSaveObject(Object obj) {
    	loadEnumeration();

    }
    /**
	 * ɾ��֮ǰ�Ĳ���
	 */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
	 * ɾ��֮ǰ�Ĳ���
	 */
    protected void postRemoveObject(Object obj) {
    	loadEnumeration();
        
    }
    /**
     * ����һ��ö��ʵ��
     */
    public void saveEnumeration(Enumeration Enumeration){
    	saveObject(Enumeration);
    
    }
    /**
     * ����IDɾ��ö�ٶ���
     */
    public void removeEnumerationById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * ����ID��ѯ
     */
    public Enumeration getEnumerationById(Integer id){
   		return (Enumeration) getObjectById(id);
    }
    /**
     * ȡ��ҳ��չʾö���б�
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
	 * ����һ����ȫö��ʵ��
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
