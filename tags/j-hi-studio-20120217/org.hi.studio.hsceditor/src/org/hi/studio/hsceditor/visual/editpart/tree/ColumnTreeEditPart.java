/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ 
/*    */ public class ColumnTreeEditPart extends AbstractDBTreeEditPart
/*    */ {
/*    */   protected void refreshVisuals()
/*    */   {
/*  9 */     ColumnModel model = (ColumnModel)getModel();
/*    */ 
/* 11 */     StringBuilder sb = new StringBuilder();
/* 12 */     sb.append(model.getColumnName()).append("(").append(model.getLogicalName()).append(")");
/* 13 */     sb.append(" - ");
/*    */ 
/* 19 */     setWidgetText(sb.toString());
/*    */ 
/* 21 */     if (model.isPrimaryKey())
/* 22 */       setWidgetImage(DBPlugin.getImage("icons/pk_column.gif"));
/*    */     else
/* 24 */       setWidgetImage(DBPlugin.getImage("icons/column.gif"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.ColumnTreeEditPart
 * JD-Core Version:    0.6.0
 */