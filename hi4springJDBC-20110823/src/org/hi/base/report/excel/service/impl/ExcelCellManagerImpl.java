/*    */ package org.hi.base.report.excel.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.report.excel.model.ExcelCell;
/*    */ import org.hi.base.report.excel.service.ExcelCellManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class ExcelCellManagerImpl extends ManagerImpl
/*    */   implements ExcelCellManager
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
/*    */   public void saveExcelCell(ExcelCell excelCell)
/*    */   {
/* 34 */     saveObject(excelCell);
/*    */   }
/*    */ 
/*    */   public void removeExcelCellById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public ExcelCell getExcelCellById(Integer id)
/*    */   {
/* 44 */     return (ExcelCell)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<ExcelCell> getExcelCellList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityExcelCell(ExcelCell excelCell) {
/* 52 */     saveObject(excelCell);
/*    */   }
/*    */   public void removeSecurityExcelCellById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public ExcelCell getSecurityExcelCellById(Integer id) {
/* 58 */     return (ExcelCell)getObjectById(id);
/*    */   }
/*    */   public List<ExcelCell> getSecurityExcelCellList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.service.impl.ExcelCellManagerImpl
 * JD-Core Version:    0.6.0
 */