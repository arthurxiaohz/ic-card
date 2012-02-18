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
public class InputTagBuilder implements TagBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hi.framework.web.taglib.component.TagBuilder#build(org.hi.framework.web.taglib.component.TagInfoBean)
	 */
	public String build(TagInfoBean bean) {
		return "<input type=\"text\" name=\"" + bean.getName() + "\" value=\"" + bean.getDefaultValue() + "\""
				+BuilderTools.getParameters(bean.getParameters())+"/>";
	}

}
