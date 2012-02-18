package org.hi.framework.dao;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>本接口是规范面向对象的查询排序条件,排序分为两部分：字段名、方向符，可以通过<code>addSort</code>方法不断累加排序方法返回的还是
 * 当前<code>Sorter</code>的实例，其操作方式与<code>Filter</code>方式相同
 * 本接口是规范以面向对象的方式对数据库查询进行排序
 * @see org.hi.framework.dao.Filter
 * @author 张昊
 * @since 2006-11-15
 *
 */
public interface Sorter extends Serializable {

	/**
	 *  对应数据库中的asc操作符
	 */
	public static final String ORDER_ASC = "ASC";
	/**
	 *  对应数据库中的desc操作符
	 */
	public static final String ORDER_DESC = "DESC";
	
	/**
	 * 添加排序条件
     * @param name 数据库字段名
     * 注意：默认的排序方向为正序，即ASC 
     * @return 返回当前的排序器
	 */
	
	public Sorter addSort(String name);
	/**
	 * 添加排序条件
     * @param name 数据库字段名 
	 * @param direction 排序方向
	 * 可以通过Sorter.ORDER_ASC等获取排序方向的常量
     * @return 返回当前的排序器
	 */
	public Sorter addSort(String name,String direction);
	
    /**
     * 得到SQL语句中Order by子句部分的字符串
     * @return 返回过滤字符串
     * 注意该返回的字符串不包含"order by"字符串
     */
	public String toString();

	/**
	 * 获得当前排序器的一个Map,其中key:字段名，value：排序的方向
	 * <p>其作用是Sorter与相应的ORM中做数据转换
	 * @return 返回排序信息的集合
	 */
	public Map<String, String> getSorts();
	
}
