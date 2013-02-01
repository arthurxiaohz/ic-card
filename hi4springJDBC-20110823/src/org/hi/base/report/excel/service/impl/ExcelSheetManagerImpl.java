/*    */ package org.hi.base.report.excel.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.report.excel.model.ExcelSheet;
/*    */ import org.hi.base.report.excel.service.ExcelSheetManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class ExcelSheetManagerImpl extends ManagerImpl
/*    */   implements ExcelSheetManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 14 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 19 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 24 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 29 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveExcelSheet(ExcelSheet excelSheet)
/*    */   {
/* 34 */     saveObject(excelSheet);
/*    */   }
/*    */ 
/*    */   public void removeExcelSheetById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public ExcelSheet getExcelSheetById(Integer id)
/*    */   {
/* 44 */     return (ExcelSheet)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<ExcelSheet> getExcelSheetList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityExcelSheet(ExcelSheet excelSheet) {
/* 52 */     saveObject(excelSheet);
/*    */   }
/*    */   public void removeSecurityExcelSheetById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public ExcelSheet getSecurityExcelSheetById(Integer id) {
/* 58 */     return (ExcelSheet)getObjectById(id);
/*    */   }
/*    */   public List<ExcelSheet> getSecurityExcelSheetList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.service.impl.ExcelSheetManagerImpl
 * JD-Core Version:    0.6.0
 */