package org.hi.framework.dao.ibatis3;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.hi.framework.dao.ibatis.IQuery;
import org.hi.metadata.hsc.context.service.Entity;


/**
 * һ���洢��ѯ��Ϣ�ļ�¼ʵ����,��Ҫ��������sql������ѯ����
 * @author ���
 * @since 2009-11-03
 *
 */
public class Query extends LinkedMap implements IQuery{
	/**
	 * SQL���
	 */
	StringBuffer querySql = new StringBuffer();
	Entity entity;
	
	/**
	 * ��ѯ������ص�����
	 */
	Class clazz;
	
	/**
	 * ��ѯ�����������KeyΪ������,valueΪֵ
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