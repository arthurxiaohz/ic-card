package org.hi.framework.dao.ibatis3;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.hi.framework.dao.ibatis.IQuery;
import org.hi.metadata.hsc.context.service.Entity;


/**
 * 一个存储查询信息的记录实体类,主要包括包括sql语句与查询条件
 * @author 张昊
 * @since 2009-11-03
 *
 */
public class Query extends LinkedMap implements IQuery{
	/**
	 * SQL语句
	 */
	StringBuffer querySql = new StringBuffer();
	Entity entity;
	
	/**
	 * 查询结果返回的类型
	 */
	Class clazz;
	
	/**
	 * 查询与排序的条件Key为属性名,value为值
	 */
	Map<String,Object> parameterObject = new LinkedHashMap<String,Object>();
	
	int step = 0;
	public void putParameter(String parameterName,Object obj){
		parameterObject.put(parameterName + step,obj);
		step++;
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
	
	public Object get(Object key){
		return parameterObject.get(key);
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	
	
}