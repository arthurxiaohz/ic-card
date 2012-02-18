package org.hi.framework.web.taglib.component.bean;

import org.hi.framework.paging.Page;
import org.hi.framework.web.taglib.component.TagInfoBean;

/**
 * @author zhanghao
 *
 */
public class PageTagBean extends TagInfoBean {

	private Page page;
	private String pageBeanName;
	private String currentPage;
	private String form;
	private String lookup;
	private String pageSize;
	private String textClass;
	private String buttonClass;
	private String currentPageClass;
	
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getPageBeanName() {
		return pageBeanName;
	}
	public void setPageBeanName(String pageBeanName) {
		this.pageBeanName = pageBeanName;
	}
	public String getLookup() {
		return lookup;
	}
	public void setLookup(String lookup) {
		this.lookup = lookup;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getButtonClass() {
		return buttonClass;
	}
	public void setButtonClass(String buttonClass) {
		this.buttonClass = buttonClass;
	}
	public String getTextClass() {
		return textClass;
	}
	public void setTextClass(String textClass) {
		this.textClass = textClass;
	}
	public String getCurrentPageClass() {
		return currentPageClass;
	}
	public void setCurrentPageClass(String currentPageClass) {
		this.currentPageClass = currentPageClass;
	}
}
