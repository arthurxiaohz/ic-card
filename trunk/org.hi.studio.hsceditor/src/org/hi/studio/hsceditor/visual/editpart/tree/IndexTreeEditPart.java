/*    */ package org.hi.studio.hsceditor.visual.editpart.tree;
/*    */ 
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*    */ 
/*    */ public class IndexTreeEditPart extends AbstractDBTreeEditPart
/*    */ {
/*    */   protected void refreshVisuals()
/*    */   {
/*  9 */     IndexModel model = (IndexModel)getModel();
/* 10 */     setWidgetText(model.toString());
/* 11 */     setWidgetImage(DBPlugin.getImage("icons/index.gif"));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editpart.tree.IndexTreeEditPart
 * JD-Core Version:    0.6.0
 */