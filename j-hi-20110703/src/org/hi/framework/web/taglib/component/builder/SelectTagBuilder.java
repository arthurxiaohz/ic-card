/**
 * 
 */
package org.hi.framework.web.taglib.component.builder;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.hi.common.util.StringUtils;
import org.hi.framework.web.taglib.SelectTag;
import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagInfoBean;
import org.hi.framework.web.taglib.component.bean.SelectTagBean;

/**
 * Select Tag 构建器,通过传入的InfoBean生成一个Select下拉框
 * 多选下拉框、单选框或多选框
 * 
 * @author wei.li
 * @author 张昊
 * 
 */
public class SelectTagBuilder implements TagBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hi.framework.web.taglib.TagBuilder#build(org.hi.framework.web.taglib.TagInfoBean)
	 */
	public String build(TagInfoBean bean) {
		SelectTagBean selectBean = (SelectTagBean) bean;
		Map mapping = selectBean.getMapping();
		
		Set<String> values = new LinkedHashSet<String>();

		String key = selectBean.getDefaultValue().trim();
		//将多选的值放到集合中
		if( key != null ){
			if(selectBean.isMultiple())
				values = StringUtils.strToSet(key);
			else{
				values.add(key);
			}
		}
		
		if(selectBean.isLabel()){
			
			if( key == null || key.trim().equals(""))
				return "";
			
			
			StringBuffer sb = new StringBuffer("");
			int i = 0;
			for (String value : values) {
				Object obj = mapping.get(new Integer(value));
				
				if(i>0)
					sb.append(",");
				
				if(obj != null)
					sb.append(obj);
				
				i++;
			}
			
			return sb.toString();
		}
		
		if(selectBean.getType().equals(SelectTag.SELECT_TAG_TYPE_SELECT)){
			return buildSelect(selectBean, bean, values);
		}
		else if(selectBean.getType().equals(SelectTag.SELECT_TAG_TYPE_CHECKBOX) || selectBean.getType().equals(SelectTag.SELECT_TAG_TYPE_RADIO))
			return buildCheck(selectBean, bean, values, selectBean.getType());

		return "";

	}
	
	protected String buildSelect(SelectTagBean selectBean, TagInfoBean bean, Set values){
		Map mapping = selectBean.getMapping();
		StringBuffer sb = new StringBuffer();
		sb.append("<select");
		sb.append(" name=\"" + selectBean.getName() + "\" ");
		sb.append(BuilderTools.getParameters(bean.getParameters()));
		if(selectBean.isMultiple())
			sb.append(" multiple=\"multiple\"");
		sb.append(" >");
		
		Iterator it = mapping.keySet().iterator();
		while (it.hasNext()) {
			Object keyValue =  it.next();
			String value = (String) mapping.get(keyValue);
			String selected = "";
			if (selectBean.getDefaultValue() != null
					&& values.contains(keyValue.toString())) {
				selected = "selected";
			}
			if(selectBean.isMultiple() && ((bean instanceof SelectTagBean ) && values.size() == 0 && ((SelectTagBean)bean).isAllSelected()))
				selected = "selected";
			
			sb.append(" <option " + selected + " value=\"" + keyValue + "\">");
			sb.append(value + "</option>");
		}
		sb.append("</select>");
		return sb.toString();
	}

	protected String buildCheck(SelectTagBean selectBean, TagInfoBean bean, Set<String> values, String type){
		Map mapping = selectBean.getMapping();
		StringBuffer sb = new StringBuffer();
		Iterator it = mapping.keySet().iterator();
		while(it.hasNext()){
			Object keyValue = it.next();
			String value = (String) mapping.get(keyValue);
			String selected = "";
			if (((bean instanceof SelectTagBean ) && values.size() == 0 && ((SelectTagBean)bean).isAllSelected())
					|| (selectBean.getDefaultValue() != null && values.contains(keyValue.toString()))) {
				selected = "checked";
			}
			sb.append("<label ").append(BuilderTools.getParameters(bean.getParameters())).append(">");
			sb.append("<input type=\""+type+"\" name=\""+ bean.getName() +"\" value=\""+keyValue+"\" ");
			sb.append(BuilderTools.getParameters(bean.getParameters()));
			sb.append(selected).append(" ");
			sb.append("/>" + value);
			sb.append("</label>");
			if((bean instanceof SelectTagBean) && ((SelectTagBean)bean).isBr())
				sb.append("<br>");
		}
		
		return sb.toString();
	}
	

}
