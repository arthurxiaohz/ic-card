/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelSheet;
/*    */ import org.hi.base.report.excel.service.ExcelSheetManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelSheetSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private ExcelSheet excelSheet;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.excelSheet) != null) return returnCommand();
/* 14 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/* 15 */     excelSheetMgr.saveExcelSheet(this.excelSheet);
/* 16 */     super.postExecute(this.excelSheet);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelSheet getExcelSheet() {
/* 21 */     return this.excelSheet;
/*    */   }
/*    */ 
/*    */   public void setExcelSheet(ExcelSheet excelSheet) {
/* 25 */     this.excelSheet = excelSheet;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelSheetSaveAction
 * JD-Core Version:    0.6.0
 */