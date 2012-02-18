package org.hi.framework.web.taglib;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.commons.collections.map.LinkedMap;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.Filter;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.PageInfoView;
import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagBuilderFactory;
import org.hi.framework.web.taglib.component.bean.SelectTagBean;

public class EntitySelectTag extends AbstractTag {
	private String entityName;
	private String title;
	private String key;
	private String filterName;
	private String filterStr;
	private String defaultValue;
	private String pageInfo;
	private String isAll;
	private String pattern;
	
	private String onEvent;
	
	public int doEndTag() throws JspException {
		evaluateParams();
		
		TagBuilder builder = TagBuilderFactory.getEntityTagBuilder();
		SelectTagBean bean = new SelectTagBean();
		bean.setDefaultValue(getDefaultValue(this.getName()));
		bean.setOnEvent(onEvent);
		Map resultMapping = new LinkedMap();
		if(needAll())
			resultMapping.put("", "È«²¿");
		Filter filter = this.getFilterObject();
		try {
			bean.setMapping(getContext(filter, resultMapping));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		bean.setParameters(this.getParameters());
		String html = builder.build(bean);
		try {
			pageContext.getOut().print(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bean.setParameters(this.getParameters());
		return EVAL_PAGE;
	}
	
	public Map getContext(Filter filter, Map resultMapping) throws ClassNotFoundException{
		List result = loadObjects(filter);
		if(result ==null || result.size() == 0)
			return resultMapping;
		for (Iterator i = result.iterator(); i.hasNext();) {
			Object element = (Object) i.next();
			Object key = BeanUtil.getPropertyValue(element, this.key);
			
			StringBuffer sb = new StringBuffer("");
			if(pattern == null || pattern.trim().equals("")){
				 sb.append(BeanUtil.getPropertyValue(element, this.title).toString());
			}
			else{

				List<String> titleUnits =StringUtils.strToArrayList(this.title, this.pattern);
				int step = 0;
				for (String titleUnit : titleUnits) {
					if(step >0)
						sb.append(this.pattern);
					
					sb.append(BeanUtil.getPropertyValue(element, titleUnit).toString());
					
					step++;
				}
			}
			
			resultMapping.put(key, sb.toString());
		}
		
		return resultMapping;
	}
	
	private boolean needAll() {
		return this.isAll != null && "true".equals(this.isAll);
	}
	
	
	public List loadObjects(Filter filter) throws ClassNotFoundException{
		ManagerImpl manager = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
		List result = manager.getObjects(Class.forName(entityName), filter);
		return result;
	}
	
	public Filter getFilterObject(){
		Filter filter = null;
		if(filterName != null && !filterName.trim().equals("")){
			Object obj = pageContext.getRequest().getAttribute(filterName);
			if(obj != null && obj instanceof Filter)
				filter = (Filter)obj;
		}
		
		Filter pageFilter = getPageInfoFilter();
		if(pageFilter != null && filter != null) 
			return filter.addFilter(pageFilter);
		if(pageFilter != null && filter == null)
			return pageFilter;
		
		return filter;
	}
	
	private Filter getPageInfoFilter(){
		Filter filter = null;
		if(pageInfo == null || pageInfo.trim().equals("") || this.filterStr == null || this.filterStr.trim().equals(""))
			return filter;
		PageInfoView pageInfo = null;
		try {
			pageInfo = (PageInfoView)Class.forName(this.pageInfo).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 String[] propertyArray = StringUtils.strToStrArray(this.filterStr);
		 for (String property : propertyArray) {
			 String propertyName = property.substring(0,property.indexOf("="));
			 String propertyValue = property.substring(property.indexOf("=")+1);
			 BeanUtil.ognlPropertyValue(pageInfo, propertyName, propertyValue);
		}
		filter = PageInfoUtil.populateFilter(pageInfo);
		return filter;
	}
	
	private String getDefaultValue(String fieldName) {
        int pointIndex = 0;
        pointIndex = fieldName.indexOf(".");
        if (pointIndex<=1 || pointIndex+1 >=fieldName.length() )
        	return "";
		String beanName = fieldName.substring( 0,fieldName.indexOf(".") );
		 String beanFieldName = fieldName.substring( fieldName.indexOf(".") +1 );
		 
		Object bean = pageContext.getRequest().getAttribute(beanName);
		if (bean == null )
			 return "";
	 Object returnValue = BeanUtil.getPropertyValue(bean,beanFieldName);
	  if (returnValue != null )
           return returnValue.toString();
	  else
		  return "";

	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getFilterStr() {
		return filterStr;
	}

	public void setFilterStr(String filterStr) {
		this.filterStr = filterStr;
	}

	public String getIsAll() {
		return isAll;
	}

	public void setIsAll(String isAll) {
		this.isAll = isAll;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getOnEvent() {
		return onEvent;
	}

	public void setOnEvent(String onEvent) {
		this.onEvent = onEvent;
	}
}
