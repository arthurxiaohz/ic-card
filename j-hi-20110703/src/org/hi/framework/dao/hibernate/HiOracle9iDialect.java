package org.hi.framework.dao.hibernate;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;
import org.hibernate.dialect.Oracle9Dialect;

public class HiOracle9iDialect extends Oracle9Dialect implements HibernateHiDialect{
	
	private HibernateOracleAgentDialect agent = new HibernateOracleAgentDialect();
	
	public String getMaxRecode(Object hql, Filter filter, Page page) {
		String _hql = (String)hql;
		boolean isWhere = filter != null && filter.getConditions().size() > 0;
		if(isWhere)	
			_hql += "and ";
		else 
			_hql += " where ";
		
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		return  _hql + " rownum <= "+ maxLimit + " ";
	}
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_ORACLE;
	}
	public String getFilterSQL(Filter filter, Manager manager) {
		return agent.getFilterSQL(filter, manager);
	}

}
