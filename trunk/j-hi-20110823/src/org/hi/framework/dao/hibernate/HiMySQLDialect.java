package org.hi.framework.dao.hibernate;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;
import org.hibernate.dialect.MySQLDialect;

public class HiMySQLDialect extends MySQLDialect implements HibernateHiDialect {

	private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<Page>();
	
	private final HibernateMySQLAgentDialect agent = new HibernateMySQLAgentDialect();
	public String getMaxRecode(Object hql, Filter filter, Page page) {
		pageThreadLocal.set(page);
		return hql+"";
	}

	public String transformSelectString(String select) {
		
		if(!select.matches("select\\s+.*\\s*count[(][\\*\\w\\.]+[)].+"))
			return select;
		
		select = select.trim();

		if(select.matches(".+limit\\s[\\d?]{1,}$")) {
			return select;
		}
		
		Page page = pageThreadLocal.get();
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		return select  + " limit "+maxLimit;
	}
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_MYSQL;
	}

	public String getFilterSQL(Filter filter, Manager manager) {
		return agent.getFilterSQL(filter, manager);
	}
}
