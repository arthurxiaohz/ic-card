/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.action.ExcelSheetPageInfo;
/*    */ import org.hi.base.report.excel.model.ExcelSheet;
/*    */ import org.hi.base.report.excel.service.ExcelSheetManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelSheetListAction extends BaseAction
/*    */ {
/*    */   private ExcelSheet excelSheet;
/*    */   private ExcelSheetPageInfo pageInfo;
/*    */   private List<ExcelSheet> excelSheets;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new ExcelSheetPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo);
/*    */ 
/* 24 */     this.excelSheets = excelSheetMgr.getExcelSheetList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelSheet getExcelSheet() {
/* 30 */     return this.excelSheet;
/*    */   }
/*    */ 
/*    */   public void setExcelSheet(ExcelSheet excelSheet) {
/* 34 */     this.excelSheet = excelSheet;
/*    */   }
/*    */ 
/*    */   public List<ExcelSheet> getExcelSheets() {
/* 38 */     return this.excelSheets;
/*    */   }
/*    */ 
/*    */   public void setExcelSheets(List<ExcelSheet> excelSheets) {
/* 42 */     this.excelSheets = excelSheets;
/*    */   }
/*    */ 
/*    */   public ExcelSheetPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(ExcelSheetPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelSheetListAction
 * JD-Core Version:    0.6.0
 */