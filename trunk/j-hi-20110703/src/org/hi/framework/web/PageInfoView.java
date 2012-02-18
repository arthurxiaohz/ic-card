package org.hi.framework.web;

import org.hi.framework.paging.impl.PageImpl;

/**
 * 
 * @author 张昊
 * @since 2007-3-3
 *
 */
public class PageInfoView extends PageImpl {
	private static final long serialVersionUID = 7389809057021954833L;
	
	/**
	 * 由显示页面中sortBy(sorterName)方法把参数赋值给action中的pageInfo.sorterName这个对象中的属性
	 */
	private String sorterName;
	/**
	 * 通过sortBy方法把排序的值赋给action中的pageInfo.sorterDirection这个对象中的属性
	 */
	private String sorterDirection;
	
	public String getSorterDirection() {
		return sorterDirection;
	}
	public void setSorterDirection(String sorterDirection) {
		this.sorterDirection = sorterDirection;
	}
	public String getSorterName() {
		return sorterName;
	}
	public void setSorterName(String sorterName) {
		this.sorterName = sorterName;
	}
}

