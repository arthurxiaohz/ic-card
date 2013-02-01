/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelCell;
/*    */ import org.hi.base.report.excel.service.ExcelCellManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelCellRemoveAction extends BaseAction
/*    */ {
/*    */   private ExcelCell excelCell;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
/* 14 */     excelCellMgr.removeExcelCellById(this.excelCell.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelCell getExcelCell() {
/* 19 */     return this.excelCell;
/*    */   }
/*    */ 
/*    */   public void setExcelCell(ExcelCell excelCell) {
/* 23 */     this.excelCell = excelCell;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelCellRemoveAction
 * JD-Core Version:    0.6.0
 */