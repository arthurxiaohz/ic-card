package org.hi.framework.paging;

import java.io.Serializable;

/**
 * 该接口是规范页面封装信息,包括总记录数、总页数、每页记录数(pageSize)、是否是首页或尾页、最大限记录数、
 * 在页上要显示的页码数量（middlePageNum）等。对于平台提供了全局的配置，参见hiFrameworkConfig.properties文件
 * @author 张昊
 * @since 2006-11-15
 *
 */
public interface Page extends Serializable {

	/**
	 * 设置页面总记录数
	 * @param totalRecords 总记录数
	 */
	public void setTotalRecords(int totalRecords);
	
	/**
	 * 获得页面总记录数
	 * @return 页面总记录数
	 */
	public int getTotalRecords();
	/**
	 * 设置总页数
	 * @param totalPage 总页数
	 */
	public void setTotalPage(int totalPage);
	
	/**
	 * 获取总页数 
	 * @return 总页数
	 */
	public int getTotalPage();
	
	/**
	 * 单页的记录数
	 * @return 单页的记录数
	 */
	public void setPageSize(int pageSize);
	
	/**
	 * 单页的记录数
	 * @return 单页的记录数
	 */
	public int getPageSize();
	
	
	/**
	 * 设置是否是首页
	 * @param isFristPage 是否为首页
	 */
	public void setIsFristPage(boolean isFristPage);
	
	/**
	 * 是否为首页
	 * @return 是否为首页 
	 */
	public boolean getIsFristPage();
	
	/**
	 * 设置是否为最后一页
	 * @param isLastPage 否为最后一页
	 */
	public void setIsLastPage(boolean isLastPage);
	
	/**
	 * 是否是最后一页
	 * @return
	 */
	public boolean getIsLastPage();
	
	/**
	 * 设置当前页是第几页
	 * @param currentPage 当前页的页数
	 */
	public void setCurrentPage(int currentPage);
	
	/**
	 * 得到当前页的页数
	 * @return 当前页的页数
	 */
	public int getCurrentPage();
	
	/**
	 * 当前页的第一条记录对于总记录数是第几条
	 * @param startRowPosition 当前页的为第几条记录
	 */
	public void setStartRowPosition(int startRowPosition);
	
	/**
	 * 得到当前页面的第一条记录对于总记录数的位置
	 * @return 总记录数的位置
	 */
	public int getStartRowPosition();
	
	/**
	 * 设置当前页面最后一条记录在总记录数中的位置
	 * @param endRowPosition 在总记录数中的位置
	 */
	public void setEndRowPosition(int endRowPosition);
	
	/**
	 * 返回当前页面最后一条记录在总记录数中的位置
	 * @return 在总记录数中的位置
	 */
	public int getEndRowPosition();
	
	/**
	 * 得到最大限记录数
	 * @return 最大限记录数
	 */ 
	public int getMaxRecords();
	
	/**
	 * 设置最大限记录数
	 * @param maxRecords 最大限记录数
	 */
	public void setMaxRecords(int maxRecords);
	
	/**
	 * 在翻页时中间的页码数,列如该值设为5,那么页面上只显示10个页码数,该返回值是在
	 * 全局配置文件中hiFrameworkConfig.properties设置,配置项为hi.pageinfo.currnetmiddlepag
	 * @return currnetmiddlepag
	 */
	public int getMiddlePageNum();

}
