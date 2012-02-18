package org.hi.framework.dao.impl;

import org.hi.framework.dao.Filter;

public class LikeFilter extends SimpleFilter {
	/**
	 * 值的左右两侧均加%
	 */
	public static int LIKE_CONTROLER_ALL = 0;
	/**
	 * 值的左侧加%
	 */
	public static int LIKE_CONTROLER_LEFT = 1;
	/**
	 * 值的右侧加%
	 */
	public static int LIKE_CONTROLER_RIGHT = 2;
	LikeFilter() {}
	
	public Filter addCondition(String name, String val, String op,
			String relation, int controler) {
		
		if(name == null || name.trim().equals("")){
			log.fatal("addCondition method of name  is null");
			return this;	//如果name为空或空串则当前方法操作无效
		}
		if(val == null || !(val instanceof String)){
			log.fatal("NotLikeFilter addCondition method of value  is null or not String");
			return this;	//如果val为空或类型不为String类型
		}
		
		FilterBean condition = new FilterBean();
		
		if (relation == null)
			relation = RELATION_AND;
 		
		condition.setRelations(relation);  //增加关系符
		
		if (op == null) 
				op = OPERATOR_LIKE;

		condition.setOperater(op);		//增加操作符
		condition.setValue(val);		//增加值
		condition.setLikeControler(controler); //增加like的控制,加 %的位置
		
		condition.setFieldName(name);		//设置查询字段的的字段名
		conditions.add(condition);
		return this;
	}
}
