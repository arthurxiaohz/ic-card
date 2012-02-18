package org.hi.framework.dao.springjdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


/**
 * 一个存储查询信息的记录实体类,主要包括包括sql语句与查询条件
 * @author 张昊
 * @since 2009-11-03
 *
 */
public class SpringJDBCQuery{
	/**
	 * SQL语句
	 */
	StringBuffer querySql = new StringBuffer();
	
	/**
	 * 查询与排序的条件Key为属性名,value为值
	 */
	Map<String,Object> parameterObject = new LinkedHashMap<String,Object>();
	
    private void setParameterSingle(String parameterName, Object value) {
        if (value instanceof Boolean) {
      	  parameterObject.put(parameterName, ((Boolean) value).booleanValue());
        } else if (value instanceof Byte) {
        	 parameterObject.put(parameterName, ((Byte) value).byteValue());
        } else if (value instanceof Character) {
        	 parameterObject.put(parameterName, ((Character) value).charValue());
        } else if (value instanceof Double) {
        	 parameterObject.put(parameterName, ((Double) value).doubleValue());
        } else if (value instanceof Float) {
        	 parameterObject.put(parameterName, ((Float) value).floatValue());
        } else if (value instanceof Integer) {
        	 parameterObject.put(parameterName, ((Integer) value).intValue());
        } else if (value instanceof Long) {
        	 parameterObject.put(parameterName, ((Long) value).longValue());
        } else if (value instanceof Short) {
        	 parameterObject.put(parameterName, ((Short) value).shortValue());
        } else if (value instanceof String) {
        	 parameterObject.put(parameterName, (String) value);
        } else if (value instanceof byte[]) {
        	 parameterObject.put(parameterName, (byte[]) value);
        } else if (value instanceof BigDecimal) {
        	 parameterObject.put(parameterName, (BigDecimal) value);
        } else if (value instanceof BigInteger) {
        	 parameterObject.put(parameterName, (BigInteger) value);
        } else if (value instanceof Date) {
        	 parameterObject.put(parameterName, (Date) value);
        } else if (value instanceof Time) {
        	 parameterObject.put(parameterName, (Time) value);
        } else if (value instanceof Timestamp) {
        	 parameterObject.put(parameterName, (Timestamp) value);
        } else if (value instanceof java.util.Date) {
        	 parameterObject.put(parameterName, (java.util.Date) value);
        } else if (value instanceof Locale) {
        	 parameterObject.put(parameterName, (Locale) value);
        } else {
        	 parameterObject.put(parameterName, value);
        }
    }
	
	public void putParameter(String parameterName,Object value){
//  	判断value的类型是否是一个集合,IN操作符的值就是一个集合
  	  if(value instanceof Collection){
    		Collection values = (Collection)value;
    		int j = 0;
    		for (Iterator i = values.iterator(); i.hasNext();) {
				Object val = (Object) i.next();
				setParameterSingle(parameterName+j, val);
				j++;
			}
    	}
    	else{
    		 setParameterSingle(parameterName, value);
    	}
	}
	
	public SpringJDBCQuery append(String sqlSegment){
		querySql.append(sqlSegment);
		return this;
	}
	
	public SpringJDBCQuery append(StringBuffer sqlSegment){
		querySql.append(sqlSegment);
		return this;
	}
	
	public String getQuerySql() {
		return querySql.toString();
	}

	public Object[] getParameterObjects() {
		Collection<Object> values = parameterObject.values();
		return values.toArray(new Object[values.size()]);
	}
	
	public void replaceAll(String regex, String replacement){
		String _sql = querySql.toString().replaceAll(regex, replacement);
		querySql =  new StringBuffer(_sql);
	}
	
	public String toString(){
		return this.querySql.toString();
	}
	
	
}