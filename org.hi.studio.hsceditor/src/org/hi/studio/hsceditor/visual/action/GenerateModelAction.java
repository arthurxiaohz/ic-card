/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.gef.EditDomain;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.eclipse.gef.commands.CommandStack;
/*    */ import org.eclipse.jface.action.Action;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class GenerateModelAction extends Action
/*    */ {
/*    */   private GraphicalViewer viewer;
/*    */ 
/*    */   public GenerateModelAction(GraphicalViewer viewer)
/*    */   {
/* 20 */     super(DBPlugin.getResourceString("action.toggleMode"));
/* 21 */     this.viewer = viewer;
/*    */   }
/*    */ 
/*    */   public void run() {
/* 25 */     CommandStack stack = this.viewer.getEditDomain().getCommandStack();
/*    */ 
/* 27 */     stack.execute(new Command("Toggle display mode") {
/*    */       public void execute() {
/* 29 */         RootModel root = (RootModel)GenerateModelAction.this.viewer.getContents().getModel();
/* 30 */         root.setLogicalMode(!root.getLogicalMode());
/*    */       }
/*    */ 
/*    */       public void undo() {
/* 34 */         RootModel root = (RootModel)GenerateModelAction.this.viewer.getContents().getModel();
/* 35 */         root.setLogicalMode(!root.getLogicalMode());
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.GenerateModelAction
 * JD-Core Version:    0.6.0
 */