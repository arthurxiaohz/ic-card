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
	public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str,String privilege ){
		return getObjectsForLookup(clazz, value, searchFields_str, privilege, null);
	}
	
	public List<Object> getObjectsForLookup(Class clazz, String value, String searchFields_str,String privilege, PageInfo pageInfo ) {
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
	     
	    if (privilege != null && privilege.equals("0"))  // 增加权限控制 如果为0 就代表需要做用户级权限控制
	    {
	    	Filter privileteFilter = FilterFactory.getSimpleFilter ("creator", UserContextHelper.getUserId() );
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
