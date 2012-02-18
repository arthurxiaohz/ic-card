package org.hi.framework.dao.impl;

import java.util.Collection;
import java.util.Iterator;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.NotFilter;

public class NotInFilter extends InFilter implements NotFilter {
	NotInFilter() {}
	/**
	 * 添加筛选条件
     * @param name 数据库字段名 
     * @param val 字段对应的值，类型必须是<code>Collection</code>的子类
     * @param op 操作符
     * @param relation 关系符
     * 注意：在本方法只参数op(操作符)无论设为何值,系统都将其改写为IN的特定操作符,甚至是null
     * <p><code>Filter.OPERATOR_IN</code>
     * @return 返回当前过滤器
	 */
	public InFilter addCondition(String name, Object val, String op,
			String relation) {
		super.addCondition(name, val, op, relation);
		FilterBean condition = conditions.get(conditions.size() -1);
		condition.setNot(true);
		
		return this;
	}
}
