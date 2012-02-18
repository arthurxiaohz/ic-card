package org.hi.framework.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

public abstract class AbstractOracleDialect extends HiAbstractDialect{
	
	protected  String getFeildToString(String fieldName, FilterBean filterBean){
		Object val = filterBean.getValue();
		if(val instanceof Date)
			return "to_char(" + fieldName + ",'yyyy-mm-dd')";
		else if(val instanceof Timestamp)
			return "to_char(" + fieldName + ",'yyyy-mm-dd 24hi:mi:ss')";
		else
			return fieldName;
	}
}
