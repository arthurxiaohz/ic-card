package org.hi.base.enumeration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationManager;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;

/**
 * ��ö�����ݵ�������
 * @author ���
 * @since 2007-1-26
 *  
 */
public class EnumerationHelper {
	
	private static EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
	
    /**
     * ͨ��������ö��ʵ�����֣��õ�ö��ֵbean��һ������
     * @param enumName ö��ʵ������,����ĸСд
     * @return ������ö��ʵ���Ӧ��ö��ֵ�ļ���
     */
    public static List<EnumerationValue> getEnumerationValue(String enumName){
    	
    	List<Enumeration> enums = enumMgr.getEnumerations();

    	for (Enumeration enumeration : enums) {
    		if(enumeration.getEnName().equals(enumName))
    			return enumeration.getEnumerationValues();
		}
    	
    	return new ArrayList<EnumerationValue>();
    }
    
    /**
     * ͨ������ö��ʵ�����֣��õ���ö��ֵIDΪkey����������value��һ��Map
     * @param enumName ö��ʵ������,����ĸСд   
     * @return ������ö��ֵIDΪkey����������value��һ��Map
     */
    public static Map<Integer, String> getEnumerationValueMap(String enumName, String pattern, String title){
    	
    	List<EnumerationValue> values = getEnumerationValue(enumName);
    	
    	Map<Integer, String> result = new LinkedHashMap<Integer, String>();
    	
    	for (EnumerationValue enumValue : values) {
    		StringBuffer sb = new StringBuffer("");
    		if(pattern == null && title == null){
    			result.put(enumValue.getId(), enumValue.getDescription());
    			continue;
    		}
    		
    		if(pattern == null || pattern.trim().equals("")){
				 sb.append(BeanUtil.getPropertyValue(enumValue, title).toString());
				 result.put(enumValue.getId(), sb.toString());
				 continue;
			}
    		
			List<String> titleUnits =StringUtils.strToArrayList(title, pattern);
			int step = 0;
			for (String titleUnit : titleUnits) {
				if(step >0)
					sb.append(pattern);
				
				sb.append(BeanUtil.getPropertyValue(enumValue, titleUnit).toString());
				
				step++;
			}
			
			result.put(enumValue.getId(), sb.toString());
    		
		}
    	
    	return result;
    }
    
    /**
     * ͨ������ö��ʵ�����֣��õ���ö��ֵIDΪkey����������value��һ��Map
     * @param enumName ö��ʵ������,����ĸСд
     * @return ������ö��ֵIDΪkey����������value��һ��Map
     */
    public static Map<String, String> getEnumerationValueMapForString(String enumName){
    	
    	List<EnumerationValue> values = getEnumerationValue(enumName);
    	
    	Map<String, String> result = new LinkedHashMap<String, String>();
    	
    	for (EnumerationValue enumValue : values) {
			result.put(enumValue.getId().toString(), enumValue.getDescription());
		}
    	
    	return result;
    }
    
    /**
     * ͨ��������ö��ֵIDֵ���õ���ö��ֵ��bean
     * @param enumerationValueId ö��ֵIDֵ
     * @return ö��ֵ��bean
     */
	public static EnumerationValue getEnumerationValue(Integer enumerationValueId){
    	List<Enumeration> enums = enumMgr.getEnumerations();

    	for (Enumeration enumeration : enums) {
    		List enumerationValues = enumeration.getEnumerationValues();
    		for (Iterator iter = enumerationValues.iterator(); iter.hasNext();) {
    			EnumerationValue value = (EnumerationValue) iter.next();
    			
    			if(value.getId().equals(enumerationValueId))
    				return value;
			}
    	}
    	
    	return null;
    }
	/**
	 * ȡ��ö��ֵ��������Ϣ������ö��ֵ��IDȥ�飬���ص�ö�ٶ��������ö�ٵ�������Ϣ
	 * @param enumerationValueId ����id
	 * @return description
	 */
	public static String getDescription(Integer enumerationValueId){
		EnumerationValue enumValue = getEnumerationValue(enumerationValueId);
		if(enumValue == null)
			return null;
		return enumValue.getDescription();
	}
    
}
