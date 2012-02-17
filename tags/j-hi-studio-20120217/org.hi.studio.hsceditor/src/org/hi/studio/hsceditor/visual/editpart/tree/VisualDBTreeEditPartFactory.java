/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.EditPartFactory;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.DommainModel;
/*    */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class VisualDBTreeEditPartFactory
/*    */   implements EditPartFactory
/*    */ {
/*    */   public EditPart createEditPart(EditPart context, Object model)
/*    */   {
/* 16 */     EditPart part = null;
/* 17 */     if ((model instanceof RootModel))
/* 18 */       part = new RootTreeEditPart();
/* 19 */     else if ((model instanceof TableModel))
/* 20 */       part = new TableTreeEditPart();
/* 21 */     else if ((model instanceof ColumnModel))
/* 22 */       part = new ColumnTreeEditPart();
/* 23 */     else if ((model instanceof FolderTreeEditPart.FolderModel))
/* 24 */       part = new FolderTreeEditPart();
/* 25 */     else if ((model instanceof DommainModel))
/* 26 */       part = new DommainTreeEditPart();
/* 27 */     else if ((model instanceof IndexModel)) {
/* 28 */       part = new IndexTreeEditPart();
/*    */     }
/* 30 */     if (part != null) {
/* 31 */       part.setModel(model);
/*    */     }
/* 33 */     return part;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.VisualDBTreeEditPartFactory
 * JD-Core Version:    0.6.0
 */