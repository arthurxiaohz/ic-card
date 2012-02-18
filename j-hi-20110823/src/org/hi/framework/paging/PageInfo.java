package org.hi.framework.paging;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;

/**
 * 该接口是对所有页面信息的整合，即对页面信息信息的进一步封装，其中包括Page,Fltert与Sorter
 * <p>注意：目标该类还不支持分组、聚合等SQL标准功能
 * @author张昊
 * @since 2006-12-16
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.Sorter
 * @ses org.hi.framework.paging.Page
 */
public interface PageInfo extends java.io.Serializable{
	
	/**
	 * 获取当前页面信息的过滤器，实际上是一组过滤器,通过<code>getConditions()</code>方法<p>
	 * 可以得到该页面信息所有过滤器的具体内容,该方法返回的是<code>FilterBean</code>类型的一个
	 * <code>List</code>集合
	 * @see org.hi.framework.dao.Filter.getConditions()
	 * @see import org.hi.framework.dao.impl.FilterBean
	 * @return 返回当前页面信息的过滤器
	 */
	public Filter getFilter();
	
	/**
	 * 为当前页面信息设置过滤器
	 * @param filter 过滤器
	 */
	public void setFilter(Filter filter) ;
	
	/**
	 * 获得当前页面列表的具体信息
	 * @return 返回列表页面的行号与页数
	 */
	public Page getPage() ;
	
	/**
	 * 设置列表信息
	 * @param page
	 */
	public void setPage(Page page);
	
	/**
	 * 返回排序器
	 * @return
	 */
	public Sorter getSorter() ;
	
	/**
	 * 设置排序器
	 * @param sorter
	 */
	public void setSorter(Sorter sorter) ;
}
