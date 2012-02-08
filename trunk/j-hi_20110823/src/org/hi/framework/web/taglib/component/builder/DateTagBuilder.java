/**
 * 
 */
package org.hi.framework.web.taglib.component.builder;

import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagInfoBean;

/**
 * @author wei.li
 * 
 */
public class DateTagBuilder implements TagBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hi.framework.web.taglib.component.TagBuilder#build(org.hi.framework.web.taglib.component.TagInfoBean)
	 */
	public String build(TagInfoBean bean) {
		String defaultValue = bean.getDefaultValue();
		String dateFormat = bean.getDateFormat() == null ? "yyyy-MM-dd":bean.getDateFormat();
		if(defaultValue == null)
			defaultValue = "";																					//查询无需要时间那样精确，所以即使是日期时间型也只能查日期
		return "<input type=\"text\" name=\"" + bean.getName() + "\" value=\"" + defaultValue + "\""+" onFocus=\"WdatePicker({dateFmt:'"+dateFormat+"'})\""
		+BuilderTools.getParameters(bean.getParameters())+"/>";
	}

}
