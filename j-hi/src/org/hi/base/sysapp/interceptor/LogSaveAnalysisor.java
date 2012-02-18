package org.hi.base.sysapp.interceptor;

import org.hi.common.util.BeanUtil;
import org.hi.framework.model.BaseObject;
import org.hi.framework.service.Manager;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.Field;

/**
 * @author ���
 * @since 2009-12-5
 *
 */
public class LogSaveAnalysisor extends AbstractLogAnalysisor {

	public String perProcess(Object[] args, Entity entity, Manager manager) {
		StringBuffer savesb = new StringBuffer();
		StringBuffer parameters = new StringBuffer();
		
		for (int i = 0; i < args.length; i++) {
			if(args[i] instanceof BaseObject){
				BaseObject bo = (BaseObject)args[i];
				if(!bo.isDirty()) continue; //����������
				if(!savesb.toString().contains("������Ϣ:")){
					savesb.append("������Ϣ:");
				}
				if(bo.getVersion() == null && bo.getPrimarykey() == null){ //������´�����POJO 
					savesb.append("����").append("[");
					Field lkFKField = null;
					for (Field field : entity.getField()) {
						String fieldLabel = field.getFieldLabel();
						String fieldName = field.getFieldName();
						if(field.getFieldType() == FieldType.FIELD_TYPE_LOOKUP){
							
							if(field.getLookupEntity().isIsLkForeignKey()){
								lkFKField = field;
								continue;
							}
							
							if(lkFKField != null)
								fieldName = lkFKField.getFieldName();
						}
						
						Object propertyValue = BeanUtil.getPropertyValue(bo, fieldName);
						String value = getPropertyValueToString(field, lkFKField, propertyValue);
						if(value == null) continue;
						savesb.append(fieldLabel).append(":").append(value).append(";");
					}
				}
				else{													//�����Ǹ�����ǰ��¼
					savesb.append("����");
					if(bo.getDataSymbol() != null)
						savesb.append("<").append(bo.getDataSymbol()).append(">");
					savesb.append("[");
					Field lkFKField = null;
					for (Field field : entity.getField()) {
						String fieldLabel = field.getFieldLabel();
						String fieldName = field.getFieldName();
						if(field.getFieldType() == FieldType.FIELD_TYPE_LOOKUP){
							
							if(field.getLookupEntity().isIsLkForeignKey()){
								lkFKField = field;
								continue;
							}
							
							if(lkFKField != null)
								fieldName = lkFKField.getFieldName();
						}
						if(!bo.hasOldValue(fieldName)) continue;	//���������ֵδ�б仯
						
						Object propertyValue = BeanUtil.getPropertyValue(bo, fieldName);
						String oldValue = getPropertyValueToString(field, lkFKField, bo.getOldValue(fieldName));
						String newValue = getPropertyValueToString(field, lkFKField, propertyValue);
						if(newValue == null) continue;
						savesb.append(fieldLabel).append(":").append(oldValue).append("->").append(newValue).append(";");
					}
					savesb.append("]");
				}
				
			}
			if(args[i] instanceof String){
				if(args[i] != null){
					if(!parameters.toString().contains("������Ϣ:")){
						parameters.append("������Ϣ:");
					}
					parameters.append(args[i]);
				}
			}
			
		}
		if(savesb.toString().equals("") && parameters.toString().equals(""))
			return null;
		return savesb.append(parameters).toString();
	}

	public String postProcess(Object result) {
		return null;
	}

}
