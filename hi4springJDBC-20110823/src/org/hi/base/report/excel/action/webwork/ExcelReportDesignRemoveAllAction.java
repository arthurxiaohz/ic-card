/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*    */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelReportDesignRemoveAllAction extends BaseAction
/*    */ {
/*    */   private ExcelReportDesign excelReportDesign;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer excelReportDesignid = new Integer(ids[i]);
/* 24 */         excelReportDesignMgr.removeExcelReportDesignById(excelReportDesignid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelReportDesign getExcelReportDesign() {
/* 33 */     return this.excelReportDesign;
/*    */   }
/*    */ 
/*    */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 37 */     this.excelReportDesign = excelReportDesign;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelReportDesignRemoveAllAction
 * JD-Core Version:    0.6.0
 */