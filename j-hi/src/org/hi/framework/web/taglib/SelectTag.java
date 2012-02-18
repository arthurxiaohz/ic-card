/**
 * 
 */
package org.hi.framework.web.taglib;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;

import org.apache.commons.collections.map.LinkedMap;
import org.hi.base.enumeration.EnumerationHelper;
import org.hi.common.tools.Matcher;
import org.hi.common.tools.NumberMatcher;
import org.hi.common.util.BeanUtil;
import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagBuilderFactory;
import org.hi.framework.web.taglib.component.bean.SelectTagBean;
import org.hi.i18n.util.I18NUtil;

/**
 * @author wei.li
 * @author zhanghao
 * 
 */
public class SelectTag extends AbstractTag {
	public static final String SELECT_TAG_TYPE_SELECT = "select";
	public static final String SELECT_TAG_TYPE_RADIO = "radio";
	public static final String SELECT_TAG_TYPE_CHECKBOX = "checkbox";
	
	private String emu;

	private String defaultValue;

	private String name;

	private String onclick;
	
	private String isLabel;
	
	private String type;
	
	private String multiple;
	
	private String filterPattern;

	private String pattern;
	
	private String isBr;
	
	private String allSelected;
	
	private String isNull;
	
	public String getEmu() {
		return emu;
	}

	public void setEmu(String emu) {
		this.emu = emu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public int doEndTag() throws JspException {
		evaluateParams();
		
		TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
		SelectTagBean bean = new SelectTagBean();
		Map mapping = getEnumValueMap();
		Map resultMapping = new LinkedMap();
		if(needNull())
			resultMapping.put("", "");
		resultMapping.putAll(mapping);
		bean.setName(this.getName());
		bean.setMapping(resultMapping);
		bean.setBr(needBr());
		bean.setDefaultValue(getDefaultValue(this.getName()));
		bean.setLabel(needLabel());
		bean.setMultiple(needMultiple());
		bean.setAllSelected(needAllSelected());
		bean.setType(type == null || type.equals("") ? SELECT_TAG_TYPE_SELECT : type);
		bean.setParameters(this.getParameters());
		String html = builder.build(bean);
		try {
			pageContext.getOut().print(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	protected Map getEnumValueMap(){
		Map<Integer, String> mapping = EnumerationHelper.getEnumerationValueMap(getEmu(),getPattern(), getTitle());
		if(filterPattern == null || filterPattern.trim().equals(""))
			return mapping;
		else{
			Map<Integer, String> result = new LinkedHashMap<Integer, String>();
			Matcher matcher = new NumberMatcher();
			String[] patterns = filterPattern.split(",");
			Set<Integer> keys = mapping.keySet();
			for (Integer id : keys) {
				for (int i = 0; i < patterns.length; i++) {
					String pattern = patterns[i];
					
					if(matcher.isPattern(pattern) && matcher.match(pattern, id)){
						result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
						break;
					}
					
					if(!matcher.isPattern(pattern) && pattern.equals(id.toString())){
						result.put(id, I18NUtil.getString((String)mapping.get(id), getEmu()));
						break;
					}
						
				}
			}
			
			return result;
		}
	}
	
	protected String getDefaultValue(String fieldName) {
        int pointIndex = 0;
        pointIndex = fieldName.indexOf(".");
        if (pointIndex<=1 || pointIndex+1 >=fieldName.length() )
        	return "";
		String beanName = fieldName.substring( 0,fieldName.indexOf(".") );
		 String beanFieldName = fieldName.substring( fieldName.indexOf(".") +1 );
		 Object bean = pageContext.getAttribute(beanName);
		 
		 if(bean == null)
			 bean = pageContext.getRequest().getAttribute(beanName);
		 
		if (bean == null )
			 return defaultValue != null ? defaultValue:"";
		String selectedValue = getSelectedValue();
		if(selectedValue != null)
			return selectedValue;
	 Object returnValue = BeanUtil.getPropertyValue(bean,beanFieldName);
	  if (returnValue != null )
           return returnValue.toString();
	  else
		  return defaultValue != null ? defaultValue:"";

	}

	protected String getSelectedValue(){
		if(value == null)	return null;
        int pointIndex = 0;
        pointIndex = value.indexOf(".");
        if (pointIndex<=1 || pointIndex+1 >=value.length() )
        	return null;
		String beanName = value.substring( 0,value.indexOf(".") );
		 String beanFieldName = value.substring( value.indexOf(".") +1 );
		Object bean = pageContext.getRequest().getAttribute(beanName);
		if(bean == null)	return null;
		
		Object selectedValue = BeanUtil.getPropertyValue(bean,beanFieldName);
		if(selectedValue == null)	return null;
		
		return selectedValue.toString();
	}
	
	private boolean needLabel() {
		return this.getIsLabel() != null && "true".equals(this.getIsLabel());
	}
	
	private boolean needBr() {
		return this.getIsBr() != null && "true".equals(this.getIsBr());
	}
	private boolean needMultiple() {
		return this.getMultiple() != null && "true".equals(this.getMultiple());
	}
	private boolean needAllSelected() {
		return this.getAllSelected() != null && "true".equals(this.getAllSelected());
	}
	
	private boolean needNull() {
		return this.getIsNull() != null && "true".equals(this.getIsNull());
	}
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getIsLabel() {
		return isLabel;
	}

	public void setIsLabel(String isLabel) {
		this.isLabel = isLabel;
	}

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilterPattern() {
		return filterPattern;
	}

	public void setFilterPattern(String filterPattern) {
		this.filterPattern = filterPattern;
	}

	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getIsBr() {
		return isBr;
	}

	public void setIsBr(String isBr) {
		this.isBr = isBr;
	}

	public String getAllSelected() {
		return allSelected;
	}

	public void setAllSelected(String allSelected) {
		this.allSelected = allSelected;
	}

}
