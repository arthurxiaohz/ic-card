package org.hi.base.sysapp.interceptor;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.base.enumeration.EnumerationHelper;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.model.BaseObject;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Field;


public abstract class AbstractLogAnalysisor implements LogAnalysisor {

	protected String getPropertyValueToString(Field field, Field lkFKField, Object propertyValue){
		String value = null;
		if(field.getFieldName().equals("version") || field.getFieldName().equals(BaseObject.POJO_DELETED))
			return null;
		
		if(field.getFieldType() == FieldType.FIELD_TYPE_LOOKUP){
			
			if(propertyValue == null) return "null";
			Object lkPerValue = BeanUtil.getPropertyValue(propertyValue, field.getLookupEntity().getMainLkFieldName());
			if(lkPerValue == null){
				return "null";
			}
			
			if(lkPerValue instanceof Date){
				Date date = (Date)lkPerValue;
				value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
			}
			else if(lkPerValue instanceof Timestamp){
				Timestamp time = (Timestamp)lkPerValue;
				Date date = new Date(time.getTime());
				value = StringUtils.DateToStr(date, "yyyy-MM-dd");
			}
			else{
				value = lkPerValue.toString().equals("") ? "null" : lkPerValue.toString();
			}
				
			return value;
		}
		
		Object _value = propertyValue;
		if(_value == null || (_value instanceof String && _value.equals(""))){
			value = "null";
		}

		else{
			if(field.getFieldType() == FieldType.FIELD_TYPE_ENUMERATION){
				EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)_value);
				if(enuValue == null) 
					value = _value.toString();
				else
					value = enuValue.getDescription();
			}
			
			else if(_value instanceof Date){
				Date date = (Date)_value;
				value = StringUtils.DateToStr(date, "yyyy-MM-dd");
			}
			else if(_value instanceof Timestamp){
				Timestamp time = (Timestamp)_value;
				Date date = new Date(time.getTime());
				value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
			}
			else{
				value = _value.toString();
				if(value.length() > 200)
					value = value.substring(0, 200) + "...";
			}
		}
		return value;
	}

	public boolean equals(Object logProcessor){
		return this.getClass().equals(logProcessor.getClass());
	}
}
