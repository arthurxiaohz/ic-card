/*    */ package org.hi.studio.hsceditor.visual.action;
/*    */ 
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.core.runtime.CoreException;
/*    */ import org.eclipse.gef.EditDomain;
/*    */ import org.eclipse.gef.EditPart;
/*    */ import org.eclipse.gef.GraphicalViewer;
/*    */ import org.eclipse.gef.RootEditPart;
/*    */ import org.eclipse.gef.commands.Command;
/*    */ import org.eclipse.gef.commands.CommandStack;
/*    */ import org.eclipse.jface.action.Action;
/*    */ import org.eclipse.ui.IEditorInput;
/*    */ import org.eclipse.ui.IFileEditorInput;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.util.UIUtils;
/*    */ import org.hi.studio.hsceditor.visual.editor.VisualDBEditor;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class DeleteMarkerAction extends Action
/*    */ {
/*    */   private GraphicalViewer viewer;
/*    */ 
/*    */   public DeleteMarkerAction(GraphicalViewer viewer)
/*    */   {
/* 27 */     super(DBPlugin.getResourceString("action.validation.deleteMarkers"));
/* 28 */     this.viewer = viewer;
/*    */   }
/*    */ 
/*    */   public void run() {
/* 32 */     CommandStack stack = this.viewer.getEditDomain().getCommandStack();
/* 33 */     stack.execute(new Command("Delete markers") {
/*    */       public void execute() {
/* 35 */         RootModel model = (RootModel)DeleteMarkerAction.this.viewer.getRootEditPart().getContents().getModel();
/* 36 */         for (AbstractDBEntityModel entity : model.getChildren())
/* 37 */           if ((entity instanceof TableModel))
/* 38 */             ((TableModel)entity).setError("");
/*    */       }
/*    */ 
/*    */       public boolean canUndo()
/*    */       {
/* 44 */         return false;
/*    */       }
/*    */     });
/* 48 */     IEditorInput input = UIUtils.getActiveEditor().getEditorInput();
/* 49 */     if ((input instanceof IFileEditorInput)) {
/* 50 */       IFile file = ((IFileEditorInput)input).getFile();
/*    */       try {
/* 52 */         file.deleteMarkers("org.eclipse.core.resources.problemmarker", false, 0);
/*    */       } catch (CoreException ex) {
/* 54 */         DBPlugin.logException(ex);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.action.DeleteMarkerAction
 * JD-Core Version:    0.6.0
 */