package org.hi.framework.dao.impl;

import org.hi.framework.dao.Filter;

/**
 * @author 张昊
 * @since 2006-11-15
 * 
 *
 */
public class SimpleFilter extends AbstractFilter {

	private static final long serialVersionUID = 6104162353423716952L;

	SimpleFilter(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object)
	 */
	public Filter addCondition(String name, Object val) {
		if (val instanceof String && val != null) {
			String strVal = (String) val;
			if (strVal.trim().length() == 0)
				return this; //如果为空字符串将突略当前填加的条件

			return addCondition(name, val, OPERATOR_LIKE);
		} else
			return addCondition(name, val, OPERATOR_EQ);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object, java.lang.String)
	 */
	public Filter addCondition(String name, Object val, String op) {
		return addCondition(name, val, op, RELATION_AND);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object, java.lang.String, java.lang.String)
	 */
	public Filter addCondition(String name, Object val, String op,
			String relation) {
		
		if(name == null || name.trim().equals("")){
			log.debug("addCondition method of name  is null");
			return this;	//如果name为空或空串则当前方法操作无效
		}
		
		FilterBean condition = new FilterBean();
		
		if (relation == null)
			relation = RELATION_AND;
 
		condition.setRelations(relation);  //增加关系符
		
		if (op == null) {
			if (val instanceof String)
				op = OPERATOR_LIKE;
			else
				op = OPERATOR_EQ;
		}

		condition.setOperater(op);		//增加操作符
		condition.setValue(val);		//增加值
		
		
		condition.setFieldName(name);		//设置查询字段的的字段名
		conditions.add(condition);
		return this;
	}




 
}

