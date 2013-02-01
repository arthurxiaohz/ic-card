/*     */ package org.hi.base.report.excel.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.report.excel.action.ExcelSheetPageInfo;
/*     */ import org.hi.base.report.excel.model.ExcelSheet;
/*     */ import org.hi.base.report.excel.service.ExcelSheetManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class ExcelSheetAction extends BaseAction
/*     */ {
/*     */   private ExcelSheet excelSheet;
/*     */   private ExcelSheetPageInfo pageInfo;
/*     */   private List<ExcelSheet> excelSheets;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveExcelSheet()
/*     */     throws Exception
/*     */   {
/*  25 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/*  26 */     if (super.perExecute(this.excelSheet) != null) return returnCommand();
/*  27 */     excelSheetMgr.saveExcelSheet(this.excelSheet);
/*  28 */     super.postExecute(this.excelSheet);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeExcelSheet()
/*     */     throws Exception
/*     */   {
/*  37 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/*  38 */     excelSheetMgr.removeExcelSheetById(this.excelSheet.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllExcelSheet()
/*     */     throws Exception
/*     */   {
/*  46 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer excelSheetid = new Integer(ids[i]);
/*  55 */         excelSheetMgr.removeExcelSheetById(excelSheetid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewExcelSheet()
/*     */     throws Exception
/*     */   {
/*  67 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/*  68 */     this.excelSheet = excelSheetMgr.getExcelSheetById(this.excelSheet.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String excelSheetList()
/*     */     throws Exception
/*     */   {
/*  76 */     ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new ExcelSheetPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.excelSheets = excelSheetMgr.getSecurityExcelSheetList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public ExcelSheet getExcelSheet()
/*     */   {
/*  89 */     return this.excelSheet;
/*     */   }
/*     */ 
/*     */   public void setExcelSheet(ExcelSheet excelSheet) {
/*  93 */     this.excelSheet = excelSheet;
/*     */   }
/*     */ 
/*     */   public List<ExcelSheet> getExcelSheets() {
/*  97 */     return this.excelSheets;
/*     */   }
/*     */ 
/*     */   public void setExcelSheets(List<ExcelSheet> excelSheets) {
/* 101 */     this.excelSheets = excelSheets;
/*     */   }
/*     */ 
/*     */   public ExcelSheetPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(ExcelSheetPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.struts.ExcelSheetAction
 * JD-Core Version:    0.6.0
 */