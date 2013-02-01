/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelSheet;
/*    */ import org.hi.base.report.excel.service.ExcelSheetManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelSheetViewAction extends BaseAction
/*    */ {
/*    */   private ExcelSheet excelSheet;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/* 14 */     this.excelSheet = excelSheetMgr.getExcelSheetById(this.excelSheet.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelSheet getExcelSheet() {
/* 19 */     return this.excelSheet;
/*    */   }
/*    */ 
/*    */   public void setExcelSheet(ExcelSheet excelSheet) {
/* 23 */     this.excelSheet = excelSheet;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelSheetViewAction
 * JD-Core Version:    0.6.0
 */