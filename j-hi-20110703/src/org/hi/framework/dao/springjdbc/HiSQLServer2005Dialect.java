package org.hi.framework.dao.springjdbc;

import org.hi.framework.paging.Page;

public class HiSQLServer2005Dialect extends HiSQLServerDialect implements SpringJDBCHiDialect {

	private static final String SELECT = "select";
	private static final String FROM = "from";
	private static final String DISTINCT = "distinct";
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.springjdbc.HiSQLServerDialect#getLimitString(java.lang.String, org.hi.framework.paging.Page)
	 */
	public String getLimitString(String querySelect, Page page) {
		StringBuilder sb = new StringBuilder(querySelect.trim().toLowerCase());

		int orderByIndex = sb.indexOf("order by");
		CharSequence orderby = orderByIndex > 0 ? sb.subSequence(orderByIndex, sb.length())
				: "ORDER BY CURRENT_TIMESTAMP";

		// Delete the order by clause at the end of the query
		if (orderByIndex > 0) {
			sb.delete(orderByIndex, orderByIndex + orderby.length());
		}

		// HHH-5715 bug fix
		replaceDistinctWithGroupBy(sb);

		insertRowNumberFunction(sb, orderby);

		// Wrap the query within a with statement:
		sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");
		sb.append("WHERE __hi_row_nr__ BETWEEN "+(page.getStartRowPosition() + 1)+" AND " + page.getEndRowPosition() + " ");

		return sb.toString();
	}
	protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
		int distinctIndex = sql.indexOf(DISTINCT);
		if (distinctIndex > 0) {
			sql.delete(distinctIndex, distinctIndex + DISTINCT.length() + 1);
			sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
		}
	}
	
	protected static void insertRowNumberFunction(StringBuilder sql, CharSequence orderby) {
		// Find the end of the select statement
		int selectEndIndex = sql.indexOf(SELECT) + SELECT.length();

		// Insert after the select statement the row_number() function:
		sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby + ") as __hi_row_nr__,");
	}
	protected static CharSequence getSelectFieldsWithoutAliases(StringBuilder sql) {
		String select = sql.substring(sql.indexOf(SELECT) + SELECT.length(), sql.indexOf(FROM));

		// Strip the as clauses
		return stripAliases(select);
	}
	
	protected static String stripAliases(String str) {
		return str.replaceAll("\\sas[^,]+(,?)", "$1");
	}

	public boolean inResult(int rowNum, Page page){
		return true;
	}
}
