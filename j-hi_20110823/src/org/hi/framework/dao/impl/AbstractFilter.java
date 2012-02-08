package org.hi.framework.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.dao.Filter;
import org.hi.framework.service.Manager;

/**
 *
 */
/**
 * @author hao.zhang
 *
 */
public abstract class AbstractFilter implements Filter {
	
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 其作用是在<code>Filter</code>与相应的ORM中做数据转换
	 */
	protected List<FilterBean> conditions = new ArrayList<FilterBean>();
	
	protected List<List<FilterBean>> filterGroup = new ArrayList<List<FilterBean>>();
	

	protected String aliasName;

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String toString(){
		StringBuffer strBuf = new StringBuffer();
		for (List<FilterBean>  group : filterGroup) {
			if(filterGroup.size() > 1)
				strBuf.append("[");
			for (FilterBean filterBean : group) {
				strBuf.append("[");
				strBuf.append("name:").append(filterBean.getFieldName()).append(",");
				strBuf.append("operater:").append(filterBean.getOperater()).append(",");
				strBuf.append("value:").append(filterBean.getValue() == null ? "null" :filterBean.getValue().toString()).append(",");
				strBuf.append("realtion:").append(filterBean.getRelations()).append(",");
				strBuf.append("not:").append(filterBean.isNot()).append(",");
				strBuf.append("likeControler:").append(filterBean.getLikeControler());
				strBuf.append("]");
			}
			if(filterGroup.size() > 1)
				strBuf.append("]");
			
		}
		if(filterGroup.size() == 0){
			for (FilterBean filterBean : conditions) {
				strBuf.append("[");
				strBuf.append("name:").append(filterBean.getFieldName()).append(",");
				strBuf.append("operater:").append(filterBean.getOperater()).append(",");
				strBuf.append("value:").append(filterBean.getValue() == null ? "null" :filterBean.getValue().toString()).append(",");
				strBuf.append("realtion:").append(filterBean.getRelations()).append(",");
				strBuf.append("not:").append(filterBean.isNot()).append(",");
				strBuf.append("likeControler:").append(filterBean.getLikeControler());
				strBuf.append("]");
			}
			
		}
		return strBuf.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#getConditions()
	 */
	public List<FilterBean> getConditions() {
		return conditions;
	}
	
    /* (non-Javadoc)
     * @see org.hi.framework.dao.Filter#addFilter(org.hi.framework.dao.Filter)
     */
    public Filter addFilter(Filter otherFilter){
    	return addFilter(otherFilter, Filter.RELATION_AND);
    }
    
    /* (non-Javadoc)
     * @see org.hi.framework.dao.Filter#addFilter(org.hi.framework.dao.Filter, java.lang.String)
     */
    public Filter addFilter(Filter otherFilter, String relation){
    	if(otherFilter == null || otherFilter.getConditions() == null || otherFilter.getConditions().size() < 1)
    		return this;
    	if(otherFilter.getAliasName() != null && !otherFilter.getAliasName().trim().equals(""))
    		this.aliasName = otherFilter.getAliasName();
    	
    	if(relation == null)
    		relation = Filter.RELATION_AND;

    	String otherStr = otherFilter.toString();
    	List<FilterBean> conditions = otherFilter.getConditions();
    	
    	if(filterGroup.size() == 0 && this.conditions.size() != 0){
    		List<FilterBean> mainConditions = new ArrayList<FilterBean>();
    		mainConditions.addAll(this.conditions);
    		filterGroup.add(mainConditions);
    	}
    	
    	List<List<FilterBean>> otherGroup = otherFilter.getFilterGroup();
    	if(otherGroup.size() > 1)
	    	for (List<FilterBean> group : otherGroup) {
	    		filterGroup.add(group);
			}
    	else
    		filterGroup.add(conditions);
    	
    	for (int i = 0; i <conditions.size(); i++) {
			FilterBean filterBean = (FilterBean) conditions.get(i);
			
			if(i == 0)
				filterBean.setRelations(relation);
			
			this.conditions.add(filterBean);
		}
    	
    	return this;
    
    }
    
    public void removeFilter(Filter subFilter){
    	if(subFilter == null || subFilter.getConditions() == null || subFilter.getConditions().size() < 1)
    		return;
    	if(this.conditions == null || this.conditions.size() < 1)
    		return;
    	
    	for (Iterator iterator = subFilter.getConditions().iterator(); iterator.hasNext();) {
			FilterBean subFilterBean = (FilterBean) iterator.next();
			
			for (Iterator iterator2 = conditions.iterator(); iterator2.hasNext();) {
				FilterBean filterBean = (FilterBean) iterator2.next();
				
				if(!subFilterBean.equals(filterBean))
					continue;
				
//				删除filterBean
				iterator2.remove();
				conditions.remove(filterBean);
				
//				删除group
				for (Iterator iterator3 = this.filterGroup.iterator(); iterator3.hasNext();) {
					List<FilterBean> filterBeanList = (List<FilterBean>) iterator3.next();
					for (FilterBean gFilterBean : filterBeanList) {
						if(gFilterBean == filterBean){
							iterator3.remove();
							this.filterGroup.remove(filterBeanList);
						}
					}
				}
				
			}
			
		}
    	
    }
    
    
    public List<List<FilterBean>> getFilterGroup(){
    	return this.filterGroup;
    }
    
    public String getSQL(Manager manager){
    	if(manager == null)
    		return null;
    	if(manager.getDAO().getDialect() == null)
    		return null;
    	
    	return manager.getDAO().getDialect().getFilterSQL(this, manager);
    	
    }
}
