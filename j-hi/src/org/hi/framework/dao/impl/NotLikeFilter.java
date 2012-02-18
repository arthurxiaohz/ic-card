package org.hi.framework.dao.impl;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.NotFilter;

public class NotLikeFilter extends LikeFilter implements NotFilter {
	NotLikeFilter() {}
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.impl.SimpleFilter#addCondition(java.lang.String, java.lang.Object, java.lang.String, java.lang.String)
	 */
	public Filter addCondition(String name, String val, String op,
			String relation, int controler) {
		
		super.addCondition(name, val, op, relation, controler);
		FilterBean condition = conditions.get(conditions.size() -1);
		condition.setNot(true);
		return this;
	}
}
