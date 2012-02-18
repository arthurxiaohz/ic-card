package org.hi.common.tools;

/**
 * 对象匹配器的策略接口.
 * <p>其核心思想是,通过给定的对象与模板相匹配.模板本身会提供不同的通配符
 * @author 张昊
 * @since 2007-11-22
 *
 */
public interface Matcher {
	
	/**
	 * 给定的参数是否符合模板格式
	 * @param pattern 待确认的模板
	 * @return 如果符合模板格式返回true,否则返回false
	 */
	boolean isPattern(String pattern);
	
	/**
	 * 通过给定的模板判断对象值是否与该模板相匹配
	 * @param pattern 规则模板
	 * @param value 待匹配的对象
	 * @return 如果对象与模板匹配返回true,否则返回false
	 */
	boolean match(String pattern, Object value);
}
