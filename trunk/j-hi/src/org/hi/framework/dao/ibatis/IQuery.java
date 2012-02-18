package org.hi.framework.dao.ibatis;

public interface IQuery {
	public String toString();
	public IQuery append(String sqlSegment);
	public IQuery append(StringBuffer sqlSegment);
	public StringBuffer getQuerySql();
	public void replaceAll(String regex, String replacement);
}
