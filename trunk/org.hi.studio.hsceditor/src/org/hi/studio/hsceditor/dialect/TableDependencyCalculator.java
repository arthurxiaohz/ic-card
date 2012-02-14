/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class TableDependencyCalculator
/*    */ {
/*    */   public static List<TableModel> getSortedTable(RootModel root)
/*    */   {
/* 16 */     List result = new ArrayList();
/* 17 */     for (AbstractDBEntityModel child : root.getChildren()) {
/* 18 */       if ((child instanceof TableModel)) {
/* 19 */         TableModel table = (TableModel)child;
/* 20 */         int index = -1;
/* 21 */         for (AbstractDBConnectionModel conn : table.getModelTargetConnections()) {
/* 22 */           ForeignKeyModel fk = (ForeignKeyModel)conn;
/* 23 */           TableModel target = (TableModel)fk.getSource();
/* 24 */           if (result.contains(target)) {
/* 25 */             int targetIndex = result.indexOf(target);
/* 26 */             if (index > targetIndex)
/* 27 */               index = targetIndex;
/* 28 */             else if (index == -1) {
/* 29 */               index = targetIndex;
/*    */             }
/*    */           }
/*    */         }
/* 33 */         if (index >= 0)
/* 34 */           result.add(index, table);
/*    */         else {
/* 36 */           result.add(table);
/*    */         }
/*    */       }
/*    */     }
/* 40 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.TableDependencyCalculator
 * JD-Core Version:    0.6.0
 */