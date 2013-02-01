/*    */ package org.hi.framework.paging.impl;
/*    */ 
/*    */ import org.hi.framework.dao.Filter;
/*    */ import org.hi.framework.dao.Sorter;
/*    */ import org.hi.framework.paging.Page;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ 
/*    */ public class PageInfoImpl
/*    */   implements PageInfo
/*    */ {
/*    */   private static final long serialVersionUID = -4929157234599076084L;
/*    */   private Page page;
/*    */   private Filter filter;
/*    */   private Sorter sorter;
/*    */ 
/*    */   public Filter getFilter()
/*    */   {
/* 24 */     return this.filter;
/*    */   }
/*    */ 
/*    */   public void setFilter(Filter filter)
/*    */   {
/* 30 */     if (this.filter == null)
/* 31 */       this.filter = filter;
/*    */     else
/* 33 */       this.filter.addFilter(filter);
/*    */   }
/*    */ 
/*    */   public Page getPage()
/*    */   {
/* 40 */     return this.page;
/*    */   }
/*    */ 
/*    */   public void setPage(Page page)
/*    */   {
/* 46 */     this.page = page;
/*    */   }
/*    */ 
/*    */   public Sorter getSorter()
/*    */   {
/* 52 */     return this.sorter;
/*    */   }
/*    */ 
/*    */   public void setSorter(Sorter sorter)
/*    */   {
/* 58 */     this.sorter = sorter;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.paging.impl.PageInfoImpl
 * JD-Core Version:    0.6.0
 */