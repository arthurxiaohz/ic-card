/*     */ package org.hi.framework.paging.impl;
/*     */ 
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.Page;
/*     */ 
/*     */ public class PageImpl
/*     */   implements Page
/*     */ {
/*     */   private static final long serialVersionUID = 6058623216294866584L;
/*  18 */   private int totalRecords = 0;
/*     */ 
/*  23 */   private int totalPage = 0;
/*     */ 
/*  28 */   private int currentPage = 1;
/*     */ 
/*  33 */   private boolean isFristPage = true;
/*     */ 
/*  38 */   private boolean isLastPage = false;
/*     */ 
/*  44 */   private int pageSize = HiConfigHolder.getPageSize();
/*     */ 
/*  49 */   private int startRowPosition = 0;
/*     */ 
/*  54 */   private int endRowPosition = 0;
/*     */ 
/*  59 */   private int maxRecords = HiConfigHolder.getMaxRecords();
/*     */ 
/*     */   public int getCurrentPage()
/*     */   {
/*  64 */     return this.currentPage;
/*     */   }
/*     */ 
/*     */   public void setCurrentPage(int currentPage)
/*     */   {
/*  71 */     this.currentPage = currentPage;
/*     */   }
/*     */ 
/*     */   public int getEndRowPosition()
/*     */   {
/*  78 */     return this.endRowPosition;
/*     */   }
/*     */ 
/*     */   public void setEndRowPosition(int endRowPosition)
/*     */   {
/*  85 */     this.endRowPosition = endRowPosition;
/*     */   }
/*     */ 
/*     */   public boolean getIsFristPage()
/*     */   {
/*  92 */     return this.isFristPage;
/*     */   }
/*     */ 
/*     */   public void setIsFristPage(boolean isFristPage)
/*     */   {
/*  99 */     this.isFristPage = isFristPage;
/*     */   }
/*     */ 
/*     */   public boolean getIsLastPage()
/*     */   {
/* 106 */     return this.isLastPage;
/*     */   }
/*     */ 
/*     */   public void setIsLastPage(boolean isLastPage)
/*     */   {
/* 113 */     this.isLastPage = isLastPage;
/*     */   }
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/* 120 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 127 */     this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public int getStartRowPosition()
/*     */   {
/* 134 */     return this.startRowPosition;
/*     */   }
/*     */ 
/*     */   public void setStartRowPosition(int startRowPosition)
/*     */   {
/* 141 */     this.startRowPosition = startRowPosition;
/*     */   }
/*     */ 
/*     */   public int getTotalPage()
/*     */   {
/* 148 */     return this.totalPage;
/*     */   }
/*     */ 
/*     */   public void setTotalPage(int totalPage)
/*     */   {
/* 155 */     this.totalPage = totalPage;
/*     */   }
/*     */ 
/*     */   public int getTotalRecords()
/*     */   {
/* 162 */     return this.totalRecords;
/*     */   }
/*     */ 
/*     */   public void setTotalRecords(int totalRecords)
/*     */   {
/* 169 */     this.totalRecords = totalRecords;
/*     */   }
/*     */ 
/*     */   public int getMaxRecords()
/*     */   {
/* 176 */     return this.maxRecords;
/*     */   }
/*     */ 
/*     */   public void setMaxRecords(int maxRecords)
/*     */   {
/* 183 */     this.maxRecords = maxRecords;
/*     */   }
/*     */ 
/*     */   public int getMiddlePageNum()
/*     */   {
/* 188 */     return HiConfigHolder.getCurrnetMiddlePage();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.paging.impl.PageImpl
 * JD-Core Version:    0.6.0
 */