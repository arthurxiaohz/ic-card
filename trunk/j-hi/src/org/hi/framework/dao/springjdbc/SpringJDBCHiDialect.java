package org.hi.framework.dao.springjdbc;

import java.util.List;

import javax.sql.DataSource;

import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;

public interface SpringJDBCHiDialect extends HiDialect {
	public static final String HI_PROPERTY_DIALET_KEY = "springjdbc.dialect";
	
	public String getLimitString(String querySql, Page page);
	
	public boolean inResult(int rowNum, Page page);
	
	public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values);
	
	public Number getSelectKey(String entityName, DataSource dataSource);
}
