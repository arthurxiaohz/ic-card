/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.action.ExcelReportDesignPageInfo;
/*    */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*    */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelReportDesignListAction extends BaseAction
/*    */ {
/*    */   private ExcelReportDesign excelReportDesign;
/*    */   private ExcelReportDesignPageInfo pageInfo;
/*    */   private List<ExcelReportDesign> excelReportDesigns;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/* 21 */     this.pageInfo = (this.pageInfo == null ? new ExcelReportDesignPageInfo() : this.pageInfo);
/* 22 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 24 */     this.excelReportDesigns = excelReportDesignMgr.getExcelReportDesignList(sarchPageInfo);
/*    */ 
/* 26 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelReportDesign getExcelReportDesign() {
/* 30 */     return this.excelReportDesign;
/*    */   }
/*    */ 
/*    */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 34 */     this.excelReportDesign = excelReportDesign;
/*    */   }
/*    */ 
/*    */   public List<ExcelReportDesign> getExcelReportDesigns() {
/* 38 */     return this.excelReportDesigns;
/*    */   }
/*    */ 
/*    */   public void setExcelReportDesigns(List<ExcelReportDesign> excelReportDesigns) {
/* 42 */     this.excelReportDesigns = excelReportDesigns;
/*    */   }
/*    */ 
/*    */   public ExcelReportDesignPageInfo getPageInfo() {
/* 46 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(ExcelReportDesignPageInfo pageInfo) {
/* 50 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelReportDesignListAction
 * JD-Core Version:    0.6.0
 */