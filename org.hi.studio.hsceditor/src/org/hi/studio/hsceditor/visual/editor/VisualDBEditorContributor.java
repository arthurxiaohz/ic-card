/*    */ package org.hi.studio.hsceditor.visual.editor;
/*    */ 
/*    */ import org.eclipse.gef.ui.actions.ActionBarContributor;
/*    */ import org.eclipse.gef.ui.actions.ActionRegistry;
/*    */ import org.eclipse.gef.ui.actions.DeleteRetargetAction;
/*    */ import org.eclipse.gef.ui.actions.RedoRetargetAction;
/*    */ import org.eclipse.gef.ui.actions.UndoRetargetAction;
/*    */ import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
/*    */ import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
/*    */ import org.eclipse.jface.action.IToolBarManager;
/*    */ 
/*    */ public class VisualDBEditorContributor extends ActionBarContributor
/*    */ {
/*    */   protected void buildActions()
/*    */   {
/* 19 */     addRetargetAction(new UndoRetargetAction());
/* 20 */     addRetargetAction(new RedoRetargetAction());
/* 21 */     addRetargetAction(new DeleteRetargetAction());
/* 22 */     addRetargetAction(new ZoomInRetargetAction());
/* 23 */     addRetargetAction(new ZoomOutRetargetAction());
/*    */   }
/*    */ 
/*    */   public void contributeToToolBar(IToolBarManager toolBarManager) {
/* 27 */     super.contributeToToolBar(toolBarManager);
/*    */ 
/* 32 */     toolBarManager.add(getActionRegistry().getAction("org.eclipse.gef.zoom_in"));
/* 33 */     toolBarManager.add(getActionRegistry().getAction("org.eclipse.gef.zoom_out"));
/*    */   }
/*    */ 
/*    */   protected void declareGlobalActionKeys()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editor.VisualDBEditorContributor
 * JD-Core Version:    0.6.0
 */