package org.hi.framework.dao.springjdbc;

import java.util.List;

import javax.sql.DataSource;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.impl.AbstractOracleDialect;
import org.hi.framework.paging.Page;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

public class HiOracle9iDialect extends AbstractOracleDialect implements SpringJDBCHiDialect {

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.HiDialect#getMaxRecode(java.lang.Object, org.hi.framework.dao.Filter, org.hi.framework.paging.Page)
	 */
	public String getMaxRecode(Object query, Filter filter, Page page) {
		SpringJDBCQuery _query = (SpringJDBCQuery)query;
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		if(!maxLimit.equals(String.valueOf(HiConfigHolder.PAGE_MAXRECORDS))) //如果最大限记录数为0，则突略
			return null;
		
		boolean isWhere = (filter != null && filter.getConditions().size() > 0) 
						|| _query.toString().contains("where");
		if(isWhere)	
			_query.append("and ");
		else 
			_query.append(" where ");
		

		_query.append(" rownum <= ").append(maxLimit);
		return  null;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.HiDialect#getDataBaseType()
	 */
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_ORACLE;
	}

	public String getLimitString(String querySelect, Page page) {
		if(page == null)
			return querySelect;
		
		String sql = querySelect.trim();
		boolean isForUpdate = false;
		boolean hasOffset = true;
		if ( sql.toLowerCase().endsWith(" for update") ) {
			sql = sql.substring( 0, sql.length()-11 );
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer( sql.length()+100 );
		if (hasOffset) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		}
		else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (hasOffset) {
			pagingSelect.append(" ) row_ where rownum <= "+page.getEndRowPosition()+") where rownum_ > " + page.getStartRowPosition());
		}
		else {
			pagingSelect.append(" ) where rownum <=" + page.getEndRowPosition());
		}

		if ( isForUpdate ) {
			pagingSelect.append( " for update" );
		}

		return pagingSelect.toString();
		
	}
	

	public boolean inResult(int rowNum, Page page){
		return true;
	}

	public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values) {
		return sql;
	}

	public Number getSelectKey(String entityName, DataSource dataSource) {
		String sequenceName = entityName.toUpperCase() + HiDialect.HI_SEQUENCE_SUFFIX;
		OracleSequenceMaxValueIncrementer incr = new OracleSequenceMaxValueIncrementer(dataSource, sequenceName);
		return incr.nextIntValue();
	}
}
