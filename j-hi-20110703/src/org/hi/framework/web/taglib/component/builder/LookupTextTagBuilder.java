package org.hi.framework.web.taglib.component.builder;

import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagInfoBean;
import org.hi.framework.web.taglib.component.bean.SelectTagBean;

public class LookupTextTagBuilder implements TagBuilder {

	public String build(TagInfoBean bean) {
		SelectTagBean selectBean = (SelectTagBean)bean;
		return "<span onclick=\"lookupPOP('" + selectBean.getLookup()+ "')\" style=\"cursor: hand\">²éÕÒ´ø»Ø</span>";
	}

}
