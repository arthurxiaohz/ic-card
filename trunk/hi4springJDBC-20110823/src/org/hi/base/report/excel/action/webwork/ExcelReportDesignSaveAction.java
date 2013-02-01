/*    */ package org.hi.base.report.excel.action.webwork;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*    */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class ExcelReportDesignSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private ExcelReportDesign excelReportDesign;
/*    */   private File template;
/*    */   private String templateFileName;
/*    */   private String templateContentType;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 21 */     if (super.perExecute(null) != null) return returnCommand();
/* 22 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*    */ 
/* 24 */     if (this.template != null) {
/* 25 */       String imagePath = saveFile(this.template, this.templateFileName, "report");
/* 26 */       this.excelReportDesign.setTemplate(imagePath);
/*    */     }
/*    */ 
/* 31 */     excelReportDesignMgr.saveExcelReportDesign(this.excelReportDesign);
/* 32 */     super.postExecute(null);
/* 33 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public ExcelReportDesign getExcelReportDesign() {
/* 37 */     return this.excelReportDesign;
/*    */   }
/*    */ 
/*    */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 41 */     this.excelReportDesign = excelReportDesign;
/*    */   }
/*    */ 
/*    */   public File getTemplate() {
/* 45 */     return this.template;
/*    */   }
/*    */ 
/*    */   public void setTemplate(File template) {
/* 49 */     this.template = template;
/*    */   }
/*    */ 
/*    */   public String getTemplateContentType() {
/* 53 */     return this.templateContentType;
/*    */   }
/*    */ 
/*    */   public void setTemplateContentType(String templateContentType) {
/* 57 */     this.templateContentType = templateContentType;
/*    */   }
/*    */ 
/*    */   public String getTemplateFileName() {
/* 61 */     return this.templateFileName;
/*    */   }
/*    */ 
/*    */   public void setTemplateFileName(String templateFileName) {
/* 65 */     this.templateFileName = templateFileName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ExcelReportDesignSaveAction
 * JD-Core Version:    0.6.0
 */