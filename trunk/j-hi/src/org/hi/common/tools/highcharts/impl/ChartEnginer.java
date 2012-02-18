package org.hi.common.tools.highcharts.impl;

import java.beans.PropertyDescriptor;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.context.HighChart;
import org.hi.common.tools.highcharts.core.CSSObject;
import org.hi.common.tools.highcharts.core.Function;
import org.hi.common.tools.highcharts.core.JsonObject;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;

public class ChartEnginer {
	private final static Set<String> unIncludes = new HashSet<String>();
	static{
		unIncludes.add("class");
		unIncludes.add("parentEntity");
		unIncludes.add("oldValue");
		unIncludes.add("dirty");
		unIncludes.add("dataSymbol");
		unIncludes.add("cascadeDirty");
		unIncludes.add("target");
		unIncludes.add("targetParent");
		unIncludes.add("primarykey");
	}
	public static String getChart2JSON(HighChart bean){
		return getBean2JSON(bean, null);
	}
	private static String getBean2JSON(Object bean, String properies){
		if(bean == null)
			return "";
		StringBuffer sb = new StringBuffer("{");
		List<String> propertisList = new ArrayList<String>();
		if(properies ==null){
			PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
			String propertyName;
			for (PropertyDescriptor propertyDescriptor : beanProperties) {
				propertyName = propertyDescriptor.getName();
				if(unIncludes.contains(propertyName))
					continue;
				propertisList.add(propertyName);
			}
		}
		else{
			propertisList = StringUtils.strToArrayList(properies);
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String propertyName : propertisList) {
			if(propertyName.indexOf(".") > 0){
				int index= propertyName.indexOf(".");
				String domainName = propertyName.substring(0, index);
				String endName = propertyName.substring(index+1);
				if(map.get(domainName) == null){
					List<String> doaminProperties = new ArrayList<String>();
					doaminProperties.add(endName);
					map.put(domainName, doaminProperties);
				}
				else{
					map.get(domainName).add(endName);
				}
			}
			else
				map.put(propertyName, null);
		}
		
		int i = 0;
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			String propertyName = entry.getKey();
			Object val = BeanUtil.getPropertyValue(bean, propertyName);
			if(val == null)
				continue;
			
			if(i > 0)
				sb.append(",");
			i++;
			
			
			Class propertyClazz = BeanUtil.getProperyClass(bean, propertyName);
			sb.append(propertyName); 	//加JSON的属性名
			sb.append(":");										//加JSON的属性名与值的分隔符:
			
			if(Collection.class.isAssignableFrom(propertyClazz)){
				String collProperties = null;
				if(entry.getValue() != null)
					collProperties = StringUtils.CollectionToStr(entry.getValue());
				
				sb.append(getCollection2JSONValue((Collection)val, propertyName, collProperties));
			}
			else if(ChartSymbol.class.isAssignableFrom(propertyClazz)){	//说明是domainObject
					if(val != null){
						sb.append(getBean2JSON(val, entry.getValue() == null ? null : StringUtils.CollectionToStr(entry.getValue()))); //下一级将level加1
				}
				
			}
			else{
				
				if(val  instanceof String)
					sb.append("\'").append(val);
				
				else if(val instanceof Function)
					sb.append("function() {" + val + " }");
				else if(val instanceof CSSObject || val instanceof JsonObject)
					sb.append("{ " + val + " }");
				else if(val instanceof Date)
					sb.append(StringUtils.DateToStr((Date)val, "yyyy-MM-dd"));
				else if(val instanceof Timestamp){
					sb.append(StringUtils.DateToStr(new Date(((Timestamp)val).getTime()), "yyyy-MM-dd hh:mm:ss"));
				}
				else{
					sb.append(StringUtils.escapeHtml(BeanUtil.getPropertyValueToStr(bean, propertyName)));	//先做html转义再作为JSON的值
				}
				
				if(val  instanceof String)
					sb.append("\'");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
	
	
	public static String getCollection2JSON(Collection col, String collName , String properies, boolean isObject){
		if(col == null)
			return "";
		StringBuffer sb = new StringBuffer("");
		if(isObject)
			sb.append("{");
		if(collName != null){
			sb.append(collName); //集合在JSON中的变量名
			sb.append(":");	
		}
		sb.append(getCollection2JSONValue(col, collName, properies));
		
		if(isObject)
			sb.append("}");
		return sb.toString();
	}
	
	protected static String getCollection2JSONValue(Collection col, String collName , String properies){
		if(col == null)
			return "[]";
		
		StringBuffer sb = new StringBuffer("");
		sb.append("[");								//加集合在JSON中的数组标识符
		int i = 0;
		for (Object object : col) {
			if(i >0)
				sb.append(",");
			i++;
			
			if(object instanceof ChartSymbol)
				sb.append(getBean2JSON(object, properies));
			else if(object instanceof String)
				sb.append("'").append(object).append("'");
			else
				sb.append(object);
				
		}
		sb.append("]");
		
		return sb.toString();
	}
}
