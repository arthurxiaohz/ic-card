/*    */ package org.hi.studio.hsceditor.visual.editpart;
/*    */ 
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.EditPartFactory;
/*    */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class DBEditPartFactory
/*    */   implements EditPartFactory
/*    */ {
/*    */   public EditPart createEditPart(EditPart context, Object model)
/*    */   {
/* 13 */     EditPart part = null;
/*    */ 
/* 15 */     if ((model instanceof RootModel))
/* 16 */       part = new RootEditPart();
/* 17 */     else if ((model instanceof TableModel))
/* 18 */       part = new TableEditPart();
/* 19 */     else if ((model instanceof ForeignKeyModel)) {
/* 20 */       part = new ForeignKeyEditPart();
/*    */     }
/*    */ 
/* 23 */     if (part != null) {
/* 24 */       part.setModel(model);
/*    */     }
/*    */ 
/* 27 */     return part;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.DBEditPartFactory
 * JD-Core Version:    0.6.0
 */