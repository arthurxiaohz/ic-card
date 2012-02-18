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
public class AnchorTagBuilder implements TagBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hi.framework.web.taglib.component.TagBuilder#build(org.hi.framework.web.taglib.component.TagInfoBean)
	 */
	public String build(TagInfoBean bean) {
		// TODO Auto-generated method stub
		String html = "<a href=\"" + bean.getUrl() + "\"  >" + bean.getDefaultValue()
				+ "</a>&nbsp;&nbsp;";
		return html;
	}

}
