/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*    */ import org.hi.studio.hsceditor.visual.model.DommainModel;
/*    */ 
/*    */ public class DommainTreeEditPart extends AbstractDBTreeEditPart
/*    */ {
/*    */   protected void refreshVisuals()
/*    */   {
/*  9 */     DommainModel model = (DommainModel)getModel();
/*    */ 
/* 11 */     StringBuilder sb = new StringBuilder();
/* 12 */     sb.append(model.getName()).append(" - ");
/* 13 */     sb.append(model.getType().getName());
/* 14 */     if (model.getType().supportSize()) {
/* 15 */       sb.append("(").append(model.getSize()).append(")");
/*    */     }
/*    */ 
/* 18 */     setWidgetText(sb.toString());
/* 19 */     setWidgetImage(DBPlugin.getImage("icons/domain.gif"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.DommainTreeEditPart
 * JD-Core Version:    0.6.0
 */