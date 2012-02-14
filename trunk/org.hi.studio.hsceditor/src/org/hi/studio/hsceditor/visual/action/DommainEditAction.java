/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.eclipse.gef.EditDomain;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.eclipse.gef.commands.CommandStack;
/*    */ import org.eclipse.jface.action.Action;
/*    */ import org.eclipse.swt.widgets.Control;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.visual.model.DommainModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class DommainEditAction extends Action
/*    */ {
/*    */   private GraphicalViewer viewer;
/*    */   private DommainModel editDommain;
/*    */ 
/*    */   public DommainEditAction(GraphicalViewer viewer)
/*    */   {
/* 23 */     super(DBPlugin.getResourceString("action.editDommain"));
/* 24 */     this.viewer = viewer;
/*    */   }
/*    */ 
/*    */   public DommainEditAction(GraphicalViewer viewer, DommainModel editDommain) {
/* 28 */     super(DBPlugin.getResourceString("action.editDommain"));
/* 29 */     this.viewer = viewer;
/* 30 */     this.editDommain = editDommain;
/*    */   }
/*    */ 
/*    */   public void run() {
/* 34 */     RootModel root = (RootModel)this.viewer.getContents().getModel();
/* 35 */     DommainEditDialog dialog = new DommainEditDialog(
/* 36 */       this.viewer.getControl().getShell(), root, this.editDommain);
/* 37 */     if (dialog.open() == 0)
/* 38 */       this.viewer.getEditDomain().getCommandStack().execute(
/* 39 */         new DommainEditCommand(root, dialog.getResult(), root.getDommains())); 
/*    */   }
/*    */ 
/*    */   private class DommainEditCommand extends Command {
/*    */     private RootModel rootModel;
/*    */     private List<DommainModel> newDommains;
/*    */     private List<DommainModel> oldDommains;
/*    */ 
/*    */     public DommainEditCommand(List<DommainModel> rootModel, List<DommainModel> newDommains) {
/* 50 */       this.rootModel = rootModel;
/* 51 */       this.newDommains = newDommains;
/* 52 */       this.oldDommains = oldDommains;
/*    */     }
/*    */ 
/*    */     public void execute() {
/* 56 */       this.rootModel.setDommains(this.newDommains);
/*    */     }
/*    */ 
/*    */     public void undo() {
/* 60 */       this.rootModel.setDommains(this.oldDommains);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.DommainEditAction
 * JD-Core Version:    0.6.0
 */