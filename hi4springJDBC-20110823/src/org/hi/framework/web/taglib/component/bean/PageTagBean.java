/*    */ package org.hi.framework.web.taglib.component.bean;
/*    */ 
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*    */ 
/*    */ public class PageTagBean extends TagInfoBean
/*    */ {
/*    */   private Page page;
/*    */   private String pageBeanName;
/*    */   private String currentPage;
/*    */   private String form;
/*    */   private String lookup;
/*    */   private String pageSize;
/*    */   private String textClass;
/*    */   private String buttonClass;
/*    */   private String currentPageClass;
/*    */ 
/*    */   public String getCurrentPage()
/*    */   {
/* 23 */     return this.currentPage;
/*    */   }
/*    */   public void setCurrentPage(String currentPage) {
/* 26 */     this.currentPage = currentPage;
/*    */   }
/*    */   public String getForm() {
/* 29 */     return this.form;
/*    */   }
/*    */   public void setForm(String form) {
/* 32 */     this.form = form;
/*    */   }
/*    */   public Page getPage() {
/* 35 */     return this.page;
/*    */   }
/*    */   public void setPage(Page page) {
/* 38 */     this.page = page;
/*    */   }
/*    */   public String getPageBeanName() {
/* 41 */     return this.pageBeanName;
/*    */   }
/*    */   public void setPageBeanName(String pageBeanName) {
/* 44 */     this.pageBeanName = pageBeanName;
/*    */   }
/*    */   public String getLookup() {
/* 47 */     return this.lookup;
/*    */   }
/*    */   public void setLookup(String lookup) {
/* 50 */     this.lookup = lookup;
/*    */   }
/*    */   public String getPageSize() {
/* 53 */     return this.pageSize;
/*    */   }
/*    */   public void setPageSize(String pageSize) {
/* 56 */     this.pageSize = pageSize;
/*    */   }
/*    */   public String getButtonClass() {
/* 59 */     return this.buttonClass;
/*    */   }
/*    */   public void setButtonClass(String buttonClass) {
/* 62 */     this.buttonClass = buttonClass;
/*    */   }
/*    */   public String getTextClass() {
/* 65 */     return this.textClass;
/*    */   }
/*    */   public void setTextClass(String textClass) {
/* 68 */     this.textClass = textClass;
/*    */   }
/*    */   public String getCurrentPageClass() {
/* 71 */     return this.currentPageClass;
/*    */   }
/*    */   public void setCurrentPageClass(String currentPageClass) {
/* 74 */     this.currentPageClass = currentPageClass;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.bean.PageTagBean
 * JD-Core Version:    0.6.0
 */