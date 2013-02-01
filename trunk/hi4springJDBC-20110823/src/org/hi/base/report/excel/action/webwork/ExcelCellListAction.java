/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.action.ExcelCellPageInfo;
/*    */ import org.hi.base.report.excel.model.ExcelCell;
/*    */ import org.hi.base.report.excel.service.ExcelCellManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelCellListAction extends BaseAction
/*    */ {
/*    */   private ExcelCell excelCell;
/*    */   private ExcelCellPageInfo pageInfo;
/*    */   private List<ExcelCell> excelCells;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new ExcelCellPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo);
/*    */ 
/* 24 */     this.excelCells = excelCellMgr.getExcelCellList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelCell getExcelCell() {
/* 30 */     return this.excelCell;
/*    */   }
/*    */ 
/*    */   public void setExcelCell(ExcelCell excelCell) {
/* 34 */     this.excelCell = excelCell;
/*    */   }
/*    */ 
/*    */   public List<ExcelCell> getExcelCells() {
/* 38 */     return this.excelCells;
/*    */   }
/*    */ 
/*    */   public void setExcelCells(List<ExcelCell> excelCells) {
/* 42 */     this.excelCells = excelCells;
/*    */   }
/*    */ 
/*    */   public ExcelCellPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(ExcelCellPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelCellListAction
 * JD-Core Version:    0.6.0
 */