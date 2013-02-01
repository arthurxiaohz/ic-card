/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelCell;
/*    */ import org.hi.base.report.excel.service.ExcelCellManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelCellSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private ExcelCell excelCell;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.excelCell) != null) return returnCommand();
/* 14 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/* 15 */     excelCellMgr.saveExcelCell(this.excelCell);
/* 16 */     super.postExecute(this.excelCell);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelCell getExcelCell() {
/* 21 */     return this.excelCell;
/*    */   }
/*    */ 
/*    */   public void setExcelCell(ExcelCell excelCell) {
/* 25 */     this.excelCell = excelCell;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelCellSaveAction
 * JD-Core Version:    0.6.0
 */