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
 * 对枚举数据的助手类
 * @author 张昊
 * @since 2007-1-26
 *  
 */
public class EnumerationHelper {
	
	private static EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
	
    /**
     * 通过给定的枚举实体名字，得到枚举值bean的一个集合
     * @param enumName 枚举实体名字,首字母小写
     * @return 返回与枚举实体对应的枚举值的集合
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
     * 通过给定枚举实体名字，得到以枚举值ID为key，以描述有value的一个Map
     * @param enumName 枚举实体名字,首字母小写   
     * @return 返回以枚举值ID为key，以描述有value的一个Map
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
     * 通过给定枚举实体名字，得到以枚举值ID为key，以描述有value的一个Map
     * @param enumName 枚举实体名字,首字母小写
     * @return 返回以枚举值ID为key，以描述有value的一个Map
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
     * 通过给定的枚举值ID值，得到该枚举值的bean
     * @param enumerationValueId 枚举值ID值
     * @return 枚举值的bean
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
	 * 取得枚举值的描述信息，根据枚举值的ID去查，返回的枚举对象包含着枚举的描述信息
	 * @param enumerationValueId 主键id
	 * @return description
	 */
	public static String getDescription(Integer enumerationValueId){
		EnumerationValue enumValue = getEnumerationValue(enumerationValueId);
		if(enumValue == null)
			return null;
		return enumValue.getDescription();
	}
    
}
