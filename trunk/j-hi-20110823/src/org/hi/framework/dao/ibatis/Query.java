package org.hi.framework.dao.ibatis;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 一个存储查询信息的记录实体类,主要包括包括sql语句与查询条件
 * @author 张昊
 * @since 2009-11-03
 *
 */
public class Query implements IQuery{
	/**
	 * SQL语句
	 */
	StringBuffer querySql = new StringBuffer();
	
	/**
	 * 查询与排序的条件Key为属性名,value为值
	 */
	Map<String,Object> parameterObject = new LinkedHashMap<String,Object>();
	
	public void putParameter(String parameterName,Object obj){
		parameterObject.put(parameterName,obj);
	}
	
	public Query append(String sqlSegment){
		querySql.append(sqlSegment);
		return this;
	}
	
	public Query append(StringBuffer sqlSegment){
		querySql.append(sqlSegment);
		return this;
	}
	
	public StringBuffer getQuerySql() {
		return querySql;
	}

	public Map<String, Object> getParameterObject() {
		return parameterObject;
	}
	
	public void replaceAll(String regex, String replacement){
		String _sql = querySql.toString().replaceAll(regex, replacement);
		querySql =  new StringBuffer(_sql);
	}
	
	public String toString(){
		return this.querySql.toString();
	}
	
	
}