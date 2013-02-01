/*    */ package org.hi.base.report.excel.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.report.excel.model.ExcelReportDesign;
/*    */ import org.hi.base.report.excel.service.ExcelReportDesignManager;
/*    */ import org.hi.common.util.BizNumberUtil;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class ExcelReportDesignManagerImpl extends ManagerImpl
/*    */   implements ExcelReportDesignManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 15 */     ExcelReportDesign erd = (ExcelReportDesign)obj;
/* 16 */     if ((erd.getId() == null) && ((erd.getReportNum() == null) || (erd.getReportNum().trim().equals("")))) {
/* 17 */       erd.setReportNum(BizNumberUtil.genNumber(4, "reportNum", ExcelReportDesign.class));
/*    */     }
/* 19 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 24 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 29 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 34 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveExcelReportDesign(ExcelReportDesign excelReportDesign)
/*    */   {
/* 39 */     saveObject(excelReportDesign);
/*    */   }
/*    */ 
/*    */   public void removeExcelReportDesignById(Integer id)
/*    */   {
/* 44 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public ExcelReportDesign getExcelReportDesignById(Integer id)
/*    */   {
/* 49 */     return (ExcelReportDesign)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<ExcelReportDesign> getExcelReportDesignList(PageInfo pageInfo) {
/* 53 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityExcelReportDesign(ExcelReportDesign excelReportDesign) {
/* 57 */     saveObject(excelReportDesign);
/*    */   }
/*    */   public void removeSecurityExcelReportDesignById(Integer id) {
/* 60 */     removeObjectById(id);
/*    */   }
/*    */   public ExcelReportDesign getSecurityExcelReportDesignById(Integer id) {
/* 63 */     return (ExcelReportDesign)getObjectById(id);
/*    */   }
/*    */   public List<ExcelReportDesign> getSecurityExcelReportDesignList(PageInfo pageInfo) {
/* 66 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.service.impl.ExcelReportDesignManagerImpl
 * JD-Core Version:    0.6.0
 */