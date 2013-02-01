/*     */ package org.hi.framework.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagBuilderFactory;
/*     */ import org.hi.framework.web.taglib.component.bean.PageTagBean;
/*     */ 
/*     */ public class PageTag extends AbstractTag
/*     */ {
/*     */   private String pageBeanName;
/*     */   private String form;
/*     */   private String currentPage;
/*     */   private String url;
/*     */   private String textClass;
/*     */   private String buttonClass;
/*     */   private String currentPageClass;
/*     */ 
/*     */   public String getUrl()
/*     */   {
/*  32 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/*  36 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public String getCurrentPage() {
/*  40 */     return this.currentPage;
/*     */   }
/*     */ 
/*     */   public void setCurrentPage(String currentPage) {
/*  44 */     this.currentPage = currentPage;
/*     */   }
/*     */ 
/*     */   public String getPageBeanName() {
/*  48 */     return this.pageBeanName;
/*     */   }
/*     */ 
/*     */   public void setPageBeanName(String pageBeanName) {
/*  52 */     this.pageBeanName = pageBeanName;
/*     */   }
/*     */ 
/*     */   public int doEndTag() throws JspException {
/*  56 */     StringBuffer sb = new StringBuffer();
/*  57 */     Page page = getPage(this.pageContext.getRequest());
/*  58 */     if (page == null) {
/*  59 */       return 6;
/*     */     }
/*     */ 
/*  62 */     if (getParameter("currentPage", "pageInfo") != null) this.currentPage = getParameter("currentPage", "pageInfo").toString();
/*     */ 
/*  64 */     TagBuilder builder = TagBuilderFactory.getPageTagBuilder();
/*  65 */     PageTagBean bean = new PageTagBean();
/*     */ 
/*  67 */     if ((this.currentPage == null) || (this.currentPage.trim().equals("")))
/*  68 */       this.currentPage = "1";
/*  69 */     bean.setCurrentPage(this.currentPage);
/*     */ 
/*  71 */     bean.setUrl(this.url);
/*  72 */     bean.setForm(this.form);
/*     */ 
/*  74 */     if ((this.pageBeanName == null) || (this.pageBeanName.trim().equals("")))
/*  75 */       this.pageBeanName = "pageInfo";
/*  76 */     bean.setPageBeanName(this.pageBeanName);
/*     */ 
/*  78 */     bean.setPage(page);
/*  79 */     bean.setLookup(this.pageContext.getRequest().getParameter("lookup"));
/*  80 */     bean.setPageSize(getParameter("pageInfo.pageSize").toString());
/*  81 */     bean.setButtonClass(this.buttonClass);
/*  82 */     bean.setTextClass(this.textClass);
/*  83 */     bean.setCurrentPageClass(this.currentPageClass);
/*     */ 
/*  85 */     String html = builder.build(bean);
/*     */     try {
/*  87 */       this.pageContext.getOut().print(html);
/*     */     } catch (IOException e) {
/*  89 */       e.printStackTrace();
/*     */     }
/*  91 */     return 6;
/*     */   }
/*     */ 
/*     */   private Page getPage(ServletRequest request) {
/*  95 */     Object page = null;
/*  96 */     if ((page = request.getAttribute(getPageBeanName())) != null) {
/*  97 */       return (Page)page;
/*     */     }
/*  99 */     return (Page)page;
/*     */   }
/*     */ 
/*     */   public String getAction() {
/* 103 */     return this.form;
/*     */   }
/*     */ 
/*     */   public void setAction(String action) {
/* 107 */     this.form = action;
/*     */   }
/*     */ 
/*     */   public String getForm() {
/* 111 */     return this.form;
/*     */   }
/*     */ 
/*     */   public void setForm(String form) {
/* 115 */     this.form = form;
/*     */   }
/*     */ 
/*     */   public String getButtonClass() {
/* 119 */     return this.buttonClass;
/*     */   }
/*     */ 
/*     */   public void setButtonClass(String buttonClass) {
/* 123 */     this.buttonClass = buttonClass;
/*     */   }
/*     */ 
/*     */   public String getCurrentPageClass() {
/* 127 */     return this.currentPageClass;
/*     */   }
/*     */ 
/*     */   public void setCurrentPageClass(String currentPageClass) {
/* 131 */     this.currentPageClass = currentPageClass;
/*     */   }
/*     */ 
/*     */   public String getTextClass() {
/* 135 */     return this.textClass;
/*     */   }
/*     */ 
/*     */   public void setTextClass(String textClass) {
/* 139 */     this.textClass = textClass;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.PageTag
 * JD-Core Version:    0.6.0
 */