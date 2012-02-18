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
 * ������һ����������Ŀ���ǶԱ��ֲ��͹����Ķ�������һ������
 * ��<code>populate()</code>�����ǶԱ��ֲ��͹�����<code>PageInfoView</code>
 * ���·�װΪPageInfo����,����<code>populateFilter()</code>�����ǶԱ��ֲ��͹���
 * <code>PageInfoView</code>�����װΪ<code>Filter</code>���󲢷���
 * 
 * @author ���
 * @since 2007-7-15
 * @see org.hi.framework.paging.PageInfo
 * @see org.hi.framework.web.PageInfoView
 * @ses org.hi.framework.dao.Filter
 */
public class PageInfoUtil {
	
	/**
	 * ���ֲ��͹�����<code>PageInfoView</code>���·�װΪPageInfo����,������
	 * @param pageInfoView ���ֲ��͹����Ķ���,����Ҫ������������Ϣ
	 * @param action ��ǰִ�е�action����,���û�иò��������ڱ༭���������������ѯ����
	 * @return �������·�װ���PageInfo����
	 * @see org.hi.framework.web.PageInfoView
	 */
	public static PageInfo populate(PageInfoView pageInfoView,Action action){
		
		if(pageInfoView == null)
			pageInfoView = new PageInfoView();
		
		PageInfo pageInfo = new PageInfoImpl();
	
		/******Page����*****/
		if(pageInfoView.getCurrentPage()  != 1)
			pageInfoView.setIsFristPage(false);
		
		if(pageInfoView.getIsFristPage())
			pageInfoView.setCurrentPage(1);
		
		if(pageInfoView.getIsLastPage())
			pageInfoView.setCurrentPage(pageInfoView.getTotalPage());
		//��ǰҳ��ĵ�һ����¼�����ܼ�¼����λ��
		pageInfoView.setStartRowPosition((pageInfoView.getCurrentPage()-1) * pageInfoView.getPageSize());
		
		int realRecords = pageInfoView.getStartRowPosition() + pageInfoView.getPageSize();
		
		//�������޼�¼��С����ʵ��¼��,��ȡ����޼�¼��
		realRecords = pageInfoView.getMaxRecords() != 0 && pageInfoView.getMaxRecords() < realRecords ? pageInfoView.getMaxRecords() : realRecords; 
		
		pageInfoView.setEndRowPosition(realRecords);
		pageInfo.setPage(pageInfoView);
		
		
		/******Filter����*****/
		Filter filter = null;
		filter = populateFilter(pageInfoView, "");
		
		if(HiConfigHolder.getViewMode().equals("classic"))  //ֻ�о����Ż���session�ķ�ҳ����
			sessionProcess(action, pageInfoView, filter);
			
		
		if(filter == null)
			filter =  FilterFactory.getSimpleFilter(null, null, null);
		
		pageInfo.setFilter(filter);
		

		/******Sorter����*****/
		Sorter sorter = null;
		if(BeanUtil.getPropertyValueToStr(pageInfoView,"sorterName") != null){
			String sorterName = BeanUtil.getPropertyValueToStr(pageInfoView,"sorterName");
			String direction = BeanUtil.getPropertyValueToStr(pageInfoView,"sorterDirection");
			sorter = SorterFactory.getSimpleSort(sorterName, direction);
		}
		
		pageInfo.setSorter(sorter);
		
		return pageInfo;
	}
	
	
//	��pageInfo����Ϣ�ŵ�session�л��Ǵ�session��ȡpageInfo,�Ӷ���֤�༭�����ܻص���ǰҳ�����ǵ�һҳ
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
			if(!attribName.startsWith(prefix)) //���ǰ׺��ͬ
				continue;
			
			if(!attribName.equals(sessionAttributeName)){	//�����������ͬ���ͱ����л�����ǰ��list
				isUpdate = true;
				session.removeAttribute(attribName);
				session.setAttribute(sessionAttributeName, pageInfoView);
				break;
			}
			
			//�����������ͬ�����ʾ������ʹ�ҳ�棬��������ҳ����ת����
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
		//��һ�η���list��������ǰ���ʹ�������ѯû�д���ѯ��
		if(!isUpdate)
			session.setAttribute(sessionAttributeName, pageInfoView);
	}
	
	/**
	 * ���ֲ��͹�����<code>PageInfoView</code>���·�װΪPageInfo����,������
	 * @param pageInfoView ���ֲ��͹����Ķ���,����Ҫ������������Ϣ
	 * @return �������·�װ���PageInfo����
	 * @see org.hi.framework.web.PageInfoView
	 */	
	public static PageInfo populate(PageInfoView pageInfoView){
		return populate(pageInfoView, null);
	}
	
	
	/**
	 * ���ֲ��͹�����<code>PageInfoView</code>��װΪFilter����,������
	 * @param pageInfoView  ���ֲ��͹����Ķ���,����Ҫ������������Ϣ
	 * @return ����һ��������
	 * @see org.hi.framework.web.PageInfoView
	 */
	public static Filter populateFilter(PageInfoView pageInfoView){
		return populateFilter(pageInfoView, "");
	}
	
	
	/**
	 * ���ֲ��͹�����<code>PageInfoView</code>��װΪFilter����,������
	 * @param pageInfoView  ���ֲ��͹����Ķ���,����Ҫ������������Ϣ
	 * @param prefix ��ѯ���ǰ׺
	 * @return ����һ��������
	 * @see org.hi.framework.web.PageInfoView
	 */
	protected static Filter populateFilter(PageInfoView pageInfoView, String prefix){
		Filter filter = null;
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pageInfoView);
		
		//������f_��ͷ�Ĺ�����
		Map<String, PropertyDescriptor> nameAndpd = new LinkedHashMap<String, PropertyDescriptor>();
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			if(propertyName.startsWith("f_")){
				nameAndpd.put(propertyName, descriptor);
			}
		}
		
		Set<String>propertyNames = nameAndpd.keySet();
		
		for (String propertyName : propertyNames) {
			
			//����������ǲ�����
			if(propertyName.endsWith("_op"))
				continue;
			
			//���ֵΪ�ջ��ǿմ�
			Object filterValue = BeanUtil.getPropertyValue(pageInfoView, propertyName);
			if(filterValue == null)
				continue;
			if (filterValue instanceof String) {
				String valStr = (String) filterValue;
				if(valStr.trim().equals(""))
					continue;
				
				filterValue = StringUtils.trimRight(valStr); //ȥ���ַ����Ҳ�Ŀո�
			}
				
			String operator = propertyName + "_op";
			String operatorValue = BeanUtil.getPropertyValueToStr(pageInfoView, operator);
			if(operatorValue != null && operatorValue.trim().equals(""))
				operatorValue = null;
			
			//�����������ѯ�����������䣬����01 02/03/04Ϊ���Զ���
			String filterName;
			int manyIndex = propertyName.lastIndexOf("0");
			if(manyIndex < 0)
				filterName = propertyName.substring("f_".length());
			else
				filterName = propertyName.substring("f_".length(),manyIndex);
			
			//�����lookup�͵Ľ�$�滻Ϊ.��ʵ��domain����Ĳ�ѯ
			filterName = filterName.replaceAll("[$]", ".");
			
			if(filter == null)
				filter = FilterFactory.getSimpleFilter(prefix+filterName, filterValue, operatorValue);
			else{
				if(filterValue instanceof Timestamp && manyIndex >=0){	//ֻ���������������Ĳżӳ�23Сʱ
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
		
		//����domainObject�Ĺ��˲���
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
	 * ��������������������Lookup���͵�,���Ҹö��������Ϊnull,�����
	 * ������Ϊnull
	 * @param obj ���������
	 */
	public static void POJOLookupNull(Object obj){
		POJOLookupNull(obj, null);
	}
	
	/**
	 * ��������������������Lookup���͵�,���Ҹö��������Ϊnull,�����
	 * ������Ϊnull
	 * @param obj ���������
	 * @param propertyNames ���Ը��������б��и����Ե�����,�ַ��Զ��ŷָ�
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
				if(proNames != null && proNames.contains(propertyName))	//���Ը�������������������ֵ��Ϊ��
					continue;
				
				if(parentObj != null)
					continue;			//���Ը���lookup����
				
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
