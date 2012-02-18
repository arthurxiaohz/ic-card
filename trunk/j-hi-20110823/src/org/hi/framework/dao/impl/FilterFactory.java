package org.hi.framework.dao.impl;

import java.util.Collection;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.SecurityFilter;


/**
 * 创建过滤器的工厂，通过该工厂类将具体的过滤器封装起来。
 * <p>该工厂会根据需要自动创建相应的过滤器，并为其赋一定的初值，
 * 目前该工厂仅有<code>getSimpleFilter</code>方法，以后会加入对权限或用户的过滤
 * 
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.impl.SimpleFilter
 * @author 张昊
 * @since 2006-11-15
 * 
 */
public class FilterFactory {
	
	/**
	 * 创建并返回一个普通过滤器
	 * @param name 字段名
	 * @param val 值
	 * @return 过滤器
	 */
	public static Filter getSimpleFilter(String name, Object val){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val);
		return filter;
	}
	
	/**
	 * 创建并返回一个过滤器
	 * @param name 字段名
	 * @param val 值
	 * @param op 操作符
	 * @return 过滤器
	 */
	public static Filter getSimpleFilter(String name, Object val, String op){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val, op);
		return filter;
	}
	
	/**
	 * 创建并返回一个过滤器
	 * @param name 字段名
	 * @param val 值
	 * @param op 操作符
	 * @param relation 关系符
	 * @return 过滤器
	 */
	public static Filter getSimpleFilter(String name, Object val, String op ,String relation){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val, op, relation);
		return filter;
	}
	
	/**
	 * 创建并返回一个带IN操作符的过滤器
	 * @param name 字段名
	 * @param val 值
	 * @return 过滤器
	 */	
	public static InFilter getInFilter(String name, Collection val){
		InFilter filter = new InFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN);
		return filter;
	}

	/**
	 * 创建并返回一个带IN操作符的过滤器
	 * @param name 字段名
	 * @param val 值
	 * @param op 操作符
	 * @param relation 关系符
	 * @return 过滤器
	 * 注意:因为接口原因,该方法的op参数无效,无论设置该参数值为什么系统都会将其
	 * 自动转换为IN,对应<code>Filter.OPERATOR_IN</code>,见意在调用该方法时将op
	 * 操作符设为null.
	 * 例如:FilterFactory.getInFilter(name, val, null, relation);
	 */	
	public static InFilter getInFilter(String name, Collection val, String relation){
		InFilter filter = new InFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN, relation);
		return filter;
	}
	
	/**	
	 * 创建并返回一个带IN操作符的过滤器
	 * @param name 字段名
	 * @param val 值
	 * @return 过滤器
	 */	
	public static NotInFilter getNotInFilter(String name, Collection val){
		 NotInFilter filter = new NotInFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN);
		return filter;
	}

	/**
	 * 创建并返回一个带IN操作符的过滤器
	 * @param name 字段名
	 * @param val 值
	 * @param op 操作符
	 * @param relation 关系符
	 * @return 过滤器
	 * 注意:因为接口原因,该方法的op参数无效,无论设置该参数值为什么系统都会将其
	 * 自动转换为IN,对应<code>Filter.OPERATOR_IN</code>,见意在调用该方法时将op
	 * 操作符设为null.
	 * 例如:FilterFactory.getInFilter(name, val, null, relation);
	 */	
	public static NotInFilter getNotInFilter(String name, Collection val ,String relation){
		NotInFilter filter = new NotInFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN, relation);
		return filter;
	}	
	
	/**
	 * 创建并返回一个普通过滤器
	 * @param name 字段名
	 * @param val 值
	 * @return 过滤器
	 */
	public static Filter getNotLikeFilter(String name, String val){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE);
		return filter;
	}
	
	public static Filter getNotLikeFilter(String name, String val ,String relation){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation);
		return filter;
	}
	
	public static Filter getNotLikeFilter(String name, String val ,String relation, int controler){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, controler);
		return filter;
	}
	
	public static Filter getLikeFilter(String name, String val){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE);
		return filter;
	}
	
	public static Filter getLikeFilter(String name, String val ,String relation){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, LikeFilter.LIKE_CONTROLER_ALL);
		return filter;
	}	

	public static Filter getLikeFilter(String name, String val ,String relation, int controler){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, controler);
		return filter;
	}
	
	/**
	 * 创建并返回一个数据级权限过滤器
	 * @return 过滤器
	 */
	public static Filter getSecurityFilter(){
		String className = HiConfigHolder.getSecurityFilterCalss();
		SecurityFilter filter =  null;
		try {
			filter = (SecurityFilter) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return filter.getSeurityFilter();
	}
}
