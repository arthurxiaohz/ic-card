package org.hi.framework.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.paging.impl.PageImpl;
import org.hi.framework.paging.impl.PageInfoImpl;
import org.hi.framework.security.acegi.MethodConfigAttributeDefHolder;
import org.hi.framework.security.context.UserContextHelper;

public class ManagerImpl extends AbstractBaseManager {
	protected Class modelClass = null;

	/* modelClass是从spring配置文件中配置的属性值获得
	 * @see org.hi.framework.service.Manager#getModelClass()
	 */
	public Class getModelClass() {
		return modelClass;
	}

	public void setModelClass(Class modelClass) {
		this.modelClass = modelClass;
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#removeObjectById(java.io.Serializable)
	 */
	public void removeObjectById(Serializable id) {
		this.removeObjectById(modelClass, id);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjectById(java.io.Serializable)
	 */
	public Object getObjectById(Serializable id) {
		return this.getObjectById(this.modelClass, id);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getUniqueObject(org.hi.framework.dao.Filter)
	 */
	public Object getUniqueObject(Filter filter) {
		return this.getUniqueObject(this.modelClass, filter);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjects()
	 */
	public List getObjects() {
		return this.getObjects(this.modelClass);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjects(org.hi.framework.dao.Filter)
	 */
	public List getObjects(Filter filter) {
		return this.getObjects(this.modelClass, filter);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjects(org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter)
	 */
	public List getObjects(Filter filter, Sorter sorter) {
		return this.getObjects(this.modelClass, filter, sorter);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjects(org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter, org.hi.framework.paging.Page)
	 */
	public List getObjects(Filter filter, Sorter sorter, Page page) {
		return this.getObjects(this.modelClass, filter, sorter, page);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getObjects(org.hi.framework.paging.PageInfo)
	 */
	public List getObjects(PageInfo pageInfo) {
		return this.getObjects(this.modelClass, pageInfo);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#getList(org.hi.framework.paging.PageInfo)
	 */
	public List getList(PageInfo pageInfo) {
		return this.getObjects(this.modelClass, pageInfo);
	}
	
	public int getObjectCount(){
		return getObjectCount(this.modelClass);
	}
	
	public int getObjectCount(Filter filter){
		return dao.getObjectCount(this.modelClass, filter);
	}
	
	/**
	 * 当Suggest Lookup时也就是在联想查找时通过该方法返回结果记录
	 * @param clazz 待查找的POJO类
	 * @param value 查找的值
	 * @param searchFields_str 属性名字符串列表以逗号分隔
	 * @param authorityNames 权限名字符串列表以逗号分隔
	 * @return 返回联想下拉的结果集的POJO对象集合
	 */
	public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str,String authorityNames ){
		return getObjectsForLookup(clazz, value, searchFields_str, authorityNames, null);
	}
	
	/**
	 * 当Suggest Lookup时也就是在联想查找时通过该方法返回结果记录
	 * @param clazz 待查找的POJO类
	 * @param value 查找的值
	 * @param searchFields_str 属性名字符串列表以逗号分隔
	 * @param authorityNames 权限名字符串列表以逗号分隔
	 * @param pageInfo 返回的解决集条数与辅加的过滤条件
	 * @return 返回联想下拉的结果集的POJO对象集合
	 */
	public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str,String authorityNames, PageInfo pageInfo ) {
	    String[] searchFields = searchFields_str.split(",");

	    Filter filter = null;
	    
	    if (value != null && !value.equals(""))
	    for(int i=0;i<searchFields.length ; i++ )
	    {
	    	if (filter == null )
	    		filter = FilterFactory.getSimpleFilter (searchFields[i] ,value );
	    	else
	    		filter.addCondition(searchFields[i] ,value,null,Filter.RELATION_OR);
	    }
	     
	    if (authorityNames != null && !authorityNames.equals(""))  // 权限名列表
	    {
	    	MethodConfigAttributeDefHolder.createConfigAttributeDefinition(authorityNames);
	    	Filter privileteFilter = FilterFactory.getSecurityFilter();
	    	MethodConfigAttributeDefHolder.setConfigAttributeDefinition(null);
	    	if (filter == null )
	    		filter = privileteFilter;
	    	else
	    		filter.addFilter(privileteFilter, Filter.RELATION_AND) ;
	    		
	    }
	    
	    if(pageInfo == null){
		    pageInfo = new PageInfoImpl();
		    Page page = new PageImpl();
		    pageInfo.setFilter(filter);
		    pageInfo.setPage(page);
	    }
	    else{
	    	pageInfo.setFilter(filter);
	    }
		List list = getObjects(clazz, pageInfo);
	 
		return (List<Object>)list;
	}
}
