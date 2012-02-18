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
import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagBuilderFactory;
import org.hi.framework.web.taglib.component.TagInfoBean;
import org.hi.framework.web.taglib.component.bean.SelectTagBean;
import org.hi.i18n.util.I18NUtil;

/**
 * 查询标签
 * 
 * @author wei.li
 * 
 */
public class SearchListTag extends AbstractTag {
	
	private String name;
	private String emu;
	private String defaultValue;
	private String id;
	private String lookup;
	private String needSelect;
	private String br;
	private String isDate;
	private String dateFormat;
	private String filterPattern;
	private String pattern;
	
	public String getFilterPattern() {
		return filterPattern;
	}

	public void setFilterPattern(String filterPattern) {
		this.filterPattern = filterPattern;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getIsDate() {
		return isDate;
	}

	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}

	public int doEndTag() throws JspException {
		StringBuffer sb = new StringBuffer();
		evaluateParams();
		if (needSelect()) {
			sb.append(buildSelect());
		}
		sb.append(builderInput());

		if (isDateInput()) {
			sb = new StringBuffer();
			sb.append(builderDateInput());
		}
		if (isLookUp()) {
			sb.append(builderLookup());
		}
		if(isEmu()) {
			sb = new StringBuffer();
			sb.append(this.buildSelectElement());
		}
		if (needBR()) {
			sb.append("<br/>");
		}
		try {
			pageContext.getOut().print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	private String buildSelectElement() {
		TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
		SelectTagBean bean = new SelectTagBean();
		Map emuMapping = getEnumValueMap();
		Map resultMapping = new LinkedMap();
		resultMapping.put("",  I18NUtil.getString("全部") );
		resultMapping.putAll(emuMapping);
		bean.setName(this.getName());
		bean.setType(SelectTag.SELECT_TAG_TYPE_SELECT);
		bean.setMultiple(false);
		bean.setMapping(resultMapping);
		bean.setDefaultValue(this.getPageDefaultValue());
		bean.setParameters(this.getParameters());
		String html = builder.build(bean);
		return html;
	}
	
	protected Map getEnumValueMap(){
		Map<Integer, String> mapping = EnumerationHelper.getEnumerationValueMap(getEmu(), getPattern(), getTitle());
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
	
	private boolean isEmu() {
		return this.getEmu()!=null? true:false;
	}
	private boolean isLookUp() {
		return this.getLookup() != null ? true : false;
	}

	private String builderLookup(){
		TagBuilder builder = TagBuilderFactory.getLookupTagBuilder();
		SelectTagBean bean = new SelectTagBean();
		bean.setName(this.getName());
		bean.setLookup(this.lookup);
		bean.setParameters(this.getParameters());
		return builder.build(bean);
	}
	
	private String builderDateInput() {
		TagBuilder builder = TagBuilderFactory.getDateTagBuilder();
		TagInfoBean bean = new TagInfoBean();
		bean.setName(this.getName());
		bean.setDateFormat(this.dateFormat);
		bean.setDefaultValue(getPageDefaultValue());
		bean.setParameters(this.getParameters());
		return builder.build(bean);
	}

	private String builderInput() {
		TagBuilder builder = TagBuilderFactory.getInputTagBuilder();
		TagInfoBean bean = new TagInfoBean();
		bean.setName(this.getName());
		bean.setDefaultValue(getPageDefaultValue());
		bean.setParameters(this.getParameters());
		return builder.build(bean);
	}

	private boolean isDateInput() {
		return this.getIsDate() != null && "true".equals(this.getIsDate());
	}

	private boolean needBR() {
		return this.getBr() == null || "true".equals(this.getBr());
	}

	private String buildSelect() {
		TagBuilder builder = TagBuilderFactory.getSelectTagBuilder();
		SelectTagBean bean = new SelectTagBean();
		Map map = new LinkedHashMap();
		map.put("", I18NUtil.getString("操作符"));
		map.put("&lt;", I18NUtil.getString("小于"));
		map.put("&gt;", I18NUtil.getString("大于"));
		map.put("=", I18NUtil.getString("等于"));
		map.put("&lt;=", I18NUtil.getString("小于等于"));
		map.put("&gt;=", I18NUtil.getString("大于等于"));
		bean.setMapping(map);
		bean.setType(SelectTag.SELECT_TAG_TYPE_SELECT);
		bean.setMultiple(false);
		bean.setName(this.getName() + "_op");
		bean.setDefaultValue("");
		return builder.build(bean);
	}

	private String getPageDefaultValue() {
		Object value = getParameter(this.getName());

		return value == null ? "" : value.toString();
	}

	private boolean needSelect() {
		boolean needSelect = false;
		if ("true".equals(this.getNeedSelect())) {
			needSelect = true;
		}
		return needSelect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeedSelect() {
		return needSelect;
	}

	public void setNeedSelect(String needSelect) {
		this.needSelect = needSelect;
	}

	public String getBr() {
		return br;
	}

	public void setBr(String br) {
		this.br = br;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLookup() {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}

	

	public void setEmu(String emu) {
		this.emu = emu;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getEmu() {
		return emu;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}
