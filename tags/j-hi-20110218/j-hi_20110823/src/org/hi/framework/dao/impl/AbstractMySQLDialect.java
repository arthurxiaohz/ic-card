package org.hi.framework.dao.impl;




public abstract class AbstractMySQLDialect extends HiAbstractDialect{
	protected  String getFeildToString(String fieldName, FilterBean filterBean){
		return fieldName;
	}
}
