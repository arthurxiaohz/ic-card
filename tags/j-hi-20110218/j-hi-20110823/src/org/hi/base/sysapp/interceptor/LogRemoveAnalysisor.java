package org.hi.base.sysapp.interceptor;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.EnumerationHelper;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.model.BaseObject;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.Field;

/**
 * @author 张昊
 * @since 2009-12-3
 *
 */
public class LogRemoveAnalysisor extends AbstractLogAnalysisor {
	
	public String perProcess(Object[] args, Entity entity, Manager manager) {
		ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
		StringBuffer info = new StringBuffer();
		info.append("记录信息:");
		
		for (int i = 0; i < args.length; i++) {
			BaseObject bo = null;
			if(args[i] instanceof Integer){
				Integer id = (Integer)args[i];
				bo = (BaseObject)bMgr.getObjectById(manager.getModelClass(), id);
			}
			if(args[i] instanceof BaseObject ){
				bo = (BaseObject)args[i];
			}
			if(bo == null){
				info.append("无  ");
				continue;
			}
			
			Field lkFKField = null;
			String fieldLabel = null;
			String value = null;
			for (Field field : entity.getField()) {
				fieldLabel = field.getFieldLabel();
				if(field.getFieldName().equals("version") || field.getFieldName().equals(BaseObject.POJO_DELETED))
					continue;
				
				if(field.getFieldType() == FieldType.FIELD_TYPE_LOOKUP){
					if(field.getLookupEntity().isIsLkForeignKey()){
						lkFKField = field;
						continue;
					}
					
					Object lkPerValue = BeanUtil.getPropertyValue(bo, lkFKField.getFieldName() + "." + field.getLookupEntity().getMainLkFieldName());
					if(lkPerValue == null){
						value = "null";
						info.append(fieldLabel).append(":").append(value).append(";");
						continue;
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
						
					info.append(fieldLabel).append(":").append(value).append(";");
					continue;
				}
				
				Object _value = BeanUtil.getPropertyValue(bo, field.getFieldName());
				if(_value == null || (_value instanceof String && _value.equals(""))){
					value = "null";
				}

				else{
					if(field.getFieldType() == FieldType.FIELD_TYPE_ENUMERATION){
						EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)_value);
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
				info.append(fieldLabel).append(":").append(value).append(";");
			}
			
		}
		
		return info.toString();
	}

	public String postProcess(Object result) {
		return null;
	}

}
