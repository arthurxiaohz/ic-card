package org.hi.framework.paging.impl;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

/**
 * @author ’≈Íª
 * @since 2006-12-16
 * @see org.hi.framework.paging.PageInfo
 */
public class PageInfoImpl implements PageInfo{

	private static final long serialVersionUID = -4929157234599076084L;
	private Page page;
	private Filter filter;
	private Sorter sorter;
	
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#getFilter()
	 */
	public Filter getFilter() {
		return filter;
	}
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#setFilter(org.hi.framework.dao.Filter)
	 */
	public void setFilter(Filter filter) {
		if(this.filter == null)
			this.filter = filter;
		else
			this.filter.addFilter(filter);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#getPage()
	 */
	public Page getPage() {
		return page;
	}
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#setPage(org.hi.framework.paging.Page)
	 */
	public void setPage(Page page) {
		this.page = page;
	}
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#getSorter()
	 */
	public Sorter getSorter() {
		return sorter;
	}
	/* (non-Javadoc)
	 * @see org.hi.framework.paging.PageInfo#setSorter(org.hi.framework.dao.Sorter)
	 */
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
}
