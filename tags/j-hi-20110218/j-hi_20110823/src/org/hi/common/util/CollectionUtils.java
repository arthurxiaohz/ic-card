package org.hi.common.util;

import java.util.Collection;

public class CollectionUtils {
	
	/**
	 * �Լ���Ԫ����ĳ�����Խ������,���propertyNameֵΪnull,����Ϊ���ϵ�Ԫ����ԭʼ���͵İ�װ��
	 * @param coll ����
	 * @param propertyName ����Ԫ��POJO�е�ĳ������ֵ
	 * @return 
	 */
	public static Double getPropertySum(Collection coll, String propertyName){
		if(coll == null || coll.size() == 0)
			return null;
		Double result = 0d;
		for (Object bean : coll) {
			Object value = null;
			
			if(propertyName == null)	//������ϵ�Ԫ����ԭʼ���͵İ�װ��,��propertyNameΪ��
				value = bean;
			else
				value = BeanUtil.getPropertyValue(bean, propertyName);
			
			if(value == null)	//����ǿ�ֵ
				continue;
			
			if(!(value instanceof Number)) //���ֵ��������
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
