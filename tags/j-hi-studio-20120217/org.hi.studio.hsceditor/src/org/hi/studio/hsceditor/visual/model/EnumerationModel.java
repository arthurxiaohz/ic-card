/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.draw2d.geometry.Rectangle;
/*    */ 
/*    */ public class EnumerationModel extends TableModel
/*    */ {
/* 14 */   private String enumName = "";
/* 15 */   private String enumDesc = "";
/*    */ 
/* 17 */   public String getEnumName() { return this.enumName; }
/*    */ 
/*    */   public void setEnumName(String enumName) {
/* 20 */     this.enumName = enumName;
/*    */   }
/*    */   public String getEnumDesc() {
/* 23 */     return this.enumDesc;
/*    */   }
/*    */   public void setEnumDesc(String enumDesc) {
/* 26 */     this.enumDesc = enumDesc;
/*    */   }
/*    */ 
/*    */   public ICloneableModel clone() {
/* 30 */     EnumerationModel table = new EnumerationModel();
/* 31 */     table.setTableName(getTableName());
/* 32 */     table.setLogicalName(getLogicalName());
/* 33 */     table.setDescription(getDescription());
/* 34 */     table.setLinkedPath(getLinkedPath());
/* 35 */     table.setConstraint(new Rectangle(getConstraint()));
/* 36 */     table.setBackgroundColor(getBackgroundColor());
/*    */ 
/* 38 */     ColumnModel[] oldColumns = getColumns();
/* 39 */     new ColumnModel[oldColumns.length];
/* 40 */     List columns = new ArrayList();
/* 41 */     for (int i = 0; i < oldColumns.length; i++) {
/* 42 */       if (!oldColumns[i].isParent())
/* 43 */         columns.add(oldColumns[i].toNewColumn());
/*    */     }
/* 45 */     table.setColumns((ColumnModel[])columns.toArray(new ColumnModel[columns.size()]));
/* 46 */     table.setEnumName(getEnumName());
/* 47 */     table.setEnumDesc(getEnumDesc());
/*    */ 
/* 50 */     return table;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.EnumerationModel
 * JD-Core Version:    0.6.0
 */