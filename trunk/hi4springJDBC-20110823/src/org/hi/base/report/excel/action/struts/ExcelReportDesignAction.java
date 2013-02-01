/*     */ package org.hi.base.report.excel.action.struts;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.report.excel.action.ExcelReportDesignPageInfo;
/*     */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*     */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class ExcelReportDesignAction extends BaseAction
/*     */ {
/*     */   private ExcelReportDesign excelReportDesign;
/*     */   private ExcelReportDesignPageInfo pageInfo;
/*     */   private List<ExcelReportDesign> excelReportDesigns;
/*     */   private String orderIndexs;
/*     */   private File template;
/*     */   private String templateFileName;
/*     */   private String templateContentType;
/*     */ 
/*     */   public String saveExcelReportDesign()
/*     */     throws Exception
/*     */   {
/*  28 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*  29 */     if (super.perExecute(this.excelReportDesign) != null) return returnCommand();
/*     */ 
/*  32 */     if (this.template != null) {
/*  33 */       String imagePath = saveFile(this.template, this.templateFileName, "report");
/*  34 */       this.excelReportDesign.setTemplate(imagePath);
/*     */     }
/*     */ 
/*  38 */     excelReportDesignMgr.saveExcelReportDesign(this.excelReportDesign);
/*  39 */     super.postExecute(this.excelReportDesign);
/*  40 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeExcelReportDesign()
/*     */     throws Exception
/*     */   {
/*  48 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*  49 */     excelReportDesignMgr.removeExcelReportDesignById(this.excelReportDesign.getId());
/*  50 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllExcelReportDesign()
/*     */     throws Exception
/*     */   {
/*  57 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*  58 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  60 */       String[] ids = this.orderIndexs.split(",");
/*  61 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  63 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  65 */         Integer excelReportDesignid = new Integer(ids[i]);
/*  66 */         excelReportDesignMgr.removeExcelReportDesignById(excelReportDesignid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  71 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewExcelReportDesign()
/*     */     throws Exception
/*     */   {
/*  78 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*  79 */     this.excelReportDesign = excelReportDesignMgr.getExcelReportDesignById(this.excelReportDesign.getId());
/*  80 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String excelReportDesignList()
/*     */     throws Exception
/*     */   {
/*  87 */     ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
/*  88 */     this.pageInfo = (this.pageInfo == null ? new ExcelReportDesignPageInfo() : this.pageInfo);
/*  89 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  91 */     this.excelReportDesigns = excelReportDesignMgr.getSecurityExcelReportDesignList(sarchPageInfo);
/*     */ 
/*  93 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public ExcelReportDesign getExcelReportDesign()
/*     */   {
/* 100 */     return this.excelReportDesign;
/*     */   }
/*     */ 
/*     */   public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 104 */     this.excelReportDesign = excelReportDesign;
/*     */   }
/*     */ 
/*     */   public List<ExcelReportDesign> getExcelReportDesigns() {
/* 108 */     return this.excelReportDesigns;
/*     */   }
/*     */ 
/*     */   public void setExcelReportDesigns(List<ExcelReportDesign> excelReportDesigns) {
/* 112 */     this.excelReportDesigns = excelReportDesigns;
/*     */   }
/*     */ 
/*     */   public ExcelReportDesignPageInfo getPageInfo() {
/* 116 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(ExcelReportDesignPageInfo pageInfo) {
/* 120 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 124 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 128 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */   public File getTemplate() {
/* 131 */     return this.template;
/*     */   }
/*     */ 
/*     */   public void setTemplate(File template) {
/* 135 */     this.template = template;
/*     */   }
/*     */ 
/*     */   public String getTemplateContentType() {
/* 139 */     return this.templateContentType;
/*     */   }
/*     */ 
/*     */   public void setTemplateContentType(String templateContentType) {
/* 143 */     this.templateContentType = templateContentType;
/*     */   }
/*     */ 
/*     */   public String getTemplateFileName() {
/* 147 */     return this.templateFileName;
/*     */   }
/*     */ 
/*     */   public void setTemplateFileName(String templateFileName) {
/* 151 */     this.templateFileName = templateFileName;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.struts.ExcelReportDesignAction
 * JD-Core Version:    0.6.0
 */