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
			defaultValue = "";																					//��ѯ����Ҫʱ��������ȷ�����Լ�ʹ������ʱ����Ҳֻ�ܲ�����
		return "<input type=\"text\" name=\"" + bean.getName() + "\" value=\"" + defaultValue + "\""+" onFocus=\"WdatePicker({dateFmt:'"+dateFormat+"'})\""
		+BuilderTools.getParameters(bean.getParameters())+"/>";
	}

}
