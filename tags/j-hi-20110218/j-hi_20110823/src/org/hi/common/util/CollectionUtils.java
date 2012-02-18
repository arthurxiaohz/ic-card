package org.hi.common.util;

import java.util.Collection;

public class CollectionUtils {
	
	/**
	 * 对集合元素中某个属性进行求合,如果propertyName值为null,则视为集合的元素是原始类型的包装类
	 * @param coll 集合
	 * @param propertyName 集合元素POJO中的某个属性值
	 * @return 
	 */
	public static Double getPropertySum(Collection coll, String propertyName){
		if(coll == null || coll.size() == 0)
			return null;
		Double result = 0d;
		for (Object bean : coll) {
			Object value = null;
			
			if(propertyName == null)	//如果集合的元素是原始类型的包装类,则propertyName为空
				value = bean;
			else
				value = BeanUtil.getPropertyValue(bean, propertyName);
			
			if(value == null)	//如果是空值
				continue;
			
			if(!(value instanceof Number)) //如果值不是数字
				continue;
			
			Number _value = (Number)value;
			result += _value.doubleValue();
			
		}
		return result;
	}
	
	public static Object getElementByPropertyValue(Collection coll,  String propertyName, Object value){
		for (Object object : coll) {
			Object _value = BeanUtil.getPropertyValue(object, propertyName);
			if(_value == null)
				continue;
			
			if(_value.equals(value))
				return object;
		}
		return null;
	}
}
