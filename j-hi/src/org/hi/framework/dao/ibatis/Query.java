package org.hi.framework.dao.ibatis;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * һ���洢��ѯ��Ϣ�ļ�¼ʵ����,��Ҫ��������sql������ѯ����
 * @author ���
 * @since 2009-11-03
 *
 */
public class Query implements IQuery{
	/**
	 * SQL���
	 */
	StringBuffer querySql = new StringBuffer();
	
	/**
	 * ��ѯ�����������KeyΪ������,valueΪֵ
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