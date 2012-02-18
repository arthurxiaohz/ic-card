/**
 * 
 */
package org.hi.framework.web.taglib;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;

import org.hi.framework.paging.Page;
import org.hi.framework.web.taglib.component.TagBuilder;
import org.hi.framework.web.taglib.component.TagBuilderFactory;
import org.hi.framework.web.taglib.component.bean.PageTagBean;

/**
 * 分页标签，从request中获得Page对象，通过page对象进行分页，如果没有发现page对象就不进行
 * tag生成，自动跳出
 * @author wei.li
 * 
 */
public class PageTag extends AbstractTag {
	private String pageBeanName;
	private String form;
	private String currentPage;
	private String url;
	private String textClass;
	private String buttonClass;
	private String currentPageClass;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageBeanName() {
		return pageBeanName;
	}

	public void setPageBeanName(String pageBeanName) {
		this.pageBeanName = pageBeanName;
	}

	public int doEndTag() throws JspException {
		StringBuffer sb = new StringBuffer();
		Page page = getPage(pageContext.getRequest());
		if (page == null) {
			return EVAL_PAGE;
		}
	
		if(getParameter("currentPage", "pageInfo") != null )currentPage = getParameter("currentPage","pageInfo").toString();	// add by xiao set currentPage value
		
		TagBuilder builder = TagBuilderFactory.getPageTagBuilder();
		PageTagBean bean = new PageTagBean();
		
		if(this.currentPage == null || this.currentPage.trim().equals(""))
			this.currentPage = "1";
		bean.setCurrentPage(this.currentPage);
		
		bean.setUrl(this.url);
		bean.setForm(this.form);
		
		if(this.pageBeanName == null || this.pageBeanName.trim().equals(""))
			this.pageBeanName = "pageInfo";
		bean.setPageBeanName(this.pageBeanName);
		
		bean.setPage(page);
		bean.setLookup(pageContext.getRequest().getParameter("lookup"));
		bean.setPageSize(getParameter("pageInfo.pageSize").toString());
		bean.setButtonClass(buttonClass);
		bean.setTextClass(textClass);
		bean.setCurrentPageClass(currentPageClass);
		
		String html = builder.build(bean);
		try {
			pageContext.getOut().print(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	private Page getPage(ServletRequest request) {
		Object page = null;
		if ((page = request.getAttribute(this.getPageBeanName())) != null) {
			return (Page) page;
		}
		return (Page) page;
	}

	public String getAction() {
		return form;
	}

	public void setAction(String action) {
		this.form = action;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getButtonClass() {
		return buttonClass;
	}

	public void setButtonClass(String buttonClass) {
		this.buttonClass = buttonClass;
	}

	public String getCurrentPageClass() {
		return currentPageClass;
	}

	public void setCurrentPageClass(String currentPageClass) {
		this.currentPageClass = currentPageClass;
	}

	public String getTextClass() {
		return textClass;
	}

	public void setTextClass(String textClass) {
		this.textClass = textClass;
	}

}
