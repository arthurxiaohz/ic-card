package org.hi.framework.web;

import java.beans.PropertyDescriptor;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.paging.impl.PageInfoImpl;

/**
 * 该类是一个工具类其目的是对表现层送过来的对象做进一步处理
 * 如<code>populate()</code>方法是对表现层送过来的<code>PageInfoView</code>
 * 重新封装为PageInfo对象,再如<code>populateFilter()</code>方法是对表现层送过来
 * <code>PageInfoView</code>对象封装为<code>Filter</code>对象并返回
 * 
 * @author 张昊
 * @since 2007-7-15
 * @see org.hi.framework.paging.PageInfo
 * @see org.hi.framework.web.PageInfoView
 * @ses org.hi.framework.dao.Filter
 */
public class PageInfoUtil {
	
	/**
	 * 表现层送过来的<code>PageInfoView</code>重新封装为PageInfo对象,并返回
	 * @param pageInfoView 表现层送过来的对象,其主要过滤与排序信息
	 * @param action 当前执行的action动作,如果没有该参数，则在编辑或浏览将不保留查询条件
	 * @return 返回重新封装后的PageInfo对象
	 * @see org.hi.framework.web.PageInfoView
	 */
	public static PageInfo populate(PageInfoView pageInfoView,Action action){
		
		if(pageInfoView == null)
			pageInfoView = new PageInfoView();
		
		PageInfo pageInfo = new PageInfoImpl();
	
		/******Page部分*****/
		if(pageInfoView.getCurrentPage()  != 1)
			pageInfoView.setIsFristPage(false);
		
		if(pageInfoView.getIsFristPage())
			pageInfoView.setCurrentPage(1);
		
		if(pageInfoView.getIsLastPage())
			pageInfoView.setCurrentPage(pageInfoView.getTotalPage());
		//当前页面的第一条记录对于总记录数的位置
		pageInfoView.setStartRowPosition((pageInfoView.getCurrentPage()-1) * pageInfoView.getPageSize());
		
		int realRecords = pageInfoView.getStartRowPosition() + pageInfoView.getPageSize();
		
		//如果最大限记录数小于真实记录数,则取最大限记录数
		realRecords = pageInfoView.getMaxRecords() != 0 && pageInfoView.getMaxRecords() < realRecords ? pageInfoView.getMaxRecords() : realRecords; 
		
		pageInfoView.setEndRowPosition(realRecords);
		pageInfo.setPage(pageInfoView);
		
		
		/******Filter部分*****/
		Filter filter = null;
		filter = populateFilter(pageInfoView, "");
		
		if(HiConfigHolder.getViewMode().equals("classic"))  //只有经典版才会做session的翻页处理
			sessionProcess(action, pageInfoView, filter);
			
		
		if(filter == null)
			filter =  FilterFactory.getSimpleFilter(null, null, null);
		
		pageInfo.setFilter(filter);
		

		/******Sorter部分*****/
		Sorter sorter = null;
		if(BeanUtil.getPropertyValueToStr(pageInfoView,"sorterName") != null){
			String sorterName = BeanUtil.getPropertyValueToStr(pageInfoView,"sorterName");
			String direction = BeanUtil.getPropertyValueToStr(pageInfoView,"sorterDirection");
			sorter = SorterFactory.getSimpleSort(sorterName, direction);
		}
		
		pageInfo.setSorter(sorter);
		
		return pageInfo;
	}
	
	
//	将pageInfo的信息放到session中或是从session中取pageInfo,从而保证编辑后仍能回到当前页，而非第一页
	protected static void sessionProcess(Action action, PageInfoView pageInfoView, Filter filter) {
		if(action == null)
			return;

		HttpSession session = action.getSession();
		String prefix = "Hi_ListPageInfo_";
		String actionClassName = action.getClass().getName();
		String sessionAttributeName = prefix+actionClassName;
		boolean isUpdate = false;
		for(Enumeration<String> en = session.getAttributeNames(); en.hasMoreElements();){
			String attribName = en.nextElement();
			if(!attribName.startsWith(prefix)) //如果前缀不同
				continue;
			
			if(!attribName.equals(sessionAttributeName)){	//如果属性名不同，就表明切换到当前的list
				isUpdate = true;
				session.removeAttribute(attribName);
				session.setAttribute(sessionAttributeName, pageInfoView);
				break;
			}
			
			//如果属性名相同，则表示最近访问过页面，并从其它页面跳转回来
			if(attribName.equals(sessionAttributeName) && filter == null && pageInfoView.getSorterName() == null && pageInfoView.getIsFristPage()){ 
				isUpdate = true;
				PageInfoView o_pageView = (PageInfoView)session.getAttribute(sessionAttributeName);
				
				PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pageInfoView);
				for (PropertyDescriptor descriptor : properties) {
					String propertyName = descriptor.getName();
					if(!propertyName.startsWith("f_"))
						continue;
					Object o_value = BeanUtil.getPropertyValue(o_pageView, propertyName);
					BeanUtil.setPropertyValue(pageInfoView, propertyName, o_value);
				}
				
				pageInfoView.setCurrentPage(o_pageView.getCurrentPage());
				pageInfoView.setEndRowPosition(o_pageView.getEndRowPosition());
				pageInfoView.setMaxRecords(o_pageView.getMaxRecords());
				pageInfoView.setPageSize(o_pageView.getPageSize());
				pageInfoView.setSorterDirection(o_pageView.getSorterDirection());
				pageInfoView.setSorterName(o_pageView.getSorterName());
				pageInfoView.setStartRowPosition(o_pageView.getStartRowPosition());
				pageInfoView.setTotalPage(o_pageView.getTotalPage());
				pageInfoView.setTotalRecords(o_pageView.getTotalRecords());
				
				filter = populateFilter(o_pageView, "");
				break;
			}
		}
		//第一次访问list，或者以前访问过但本查询没有带查询项
		if(!isUpdate)
			session.setAttribute(sessionAttributeName, pageInfoView);
	}
	
	/**
	 * 表现层送过来的<code>PageInfoView</code>重新封装为PageInfo对象,并返回
	 * @param pageInfoView 表现层送过来的对象,其主要过滤与排序信息
	 * @return 返回重新封装后的PageInfo对象
	 * @see org.hi.framework.web.PageInfoView
	 */	
	public static PageInfo populate(PageInfoView pageInfoView){
		return populate(pageInfoView, null);
	}
	
	
	/**
	 * 表现层送过来的<code>PageInfoView</code>封装为Filter对象,并返回
	 * @param pageInfoView  表现层送过来的对象,其主要过滤与排序信息
	 * @return 返回一个过滤器
	 * @see org.hi.framework.web.PageInfoView
	 */
	public static Filter populateFilter(PageInfoView pageInfoView){
		return populateFilter(pageInfoView, "");
	}
	
	
	/**
	 * 表现层送过来的<code>PageInfoView</code>封装为Filter对象,并返回
	 * @param pageInfoView  表现层送过来的对象,其主要过滤与排序信息
	 * @param prefix 查询域的前缀
	 * @return 返回一个过滤器
	 * @see org.hi.framework.web.PageInfoView
	 */
	protected static Filter populateFilter(PageInfoView pageInfoView, String prefix){
		Filter filter = null;
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pageInfoView);
		
		//处理以f_开头的过滤域
		Map<String, PropertyDescriptor> nameAndpd = new LinkedHashMap<String, PropertyDescriptor>();
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			if(propertyName.startsWith("f_")){
				nameAndpd.put(propertyName, descriptor);
			}
		}
		
		Set<String>propertyNames = nameAndpd.keySet();
		
		for (String propertyName : propertyNames) {
			
			//如果属性名是操作符
			if(propertyName.endsWith("_op"))
				continue;
			
			//如果值为空或是空串
			Object filterValue = BeanUtil.getPropertyValue(pageInfoView, propertyName);
			if(filterValue == null)
				continue;
			if (filterValue instanceof String) {
				String valStr = (String) filterValue;
				if(valStr.trim().equals(""))
					continue;
				
				filterValue = StringUtils.trimRight(valStr); //去除字符串右侧的空格
			}
				
			String operator = propertyName + "_op";
			String operatorValue = BeanUtil.getPropertyValueToStr(pageInfoView, operator);
			if(operatorValue != null && operatorValue.trim().equals(""))
				operatorValue = null;
			
			//如果有重名查询，如日期区间，则以01 02/03/04为属性定名
			String filterName;
			int manyIndex = propertyName.lastIndexOf("0");
			if(manyIndex < 0)
				filterName = propertyName.substring("f_".length());
			else
				filterName = propertyName.substring("f_".length(),manyIndex);
			
			//如果是lookup型的将$替换为.以实现domain对象的查询
			filterName = filterName.replaceAll("[$]", ".");
			
			if(filter == null)
				filter = FilterFactory.getSimpleFilter(prefix+filterName, filterValue, operatorValue);
			else{
				if(filterValue instanceof Timestamp && manyIndex >=0){	//只有是日期区间后面的才加出23小时
					Timestamp timestamp = (Timestamp)filterValue;
					filterValue = new Timestamp(timestamp.getTime() + 24*60*60*1000 - 1);
				}
				else if(filterValue instanceof Date && manyIndex >=0){  
					Date date = (Date)filterValue;
					filterValue = new Date(date.getTime() + 24*60*60*1000 - 1);
				}
				
				filter.addCondition(prefix+filterName, filterValue, operatorValue);
			}
		}
		
		//处理domainObject的过滤部分
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			Object obj = BeanUtil.getPropertyValue(pageInfoView, propertyName);
			if(obj != null && obj instanceof PageInfoView){
				PageInfoView pageInfo = (PageInfoView)obj;
				String pageInfoPrefix = propertyName + ".";
				if(!prefix.trim().equals(""))
					pageInfoPrefix = prefix + pageInfoPrefix;
				
				if(filter == null)
					filter =  FilterFactory.getSimpleFilter(null, null, null);
				filter.addFilter(populateFilter(pageInfo, pageInfoPrefix));
			}
		}
		
		return filter;

	}
	
	/**
	 * 如果给定对象的属性中有Lookup类型的,而且该对象的主键为null,则将这个
	 * 属生设为null
	 * @param obj 待处理对象
	 */
	public static void POJOLookupNull(Object obj){
		POJOLookupNull(obj, null);
	}
	
	/**
	 * 如果给定对象的属性中有Lookup类型的,而且该对象的主键为null,则将这个
	 * 属生设为null
	 * @param obj 待处理对象
	 * @param propertyNames 忽略给定属性列表中该属性的设置,字符以逗号分隔
	 */
	public static void POJOLookupNull(Object obj, String propertyNames){
		POJOLookupNull(obj, propertyNames, null);
	}
	
	
	private static void POJOLookupNull(Object obj, String propertyNames,Object parentObj){
		Set<String> proNames = null;
		if(propertyNames != null){
			List<String> pros = StringUtils.strToArrayList(propertyNames);
			proNames = new HashSet<String>();
			for (String propery : pros) {
				proNames.add(propery);
			}
		}
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(obj);
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			Object domainObject = BeanUtil.getPropertyValue(obj, propertyName);
			
			if(domainObject == null)
				continue;
			
			if(domainObject instanceof BaseObject){
				if(proNames != null && proNames.contains(propertyName))	//忽略给定的属性名，不将该值置为空
					continue;
				
				if(parentObj != null)
					continue;			//忽略父的lookup属性
				
				BeanUtil.setPropertyValue(obj, propertyName, null);
			}
			
			if(domainObject instanceof Collection){
				Collection coll = (Collection)domainObject;
				if(coll == null)
					continue;
			
				for (Object object : coll) {
					POJOLookupNull(object,propertyNames,obj);
				}
			}
		}
	}

}
