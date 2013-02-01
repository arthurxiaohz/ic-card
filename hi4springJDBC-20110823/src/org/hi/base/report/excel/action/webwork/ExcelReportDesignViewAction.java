/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*    */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelReportDesignViewAction extends BaseAction
/*    */ {
/*    */   private ExcelReportDesign excelReportDesign;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/* 14 */     this.excelReportDesign = excelReportDesignMgr.getExcelReportDesignById(this.excelReportDesign.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelReportDesign getExcelReportDesign() {
/* 19 */     return this.excelReportDesign;
/*    */   }
/*    */ 
/*    */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 23 */     this.excelReportDesign = excelReportDesign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelReportDesignViewAction
 * JD-Core Version:    0.6.0
 */