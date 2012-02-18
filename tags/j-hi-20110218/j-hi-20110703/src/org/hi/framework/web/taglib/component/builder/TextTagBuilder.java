/**
 * 
 */
package org.hi.framework.web.taglib.component.builder;

import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagInfoBean;

/**
 * @author xiao
 * 
 */
public class TextTagBuilder implements TagBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hi.framework.web.taglib.component.TagBuilder#build(org.hi.framework.web.taglib.component.TagInfoBean)
	 */
	public String build(TagInfoBean bean) {
		// TODO Auto-generated method stub
		String html =  bean.getDefaultValue();
		return html+"&nbsp;&nbsp;";
	}

}
