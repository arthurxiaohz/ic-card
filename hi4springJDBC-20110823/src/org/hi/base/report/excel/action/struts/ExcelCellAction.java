/*     */ package org.hi.base.report.excel.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.report.excel.action.ExcelCellPageInfo;
/*     */ import org.hi.base.report.excel.model.ExcelCell;
/*     */ import org.hi.base.report.excel.service.ExcelCellManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class ExcelCellAction extends BaseAction
/*     */ {
/*     */   private ExcelCell excelCell;
/*     */   private ExcelCellPageInfo pageInfo;
/*     */   private List<ExcelCell> excelCells;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveExcelCell()
/*     */     throws Exception
/*     */   {
/*  25 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/*  26 */     if (super.perExecute(this.excelCell) != null) return returnCommand();
/*  27 */     excelCellMgr.saveExcelCell(this.excelCell);
/*  28 */     super.postExecute(this.excelCell);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeExcelCell()
/*     */     throws Exception
/*     */   {
/*  37 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/*  38 */     excelCellMgr.removeExcelCellById(this.excelCell.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllExcelCell()
/*     */     throws Exception
/*     */   {
/*  46 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer excelCellid = new Integer(ids[i]);
/*  55 */         excelCellMgr.removeExcelCellById(excelCellid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewExcelCell()
/*     */     throws Exception
/*     */   {
/*  67 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/*  68 */     this.excelCell = excelCellMgr.getExcelCellById(this.excelCell.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String excelCellList()
/*     */     throws Exception
/*     */   {
/*  76 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new ExcelCellPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.excelCells = excelCellMgr.getSecurityExcelCellList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public ExcelCell getExcelCell()
/*     */   {
/*  89 */     return this.excelCell;
/*     */   }
/*     */ 
/*     */   public void setExcelCell(ExcelCell excelCell) {
/*  93 */     this.excelCell = excelCell;
/*     */   }
/*     */ 
/*     */   public List<ExcelCell> getExcelCells() {
/*  97 */     return this.excelCells;
/*     */   }
/*     */ 
/*     */   public void setExcelCells(List<ExcelCell> excelCells) {
/* 101 */     this.excelCells = excelCells;
/*     */   }
/*     */ 
/*     */   public ExcelCellPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(ExcelCellPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.struts.ExcelCellAction
 * JD-Core Version:    0.6.0
 */