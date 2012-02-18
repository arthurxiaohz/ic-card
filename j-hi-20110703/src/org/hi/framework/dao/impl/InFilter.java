package org.hi.framework.dao.impl;

import java.util.Collection;
import java.util.Iterator;

import org.hi.framework.dao.Filter;

/**
 * 该过滤器是为了满足SQL语句中的IN子句所做的特殊过滤器类
 * 正因为于此,所以该类中的成员方法<code>addCondition(...)</code>所有与操作符对应的
 * 参数都将是无效的,系统会其自动转换为<code>Filter.OPERATOR_IN</code>值
 * 
 * 
 * @author 张昊
 * @since 2006-12-18
 *
 */
public class InFilter extends AbstractFilter {
	
	private static final long serialVersionUID = 3988800758696951324L;
	
	InFilter(){
		
	}
	
	/**
	 * 添加筛选条件
     * @param name 数据库字段名 
     * @param val 字段对应的值，类型必须是<code>Collection</code>的子类
     * @return 返回当前过滤器
	 * @see org.hi.framework.dao.Filter#addCondition(java.lang.String, java.lang.Object)
	 */
	public InFilter addCondition(String name, Object val) {
		return addCondition(name, val, Filter.OPERATOR_IN, Filter.RELATION_AND);
	}


	@Deprecated
	public InFilter addCondition(String name, Object val, String op) {
		return addCondition(name, val, Filter.OPERATOR_IN, Filter.RELATION_AND);
	}

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
		
		op = Filter.OPERATOR_IN;
		
		if(name == null || name.trim().equals("") || val == null){
			log.fatal("addCondition method of name or value is null");
			return this;	//如果name为空或空串则当前方法操作无效
		}
		
		if (val instanceof Collection) {
			Collection vals = (Collection)val;
			
			if(vals.size() == 0)
				return this;
			
			FilterBean condition = new FilterBean();
			
			if (relation == null)
				relation = RELATION_AND;
	 
			
			condition.setRelations(relation);  //增加关系符
			
			condition.setFieldName(name);
			
			condition.setOperater(op); //添加操作符
			condition.setValue(val); 
			
			conditions.add(condition); //将封装好的FilterBean存放到集合中
		}
		else{
			log.fatal("this is filter value not Collection Class");
			return this;	//如果name为空或空串则当前方法操作无效
		}
		
		return this;
	}
}
