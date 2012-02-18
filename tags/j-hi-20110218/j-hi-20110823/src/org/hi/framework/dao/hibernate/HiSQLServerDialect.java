package org.hi.framework.dao.hibernate;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;
import org.hibernate.dialect.SQLServerDialect;

public class HiSQLServerDialect extends SQLServerDialect implements	HibernateHiDialect {
	private HibernateSQLServerAgentDialect agent = new HibernateSQLServerAgentDialect();
	public String getMaxRecode(Object hql, Filter filter, Page page) {
		String _hql = (String)hql;
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		String top = " top "+ maxLimit + " ";
		
		_hql.replaceAll("select", "select"+top);
		return _hql;
	}
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_SQLSERVER;
	}
	public String getFilterSQL(Filter filter, Manager manager) {
		return agent.getFilterSQL(filter, manager);
	}
}
