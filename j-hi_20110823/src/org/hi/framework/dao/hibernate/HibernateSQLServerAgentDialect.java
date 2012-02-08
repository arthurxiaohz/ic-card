package org.hi.framework.dao.hibernate;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.AbstractMySQLDialect;
import org.hi.framework.paging.Page;

class HibernateSQLServerAgentDialect extends AbstractMySQLDialect{

	/**
	 * @deprecated
	 */
	public String getDataBaseType() {
		return null;
	}
	/**
	 * @deprecated
	 */

	public String getMaxRecode(Object query, Filter filter, Page page) {
		return null;
	}

}
